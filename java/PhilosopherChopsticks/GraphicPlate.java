import java.awt.*;

class GraphicPlate {
	private Point center;
	private Point coords;
	private Color color;
	private int phID;
	private int angle;
	private int size;
	private int ident;
	
	GraphicPlate(int ident, Point center, Point coords, int size) {
		this.ident = ident;
		this.center = center;
		this.size = size;
		
		this.phID = -1;
		setColor(phID);
		
		this.angle = 72 * ident;
		this.coords = new Point(Graphic2D.rotate(coords.x, coords.y, 
							 center.x, center.y, angle));
		this.coords.x -= 10;
		this.coords.y += 5;
	}
	
	public void setColor(int phID) {
		this.phID = phID;
		
		if(phID == -1) {
			this.color = Color.black;
		}
		else if(phID == 0) {
			this.color = Color.red;
		}
		else if(phID == 1) {
			this.color = Color.blue;
		}
		else if(phID == 2) {
			this.color = Color.green;
		}
		else if(phID == 3) {
			this.color = Color.yellow;
		}
		else if(phID == 4) {
			this.color = Color.white;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(coords.x, coords.y, size, size);
	}

}

