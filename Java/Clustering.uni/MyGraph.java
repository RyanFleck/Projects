import java.util.*;

/**
 * 
 * Class MyGraph implements a graph using an (extended) adjacency matrix data structure
 * It implements the interface Graph<Integer,Double>: an Integer value is stored at each vertex and
 * corresponds to its index in the adjacency matrix; a Double value is stored at each edge and
 * corresponds to edge weight/distance.
 * 
 * For a description of the desired behavior of these methods consult the Graph interface.
 * 
 * @author Lucia Moura
 *
 */

public class MyGraph implements Graph<Integer,Double>{
	
	private int numVertices, numEdges; // number of edges and number of edges
	private ArrayList<MyVertex> vertices; // list of vertices idexed by the vertex index
	private LinkedList<MyEdge> edges; // list of edges
    private MyEdge [][] adjacencyMatrix; // This will be an numVertices by numVertices adjacency matrix. 
    									 // if vertex index i and index j are connected by edge e
    									 // then adjacencyMatrix[i,j]=e
	
    /**
     *  MyVertex: nested class implementing the Vertex interface 
     *  
     */
	public class MyVertex implements Vertex<Integer>{
		private int index;   // index of vertex in adjacency matrix valie in (0..numVertices-1)
		private String name; // label/name of vertex
		private int degree; // degree of vertex
		
		public MyVertex(int index, String name) {
			this.index=index; 
			this.name=name;
			this.degree=0;
		}

		public String getName() {
			return name;
		}
		@Override
		public Integer getElement() {
			return index;
		}
		@Override
		public String toString() {
			return "v"+index+":"+name;
		}
		
	}
	
	 /**
     *  MyEdge: nested class implementing the Edge interface 
     *  
     */
	public class MyEdge implements Comparable<MyEdge>, Edge<Double>  {
        private Double dist;
        private MyVertex v1, v2; 
        public MyEdge(double dist, MyVertex v1, MyVertex v2) {
        	this.dist=dist;
        	this.v1=v1;
        	this.v2=v2;
        }
		@Override
		public Double getElement() {
			return dist;
		}
		
		@Override
		public String toString() {
			return "e={"+v1+","+v2+"}"+" dist="+dist;
		}
		
		@Override
		public int compareTo(MyEdge o) {
			return (this.dist).compareTo(o.dist);
		}
		
	}
	
	/** 
	 * MyGraph() the constructor for the class
	 * the array names has length equals to the number n of vertices and specify the labels for vertices 0..n-1
	 * the arrays end1, end2, dist have length equals to the number m of edges
	 * Values end1[i] and end2[i] represent the indices (between 0..n-1) of the vertices that are endpoints of edge i
	 * dist[i] is the distance/weight of edge i
	*/
	
	public MyGraph(String [] names, int [] end1, int[] end2, double [] dist) {
		
		
		// part 1 create vertices 
		numVertices=names.length; // sets number of vertices which is the length of array names
		
		// *** start student to-do 1
		// complete here what is required for vertex creation
		System.out.println("!Vertex Creation Initialized. Vertices = "+numVertices+".");
		vertices = new ArrayList<MyVertex>();
		
		for(int x=0;x<names.length;x++)
			{	
				vertices.add(new MyVertex(x,names[x]));
			}
		System.out.println("!Vertex Creation Completed.\n");
		// *** end student to-do 1
		
		// part 2: create edges
		numEdges=end1.length; // sets the number of edges which is the length of arrays end1,end2,dist
		if ((end2.length!=numEdges) || (dist.length!=numEdges)) {
			throw new IllegalArgumentException("Uneven array sizes for 2nd 3rd 4th arguments.");
		
		}
		// initialize adjacency matrix with null
		adjacencyMatrix=new MyEdge[numVertices][numVertices];
		edges=new LinkedList<MyEdge>();
		for (int i= 0; i< numVertices; i++)
			for (int j=0; j< numVertices; j++) {
				adjacencyMatrix[i][j]=null;
			}
		// *** start student to-do 2
		// part to be completed below: create edges placing in LinkedList edges as well as
		// adding the edge reference to the correct position in adjacency matrix
		System.out.println("!Creation Initialized.");
		MyEdge tempEdge;
		for(int y=0;y<numEdges;y++)
			{
					///System.out.println("Edge "+dist[y]+" "+vertices.get(end1[y]).toString()+" "+vertices.get(end2[y]).toString()+" created.");
					//System.out.println(new MyEdge(dist[y],vertices.get(end1[y]),vertices.get(end2[y])).toString());
					tempEdge = new MyEdge(dist[y],vertices.get(end1[y]),vertices.get(end2[y]));
					edges.add(tempEdge);
					adjacencyMatrix[end1[y]][end2[y]] = tempEdge;
					adjacencyMatrix[end2[y]][end1[y]] = tempEdge;
			}
			
		
		for(int zed = 0; zed < numEdges ; zed++){
			System.out.println("Edge between "+end1[zed]+" and "+end2[zed]+" is "+adjacencyMatrix[end1[zed]][end2[zed]]);}
			
			
			
		System.out.println("!Edge Creation Completed.\n");
		// *** end student to-do 2
		
	}




