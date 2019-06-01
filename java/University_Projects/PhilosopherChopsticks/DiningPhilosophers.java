public class DiningPhilosophers {

	public static void main(String args[]) {
		GraphicTable table = new GraphicTable();
		
		Chopstick c0 = new Chopstick(0);
		Chopstick c1 = new Chopstick(1);
		Chopstick c2 = new Chopstick(2);
		Chopstick c3 = new Chopstick(3);
		Chopstick c4 = new Chopstick(4);
		
		Philosopher p0 = new Philosopher(0, table, c0, c4);
		Philosopher p1 = new Philosopher(1, table, c1, c0);
		Philosopher p2 = new Philosopher(2, table, c2, c1);
		Philosopher p3 = new Philosopher(3, table, c3, c2);
		Philosopher p4 = new Philosopher(4, table, c4, c3);
		
		p0.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}
}
