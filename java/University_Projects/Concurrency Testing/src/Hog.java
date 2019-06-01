/**
 * @author rflec028
 *
 */
public class Hog implements Runnable{
	private String name;
	/**
	 * @throws InterruptedException 
	 * 
	 */
	public Hog(String iame) throws InterruptedException {
		name = iame;
		System.out.println(name+" is awake...");
		
	}
	@Override
	public void run() 
	{
		System.out.println(name+"Is hogging all the food.");
		eat();
				
		
		
	}
	
	private void eat()
	{
		System.out.println(name+" ate food.");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}


}
