public class Player {
    private String name;
    private int level;
    private PlayHistory story;
    public Player(String iname, PlayHistory istory){
	level = 0;
	name = iname;
	story = istory;
	story.log("Level "+level+" character for "+name+" has been generated.\n\n");
	
    }

}
