import java.awt.event.*;
/** This class a collection of methods used to get the random piece animal
* @author Alyssa Ysabelle Meneses
* @author Lind Matthew Tan
* @version 1.0
*/
public class Controller extends MouseAdapter{
    private GUI gui;
    private int x=-1;
    private int y=-1;
    private int dX=-1;
    private int dY=-1;
    JButtonWithPos checkerTile;
    
    /**
     * This method moves the piece to its destination
     * @param gui GUI of the game
     * @param player1 first player
     * @param player2 second player
     */
    public Controller (GUI gui, Player player1, Player player2)
    {
        this.gui = gui;
        gui.addListener(this);
        Player p1 =player1;
        Player p2 =player2;
        GamePhase.gameStart(p1, p2);
    }
    
    /**
     * This method is the event listener for the game GUI, it also calls the display for the winner
     * @param e mouse event
     */
    @Override
    public void mouseClicked(MouseEvent e) {  
        checkerTile=(JButtonWithPos) e.getSource();
        
       
            if(x==-1 && y==-1){// if there is no moving piece
                x=checkerTile.getRow();
                y=checkerTile.getCol();
                if(GamePhase.isValidMovingPiece(x, y)==false){
                    x=-1;
                    y=-1;
                    dX=-1;
                    dY=-1;
                } 

            }
            else if(x==checkerTile.getRow() && y==checkerTile.getCol() && x!=-1 && y!=-1){// if you reselected the same moving piece, reset mover and destination
                System.out.println("CONTROLLER you have chosen to reselect "+ x+" "+y);
                x=-1;
                y=-1;
                dX=-1;
                dY=-1;
            }

            else{// picking a destination
                dX=checkerTile.getRow();
                dY=checkerTile.getCol();
                if (GamePhase.turn(x, y, dX, dY)==true){// if good move, renew icons
                    gui.chessButtons[dX][dY].setIcon(gui.chessButtons[x][y].getIcon());
                    gui.chessButtons[x][y].removeIcon();
                }
                x=-1;
                y=-1;
                dX=-1;
                dY=-1;
                
            }
        if(GamePhase.getBoard().checkWinner() == true){
            gui.disableChessButtons();
            WinnerDisplayGUI w = new  WinnerDisplayGUI( GamePhase.getWinner());

        }
        checkerTile=null;
    }
}
