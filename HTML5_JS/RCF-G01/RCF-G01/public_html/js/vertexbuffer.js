/* global gl */

"use strict";
var gSquareVertexBuffer = null;

function initSquareBuffer(){
    var verticesOfSquare = [
        0.5, 0.5, 0.0,
        -0.5, 0.5, 0.0,
        0.5, -0.5, 0.0,
        -0.5, -0.5, 0.0
    ];
    
    gSquareVertexBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, gSquareVertexBuffer);
    gl.bufferData(
            gl.ARRAY_BUFFER,
            new Float32Array(verticesOfSquare),
            gl.STATIC_DRAW
            );
}