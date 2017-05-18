/**
 * 
 */

/**
 * @author rflec028
 *
 */
public class DataStructureTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Creating nodes...");
		GraphNode one = new GraphNode();
		GraphNode two = new GraphNode();
		GraphNode three = new GraphNode();
		GraphNode four = new GraphNode();
		
		one.setName("One");
		two.setName("Two");
		three.setName("Three");
		four.setName("Four");
		
		
		one.connect(two, 14);
		two.connect(three, 4);
		three.connect(one, 7);
		four.connect(one,30);
		four.connect(two,28);

		//This block ensures that nodes/edge distances are being initialized properly.
		System.out.println("\nTests\n");
		System.out.println("Distance between nodes one and three: "+one.simpleDistanceToNode(three));
		System.out.println("Distance between nodes one and two: "+one.simpleDistanceToNode(two));
		System.out.println("Distance between nodes two and three: "+two.simpleDistanceToNode(three));
		System.out.println("Distance between nodes one and four: "+one.simpleDistanceToNode(four));
		System.out.println("Distance between nodes two and four: "+two.simpleDistanceToNode(four));
		
		System.out.println("\nDistance between bridged nodes three and four: "+three.simpleDistanceToNode(four));
		
	}

}
