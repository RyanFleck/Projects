/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node(T value, Node<T> next) {
            this.value = value;
            this.next  = next;
        }
    }

    // Instance variable

    private Node<E> head;

    //  ----------------------------------------------------------
    //  SinglyLinkedList methods
    //  ----------------------------------------------------------

    public void addFirst( E item ) {
        if (item == null) {
            throw new NullPointerException("Illegal argument");
        }

        head = new Node<E>(item, head);
    }

    public boolean isEmpty() { 
        return head == null; 
    }

    public SinglyLinkedList<E> take(int n) 
	{
		return this.first(n);
    }
	
	private SinglyLinkedList<E> first(int n) 
	{
		if (isEmpty()&&n!=0)
		{
			throw new IllegalArgumentException();
			
		}
		else if (isEmpty()||n==0)
		{
			return new SinglyLinkedList();
		}
		
		SinglyLinkedList ret;
		E p=head.value;
		
		head=head.next;
		ret=first(n-1);
		ret.addFirst(p);
		this.addFirst(p);		
		
		return ret;
	}
    //  ----------------------------------------------------------
    //  Other instance methods
    //  ----------------------------------------------------------

    @Override
    public String toString() {
        return "{" + toString(head) + "}";
    }

    private String toString(Node<E> p) {

        String result = "";

        if (p != null) {
            result = p.value.toString();
            if (p.next != null) {
                result = result + "," + toString(p.next);
            }
        }

        return result;
    }
}
