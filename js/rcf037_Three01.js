// ES5

// Successfully renders a spinning cube.

// Based on tutorial https://tympanus.net/codrops/2016/04/26/the-aviator-animating-basic-3d-scene-threejs/
// Based on tutorial https://www.jonathan-petitcolas.com/2013/04/02/create-rotating-cube-in-webgl-with-threejs.html

console.log('[RCF037] Loaded!');

// Palette
const colors = {
  purple: 0xe305fc,
  mint: 0x05fcc6,
  black: 0x161616,
};

// Init when window loaded.

window.addEventListener('load', init, false);

let scene; let camera; let fieldOfView; let aspectRatio; let cube; let cube2; let
  cube3;
nearPlane, farPlane, HEIGHT, WIDTH, renderer, container;


function init() {
  console.log('[RCF037] init(): Begin init sequence.');
  createScene();
  // createLights();
  // createObj();
  render();
}

function createScene() {
  console.log('[RCF037] createScene(): Init window.');
  HEIGHT = window.innerHeight;
  WIDTH = window.innerWidth;

  scene = new THREE.Scene();

  scene.fog = new THREE.Fog(colors.black, 100, 950);

  aspectRatio = WIDTH / HEIGHT;
  fieldOfView = 75;
  nearPlane = 1;
  farPlane = 10;
  camera = new THREE.PerspectiveCamera(fieldOfView, aspectRatio,
    nearPlane, farPlane);
  camera.position.set(0, 3.5, 5);
  camera.lookAt(scene.position);

  console.log('[RCF037] createScene(): Init renderer.');
  renderer = new THREE.WebGLRenderer({
    alpha: true,
    antialias: true,
  });

  renderer.setSize(WIDTH, HEIGHT);
  renderer.shadowMap.enabled = true;

  console.log('[RCF037] createScene(): Insert WebGL renderer.');
  container = document.getElementById('rcf037');
  container.appendChild(renderer.domElement);
  window.addEventListener('resize', handleWindowResize, false);

  // Cube
  cube = new THREE.Mesh(new THREE.CubeGeometry(2, 2, 2), new THREE.MeshNormalMaterial());
  cube2 = new THREE.Mesh(new THREE.CubeGeometry(2, 2, 2), new THREE.MeshNormalMaterial());
  cube3 = new THREE.Mesh(new THREE.CubeGeometry(2, 2, 2), new THREE.MeshNormalMaterial());
  scene.add(cube);
  // cube2.translateX(4).translateZ(-1);
  // cube3.translateX(-4).transalteZ(1);
  scene.add(cube2);
  scene.add(cube3);
}

function render() {
  requestAnimationFrame(render);
  rotateCubes();
  renderer.render(scene, camera);
}

function rotateCubes() {
  const speed = 0.01;
  const c1 = cube.rotation;
  const c2 = cube2.rotation;
  const c3 = cube3.rotation;

  c1.x -= speed * 2;
  c1.y -= speed;
  c1.z -= speed * 3;

  c2.x -= speed * 2;
  c2.z -= speed;
  c2.y -= speed * 3;

  c3.y -= speed * 2;
  c3.x -= speed;
  c3.z -= speed * 3;
}

function handleWindowResize() {
  HEIGHT = window.innerHeight;
  WIDTH = window.innerWidth;
  console.log(`[RCF037] handleWindowResize(): Resizing to ${WIDTH}, ${HEIGHT}.`);
  renderer.setSize(WIDTH, HEIGHT);
  camera.aspect = WIDTH / HEIGHT;
  camera.updateProjectionMatrix();
}
