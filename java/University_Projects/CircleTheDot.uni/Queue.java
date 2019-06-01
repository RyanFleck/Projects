public interface Queue<E> {
    public boolean isEmpty();
    public void enqueue( E o );
    public E dequeue();
}
