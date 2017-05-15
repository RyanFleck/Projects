import javax.swing.JOptionPane;

/**
 * The class <b>MontyHall</b> simulates one game. Is uses three <b>Door</b> objects
 * to simulate the three doors. One game consists of the following steps
 * <ol>
 * <li>Resets all three doors</li>
 * <li>Simulates the selection of one of the doors by the player</li>
 * <li>Simulates opening of an empty door by the host</li>
 * <li> provide the outcome for switching and not switching door</li>
 * </ol>
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */
 
import java.util.Random;

public class MontyHall {
	
	
	
	public Door[] doorArray;
	public int prize_door_int,player_door_int,host_door_int,numberOfDoors;
	

	/** 
     * Initializes the list of doors.
     * 
     * @param numberOfDoors number of door used in the simulation
     */
 	public MontyHall(int numberOfDoors)
		{
		this.numberOfDoors=numberOfDoors;
		doorArray = new Door[numberOfDoors];
		for (int i=0;i<numberOfDoors;i++)
		{
			doorArray[i]= new Door(Integer.toString(i));
		}
		}
	
	/** 
     * Runs a series of Monty Hall games and displays the resulting statistics in a 
     * message dialog or on the standard output  
     * 
     * @param numberOfGames the number of games to simulate
     * @param commandLine if true, sends the results as CSV to standard output, else uses a message dialog
     */
	
	public void runGames(int numberOfGames, boolean commandLine)
	{
		Statistics stats= new Statistics(numberOfDoors);
		for (int i=0; i<numberOfGames;i++)
		{
			this.oneGame();
			stats.updateStatistics(doorArray);
		}
		System.out.println("\n\n\n***CSV information***\n\n\n");
		System.out.println(stats.toCSV());
		
		
		
	if(commandLine)
	{
		System.out.println(stats.toString());
	}
	else
	{
		JOptionPane.showMessageDialog(null,stats.toString(),"Results",JOptionPane.INFORMATION_MESSAGE);
	}
	}
	
	/** 
     * Simulates one Monty Hall game.  
     * <ol>
     * <li>Resets all the doors</li>
	 * <li>Simulates the selection of one of the doors by the player</li>
	 * <li>Simulates opening of an empty door by the host</li>
	 * <li>prints the outcome for switching and not switching door to standard output</li>
	 * </ol>
     */
 
public void oneGame(){
		for(int i=0;i<this.numberOfDoors;i++)
		{
			doorArray[i].reset();
		}
		
		Random r= new Random();
		prize_door_int= r.nextInt(this.numberOfDoors);
		doorArray[prize_door_int].setPrize();
		Door player_door = pickADoor();
		Door host_door = openOtherDoors(doorArray[prize_door_int],player_door);
			
		System.out.println("The prize is behind door "+(prize_door_int+1)+".");
		System.out.println("The player selected door "+(player_door_int+1)+".");
		System.out.println("The host left door "+(host_door_int+1)+" and "+(player_door_int+1)+" closed.");


		System.out.println("Switching to door "+(host_door_int+1)+".");
		
		
		//MANDATORY
		if(host_door_int!=prize_door_int){
			System.out.println("Switching strategy would have lost.");
		} else{
			System.out.println("Switching strategy would have won.");	
		}
		
	}

	/** 
     * Simulates a random selection of one of the  doors.
     * @return the door randomly selected  
     */
 	private Door pickADoor()
	{	Random r= new Random();
		player_door_int= r.nextInt(3);
		doorArray[player_door_int].choose();
		
	return doorArray[player_door_int];}
	
	/** 
     * Simulates the opening of numberOfDoors-2 doors once the player selected one.
     * It should  open doors chosen randomly among the ones that don't have the prize and
     * that are not selected by the player
     * 
     *   @param prizeDoor the door that hides the prize
     *   @param selectedDoor the door that was selected by the player
     */
	 
private Door openOtherDoors(Door prizeDoor, Door selectedDoor)
		{
			
			if(prizeDoor.equals(selectedDoor))
			{
				Random r= new Random();
				this.host_door_int = r.nextInt(this.numberOfDoors);
			}
			else
			{
				this.host_door_int=this.prize_door_int;
			}
			
			
			for (int i=0; i<this.numberOfDoors; i++)
			{
				if(i!=this.host_door_int&& !this.doorArray[i].equals(prizeDoor)&& !this.doorArray[i].equals(selectedDoor))
				{	
					doorArray[i].open();					
				}
				
			}
		return(doorArray[this.host_door_int]);
		}
	
	
 	/**
    * The main method of this program. Examples of the execution of the program
    * from the command line:
    * <pre>
    * > java MontyHall 5 3
    * 
    * Number of games played: 5
    * Staying strategy won 2 games (40%)
	* Switching strategy won 3 games (60%)
	*	Selected doors:
	*		door 1: 1 (20%)
	*		door 2: 3 (60%)
	*		door 3: 1 (20%)
	*	Winning doors:
	*		door 1: 1 (20%)
    *		door 2: 1 (20%)
	*		door 3: 3 (60%)
	*	Open doors:
    *		door 1: 2 (40%)
	*		door 2: 2 (40%)
 	*		door 3: 1 (20%)
 	*
    * @param args (optional) the number of games to simulate, and the number of doors to use
	*/
	
	public static void main(String[] args) {

		MontyHall montyHall;
		int numberOfGames;
		int numberOfDoors;
		boolean commandLine = false;
		
		StudentInfo.display();

		if (args.length == 2) {
			numberOfGames = Integer.parseInt(args[0]);
			numberOfDoors = Integer.parseInt(args[1]);
			commandLine = true;
		} else {
			numberOfGames = Integer.parseInt(JOptionPane.showInputDialog("Input the number of games to play", "1000"));
			numberOfDoors = Integer.parseInt(JOptionPane.showInputDialog("Input the number of doors", "3"));
		}

		
		montyHall = new MontyHall(numberOfDoors);		
		montyHall.runGames(numberOfGames, commandLine);
	}

}
