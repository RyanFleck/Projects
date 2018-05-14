public class Q3_Test {


    public static void main( String[] args ) {
		StudentInfo.display();
		LinkedList things=new LinkedList ();
		things.addLast("Dan");
		things.addLast("A banana");
		things.addLast("Some socks");
		things.addLast("Dan");
		things.addLast("Dan");
		things.addLast("A potato");
		things.addLast("Stanley");
		things.addLast("A sweaty glove");
		things.addLast("A beard Comb");
		things.addLast("A potato");
		things.addLast("Dan");
		
		System.out.println("Things: "+things);
		System.out.println("Things that are Dan: "+ListUtil.indexOfAll(things, "Dan"));
		System.out.println("Things that are A potato: "+ListUtil.indexOfAll(things, "A potato"));
		System.out.println("Things that dont are null: "+ListUtil.indexOfAll(things, null));
		things=new LinkedList ();
		System.out.println("Things that dont appear in an empty list: "+ListUtil.indexOfAll(things, "Peter"));
    }
}
