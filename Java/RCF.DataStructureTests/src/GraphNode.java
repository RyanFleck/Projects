/**
 * 
 */

import java.util.HashMap;

/**
 * @author rflec028
 *
 */
public class GraphNode extends TestClass{

	private HashMap<GraphNode,Integer> nodeMap;
	
	public GraphNode(){
		System.out.println("Node created!");
		nodeMap = new HashMap<GraphNode,Integer>();
	}
	
	
	
	
	
	
	
	//Simple connection methods:
	
	public void connect(GraphNode other,Integer distance){
		this.addSingleLink(other, distance);
		other.addSingleLink(this, distance);
	}
	
	public void addSingleLink(GraphNode other,Integer distance){
		nodeMap.put(other,distance);
		System.out.println("Nodes linked!");
	}
	
	
	

}
