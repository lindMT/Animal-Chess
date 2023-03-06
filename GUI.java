import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
import javax.imageio.ImageIO;

/** This class is the GUI for the game
* @author Alyssa Ysabelle Meneses
* @author Lind Matthew Tan
* @version 1.0
*/
public class GUI extends JFrame{
    private Image Grass;
    private Image redHouse;
    private Image redTrap;
    private Image blueHouse;
    private Image blueTrap;
    private Image River;
    private JPanelWithImage [][] pHolder;
    private BufferedImage [][] chessPieceImages;
    private ImageIcon emptyIcon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
    public JButtonWithPos[][] chessButtons = new JButtonWithPos[7][9];
       
    /**
     * constructor for game GUI
     */
    public GUI(){

        super("Animal Chess");
        GridLayout layout = new GridLayout(7,9);

        layout.setHgap(0);
        layout.setVgap(0);
        setLayout(layout);
        
        loadImages();
        
        pHolder= new JPanelWithImage[7][9];
        
        for(int m = 0; m < 7; m++) {
            for(int j=0; j< 9; j++){

                if((m==1||m==2||m==4||m==5)&& (j==3|| j== 4 || j==5)){
                    pHolder[m][j] = new JPanelWithImage(River);
                }
                
                else if ((m==2 && j==0)||(m==4 && j==0)||(m==3 && j==1)){
                    pHolder[m][j] = new JPanelWithImage(redTrap);
                }
                else if ((m==2 && j==8)||(m==4 && j==8)||(m==3 && j==7)){
                    pHolder[m][j] = new JPanelWithImage(blueTrap);
                }

                else if (m==3 && j==0){
                    pHolder[m][j] = new JPanelWithImage(redHouse);
                }
                else if (m==3 && j==8){
                    pHolder[m][j] = new JPanelWithImage(blueHouse);
                }
               
                else{
                    pHolder[m][j] = new JPanelWithImage(Grass);
                }

                this.add(pHolder[m][j]);
                pHolder[m][j].setSize(78,78);//64 64 aasdf
                pHolder[m][j].setVisible(true);
            }
      }

        setBounds(100, 100, 702, 546);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        setResizable(false);
        
        

        for(int i=0; i<7;i++){
            for(int j=0; j<9; j++){
                chessButtons[i][j]= new JButtonWithPos(i, j);
            }
        }

        // sets icon for tiles with pieces
            //red
        chessButtons[0][0].setIcon(new ImageIcon(chessPieceImages[0][5]));
        chessButtons[0][2].setIcon(new ImageIcon(chessPieceImages[0][7]));
        chessButtons[1][1].setIcon(new ImageIcon(chessPieceImages[0][1]));
        chessButtons[2][2].setIcon(new ImageIcon(chessPieceImages[0][2]));
        chessButtons[4][2].setIcon(new ImageIcon(chessPieceImages[0][4]));
        chessButtons[5][1].setIcon(new ImageIcon(chessPieceImages[0][3]));
        chessButtons[6][0].setIcon(new ImageIcon(chessPieceImages[0][6]));
        chessButtons[6][2].setIcon(new ImageIcon(chessPieceImages[0][0]));
            //blue
        chessButtons[0][6].setIcon(new ImageIcon(chessPieceImages[1][0]));
        chessButtons[0][8].setIcon(new ImageIcon(chessPieceImages[1][6]));
        chessButtons[1][7].setIcon(new ImageIcon(chessPieceImages[1][3]));
        chessButtons[2][6].setIcon(new ImageIcon(chessPieceImages[1][4]));
        chessButtons[4][6].setIcon(new ImageIcon(chessPieceImages[1][2]));
        chessButtons[5][7].setIcon(new ImageIcon(chessPieceImages[1][1]));
        chessButtons[6][6].setIcon(new ImageIcon(chessPieceImages[1][7]));
        chessButtons[6][8].setIcon(new ImageIcon(chessPieceImages[1][5]));
       
        // adds to board
        for(int i=0; i<7; i++){
            for(int j=0; j<9; j++){
                if(chessButtons[i][j].getIcon()==null){
                    chessButtons[i][j].setIcon(emptyIcon);
                }
                
                chessButtons[i][j].setSize(new Dimension(78,78));

                chessButtons[i][j].setOpaque(false);
                chessButtons[i][j].setContentAreaFilled(false);
                chessButtons[i][j].setBorderPainted(false);
                pHolder[i][j].setLayout(new CardLayout());
                pHolder[i][j].add(chessButtons[i][j]);
            }
        }

        setVisible (true);

    }

    /**
     * this method loads the images in to the chessPieceImages[][]
     */
    private void loadImages(){

        chessPieceImages = new BufferedImage[2][8];
        

        try {
            BufferedImage bi = ImageIO.read(new File ("animal.png"));
            
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 8; j++) {
                    chessPieceImages[i][j] = bi.getSubimage(j * 64, i * 64, 64, 64);
                }
            }

            Grass = ImageIO.read(new File ("Grass.png"));
            
            redTrap = ImageIO.read(new File("Red_Trap.png"));
            blueTrap = ImageIO.read(new File("Blue_Trap.png"));

            redHouse = ImageIO.read(new File ("Red_House.png"));
            blueHouse = ImageIO.read(new File("Blue_House.png"));
            River = ImageIO.read(new File("River.png"));



        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * this method adds the mouse adapter listener
     */
    public void addListener (MouseAdapter listener)
	{
        
        this.addMouseListener (listener);
         for(int i=0; i< 7; i++){
            for(int j=0; j<9; j++){
                chessButtons[i][j].addMouseListener (listener);
                pHolder[i][j].addMouseListener (listener);
            }
        }
       
	}
    /**
     * this method disables the chess buttons
     */
    public void disableChessButtons(){
        for(int i=0; i< 7; i++){
            for(int j=0; j<9; j++){
                chessButtons[i][j].setEnabled(false);
            }
        }
    }
    
}