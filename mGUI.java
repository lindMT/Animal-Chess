import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** This class is the GUI for menu
* @author Alyssa Ysabelle Meneses
* @author Lind Matthew Tan
* @version 1.0
*/
public class mGUI extends JFrame{
    private JLabel welcome1;
    private JLabel welcome2;
    private JButton pSetup;

    /**constructor for mGUI */
    public mGUI(){
        super("Animal Chess Menu");

        setLayout (new GridLayout(2,1));
        JFrame.setDefaultLookAndFeelDecorated(true);
		init ();
		setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		setBounds(600,300, 500,300);
		setVisible (true);
    }
    /**initializer for mGUI */
    public void init(){
        welcome1 = new JLabel("Welcome to Animal Chess!");
        welcome1.setFont(new Font("SansSerif", Font.BOLD, 28));
        welcome2 = new JLabel("Setup player info to start the game.");
        welcome2.setFont(new Font("SansSerif", Font.ROMAN_BASELINE, 18));

        pSetup = new JButton("Begin Setup.");
        pSetup.setPreferredSize(new Dimension(300, 100));
        pSetup.setBackground(new Color(59, 59, 59));
        pSetup.setForeground(Color.WHITE);
        pSetup.setFocusPainted(false);
        pSetup.setFont(new Font("SansSerif", Font.ROMAN_BASELINE, 20));

        JPanel[][] pHolder = new JPanel[2][1];   
       

        for(int m = 0; m < 2; m++) {
            pHolder[m][0] = new JPanel();
            this.add(pHolder[m][0]);
        }
        pHolder[0][0].add(welcome1);
        pHolder[0][0].add(welcome2);
        pHolder[1][0].add(pSetup);
    
    }
    /** 
     * this method sets listener for mGUI
     * @param listener action listener to be set
     */
    public void setListener(ActionListener listener){
        pSetup.addActionListener(listener);
    }
    /** 
     * this method changes button enabled or not
     * @param b determines if disabling or enabling buttons (true if yes, false if not)
     */
    public void enablePlayerbtn(boolean b){
        pSetup.setEnabled(b);
    }


}