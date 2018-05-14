@ECHO OFF
ECHO **************************************************
ECHO **        FOR WIN10x64: C# Compile N' Run       **
ECHO **************************************************
ECHO Using %1

csc /out:prog.exe %1
.\prog.exe
