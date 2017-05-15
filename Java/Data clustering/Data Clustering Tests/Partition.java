/**
 * 
 * Disjoint Partition of a set providing an union-find data structure
 * where clusters are implemented as linked lists of elements of type T 
 * Each cluster is represented by a Dnode of a doubly linked list of clusters
 * Each cluster/Dnode, points to a singly linked list of Node each containing an element in the cluster.
 * For efficient implementation of method find, each Node points to the Dnode of the cluster it belongs to.
 * 
 * @author Lucia Moura
 *
 * @param <T>
 */
public class Partition <T> {
	
	// inner class specifying a node in the singly linked lists
	public class Node {
		private Node next;
		private T element;
		private Dnode cluster=null;
		public Node (T element, Node next, Dnode cluster) {
			this.element=element;
			this.next=next;
			this.cluster=cluster;
		}
	}
	
	// inner class specifying a node in the doubly linked list of clusters
	public class Dnode {
		private Node first;
		private Dnode next, prev;
		private int size;
		
		Dnode(Node first, Dnode prev, Dnode next) {
			this.first=first;
			this.prev=prev;
			this.next=next;
			this.size=0;
		}
		
	}
		
	private Dnode headCluster, tailCluster; // references to the dummy head and tail of the doubly linked list
	private int countClusters; // size of doubly linked list (not counting the dummies)
	
	public Partition() {	
		// creates an empty doubly linked list of clusters with dummy head and tail
		headCluster=new Dnode(null,null,null);
		tailCluster=new Dnode(null,headCluster,null);
		headCluster.next=tailCluster;
		countClusters=0;
	}
	
	public int numClusters() {
		return countClusters;
	}
	/**
	 * makeCluster creates a new cluster formed by the given element and inserts at the end of the list of clusters
	 * @param element
	 */
	public Node makeCluster(T element) {  // nothing needs to be changed here
		Node newNode=new Node(element,null,null);
		Dnode newCluster=new Dnode(newNode,tailCluster.prev,tailCluster);
		tailCluster.prev.next=newCluster;
		tailCluster.prev=newCluster;
		newCluster.first.cluster=newCluster;
		newCluster.size++;
		countClusters++;
		return newNode;
	}

	/****** for students to implement ***
	 * find returns the Dnode corresponding to the cluster where the node belongs to
	 * 
	 */
	public Dnode find(Node node) {
		return node.cluster;
	}
	
	/******** for students to implement ****
	 *  union returns merges the cluster where node p belongs to with the one node q belongs to.
	 *  This method must run in O(min(n_q,n_p)) time, where n_p is the size of the cluster of node p
	 *  and n_q is the size of the cluster of node q.
	 *  Note: You must do appropriate updates on the linked list and double linked list and its corresponding
	 *  nodes and sizes to correctly reflect the fact that the clusters have been merged.
	 *  */
	public void union (Node p, Node q) {
		System.out.println("\n\n\nUNION INITIATED\n+++++++++++++++\n");
		System.out.println("Size of cluster p:"+p.cluster.size+" element is "+p.element);
		System.out.println("Size of cluster q:"+q.cluster.size+" element is "+q.element);
		
		Dnode longDNode;
		Dnode shortDNode;
		
		//Printouts for testing.
		System.out.print(" Assigning long and short clusters... ");
		
		
		//Assign long and short clusters.
		if(p.cluster.size>q.cluster.size)
		{
			longDNode = p.cluster;
			shortDNode = q.cluster;
			System.out.print("Placing "+q.element+" into "+p.element+"...");
			p.cluster.size+=q.cluster.size;
		}
		else
		{
			longDNode = q.cluster;
			shortDNode = p.cluster;
			System.out.print("Placing "+p.element+" into "+q.element+"...");
			q.cluster.size+=p.cluster.size;
		}
		
		//Printouts for testing.
		System.out.println(" Done.");
		System.out.print("Finding end of short cluster...");
		
		
		//Reassign Nodes to a DNode.
		Node i = shortDNode.first;
		i.cluster=longDNode;
		while(i.next!=null)
		{	
			i=i.next;
			i.cluster=longDNode;
			
		}
		
		
		//Printouts for testing.
		System.out.println(" "+i.element+".");
		System.out.print("Rearranging nodes...");
		
		
		//Move head of short cluster to head of long cluster, and head of long cluster to tail of short cluster.
		Node x = longDNode.first;
		i.next = x;
		longDNode.first = shortDNode.first;
		//shortDNode.first = null;
		
		
		//Printouts for testing.
		System.out.println(" Done.");
		System.out.print("Rearranging clusters...");
		
		//Removing DNode.
		Dnode temp = shortDNode;
		Dnode previous = shortDNode.prev;
		Dnode next = shortDNode.next;
		previous.next = next;
		next.prev = previous;
		
		
		//Output for testing.
		System.out.println(" Done.\nSystem at present:");
		Dnode C = headCluster;
		Node N;
		int num = 0;
		while(C.next!=null)
		{
			C = C.next;
			N = C.first;
			num++;
			
			if(N!=null){System.out.print("\nDNODE"+num+": ");}
			
			while(N!=null)
			{
				System.out.print(N.element);
				N=N.next;
			}
			
			//Prints the location of insertions and the area around the deletion.
			if(C.equals(longDNode)){System.out.print(" <INSERTION");}
			if(C.equals(temp.prev)){System.out.print(" <START DELETION");}
			if(C.equals(temp.next)){System.out.print(" <END DELETION");}
		}
		
		System.out.println("\n\n++++++++++++++\nUNION COMPLETE\n");
	}
	
	@Override
	public String toString() {
		// prints all clusters information and elements (nothing to be changed here)
		StringBuilder s = new StringBuilder(); int num=0;
		for (Dnode d=headCluster.next; d!=tailCluster; d=d.next) {
			s.append("Cluster ");
		    s.append(++num); s.append(" (size="); s.append(d.size); s.append("): ");
			for (Node n=d.first; n!=null; n=n.next) {
				s.append(n.element.toString());
				s.append(',');
			}
			s.append("\n");
		}
		return s.toString();
	}
	
}
