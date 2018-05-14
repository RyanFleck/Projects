

/**
 * The class <b>CircleTheDot</b> launches the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class CircleTheDot {


   /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If a game size (>4) is passed as parameter, it is 
     * used as the board size. Otherwise, a default value is passed
     * 
     * @param args
     *            command line parameters
     */
     public static void main(String[] args) {
       
        int size = 9;
        if (args.length == 1) {
            try{
                size = Integer.parseInt(args[0]);
                if(size<4){
                    System.out.println("Invalide argument, using default...");
                    size = 9;
                }
            } catch(NumberFormatException e){
                System.out.println("Invalide argument, using default...");
            }
        }
        GameController game = new GameController(size);
        StudentInfo info = new StudentInfo();
        info.display();
    }


}
