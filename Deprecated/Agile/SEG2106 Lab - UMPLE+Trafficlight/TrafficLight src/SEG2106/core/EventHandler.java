package SEG2106.core;

public interface EventHandler {

	public boolean timerYellow();
	public boolean timerGreen();
	//modified the methods to work with generated code//
	public boolean enterMediumTraffic();
	public boolean enterLowTraffic();
	public boolean enterHighTraffic();
	// allows exit of states when changing to a different mode//
	public boolean exitLowTraffic();
	public boolean exitMediumTraffic();
	public boolean exitHighTraffic();
}
