/**
 * 
 */
package com.rcf.app;

/**
 * @author rflec028
 *
 */
public class Logger {
	
	private String area;
	
	public Logger(String area) throws InvalidStringException {
		setArea(area);
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) throws InvalidStringException {
		this.area = area;
	}

}
