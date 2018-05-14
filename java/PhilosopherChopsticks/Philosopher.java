public class Philosopher extends Thread {
	private GraphicTable table;
	private Chopstick left;
	private Chopstick right;
	private int ID;
	final int timeThink_max = 5000;
	final int timeNextFork = 100;
	final int timeEat_max = 5000;
	
	Philosopher(int ID, GraphicTable table, Chopstick left, Chopstick right) {
		this.ID = ID;
		this.table = table;
		this.left = left;
		this.right = right;
		setName("Philosopher "+ID);
	}
	
	public void run() {
		while(true){
			
			// Tell the table GUI that I am thinking
			table.isThinking(ID);
			// Print to console that I am thinking
			System.out.println(getName()+" thinks");
			
			// Let the thread sleep (in order to simulate thinking time)
			try {
				sleep((long)(Math.random()*timeThink_max));
			} catch(InterruptedException e) {
				System.out.println(e);
			}
			
			// Done with thinking
			System.out.println(getName()+" finished thinking"); 
			 
			// and now I am hungry!
			System.out.println(getName()+" is hungry"); 
			// Tell the GUI I am hungry...
			table.isHungry(ID);
			
			// Let's try to get the left chopstick
			System.out.println(getName()+" wants left chopstick");
			left.take();
			
			// Tell the GUI that I took the left chopstick
			table.takeChopstick(ID, left.getID());
			System.out.println(getName()+" got left chopstick");
			
			// I'll wait a bit before I try to get the next chopstick (it's philosopher's etiquette)
			try {
				sleep(timeNextFork);
			} catch(InterruptedException e) {
				System.out.println(e);
			} 
			
			// Ok, enough etiquette nonesense, now I need my right chopstick
			System.out.println(getName()+" wants right chopstick");
			right.take();

			// Got it!
			table.takeChopstick(ID, right.getID());
			System.out.println(getName()+" got right chopstick");
			
			// Sweet taste of steamed rice....
			System.out.println(getName()+" eats"); 
			try {
				sleep((long)(Math.random()*timeEat_max));
			} catch(InterruptedException e) {
				System.out.println(e);
			}
			
			// Ok, I am really full now
			System.out.println(getName()+" finished eating"); 
			
			// I just realized I did not wash these chopsticks 
			// and the philosopher on my right is coming down with a flu 
			
			// I'll release the left chopstick
			table.releaseChopstick(ID, left.getID());
			left.release();
			System.out.println(getName()+" released left chopstick");

			// I'll release the right chopstick
			table.releaseChopstick(ID, right.getID());
			right.release();
			System.out.println(getName()+" released right chopstick");
		
		}
	}
}
