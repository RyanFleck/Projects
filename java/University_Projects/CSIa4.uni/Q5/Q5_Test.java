public class Q5_Test {

    public static BinarySearchTree tree = new BinarySearchTree();

    public static void main( String[] args ) {
        StudentInfo.display();
		
		
        tree.add( 5 );
        tree.add( 7 );
        tree.add( 2 );
        tree.add( 1 );
        tree.add( 3 );
        tree.add( 6 );
        tree.add( 8 );
        tree.add( 4 );
        
        System.out.print("Simple test cases:\n--------------------");
        
        //Simple functional test.
        System.out.print("\ncount(3,6) returns "+tree.count(3,6)+".");
        
        //Simple functional test.
        System.out.print("\ncount(1,10) returns "+tree.count(1,10)+".");
        
        
        //Simple functional test.
        System.out.print("\ncount(1,3) returns "+tree.count(1,3)+".");
        
        //Simple functional test.
        System.out.print("\ncount(1,0) returns "+tree.count(1,0)+".");
        
        
        
        System.out.print("\n\nNull test cases:\n--------------------");
        
        //Tests for malformed input.
        System.out.print("\n\nAttempting count(null,null)...");
         try
         {
             System.out.print("\ncount(null,null) returns "+tree.count(null,null)+"."); 
         }
         catch(NullPointerException e)
         {
             System.out.print("\nNull object caught, and cannot be used.");
         }
        
        //Tests again for malformed input.
        System.out.print("\n\nAttempting count(0,null)...");
         try
         {
             System.out.print("\ncount(null,null) returns "+tree.count(0,null)+"."); 
         }
         catch(NullPointerException e)
         {
             System.out.print("\nNull object caught, and cannot be used.");
         }
        
        
        
        //Add null object.
        tree = new BinarySearchTree();
        
        tree.add( 5 );
        tree.add( 7 );
        tree.add( 2 );
        tree.add( 1 );
        
        System.out.print("\n\nAttempting to add null object to tree...");
        try
         {
             tree.add( null );
         }
         catch(NullPointerException e)
         {
             System.out.print("\nNull object caught, and cannot be used.");
         }
         
         
         //Add null object.
        tree = new BinarySearchTree();
        //tree is empty.
        
        
        
        
        System.out.print("\n\nAttempting to find numbers in empty tree...");
        System.out.println("\nThis number should be zero ==> "+tree.count(0,100));
         
         
    }
}
