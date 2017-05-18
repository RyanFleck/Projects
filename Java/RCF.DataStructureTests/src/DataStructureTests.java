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
		
		one.setName("One");
		two.setName("Two");
		three.setName("Three");
		
		one.connect(two, 14);
		two.connect(three, 4);
		three.connect(one, 7);

		System.out.println();
		
	}

}
