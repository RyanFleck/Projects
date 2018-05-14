package SEG2106.core;

import java.util.LinkedList;
import java.util.List;


public abstract class EventGenerator extends Thread{
	// Declaring some constants
	protected static final int EVENT_HANDLERS_LIMIT = 100;
	
	protected static final int TRAFFIC_HIGH_EVENT = 1;
	protected static final int TRAFFIC_MODERATE_EVENT = 2;
	protected static final int TRAFFIC_LOW_EVENT = 3;
	protected static final int TIMER_GREEN_EVENT = 4;
	protected static final int TIMER_YELLOW_EVENT = 5;
	
	protected List<EventHandler> eventHandlers;
	
	public EventGenerator (){
		
		eventHandlers = new LinkedList<EventHandler>();
		
	}
	

	
	public boolean addEventHandler(EventHandler handler){
		if (eventHandlers.size() < EVENT_HANDLERS_LIMIT){
			eventHandlers.add(handler);
			return true;
		}
		else {
			return false;
		}
	}
	
	protected abstract void sendEvent(int eventID);
	
	public abstract void run();
}
