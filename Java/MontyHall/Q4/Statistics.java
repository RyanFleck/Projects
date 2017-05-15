
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
	
	int info[][];
	int st=0,sw=0, gamesPlayed=0;

	
	
	
	/** 
     * Initializes the statistics.
     */
 	public  Statistics(int numberOfDoors)
	{
	info=new int[3][numberOfDoors];	
		
	}
	
	/** 
     * Updates statistics after one game.
     *   @param door1 the first door in the game
     *   @param door2 the second door in the game
     *   @param door3 the third door in the game
     */
 	public void updateStatistics(Door[] microcosm){
	
	Door hall[]=microcosm;
	for (int i=0; i<hall.length;i++)
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
		String[] types={"Selected","Open","Winner"};
		String output=
		("Total Games: "+Integer.toString(this.gamesPlayed)+"\n"+
		"Switching would have won: "+Integer.toString(this.sw)+" or "+Integer.toString(((int)(100*this.sw/this.gamesPlayed)))+"% times\n"+
		"Staying would have won: "+Integer.toString(this.st)+" or "+Integer.toString(((int)(100*this.st/this.gamesPlayed)))+"% times\n");
		
		
		for (int i=0;i<3;i++)
		{
			output+=("\n"+types[i]+":\n");

			for (int j=0;j<info[0].length;j++)
			{
				output+=" Door: "+(j+1)+": "+Integer.toString(this.info[i][j]);
			}
		}
	return
		(output);
	
	}

	public String toCSV()
	{
		String output=
		("Number of games,"+Integer.toString(this.gamesPlayed)+"\n"+
		"Number of doors,"+this.info[0].length+"\n,Win,Loss\n"+
		"Staying strategy,"+Integer.toString(this.st)+","+Integer.toString(this.sw)+"\n"+
		"Switching strategy,"+Integer.toString(this.sw)+","+Integer.toString(this.st)+"\n"+
		",Selected doors,Winning doors,Open doors"+"\n");
		for (int j=0;j<info[0].length;j++)
		{
			output+=("\nDoor:"+(j+1)+",");
			for (int i=0;i<3;i++)			
			{
				output+=(Integer.toString(this.info[i][j])+",");
			}
		}
	return
	(output);

	}
	
}

	
	