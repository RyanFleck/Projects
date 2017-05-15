package SEG2106.core;

import javax.swing.JFrame;

import SEG2106.GUI.TrafficLightAnimation;
import SEG2106.GUI.TrafficLightUserInterface;

public class TrafficLightManager extends EventGenerator implements Runnable{

	private static TrafficLightManager trafficLightManager;

	private TrafficLightUserInterface trafficLightUI;

	private static final long TIMER_GREEN_PERIOD = 3000;
	private static final long TIMER_YELLOW_PERIOD = 1000;
	
	/**
	 * This methods implement the singleton pattern by allowing only a single
	 * instance of this class to be created
	 * @return TrafficLightManager instance
	 */
	public static TrafficLightManager getTrafficManager(){
		if (trafficLightManager == null){
			trafficLightManager = new TrafficLightManager();
		}
		return trafficLightManager;
	}


	private TrafficLightManager (){
		super();
		// Create the animation frame
		trafficLightUI = new TrafficLightAnimation();
		
		JFrame win = new JFrame("Traffic Light");
		win.setSize(800, 600);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		win.add((TrafficLightAnimation)trafficLightUI);
		win.setVisible(true);
		
		// Create thread that will generate timing events
		Thread t = new Thread(this);
		t.start();

	}
	
	
	public void setTrafficCondition(String trafficCondition){
		// Create and send an even regarding the traffic condition
		if (trafficCondition.equalsIgnoreCase("lowTraffic")){
			sendEvent(TRAFFIC_LOW_EVENT);
		}
		else if (trafficCondition.equalsIgnoreCase("moderateTraffic")){
			sendEvent(TRAFFIC_MODERATE_EVENT);
		}
		else if (trafficCondition.equalsIgnoreCase("highTraffic")){
			sendEvent(TRAFFIC_HIGH_EVENT);
		}
	}
	
	/**
	 * Generate timing events
	 */
	public void run(){
		while (true){
			try {
				Thread.sleep(TIMER_GREEN_PERIOD);
				sendEvent(TIMER_GREEN_EVENT);
				
				Thread.sleep(TIMER_YELLOW_PERIOD);
				sendEvent(TIMER_YELLOW_EVENT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Sends an event to all listening event handlers
	 */
	@Override
	protected void sendEvent(int eventID) {

		
		for (EventHandler handler: eventHandlers){
			switch (eventID){
				case TIMER_YELLOW_EVENT: handler.timerYellow();
				break;
				case TIMER_GREEN_EVENT: handler.timerGreen();
				break;
				case TRAFFIC_LOW_EVENT: handler.enterLowTraffic(); handler.exitHighTraffic(); handler.exitMediumTraffic();
				break;
				case TRAFFIC_MODERATE_EVENT: handler.enterMediumTraffic(); handler.exitHighTraffic(); handler.exitLowTraffic(); 
				break;
				case TRAFFIC_HIGH_EVENT: handler.enterHighTraffic();  handler.exitLowTraffic(); handler.exitMediumTraffic();
				break;
			}
		}
		
	}
	
	/**
	 * Methods to control the animation of the traffic light
	 */
	public void northGreen(){
		trafficLightUI.northGreen();
	}
	
	public void northGreenAndArrow(){
		 trafficLightUI.northGreenAndArrow();
	}
	
	public void northYellow(){
		trafficLightUI.northYellow();
	}
	
	public void northRed(){
		trafficLightUI.northRed();
	}
	
	public void northArrow(){
		trafficLightUI.northArrow();
	}
	
	

	public void southGreen(){
		trafficLightUI.southGreen();
	}
	
	public void southYellow(){
		trafficLightUI.southYellow();
	}
	
	public void southRed(){
		trafficLightUI.southRed();
	}
	
	public void southArrow(){
		trafficLightUI.southArrow();
	}
	
	public void southGreenAndArrow(){
		 trafficLightUI.southGreenAndArrow();
	}
	
	public void westGreen(){
		trafficLightUI.westGreen();
	}
	
	public void westYellow(){
		trafficLightUI.westYellow();
	}
	
	public void westRed(){
		trafficLightUI.westRed();
	}
	
	public void westArrow(){
		trafficLightUI.westArrow();
	}
	
	public void westGreenAndArrow(){
		trafficLightUI.westGreenAndArrow();
	}
	
	public void eastGreen(){
		trafficLightUI.eastGreen();
	}
	
	public void eastYellow(){
		trafficLightUI.eastYellow();
	}
	
	public void eastRed(){
		trafficLightUI.eastRed();
	}
	
	public void eastArrow(){
		trafficLightUI.eastArrow();
	}
	
	public void eastGreenAndArrow(){
		trafficLightUI.eastGreenAndArrow();
	}
	
	/*************************************/

}
