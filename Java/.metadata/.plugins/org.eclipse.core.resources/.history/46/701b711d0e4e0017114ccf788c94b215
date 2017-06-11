package com.libgdx.battlecommander;

public interface Unit{
	
	
	/*
	====================
	Move
	-Checks if the coordinate can be moved to, then moves the unit to the coordinates.
	-Plays movement animations.
	====================
	*/
	public void spawn(int coordX,int coordY);
	/*
	====================
	Move
	-Checks if the coordinate can be moved to, then moves the unit to the coordinates.
	-Plays movement animations.
	====================
	*/
	public boolean Move(int coordX, int coordY);
	
	/*
	====================
	Attack
	-Checks if a target is within range, 
	====================
	*/
	public boolean Attack(int coordX,int coordY,int[] range);
	
	/*
	====================
	RecieveFocus
	-Changes unit color and animation.
	====================
	*/
	public boolean RecieveFocus();
	
	/*
	====================
	LoseFocus
	-Reverts to unfocused animation and color.
	====================
	*/
	public boolean LoseFocus();
	
	/*
	====================
	Info
	Displays unit info on-screen when cursor is hovered over unit.
	====================
	*/
	public String Info();
	
	/*
	====================
	PrintDebugInfo
	Prints unit info to terminal for debugging.
	====================
	*/
	public void PrintDebugInfo();
	
	
}
