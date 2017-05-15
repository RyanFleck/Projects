
/**
 * The class  <b>Statistics</b> accumulates information about a series of games:
 * <ol>
 * <li>Number of game played</li>
 * <li>Number of times the switching strategy was successful</li>
 * <li>Number of times the switching strategy was not successful</li>
 * <li>Number of times each door has the prize behind it</li>
 * <li>Number of times each door was chosen by the player</li>
 * <li>Number of times each door was open by the host</li>
 * </ol>
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */
public class Statistics {
	
	int info[][]=new int[3][3];
	int st=0,sw=0, gamesPlayed=0;

	/** 
     * Initializes the statistics.
     */
 	public  Statistics(){}
	
	/** 
     * Updates statistics after one game.
     *   @param door1 the first door in the game
     *   @param door2 the second door in the game
     *   @param door3 the third door in the game
     */
 	public void updateStatistics(Door door1, Door door2, Door door3){
	
	Door hall[]={door1,door2,door3};
	for (int i=0; i<3;i++)
	{
		oneDoor(hall[i],i);	
	}
	this.gamesPlayed++;
	}
	/** 
     * Updates statistics for one single door.
     *   @param door the door for which statistics are updated
     *   @param index index of that door (0, 1 or 2)
	*/
	
	public void oneDoor(Door door, int index)
	{
		if (door.door_selected){this.info[0][index]++;}
		if (door.door_open){this.info[1][index]++;}
		
		if (((door.door_selected==false || door.door_open==false)&&door.door_prize)){this.info[2][index]++;}
		
		if (door.door_selected&&door.door_prize){this.st++;}	
		else if (door.door_open==false&&door.door_prize){this.sw++;}
	}

	/** 
     *  @return Returns the complete statistics information
     */
	public String toString()
	{
		// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
		
	return
		(
		"Total Games: "+Integer.toString(this.gamesPlayed)+"\n"+
		"Switching would have won: "+Integer.toString(this.sw)+" or "+Integer.toString(((int)(100*this.sw/this.gamesPlayed)))+"% times\n"+
		"Staying would have won: "+Integer.toString(this.st)+" or "+Integer.toString(((int)(100*this.st/this.gamesPlayed)))+"% times\n"+
		"\nSelected: \n Door 1: "+Integer.toString(this.info[0][0])+"  Door 2: "+Integer.toString(this.info[0][1])+"  Door 3: "+Integer.toString(this.info[0][2])+
		"\nOpened: \n Door 1: "+Integer.toString(this.info[1][0])+"  Door 2: "+Integer.toString(this.info[1][1])+"  Door 3: "+Integer.toString(this.info[1][2])+
		"\nWins: \n Door 1: "+Integer.toString(this.info[2][0])+"  Door 2: "+Integer.toString(this.info[2][1])+"  Door 3: "+Integer.toString(this.info[2][2])
		);
	
	}

	public String toCSV()
	{
	
	return
	(
		"Number of games,"+Integer.toString(this.gamesPlayed)+"\n"+
		"Number of doors,3\n,Win,Loss\n"+
		"Staying strategy,"+Integer.toString(this.st)+","+Integer.toString(this.sw)+"\n"+
		"Switching strategy,"+Integer.toString(this.sw)+","+Integer.toString(this.st)+"\n"+
		",Selected doors,Winning doors,Open doors"+"\n"+
		"Door 1,"+this.info[0][0]+","+this.info[2][0]+","+this.info[1][0]+"\n"+
		"Door 2,"+this.info[0][1]+","+this.info[2][1]+","+this.info[1][1]+"\n"+
		"Door 3,"+this.info[0][2]+","+this.info[2][2]+","+this.info[1][2]+"\n"
	);
	//sow
	/*
	
Number of games,val
Number of doors,3
,Win,Loss
Staying strategy,val,val
Switching strategy,val,val
,Selected doors,Winning doors,Open doors
Door 1,val,val,val
Door 2,val,val,val
Door 3,val,val,val
	
	*/

	}
	
}

	
	