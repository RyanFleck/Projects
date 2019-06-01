

/**
 * The class <b>Door</b> stores the information about one of the door: 
 * does it have the prize behind it? Is it open or closed? Was it 
 * selected by the player?
 * 
 * It provides other objects access to these information through some
 * <b>setters</b> and <b>getters</b>.
 * 
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */
public class Door {

	private Boolean door_prize, door_open, door_selected;
	public String door_name;

	public Door(String name)
	{
	this.door_name = name;
	this.door_prize = false;
	this.door_open = false; 
	this.door_selected = false;
	}

	public void reset()
	{
	this.door_prize = false;
	this.door_open = false; 
	this.door_selected = false;
	}
	
	public void open()
	{
	this.door_open = true; 
	}
	
	
	public boolean isOpen()
	{
	return(this.door_open); 
	}
	
	
	public void setPrize()
	{
	this.door_prize = true; 
	}
	
	
	public boolean hasPrize()
	{
	return(this.door_prize);
	}
	
	
	public void choose(){
	this.door_selected = true;
	}

	
	public boolean isChosen()
	{
	return(this.door_selected);
	}
	
	public String getName()
	{
	return(door_name);
	}
}
