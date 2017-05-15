/**
 * The class <b>Pair</b> as seen in the lectures for ITI1121
 *
 * @author Marcel Trucotte, University of Ottawa
 */

public class Pair<T> {
    private T first;
    private T second;
    public Pair( T first, T second ) {
	this.first = first;
	this.second = second;
    }
    public T getFirst( ) {
	return first;
    }
    public T getSecond( ) {
	return second;
    }
}
