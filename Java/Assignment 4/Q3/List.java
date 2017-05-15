public interface List<E> {
    void addFirst(E elem);
    void addLast(E elem);
    int size();
    Iterator<E> iterator();
}