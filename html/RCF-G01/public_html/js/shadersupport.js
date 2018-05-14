/* 
 * Copyright (C) 2018 rflec028
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


/* global gl, gSquareVertexBuffer */

var gSimpleShader = null;
var gShaderVertexPositionAttribute = null;

function loadAndCompileShader(id, shaderType){
    var shaderText, shaderSource, compiledShader;
    
    //Get shader source:
    shaderText = document.getElementById(id);
    shaderSource = shaderText.firstChild.textContent;
    
    //Compile shader:
    compiledShader = gl.createShader(shaderType);
    
    //Check for errors and return:
    if (!gl.getShaderParameter(compiledShader, gl.COMPILE_STATUS)){
        alert(  "Shader compile error: "+
                gl.getShaderInfoLog(compiledShader)
                );
    }
    return compiledShader;
}

function initSimpleShader(vertexShaderID,fragmentShaderID){
    var vertexShader = loadAndCompileShader(vertexShaderID, gl.VERTEX_SHADER);
    var fragmentShader = loadAndCompileShader(fragmentShaderID, gl.FRAGMENT_SHADER);
    
    gSimpleShader = gl.createProgram();
    gl.attachShader(gSimpleShader, vertexShader);
    gl.attachShader(gSimpleShader, fragmentShader);
    gl.linkProgram(gSimpleShader);
    
    if(!gl.getProgramParameter(gSimpleShader, gl.LINK_STATUS)){
        alert("Error linking shader.");
    }
    
    gShaderVertexPositionAttribute = gl.getAttribLocation(gSimpleShader, "aSquareVertexPosition");
    gl.bindBuffer(gl.ARRAY_BUFFER,gSquareVertexBuffer);
    gl.vertexAttribPointer(
                gShaderVertexPositionAttribute,
                3,
                gl.FLOAT,
                false,
                0,
                0
            );
}