// ES5
// Based on tutorial https://tympanus.net/codrops/2016/04/26/the-aviator-animating-basic-3d-scene-threejs/
// Based on tutorial https://www.jonathan-petitcolas.com/2013/04/02/create-rotating-cube-in-webgl-with-threejs.html

console.log('[RCF037] Loaded!');
// var THREE = require('three');

// Palette
const colors = {
    purple: 0xe305fc,
    mint: 0x05fcc6,
    black: 0x161616,
};


// Init when window loaded.
window.addEventListener('load', init, false);

// Camera, scene, window:
let scene; let camera; let fov; let aspectRatio;


let nearPlane; let farPlane; let H; let W; let renderer; let
    container;

// Lights, environment:
let hemispherel; let shadowl; let land; let
    sky;

// Mouse
let mp = { x: 0, y: 0 };

function init() {
    createScene();

    createLights();
    createSky();
    createLand();

    document.addEventListener('mousemove', mpMove, false);
    loop();
}


function createScene() {
    // Init Scene
    scene = new THREE.Scene();
    scene.fog = new THREE.Fog(0x385938, 100, 950);

    // Init Camera
    H = window.innerHeight;
    W = window.innerWidth;
    aspectRatio = W / H;
    fov = 70;
    nearPlane = 1;
    farPlane = 10000;
    camera = new THREE.PerspectiveCamera(fov, aspectRatio, nearPlane, farPlane);
    camera.position.set(0, 100, 200);

    // Init renderer
    renderer = new THREE.WebGLRenderer({ alpha: true, antialias: true });
    renderer.setSize(W, H);
    renderer.shadowMap.enabled = true;

    // Map to DOM
    container = document.getElementById('rcf037');
    container.appendChild(renderer.domElement);

    // Handle resizing events
    window.addEventListener('resize', hwr, false);
}


function createLights() {
    // ( color-sky, color-ground, intensity 0-1 )
    hemispherel = new THREE.HemisphereLight(0xaaaaaa, 0x000000, 0.9);


    shadowl = new THREE.DirectionalLight(0xffffff, 0.9);
    shadowl.position.set(150, 350, 350);
    shadowl.castShadow = true;

    // Visible area of projected shadow?
    shadowl.shadow.camera.left = -400;
    shadowl.shadow.camera.right = 400;
    shadowl.shadow.camera.top = 400;
    shadowl.shadow.camera.bottom = -400;
    shadowl.shadow.camera.near = 1;
    shadowl.shadow.camera.far = 1000;

    shadowl.shadow.mapSize.height = 2048;
    shadowl.shadow.mapSize.width = 2048;

    scene.add(hemispherel);
    scene.add(shadowl);
}


Cloud = function () {
    this.mesh = new THREE.Object3D();
    const geom = new THREE.SphereGeometry(34, 10, 10);
    const mat = new THREE.MeshPhongMaterial({
        color: 0x9ace9a,
        flatShading: true,
    });

    const nBlocs = 5 + Math.floor(Math.random() * 3);
    for (let i = 0; i < nBlocs; i++) {
        const m = new THREE.Mesh(geom, mat);
        const mp = m.position;
        mp.x = i * 15;
        mp.y = Math.random() * 10;
        mp.z = Math.random() * 10;

        const s = 0.1 + Math.random() * 0.9;
        m.scale.set(s, s, s);
        m.castShadow = true;
        m.recieveShadow = true;
        this.mesh.add(m);
    }
};

Sky = function () {
    this.mesh = new THREE.Object3D();
    this.nClouds = 20;
    const stepAngle = Math.PI * 2 / this.nClouds;

    for (let i = 0; i < this.nClouds; i++) {
        const c = new Cloud();

        // Place clouds at equal intervals but random height.
        const a = stepAngle * i;
        const h = 800 + Math.random() * 200;
        c.mesh.position.y = Math.sin(a) * h;
        c.mesh.position.x = Math.cos(a) * h;
        c.mesh.rotation.z = a + Math.PI / 2;
        c.mesh.position.z = -400 - Math.random() * 400;

        // Scale each cloud.
        const s = 1 + Math.random() * 2;
        c.mesh.scale.set(s, s, s);

        this.mesh.add(c.mesh);
    }
};

function createSky() {
    sky = new Sky();
    sky.mesh.position.y = -600;
    scene.add(sky.mesh);
}


/* To create an object:
 * 1. Create a geometry.
 * 2. Create a material.
 * 3. Pass those to a mesh.
 * 4. Add the mesh to the scene.
 */

Land = function () {
    const g = new THREE.CylinderGeometry(600, 600, 900, 40, 10);
    g.applyMatrix(new THREE.Matrix4().makeRotationX(-Math.PI / 2));

    const materia = new THREE.MeshPhongMaterial({
        color: colors.black,
        flatShading: true,
    });

    this.mesh = new THREE.Mesh(g, materia);
    this.mesh.recieveShadow = true;
};

function createLand() {
    land = new Land();
    land.mesh.position.y = -600;
    scene.add(land.mesh);
}


function loop() {
    land.mesh.rotation.z -= 0.0005;
    sky.mesh.rotation.z += 0.002;
    renderer.render(scene, camera);
    requestAnimationFrame(loop);
}

function mpMove() {
    const tx = -1 + (event.clientX / W) * 2;
    const ty = 1 - (event.clientY / H) * 2;
    mp = { x: tx, y: ty };
}


// Handle window resize.
function hwr() {
    H = window.innerHeight;
    W = window.innerWidth;
    renderer.setSize(W, H);
    camera.aspect = W / H;
    camera.updateProjectionMatrix();
}
