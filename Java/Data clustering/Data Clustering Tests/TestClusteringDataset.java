import java.util.LinkedList;

/**
 * Created by sahil_saroop on 2016-12-01.
 */
public class TestClusteringDataset {
	
    public static void main(String[] args) {
        
        /*** two types of datasets can be used: HARTIGAN and SPAETH
         *   comment out (choice 1) OR (choice 2) to select each of them
         */
    	/****  Choice 1: pick one of the files based on points in space **************/
        // String TXTFilePath= "dataset_SPAETH/spaeth_01.txt"; /** file path and name for SPAETH*/
        // Distance.FileType ft=  Distance.FileType.SPAETH; /** file format for SPAETH ***/
        
    	
        /***** Choice 2 : different types of data for clustering ****************/
        String TXTFilePath= "dataset_HARTIGAN/file02.txt"; /** file path and name for HARTIGAN */
        //String TXTFilePath= "dataset_HARTIGAN/file14.txt"; /** file path and name for HARTIGAN */
        // String TXTFilePath= "dataset_HARTIGAN/file27.txt"; /** file path and name for HARTIGAN */
        Distance.FileType ft=  Distance.FileType.HARTIGAN; /** file format for HARTIGAN ***/
        
        /**** Now select type of distance and how many clusters (Euclidean and Manhattan provided) ****/
        // Distance.Distances di= Distance.Distances.Euclidean; // other types of distances available in weka library
        Distance.Distances di= Distance.Distances.Manhattan;
        int numberOfClusters = 3; // select how many clusters you want
        
        System.out.println("Clustering data from dataset"+TXTFilePath);
        System.out.println("Using "+numberOfClusters+" clusters.");
        
        Distance d = new Distance();
        String[] names = d.getVerticesLabel(TXTFilePath, ft);
        int[][] points = d.getVertices(TXTFilePath, ft);
        int N=names.length; // number of vertices that will be created
        int[] v1 = points[0];
        int[] v2 = points[1];
        double[] dist = d.ComputeDistance(TXTFilePath, di);

        System.out.println("\nCreating graph");

        MyGraph spG=new MyGraph(names, v1, v2, dist);

        System.out.println("Initializing Kruskal Algorithms");

        KruskalAlgorithms<Integer,Double> clusterAlg = new KruskalAlgorithms<Integer, Double>();

        System.out.println("Next it will group vertices in "+numberOfClusters+  " clusters.");

        LinkedList<Edge<Double>> tree;
        Partition<Vertex<Integer>> clusters = new Partition<Vertex<Integer>>();
        System.out.println("before Kruskal Algorithm");
        tree=clusterAlg.kruskalClusters(spG, numberOfClusters, clusters);
        System.out.println("after Kruskal Algorithm");
        System.out.println("\nData was clustered as follows");
        System.out.println(clusters); // toString() is already implemented for class Partition.
        

    }

}
