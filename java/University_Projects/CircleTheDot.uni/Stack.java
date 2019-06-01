/**
 * Stack Abstract Data Type. A Stack is a linear data structure
 * following last-in-first-out protocol, i.e. the last element
 * that has been added onto the Stack, is the first one to
 * be removed.
 *
 * @author Marcel Turcotte
 */

public interface Stack<E> {

    /**
     * Tests if this Stack is empty.
     *
     * @return true if this Stack is empty; and false otherwise.
     */

    public abstract boolean isEmpty();

    /**
     * Returns a reference to the top element; does not change
     * the state of this Stack.
     *
     * @return The top element of this stack without removing it.
     */

    public abstract E peek();

    /**
     * Removes and returns the element at the top of this stack.
     *
     * @return The top element of this stack.
     */

    public abstract E pop();

    /**
     * Puts an element onto the top of this stack.
     *
     * @param element the element be put onto the top of this stack.
     */

    public abstract void push( E element );

}
