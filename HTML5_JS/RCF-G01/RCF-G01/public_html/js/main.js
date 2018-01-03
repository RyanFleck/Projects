/* global gl, gSimpleShader, gShaderVertexPositionAttribute */

"use strict";
var gl = null;

function initializeGL(){
var canvas = document.getElementById("GLCanvas");
gl = canvas.getContext("webgl") || canvas.getContext("experimental-webgl");

if(gl !== null){
    gl.clearColor(0.2,0.2,0.2,1.0);
    initSquareBuffer();
    initSimpleShader("VertexShader","FragmentShader");
}else{
    document.write("<br><b>No WebGL support!</b>");
}
}

function clearCanvas(){
    gl.clear(gl.COLOR_BUFFER_BIT);
}

function doDraw(){
    initializeGL();
    clearCanvas();
    drawSquare();
}

function drawSquare(){
    gl.useProgram(gSimpleShader);
    gl.enableVertexAttribArray(gShaderVertexPositionAttribute);
    gl.drawArrays(gl.TRIANGLE_STRIP, 0, 4);
}