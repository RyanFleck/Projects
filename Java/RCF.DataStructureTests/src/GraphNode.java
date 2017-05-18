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
		this.addSingleLink(other, distance,1);
		other.addSingleLink(this, distance,0);
	}
	
	public void addSingleLink(GraphNode other,Integer distance, int displayDist){
		nodeMap.put(other,distance);
		if(displayDist==1){System.out.println("Nodes "+this.getName()+" and "+other.getName()+" linked!\nDistance: "+nodeMap.get(other));
		}}
	
	
	

}
