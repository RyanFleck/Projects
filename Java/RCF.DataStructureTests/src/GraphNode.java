/**
 * 
 */

import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

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
	
	//Queries and graph information:
	
	public GraphNode[] getConnectedNodes(){
		Set<GraphNode> connectedNodes = nodeMap.keySet();
		return (GraphNode[])connectedNodes.toArray();
	}
	
	public Boolean isConnected(GraphNode other){
		return nodeMap.containsKey(other);
	}
	
	
	
	
	//Simple graph building methods:
	
	public void connect(GraphNode other,Integer distance){
		this.addSingleLink(other, distance,1);
		other.addSingleLink(this, distance,0);
	}
	
	public void addSingleLink(GraphNode other,Integer distance, int displayDist){
		nodeMap.put(other,distance);
		if(displayDist==1){System.out.println("Nodes "+this.getName()+" and "+other.getName()+" linked!\nDistance: "+nodeMap.get(other));
		}}
	
	
	

}