	@Override
	public int numVertices() { // to be implemented by student in O(1)
		return numVertices; // return dummy value to be corrected
	}

	@Override
	public int numEdges() { // to be implemented by student in O(1)
		return numEdges; // return dummy value to be corrected
	}

	@Override
	public Iterable<Vertex<Integer>> vertices() { // to be implemented by student in O(n) where n is number of vertices
		return (Iterable<Vertex<Integer>>) new ArrayList<Vertex<Integer>>(vertices);
	}

	@Override
	public Iterable<Edge<Double>> edges() { // to be implemented by student in O(m) where m is number of edges
		return (Iterable<Edge<Double>>) new LinkedList<Edge<Double>>(edges);
	}

	@Override
	public int degree(Vertex<Integer> v) throws IllegalArgumentException { // to be implemented by student in O(1)
		int deg=0;
		for(int x=0;x<adjacencyMatrix[v.getElement()].length;x++){
			if((v.getElement()!=x)&&(adjacencyMatrix[v.getElement()][x]!=null))
			{deg++;}
			}
		return deg; // return dummy value to be corrected
	}

	@Override
	public Iterable<Edge<Double>> incidentEdges(Vertex<Integer> v) { // to be implemented by student in O(n), n number of vertices
		
		//System.out.println("Edge between "+end1[zed]+" and "+end2[zed]+" is "+adjacencyMatrix[end1[zed]][end2[zed]]);
		
		ArrayList iEdg = new ArrayList();
		
		for(int x=0; x<numVertices ; x++)
		{
			if(adjacencyMatrix[v.getElement()][x]!=null)
				{iEdg.add( adjacencyMatrix[v.getElement()][x] );}
			/*
			if(v.getElement()!=x){
				System.out.println("Edge at "+v.getElement()+" "+x+" "+adjacencyMatrix[v.getElement()][x]);
				iEdg.add(adjacencyMatrix[v.getElement()][x]);}
			*/
		}
		return (Iterable<Edge<Double>>) new ArrayList<Edge<Double>>(iEdg); // return dummy value to be corrected
	}

	@Override
	public Edge<Double> getEdge(Vertex<Integer> u, Vertex<Integer> v)
			throws IllegalArgumentException { 
		
		return adjacencyMatrix[u.getElement()][v.getElement()]; // return dummy value to be corrected
		
	}

	@Override
	public Vertex<Integer>[] endVertices( Edge<Double> e )
			throws IllegalArgumentException { // to be implemented by student in O(1)
		MyEdge x = edges.get( edges.indexOf(e) );
		MyVertex[] vertices = {x.v1,x.v2};
		return vertices;}

	@Override
	public Vertex<Integer> opposite(Vertex<Integer> v, Edge<Double> e)
			throws IllegalArgumentException { // to be implemented by student in O(1)
		
		MyEdge x = edges.get( edges.indexOf(e) );
		if(v.equals(x.v1)){return x.v2;}
		return x.v1; // return dummy value to be corrected
	}
	

}
