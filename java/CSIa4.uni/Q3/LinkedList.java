import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    private static class Node<T> {

	private T value;
	private Node<T> prev;
	private Node<T> next;

	private Node(T value, Node<T> prev, Node<T> next) {
	    this.value = value;
	    this.prev = prev;
	    this.next = next;
	}
    }

    private Node<E> head;
    private int size;

    public LinkedList() {
	head = new Node<E>(null, null, null);
	head.prev = head.next = head;
	size = 0;
    }

    private class LinkedListIterator implements Iterator<E> {

		private Node<E> current = head;

		public boolean hasNext() {
			return (current.next != head);
		}

		public E next() {
			if (!hasNext()) {
			throw new NoSuchElementException();
			}

			current = current.next;

			return current.value;
		}
    }

    public Iterator<E> iterator() {
	return new LinkedListIterator();
    }

    public int size() {
	return size;
    }

    public void addFirst(E e) {

	if (e == null) {
	    throw new NullPointerException();
	}

	Node<E> second = head.next;

	head.next = new Node<E>(e, head, second);
	second.prev = head.next;

	size++;
    }

    /** 
     * Adds an element at the end of the list.
     *
     * @param obj the object to be added at the end of the list
     * @throws NullPointerException if obj is null.
     */
  
    public void addLast(E obj) {
    
        if (obj == null) {
            throw new NullPointerException();
        }
    
        Node<E> before, after;

	before = head.prev;
        after = head;
    
        before.next = new Node<E>(obj, before, after);
        after.prev = before.next;
    
        size++;
    }
  
  //***************Added for printing simplicity***************
   public String toString() {

        String str = "";

        if ( head != null )
		{
            Node p = head.next;
			try
			{
				while ( p.value!=null ) 
				{
					str += p.value.toString()+", ";
					p = p.next;
				}
			}
			catch(Exception e)
			{System.out.println("Trying to display a list of objects that has no toString function");}
        }
        return str;
    }
	//***************Added for printing simplicity***************
}