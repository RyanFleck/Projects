/**
 * 
 */

import java.util.HashMap;

/**
 * @author rflec028
 *
 */
public class GraphNode {

	private HashMap<GraphNode,Integer> nodeMap;
	
	public GraphNode(){
		nodeMap = new HashMap<GraphNode,Integer>();
	}
	
	public void connect(GraphNode other,Integer distance){
		nodeMap.put(other,distance);
		other.connect(this, distance);
	}
	
	
	

}
