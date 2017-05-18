import java.util.HashMap;
import java.util.Set;

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
	
	public Integer dijkstraDistanceToNode(GraphNode other){
		//Implement me!
		//Use a different class to keep track of the spanning set.
		//Include method in new class to re-factor spanning set with all nodes.
		return 0;
	}
	
	//Searches through two layers. Implement Dijsktra algorithm later.
	public Integer simpleDistanceToNode(GraphNode other){
		
		Integer distance = this.rawNodeDist(other);
		if(distance==null){
			
		}
		
		return distance;
	}
	
	private Integer rawNodeDist(GraphNode other){
		return this.nodeMap.get(other);
	}
	
	//Simple graph building methods:
	
	public void connect(GraphNode other,Integer distance){
		this.addSingleLink(other, distance,1);
		other.addSingleLink(this, distance,0);
	}
	
	public void addSingleLink(GraphNode other,Integer distance, int displayDist){
		nodeMap.put(other,distance);
		
		//This IF statement and int displayDist for testing and can be removed later.
		if(displayDist==1){System.out.println("Nodes "+this.getName()+" and "+other.getName()+" linked!\nDistance: "+nodeMap.get(other));
		}}
	
	
	

}
