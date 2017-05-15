class Q2_Test
{
	public static void main (String args[])
	{
		StudentInfo.display();
		
		LinkedList A,B;	
		
		//CASE: Generic
		System.out.println("CASE: Generic");
        A =  new LinkedList<String>();
        B =  new LinkedList<String>();

        A.addLast("a");
        A.addLast("b");
        A.addLast("c");
       
        B.addLast("1");
        B.addLast("2");
        B.addLast("3");
		
		A.insertAfter("b",B);
		
		A.display();
		System.out.println("\n\n");
        
        //CASE: Multiple matching. Three c's
		System.out.println("CASE: Multiple matching. Three c's");

		A =  new LinkedList<String>();
        B =  new LinkedList<String>();
		
        A.addLast("a");
        A.addLast("b");
        A.addLast("c");
        A.addLast("c");
        A.addLast("c");
        A.addLast("d");
        A.addLast("e");

        B.addLast("1");
        B.addLast("2");
        B.addLast("3");


        A.insertAfter("c",B);
		A.display();
		System.out.println("\n\n");

        //CASE: Insert at last
		System.out.println("CASE: Insert at last");
        A =  new LinkedList<String>();
        B =  new LinkedList<String>();

        A.addLast("a");
        A.addLast("b");
        A.addLast("c");
        A.addLast("d");
        A.addLast("e");
        A.addLast("f");
        A.addLast("g");

        B.addLast("1");
        B.addLast("2");
        B.addLast("3");
        B.addLast("4");

        A.insertAfter("g",B);
		A.display();
		System.out.println("\n\n");

        //CASE: Blank other
		System.out.println("CASE: Blank other");
        A =  new LinkedList<String>();
        B =  new LinkedList<String>();

        A.addLast("a");
        A.addLast("b");
        A.addLast("c");
        A.addLast("d");
        A.addLast("e");
        A.addLast("f");
        A.addLast("g");

        A.insertAfter("c",B);
		A.display();
		System.out.println("\n\n");
		
		//Case: obj is a null
		System.out.println("Case: obj is a null");
		A =  new LinkedList<String>();
		B =  new LinkedList<String>();

        A.addLast("a");
        A.addLast("b");
        A.addLast("c");
        A.addLast("d");
        A.addLast("e");
        A.addLast("f");
        A.addLast("g");
		
		
		
		try{A.insertAfter(null,B);}
		catch(NullPointerException e){System.out.println("Succefully threw a null pointer. (obj was a null)");}	
		System.out.println("\n\n");
		
		//Case: Adding to a list that does not contain anything
		System.out.println("Case: Adding to a list that does not contain anything");
		A =  new LinkedList<String>();
        B =  new LinkedList<String>();
        
        B.addLast("1");
        B.addLast("2");
        B.addLast("3");
        B.addLast("4");
		
		
		
		try{A.insertAfter("a",B);}
		catch(IllegalArgumentException e){System.out.println("Succefully threw an IllegalArgumentException. (LinkedList did not contain obj as it was empty)");}	
		System.out.println("\n\n");
		
		//Case: adding to a list that does not contain obj
		System.out.println("Case: adding to a list that does not contain obj");
		A =  new LinkedList<String>();
        B =  new LinkedList<String>();
        
		A.addLast("a");
        A.addLast("b");
        A.addLast("c");
        A.addLast("d");
        A.addLast("e");
        A.addLast("f");
        A.addLast("g");
		
        B.addLast("1");
        B.addLast("2");
        B.addLast("3");
        B.addLast("4");
		
		
		
		try{A.insertAfter("z",B);}
		catch(IllegalArgumentException e){System.out.println("Succefully threw an IllegalArgumentException. (LinkedList did not contain obj)");}	
		System.out.println("\n\n");
		//***** Q2 *****
	}
}