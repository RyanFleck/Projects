import java.util.Random;

public class RoomNameGenerator {
    private String[] roomType,roomDesc,roomPrefix;
    private int depth=0,worldDepth,rand0,rand1,rand2;
    private int[] roomNumber;
    private Random randomNum;

    public RoomNameGenerator(int xworldDepth) {
	worldDepth=xworldDepth;
	randomNum = new Random();
	roomNumber = new int[worldDepth+2];
	roomPrefix = new String[]{"Terrible","Smelly","Mildly Uncomfortable","Very Uncomfortable","Despicable","Unwelcoming","Miserable","Kinda Okay","Chilly","Weird"};
	roomType = new String[]{"Lair","Room","Cavern","Den","Chamber","Cubicles","Alcove","Ballroom","Vault","Hall","Closet","Cupboard","Cupboard Under the Stairs","and Tiny Room","and Grand Hall"};
	roomDesc = new String[]{"Death","Destruction","Ultimate Fighting Championships","Marble Statues","Great Stone Pillars","Lawn Gnomes","Subterranian Trees","Jellyfish Tanks","Discarded Starbucks Cups","Peanut Butter Sandwiches","Monochrome Artwork","Doom","Despair","Fire","Horror","Darkness","Secrets","Lies","Fear","Terror","Cups","Eternal Suffering","Eternal Stench","Misery","Overpriced Coffee"};
	// TODO Auto-generated constructor stub
    }
    public String generateName(int rdepth){
	depth = rdepth;
	rand0 = randomNum.nextInt(roomPrefix.length);
	rand1 = randomNum.nextInt(roomType.length);
	rand2 = randomNum.nextInt(roomDesc.length);
	String output = ("The "+roomPrefix[rand0]+" "+roomType[rand1]+" of "+roomDesc[rand2]+".");
	roomNumber[depth]++;
	
	return(output);
	
    }
    public void testPrintRoomArray()
    {
	for(int x=0;x<worldDepth+2;x++)
	{System.out.println("At depth "+x+" there are "+roomNumber[x]+" rooms.");}
    }

}
