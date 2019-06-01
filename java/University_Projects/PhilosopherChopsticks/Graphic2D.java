import java.awt.*;

public class Graphic2D {

	public static Point rotate(int x, int y, int bX, int bY, int angle) {
		Point p = new Point();
		double a = Math.PI/(180.0/angle);
		
		p.x = (int)
			(x * Math.cos(a)
			- y * Math.sin(a)
			- Math.cos(a) * bX
			+ Math.sin(a) * bY
			+ bX);
		
		p.y = (int)
			(x * Math.sin(a)
			+ y * Math.cos(a)
			- Math.sin(a) * bX
			- Math.cos(a) * bY
			+ bY);
			
		return(p);
	}

}
