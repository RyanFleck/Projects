
/**
 * The class <b>Point</b> is a simple helper class that stares a 2 dimentional element on a grid
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class Point {

    /**
     * The coordinate of this point.
     */
    private int x;
    private int y;

    /**
     * Constructor 
     * 
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     */
    public Point(int x, int y){
        reset(x,y);
    }

 /**
     * Constructor 
     * 
     * @param p
     *            the Point to clone
     */
    public Point(Point p){
        reset(p.getX(),p.getY());
    }
    /**
     * Getter method for the attribute x.
     * 
     * @return the value of the attribute x
     */
    public int getX(){
        return x;
    }
    
    /**
     * Getter method for the attribute y.
     * 
     * @return the value of the attribute y
     */
    public int getY(){
        return y;
    }
    
    /**
     * Setter for x and y.
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     */
    public void reset(int x, int y){
        this.x = x;
        this.y = y;
    }

 }
