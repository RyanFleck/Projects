
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
 	public  Statistics(){
	
	
	}
	
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
		if (hall[i].door_selected){this.info[0][i]++;}
		if (hall[i].door_open){this.info[1][i]++;}
		
		if (((hall[i].door_selected==false || hall[i].door_open==false)&&hall[i].door_prize)){this.info[2][i]++;}
		
		if (hall[i].door_selected&&hall[i].door_prize){this.st++;}	
		else if (hall[i].door_open==false&&hall[i].door_prize){this.sw++;}
		
		
		
	
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
	// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
	/*
	* We believe that our previously created code (in the updateStatistics method) has rendered this method moot
	*/
	}

	/** 
     *  @return Returns the complete statistics information
     */
	public String toString(){
	// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
		
	
	
	return(
	"Total Games: "+Integer.toString(this.gamesPlayed)+"\n"+
	"Switching would have won: "+Integer.toString(this.sw)+" or "+Integer.toString(((int)(100*this.sw/this.gamesPlayed)))+"% times\n"+
	"Staying would have won: "+Integer.toString(this.st)+" or "+Integer.toString(((int)(100*this.st/this.gamesPlayed)))+"% times\n"+
	"\nSelected: \n Door 1: "+Integer.toString(this.info[0][0])+"  Door 2: "+Integer.toString(this.info[0][1])+"  Door 3: "+Integer.toString(this.info[0][2])+
	"\nOpened: \n Door 1: "+Integer.toString(this.info[1][0])+"  Door 2: "+Integer.toString(this.info[1][1])+"  Door 3: "+Integer.toString(this.info[1][2])+
	"\nWins: \n Door 1: "+Integer.toString(this.info[2][0])+"  Door 2: "+Integer.toString(this.info[2][1])+"  Door 3: "+Integer.toString(this.info[2][2])
	);
	
	}
	
}

	
	