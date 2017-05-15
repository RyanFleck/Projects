public class LinkedList<E> {
  
    private static class Node<T> {
    
        private T value;
    
        private Node<T> previous;
        private Node<T> next;
    
        private Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
  
    private Node<E> head;
    private int size;
  
    public LinkedList() {
        head = new Node<E>(null, null, null);
        head.next = head.previous = head;
        size = 0;
    }
  
    /** Returns the size of this list.
     *
     * @return the size of this list
     */
  
    public int size() {
        return size;
    }
  
    /** 
     * Adds an element at the end of the list. THIS IS A SAMPLE
     * METHOD THAT CANNOT BE USED BY InserAfter !
     *
     * @param element the element to be added.
     * @return true since duplicated values are allowed.
     * @throws NullPointerException if elem is null.
     */
  
    public boolean addLast(E element) {
    
        if (element == null) {
            throw new NullPointerException();
        }
    
        Node<E> before, after;

	before = head.previous;
        after = head;
    
        before.next = new Node<E>(element, before, after);
        after.previous = before.next;
    
        size++;
    
        return true;
    }
	
	//********************Student created code********************
	public void insertAfter(E obj, LinkedList<E>Other)
	{
		if (obj==null){throw new NullPointerException("The obj parameter is a null");}
		
		Node temp=head.next;
		while(temp.value!=null&&!temp.value.equals(obj))
		{
			temp=temp.next;
		}//set the value of temp to be the node that the values will be inserted after
		if (temp.value==null)//obj is not in Other
		{throw new IllegalArgumentException("The LinkedList does not contain obj");}
		else
		{
			temp.next.previous=Other.head.previous;
			Other.head.previous.next=temp.next;
			Other.head.next.previous=temp;
			temp.next=Other.head.next;		
			Other.head.next=Other.head;
			Other.head.previous=Other.head;
		}
		
	}
	
  
   public void display()
   {
	   	Node temp=head.next;
		while(temp.value!=null)
		{
			System.out.println(temp.value);
			temp=temp.next;
		}
   }
   
  //********************Student created code********************
}