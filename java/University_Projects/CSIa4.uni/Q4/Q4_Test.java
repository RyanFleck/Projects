public class Q4_Test {


    public static void main( String[] args ) 
	{
		StudentInfo.display();
		SinglyLinkedList things = new SinglyLinkedList();
		things.addFirst(5);
		things.addFirst(4);
		things.addFirst(3);
		things.addFirst(2);
		things.addFirst(1);
		System.out.println("Things: "+things);
		System.out.println("first 3 things: "+things.take(3));
		System.out.println("first 5 things: "+things.take(5));
		System.out.println("first 0 things: "+things.take(0));
		
		things = new SinglyLinkedList();
		System.out.println("Things has been emptied");
		try
		{System.out.println("first 3 things in an empy list: "+things.take(0));}
		catch (NullPointerException e)
		{System.out.println("Attempted to find the first three elements in an empy list and successfully caught a NullPointerException");}

		things.addFirst(3);
		things.addFirst(2);
		things.addFirst(1);
		things.addFirst(0);
		System.out.println("Things has had 0-3 added: ");
		try
		{System.out.println("first 5 things in a list of only 4: "+things.take(5));}
		catch(IllegalArgumentException e)
		{System.out.println("Attempted to find the first five elements in a list of 4 and successfully caught a IllegalArgumentException");}
    }
}
