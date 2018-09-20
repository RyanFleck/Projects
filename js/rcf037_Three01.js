// ES5
// Based on tutorial https://tympanus.net/codrops/2016/04/26/the-aviator-animating-basic-3d-scene-threejs/

console.log('[RCF037] Loaded!');

// Palette
let colors = {
    purple:0xe305fc,
    mint:0x05fcc6,
    black:0x161616
}

// Init when window loaded.

window.addEventListener('load',init,false);

var scene, camera, fieldOfView, aspectRatio, 
    nearPlane, farPlane, HEIGHT, WIDTH,renderer, container;


function init(){
    console.log('[RCF037] Init sequence...');
    createScene();
    //createLights();
    //createObj();
}

function createScene(){
    console.log('[RCF037] Create scene...');
    HEIGHT = window.innerHeight;
    WIDTH = window.innerWidth;

    scene = new THREE.Scene();

    scene.fog = new THREE.Fog(colors.black, 100, 950);

    aspectRatio = WIDTH/HEIGHT;
    fieldOfView = 75;
    nearPlane = 1;
    farPlane = 10000;
    camera = new THREE.PerspectiveCamera( fieldOfView, aspectRatio,
        nearPlane, farPlane );
    let cp = camera.position;
    cp.x = 0;
    cp.y = 100;
    cp.z = 200;

    renderer = new THREE.WebGLRenderer({
        alpha: true,
        antialias: true
    });

    renderer.setSize(WIDTH,HEIGHT);
    renderer.shadowMap.enabled = true;

    container = document.getElementById('rcf037');
    container.appendChild(renderer.domElement);
    window.addEventListener('resize',handleWindowResize, false);
}

function handleWindowResize() {
    HEIGHT = window.innerHeight;
    WIDTH = window.innerWidth;
    renderer.setSize(WIDTH, HEIGHT);
    camera.aspect = WIDTH / HEIGHT;
    camera.updateProjectionMatrix();
}