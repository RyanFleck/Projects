import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;


public class GraphicTable extends JFrame {
	private Point center;
	private GraphicPlate plates[];
	private GraphicChopstick chops[];
	
	GraphicTable() {
		super();

		setTitle("Dining Philosophers");
		setSize(200, 200);
		setBackground(Color.GRAY);
		
		center = new Point(getSize().width/2, getSize().height/2);
		
		plates = new GraphicPlate[5];
		for(int i=0; i<5; i++) {
		plates[i] = 
			new GraphicPlate(i, center, new Point(center.x, center.y-70), 20);
		}
		
		chops = new GraphicChopstick[5];
		for(int i=0; i<5; i++) {
		chops[i] = new GraphicChopstick(i, center, 
		new Point(center.x, center.y-70), 
		new Point(center.x, center.y-40));
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	
	public void isHungry(int phID) {
		plates[phID].setColor(phID);
		repaint();
	}
	
	public void isThinking(int phID) {
		plates[phID].setColor(-1);
		repaint();
	}
	
	public void takeChopstick(int phID, int chID) {
		chops[chID].setColor(phID);
		repaint();
	}
	
	public void releaseChopstick(int phID, int chID) {
		chops[chID].setColor(-1);
		repaint();
	}
	
	public void paint(Graphics g) {
		g.setColor(this.getBackground());
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for(int i=0; i<5; i++) {
			plates[i].draw(g);
			chops[i].draw(g);
		}
	}


}
