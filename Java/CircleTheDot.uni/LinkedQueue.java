public class LinkedQueue<E> implements Queue<E> {

    private static class Elem<T> {

        private T value;
        private Elem<T> next;

        private Elem( T value, Elem<T> next ) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<E> front;
    private Elem<E> rear;

    public E peek()
    {
        if (front.value == null)
        {
            throw new EmptyStackException();
        }
        else
        {
            return front.value;
        }
    }

    public void enqueue( E o ) {
        if(o != null){
        Elem<E> newElem;
        newElem = new Elem<E>( o, null );

        if ( rear == null ) {
            front = rear = newElem;
        } else {
            rear.next = newElem;
            rear = newElem;
        }}else{throw new NullPointerException();}
    }

    public E dequeue() {
		try{
        E result = front.value;
        if ( front != null & front.next == null ) {
            front = rear = null;
        } else {
            front = front.next;
        }
        return result;}
		catch(NullPointerException e)
			{
				throw new EmptyQueueException();
			}
    }

    public boolean isEmpty() {
        return front == null;
    }

}
