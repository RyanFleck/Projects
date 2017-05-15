import java.util.Random;
public class Room {
    private Room left=null,right=null,prev=null,finalRoom;
    private String name,properties;
    private int depth;
    private RoomNameGenerator rng;
    
    public Room(String iname, RoomNameGenerator irng, int idepth, Room finalRoom)
    {
	name = iname;
	rng = irng; 
	depth = idepth; 
	
    }
    public String getName(){return name;}
    public Room left(){return left;}
    public Room right(){return right;}
    public Room previous(){return prev;}
    public int getDepth(){return depth;}
    public void setDepth(int newDepth){depth = newDepth;}
    public void setPrev(Room prevRm){prev = prevRm;}
    
    public void createMoreRooms(int maxDepth)
    {
	if(depth<maxDepth)
	{
	    //System.out.println("This room: "+getName()+" depth: "+depth);
	    left = new Room(rng.generateName(depth+1),rng,depth+1,finalRoom);
	    //System.out.println("Room to left: "+left.getName());
	    right = new Room(rng.generateName(depth+1),rng,depth+1,finalRoom);
	    //System.out.println("Room to right: "+right.getName()+"\n\n");
	    left.createMoreRooms(maxDepth);
	    left.setPrev(this);
	    right.createMoreRooms(maxDepth);
	    right.setPrev(this);
	    
	}
	else
	{
	    //System.out.println("This room: "+getName()+" depth: "+depth);
	    left = finalRoom;
	    //System.out.println("Leads to final room.\n\n");
	    right = finalRoom;
	}
    }
    public void setProperties(String prop){properties=prop;}

    private void generateMonsters(){}
    private boolean sysCheckForMonsters(){return true;}
    private void generateLoot(){}
    private boolean sysCheckForLoot(){return false;}
    
    

}
