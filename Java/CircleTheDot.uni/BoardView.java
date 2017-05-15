import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


/**
 * The class <b>BoardView</b> provides the current view of the board. It extends
 * <b>JPanel</b> and lays out a two dimensional array of <b>DotButton</b> instances.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class BoardView extends JPanel {

    private static final long serialVersionUID = 1L;


  	/**
	 * The board is a two dimensionnal array of DotButtons instances
	 */
	private DotButton[][] board;


 	/**
	 * Reference to the model of the game
	 */
    private GameModel  gameModel;
 

	/**
     * Constructor used for initializing the board. The action listener for
     * the board's DotButton is the game controller
     * 
     * @param gameModel
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public BoardView(GameModel gameModel, GameController gameController) {

    	this.gameModel = gameModel;

		setBackground(Color.WHITE);
		setLayout(new GridLayout(gameModel.getSize(), 1));

		setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
		board = new DotButton[gameModel.getSize()][gameModel.getSize()];

		for (int row = 0; row < gameModel.getSize(); row++) {
			JPanel panel = new JPanel();
			if(row%2==0) {
				panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
				panel.setLayout(new FlowLayout(FlowLayout.LEADING,2,2));
			} else{
				panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
				panel.setLayout(new FlowLayout(FlowLayout.TRAILING,2,2));		
			}
			panel.setBackground(Color.WHITE);
		    for (int column = 0; column < gameModel.getSize(); column++) {
				board[column][row] = new DotButton(row, column, gameModel.AVAILABLE);
				board[column][row].addActionListener(gameController);
				panel.add(board[column][row]);
		    }
		    add(panel);
		}

    }

 	/**
	 * update the status of the board's DotButton instances based on the current game model
	 */

    public void update(){
    	for(int i = 0; i < gameModel.getSize(); i++){
			System.out.print("\n");
		   	for(int j = 0; j < gameModel.getSize(); j++){
				
		   		board[i][j].setType(gameModel.getCurrentStatus(i,j));
				System.out.print(" "+gameModel.getCurrentStatus(j,i));
		   	}
		}
		repaint();
    }

}
