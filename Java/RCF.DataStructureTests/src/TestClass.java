/**
 * @author rflec028
 *
 * This class is purely for convenience. 
 * 
 * For me, having the ability to set names helps organize things and speeds troubleshooting.
 * 
 * After all, I'm only human. Personifying inanimate objects things make work better.
 *
 */
public class TestClass {
	
	private String name;
	
	public TestClass(){
		name = ("Object:".concat(this.getClass().getSimpleName()));
		
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public String getName(){
		return name;
	}
}
