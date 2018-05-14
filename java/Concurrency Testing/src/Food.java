//Test git commit.
public class Food {

	public Food() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		
		
		
		Hog K2 = new Hog("Steve");
		Hog Kevin = new Hog("Kevin");
		Hog K3 = new Hog("Voldemar");
		
		Thread T1 = new Thread(K2);
		Thread T2 = new Thread(K3);
		Thread T3 = new Thread(Kevin);
		
		
		T1.run();
		T2.run();
		T3.run();
		
		

	}

}
