/* PART A: QUESTION ONE.
 * Provide an implementation of the Chopstick class. 
 * You should implement a mutual exclusion scheme in order to allow 
 * the philosophers to effectively use the chopsticks as shared resources. 
 * In order to achieve that, you must use the wait and notify methods of the Object class.
 * */

public class Chopstick {
	private int ID;
	private boolean free;
// hint: use a local variable to indicate whether the chopstick is free 
//                        (lying on the table), e.g.  private boolean free;
// Consider the WAIT and NOTIFY methods.

	Chopstick(int ID) {
		free = true;
		this.ID = ID;
	
	}
	
	synchronized void take() {
	if(free==false){try {wait();} catch (InterruptedException e) {e.printStackTrace();}}
	free = false;
	}
	
	synchronized void release() {
	free = true;
	notify();
	}
	    
	public int getID() {
	    return(ID);
	}
}
