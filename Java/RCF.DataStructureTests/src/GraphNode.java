import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

/**
 * @author rflec028
 *
 */
public class GraphNode extends TestClass{

	private HashMap<GraphNode,Integer> nodeMap;
	private Set nodeSet;
	private Iterator nodeMapIterator;
	
	public GraphNode(){
		System.out.println("Node created!");
		nodeMap = new HashMap<GraphNode,Integer>();
		generateIterator();
		//this.connect(this, 0);
	}
	private void generateIterator(){
		nodeSet = nodeMap.entrySet();
		nodeMapIterator = nodeSet.iterator();
	}
	
	//Queries and graph information:
	
	/*
	//NOT FUNCTIONAL. Implement with an iterator.
	public GraphNode[] getConnectedNodes(){
		System.out.println("Getting connected nodes...");
		//Set<GraphNode> connectedNodes = nodeMap.keySet();
		//GraphNode[] nodes = (GraphNode[]) connectedNodes.toArray();
		GraphNode[] nodes = (GraphNode[])nodeMap.keySet().toArray();
		for(GraphNode x : nodes){
			System.out.println("Connected node: "+x.getName());
		}
		return nodes;
	}*/
	
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
		
		System.out.println("Getting distance...");
		Integer distance = this.rawNodeDist(other);
		
		if(distance==null){
			System.out.println("A");
			generateIterator();
			System.out.println("B");
			while(nodeMapIterator.hasNext()){
				System.out.println("C");
				GraphNode temp = (GraphNode) nodeMapIterator.next();
				/*
				 * This is a huge problem- I need to contact someone with more java expertise.
				 * An error that keeps occuring:
				 * 	-Try to retrieve items from hashmap.
				 * 	-Items are returned as "object" and need to be cast to graphnode.
				 * 	-This line never runs.
				 */
				System.out.println("D");
				System.out.println("Node "+temp.getName()+" connected.");
				
			}
			
			return 0;}//Come back later.
		else{return distance;}
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
