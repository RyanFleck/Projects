
public class LinkedStack<E> implements Stack<E>{

    private static class Elem<T>{
        private T info;
        private Elem<T> next;
        private Elem( T info, Elem<T> next) {
            this.info = info;
            this.next = next;
        }
    }

    private Elem<E> top; // instance variable

	
    public LinkedStack() {
        top = null;
    }

	
    public boolean isEmpty() {
        return top == null;
    }

	
    public void push( E info ) {
        top = new Elem<E>( info, top );
    }

	
    public E peek(){
		
		//String testPeek = ""+top.info;
		//System.out.println("PEEK VALUE: '"+testPeek+"'");
		try{
			if( top.info != null )
				{
				return top.info;
				}
			}
		catch(NullPointerException e)
			{
				throw new EmptyStackException();
			}
		
		return null;
		

    }

	
    public E pop(){

        try{
		
        E savedInfo = top.info;

        Elem<E> oldTop = top;
        Elem<E> newTop = top.next;

        top = newTop;

        oldTop.info = null; // scrubbing the memory
        oldTop.next = null; // scrubbing the memory

		return savedInfo;}
		
		catch(NullPointerException e)
			{
				throw new EmptyStackException();
			}
		
		
    }
}
