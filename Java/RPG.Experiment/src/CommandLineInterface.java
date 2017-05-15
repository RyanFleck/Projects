public class CommandLineInterface {
    private static PlayHistory story;
    private static String name = "EMPTY", textInput="";
    private static Prompt prompt;
    private static Player player;
    private static RoomNameGenerator roomNameGenerator;
    private static Room finalRoom, root, currentRoom;

    public static void main(String[] args) {
	System.out.println("- UNNAMED RPG -");
	prompt = new Prompt();
	name = prompt.askString("Please enter the name of your character:");
	
	String[] classarguments = {"Rogue","High Wizard","Druid","Knight","Barbarian","Shape Shifter"};
	String ans = prompt.askChoice("What class would you like to be?",classarguments);
	System.out.println(ans+ans+ans+ans+ans);
	
	story = new PlayHistory(name);
	player = new Player(name,story);
	//player.generate();
	int worldDepth = 4;
	roomNameGenerator = new RoomNameGenerator(worldDepth);
	finalRoom = new Room("finalRoom", roomNameGenerator, worldDepth+1,root);
	root = new Room(roomNameGenerator.generateName(0), roomNameGenerator, 0,finalRoom);
	finalRoom.setPrev(root);
	root.createMoreRooms(worldDepth);
	//roomNameGenerator.testPrintRoomArray();
	currentRoom = root;
	//TODO populate world

	story.log("Your quest, "+ name + " of the Northern Isles, begins on a dark night on a dark, frothing sea.");
	story.log("The wind whips your hair about your face and you desperately try to keep your tiny vessel afloat.");
	story.log("A bolt of lightning and boom of thunder illuminate land ahead, but your hopes are quickly dashed as a huge wave rises ahead.");
	story.log("You are pulled under, and the world goes dark...");
	prompt.petc();

	String[] arguments = {"A","B","C","D"};
	prompt.askChoice("ABCD?",arguments);
	
	System.out.println("\n\nYou awake in "+currentRoom.getName());
	story.log("On your LEFT is a door marked "+currentRoom.left().getName());
	story.log("On your RIGHT is a door marked "+currentRoom.right().getName());
	story.log("At your BACK is a crumbled archway and a locked door...");
	story.log("There is no way to go but forward.");
	
	
	while(!textInput.toLowerCase().equals("quit"))
	{
	    
	    textInput = prompt.askString("\n...What will you do next?").toLowerCase();
	    switch(textInput)
	    {
	    /*
	    case "left": //Enters left door
		if(currentRoom.left()!=null){
		story.log("You enter the "+currentRoom.left().getName());
		if(currentRoom.left().left()!=null){story.log("On your LEFT is a door marked "+currentRoom.left().left().getName());}
		if(currentRoom.left().right()!=null){story.log("On your RIGHT is a door marked "+currentRoom.left().right().getName());}
		if(currentRoom.left().previous()!=null){story.log("At your BACK is a door marked "+currentRoom.previous().getName());}
		else{story.log("The door behind you is locked.");}
		currentRoom = currentRoom.left();}
		else{story.log("You try to open the door on the left, but it is locked.");}
		break;
		*/
	    case "left":
		if(currentRoom.left()!=null){
		    currentRoom = currentRoom.left();
		    story.log("You enter "+currentRoom.getName());
		    System.out.println();
		    if(currentRoom.left()!=null)
		    	{System.out.println("On your LEFT is a door marked "+currentRoom.left().getName());}
		    if(currentRoom.right()!=null)
		    	{System.out.println("On your RIGHT is a door marked "+currentRoom.right().getName());}
		    if(currentRoom.previous()!=null)
		    	{System.out.println("At your BACK is a door marked "+currentRoom.previous().getName());}
		    	else{story.log("The door behind you is sealed.");}
		}else{story.log("You try to open the door on the left, but it is locked.");}
		break;
	    case "right":
		if(currentRoom.right()!=null){
		    currentRoom = currentRoom.right();
		    story.log("You enter "+currentRoom.getName());
		    System.out.println();
		    if(currentRoom.left()!=null)
		    	{System.out.println("On your LEFT is a door marked "+currentRoom.left().getName());}
		    if(currentRoom.right()!=null)
		    	{System.out.println("On your RIGHT is a door marked "+currentRoom.right().getName());}
		    if(currentRoom.previous()!=null)
		    	{System.out.println("At your BACK is a door marked "+currentRoom.previous().getName());}
		    	else{story.log("The door behind you is sealed.");}
		}else{story.log("You try to open the door on the left, but it is locked.");}
		break;
	    case "back":
		if(currentRoom.previous()!=null){
		    currentRoom = currentRoom.previous();
		    story.log("You enter "+currentRoom.getName());
		    System.out.println();
		    if(currentRoom.left()!=null)
		    	{System.out.println("On your LEFT is a door marked "+currentRoom.left().getName());}
		    if(currentRoom.right()!=null)
		    	{System.out.println("On your RIGHT is a door marked "+currentRoom.right().getName());}
		    if(currentRoom.previous()!=null)
		    	{System.out.println("At your BACK is a door marked "+currentRoom.previous().getName());}
		    	else{System.out.println("The door behind you is sealed.");}
		}else{System.out.println("The door behind you is locked.");}
		break;
	    case "exit":
		textInput = "quit";
		break;
	   
	    }
	}

	story.end();
    }
}
