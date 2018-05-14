package SEG2106.GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TrafficLightAnimation extends JPanel implements TrafficLightUserInterface{
	
	
	
	private Color [] red;
	private Color [] yellow;
	private Color [] green;
	private Color [] arrow;
	private Color [] greenAndArrow;
	
	private Color [] northColors;
	private Color [] southColors;
	private Color [] westColors;
	private Color [] eastColors;
	
	public TrafficLightAnimation() {
		
		setBackground(Color.LIGHT_GRAY);
		


		red = new Color [4];
		red[0] = Color.RED;
		red[1] = Color.BLACK;
		red[2] = Color.BLACK;
		red[3] = Color.BLACK;
		
		yellow = new Color [4];
		yellow[0] = Color.BLACK;
		yellow[1] = Color.YELLOW;
		yellow[2] = Color.BLACK;
		yellow[3] = Color.BLACK;
		
		green = new Color [4];
		green[0] = Color.BLACK;
		green[1] = Color.BLACK;
		green[2] = Color.GREEN;
		green[3] = Color.BLACK;
		
		arrow = new Color [4];
		arrow[0] = Color.BLACK;
		arrow[1] = Color.BLACK;
		arrow[2] = Color.BLACK;
		arrow[3] = Color.GREEN;
		
		greenAndArrow = new Color [4];
		greenAndArrow[0] = Color.BLACK;
		greenAndArrow[1] = Color.BLACK;
		greenAndArrow[2] = Color.GREEN;
		greenAndArrow[3] = Color.GREEN;
		
		// Initialize both horizontals to green, the rest to red
		northColors = green;
		southColors = green;
		
		westColors = red;
		eastColors = red;
	}
	
	// This is where you should do ALL your painting.
	// Here and in methods it calls.
	// Don't call it yourself. Swing does that for you.
	@Override
	public void paintComponent(Graphics g) {
		drawLights(g);
	}
	
	// I have moved all the painting stuff from your constructor here.
	private void drawLights(Graphics g) {
		int halfWayH = this.getWidth()/2;
		int halfWayV = this.getHeight()/2;
		
		int lightDiameter = this.getWidth()/12;
		
		// Draw the north horizontal light
		
		int y = lightDiameter/2;
		int i = 0;
		for (int x = halfWayH - 2*lightDiameter; x <= halfWayH + lightDiameter; x+= lightDiameter){
			drawLight(i,x,y,lightDiameter,northColors[i++],g );

		}
		

		
		// Draw the south horizontal light
		y = this.getHeight() - (int)(1.5*lightDiameter);
		i = 0;
		for (int x = halfWayH - 2*lightDiameter; x <= halfWayH + lightDiameter; x+= lightDiameter){
			drawLight(i,x,y,lightDiameter,southColors[i++],g );
		}
		
		
		// Draw the west vertical light
		int x = lightDiameter/2;
		i = 0;
		for (y = halfWayV - 2*lightDiameter; y <= halfWayV + lightDiameter; y+= lightDiameter){
			drawLight(i,x,y,lightDiameter,westColors[i++],g );
		}
		
		// Draw the east vertical light
		x = this.getWidth() - (int)(1.5*lightDiameter);
		i = 0;
		for (y = halfWayV - 2*lightDiameter; y <= halfWayV + lightDiameter; y+= lightDiameter){
				drawLight(i,x,y,lightDiameter,eastColors[i++],g );
		}
		
	}
	

	private void drawLight(int i, int x,int y, int diameter,Color c, Graphics g){
		if (i==3)
			drawArrow(x,y,diameter,c,g );
		else
			drawSphere(x,y,diameter,c,g );
		
	}
	
	
	private void drawSphere(int x,int y, int diameter,Color c, Graphics g){
		
		g.setColor(c);
		g.fillOval(x, y, diameter, diameter);
		
		g.setColor(Color.BLACK);
		g.drawOval(x, y, diameter, diameter);
	}
	
	
	private void drawArrow(int x,int y, int diameter,Color c, Graphics g){
		
		g.setColor(Color.BLACK);
		g.fillOval(x, y, diameter, diameter);
		
		g.setColor(c);
		int [] i = new int [8];
		int [] j = new int [8];
		
		int xArrowHead = x;
		int yArrowHead = y + diameter/2;
		
		i[0] = xArrowHead;
		j[0] = yArrowHead;
		
		i[1] = xArrowHead + diameter/3;
		j[1] = yArrowHead - diameter/3;
		
		i[2] = xArrowHead + diameter/3;
		j[2] = yArrowHead - diameter/12;
		
		i[3] = xArrowHead + diameter;
		j[3] = yArrowHead - diameter/12;
		
		i[4] = xArrowHead + diameter;
		j[4] = yArrowHead + diameter/12;
		
		i[5] = xArrowHead + diameter/3;
		j[5] = yArrowHead + diameter/12;
		
		i[6] = xArrowHead + diameter/3;
		j[6] = yArrowHead + diameter/3;
		
		i[7] = xArrowHead;
		j[7] = yArrowHead;
		
		g.fillPolygon(i, j, i.length);
		
		g.setColor(Color.BLACK);
		g.drawOval(x, y, diameter, diameter);
	}
	
	
	
	public void northGreen(){
		northColors = green;
		this.repaint();
	}
	
	public void northYellow(){
		northColors = yellow;
		this.repaint();
	}
	
	public void northRed(){
		northColors = red;
		this.repaint();
	}
	
	public void northArrow(){
		northColors = arrow;
		this.repaint();
	}
	
	
	public void northGreenAndArrow() {
		northColors = greenAndArrow;
		this.repaint();
	}

	public void southGreen(){
		southColors = green;
		this.repaint();
	}
	
	public void southYellow(){
		southColors = yellow;
		this.repaint();
	}
	
	public void southRed(){
		southColors = red;
		this.repaint();
	}
	
	public void southArrow(){
		southColors = arrow;
		this.repaint();
	}
	
	public void southGreenAndArrow() {
		southColors = greenAndArrow;
		this.repaint();
	}
	
	public void westGreen(){
		westColors = green;
		this.repaint();
	}
	
	public void westYellow(){
		westColors = yellow;
		this.repaint();
	}
	
	public void westRed(){
		westColors = red;
		this.repaint();
	}
	
	public void westArrow(){
		westColors = arrow;
		this.repaint();
	}
	
	public void westGreenAndArrow() {
		westColors = greenAndArrow;
		this.repaint();
		
	}
	
	public void eastGreen(){
		eastColors = green;
		this.repaint();
	}
	
	public void eastYellow(){
		eastColors = yellow;
		this.repaint();
	}
	
	public void eastRed(){
		eastColors = red;
		this.repaint();
	}
	
	public void eastArrow(){
		eastColors = arrow;
		this.repaint();
	}
	
	public void eastGreenAndArrow() {
		eastColors = greenAndArrow;
		this.repaint();
		
	}
	


}