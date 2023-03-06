import javax.swing.*;
import java.awt.*;

/**
 * this class is the GUI to display the winner
 * @author Alyssa Ysabellele Meneses
 * @author Lind Matthew Tan
 * @version 1.0
 */

public class WinnerDisplayGUI extends JFrame{
     private Player winner;
    /**
     * Constructor for WinnerDisplayGUI
     * @param winner player winner
     */
    public WinnerDisplayGUI(Player winner){
        super("Winner!");
        this.winner=winner;
        setLayout (new FlowLayout());
        JFrame.setDefaultLookAndFeelDecorated(true);
		init ();
		setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		//setBounds(600,300, 500,200);
        pack();
		setVisible (true);
    }

    /**
     * initializes contents for the WinnerDisplayGUI
     */
    public void init(){
        JLabel grats = new JLabel("Congratulations for Winning " + winner.getName()+"!");
        grats.setFont(new Font("SansSerif", Font.BOLD, 28));
        grats.setForeground(Color.WHITE);
        JPanel p = new JPanel();   

        if(winner.getColor().equalsIgnoreCase("Red"))
            p.setBackground(Color.RED);
        else
            p.setBackground(Color.BLUE);

        this.add(p);
        p.add(grats);
    
    }
}