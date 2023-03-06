import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

/** This class the GUI for the player interface
* @author Alyssa Ysabelle Meneses
* @author Lind Matthew Tan
* @version 1.0
*/
public class pGUI extends JFrame{
    private JTextField tx1;
    private JButton jbN1;
    private JButton jb1;
    private JButton jb2;
    private JButton jb3;
    private JButton jb4;
    private JButton jb5;
    private JButton jb6;
    private JButton jb7;
    private JButton jb8;
    private JLabel animal1;
    private JLabel color1;
    private JButton jb1R;
    private JButton jb1B;

    private JTextField tx2;
    private JButton jbN2;
    private JButton jb2_1;
    private JButton jb2_2;
    private JButton jb2_3;
    private JButton jb2_4;
    private JButton jb2_5;
    private JButton jb2_6;
    private JButton jb2_7;
    private JButton jb2_8;
    private JLabel animal2;
    private JLabel color2;
    private JButton jb2R;
    private JButton jb2B;

    private JButton Finish;

    private String p1name;
    private String p1color;
    private String p2name;
    private String p2color;  

    /**
     * Constructor for the player GUI
     */
    public pGUI(){
        super("Player Info Getter");
        setLayout (new GridLayout(6, 2));
		init ();
		setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		setBounds(600,300, 650,400);
		setVisible (true);
    }
    /**
     * Initializer for the player GUI
     */
    public void init(){
        tx1 = new JTextField();
        tx1.setColumns(25);
        jbN1 = new JButton("Save P1 Name");    
        jb1 = new JButton("P1 Random Animal");   
        jb2 = new JButton("P1 Random Animal");
        jb3 = new JButton("P1 Random Animal");      
        jb4 = new JButton("P1 Random Animal");      
        jb5 = new JButton("P1 Random Animal");
        jb6 = new JButton("P1 Random Animal");
        jb7 = new JButton("P1 Random Animal");      
        jb8 = new JButton("P1 Random Animal");
        jb1R = new JButton("P1 Red");
        jb1B = new JButton("P1 Blue");
        animal1 = new JLabel("Animal Chosen: none");
        animal1.setFont(new Font("Serif", Font.BOLD, 18));
        color1 = new JLabel("Color: not selected yet");
        color1.setFont(new Font("Serif", Font.BOLD, 18));

        tx2 = new JTextField();
        tx2.setColumns(25);
        jbN2 = new JButton("Save P2 Name");    
        jb2_1 = new JButton("P2 Random Animal");    
        jb2_2 = new JButton("P2 Random Animal");
        jb2_3 = new JButton("P2 Random Animal");    
        jb2_4 = new JButton("P2 Random Animal");    
        jb2_5 = new JButton("P2 Random Animal");
        jb2_6 = new JButton("P2 Random Animal");
        jb2_7 = new JButton("P2 Random Animal");    
        jb2_8 = new JButton("P2 Random Animal");
        jb2R = new JButton("P2 Red");
        jb2B = new JButton("P2 Blue");
        animal2 = new JLabel("Animal Chosen: none");
        animal2.setFont(new Font("Serif", Font.BOLD, 18));
        color2 = new JLabel("Color: not selected yet");
        color2.setFont(new Font("Serif", Font.BOLD, 18));


        Finish = new JButton("Finish");

        JPanel[][] pHolder = new JPanel[6][2];    
            
        for(int m = 0; m < 6; m++) {
              for(int j=0; j< 2; j++){
                pHolder[m][j] = new JPanel();
                this.add(pHolder[m][j]);
              }
        }
        
        pHolder[0][0].add(tx1);
        pHolder[0][0].add(jbN1);
        
        pHolder[0][0].add(jb1R);
        pHolder[0][0].add(jb1B);
        pHolder[0][1].add(animal1);////////////////////////
        pHolder[0][1].add(color1);

        pHolder[1][0].add(jb1);
        pHolder[1][0].add(jb2);
        pHolder[1][0].add(jb3);
        pHolder[1][0].add(jb4);
        pHolder[2][0].add(jb5);
        pHolder[2][0].add(jb6);
        pHolder[2][0].add(jb7);
        pHolder[2][0].add(jb8);

        pHolder[3][0].add(tx2);
        pHolder[3][0].add(jbN2);

        pHolder[3][0].add(jb2R);
        pHolder[3][0].add(jb2B);
        pHolder[3][1].add(animal2);//////////////
        pHolder[3][1].add(color2);

        pHolder[4][0].add(jb2_1);
        pHolder[4][0].add(jb2_2);
        pHolder[4][0].add(jb2_3);
        pHolder[4][0].add(jb2_4);
        pHolder[5][0].add(jb2_5);
        pHolder[5][0].add(jb2_6);
        pHolder[5][0].add(jb2_7);
        pHolder[5][0].add(jb2_8);

        pHolder[5][1].add(Finish);

        p1name = null;
        p1color = null;
        p2name = null;
        p2color = null;

        tx1.setEditable(true);
        tx2.setEditable(true);
    }
    /**
     * Sets action listener for the player GUI
     * @param listener action listener
     */
    public void setListener(ActionListener listener){
        jbN1.addActionListener(listener);
        jb1.addActionListener(listener);
        jb2.addActionListener(listener);
        jb3.addActionListener(listener);
        jb4.addActionListener(listener);
        jb5.addActionListener(listener);
        jb6.addActionListener(listener);
        jb7.addActionListener(listener);
        jb8.addActionListener(listener);

        jb1R.addActionListener(listener);
        jb1B.addActionListener(listener);
        ///////////////////////////////
        jbN2.addActionListener(listener);
        jb2_1.addActionListener(listener);
        jb2_2.addActionListener(listener);
        jb2_3.addActionListener(listener);
        jb2_4.addActionListener(listener);
        jb2_5.addActionListener(listener);
        jb2_6.addActionListener(listener);
        jb2_7.addActionListener(listener);
        jb2_8.addActionListener(listener);

        jb2R.addActionListener(listener);
        jb2B.addActionListener(listener);

        Finish.addActionListener(listener);
    }
    /**
     * Sets document listener for the player GUI
     * @param listener document listener
     */
    public void setDocumentListener (DocumentListener listener)
	{
		tx1.getDocument ().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
                enableSaveName(1, true);
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                enableSaveName(1, true);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            //Plain text components don't fire these events.
            }
        });


        tx2.getDocument ().addDocumentListener (new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
                enableSaveName(2, true);
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                enableSaveName(2, true);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        });

	}
    /**
     * this method returns the entered text on the first text field
     * @return String input from the first text field
     */
    public String getTFcontent1(){
        return tx1.getText();
    }

    /**
     * this method returns the entered text on the second text field
     * @return String input from the second text field
     */
    public String getTFcontent2(){
        return tx2.getText();
    }

    /**
     * This method disables/enables saveName buttons depending on the owner
     * @param owner owner of the button
     * @param b false to disable or true enable
     */
    public void enableSaveName(int owner, boolean b){
        if(owner==1){
            jbN1.setEnabled(b);
            tx1.setEditable(b);         
        }
            
        else {
            jbN2.setEnabled(b);
            tx2.setEditable(b);
        }
    }

    /**
     * disables the color picker button
     * @param owner owner of the buttons to disable
     */
    public void disableColors(int owner){
        if(owner==1){
            jb1R.setEnabled(false);
            jb1B.setEnabled(false);
        }
        else if(owner==2){
            jb2R.setEnabled(false);
            jb2B.setEnabled(false);
        }
    }
    /**
     * enable.disable the finish button
     * @param b false to disable or true enable
     */
    public void enableFinish(boolean b){
        Finish.setEnabled(b);
    }
    
    /**
     * enable.disable the animal buttons for the first chooser
     * @param b false to disable or true enable
     */
    public void enableButtons1(boolean b){
        jb1.setEnabled(b);
        jb2.setEnabled(b);
        jb3.setEnabled(b);
        jb4.setEnabled(b);
        jb5.setEnabled(b);
        jb6.setEnabled(b);
        jb7.setEnabled(b);
        jb8.setEnabled(b);
    }

    /**
     * enable.disable the animal buttons for the second chooser
     * @param b false to disable or true enable
     */
    public void enableButtons2(boolean b){
        jb2_1.setEnabled(b);
        jb2_2.setEnabled(b);
        jb2_3.setEnabled(b);
        jb2_4.setEnabled(b);
        jb2_5.setEnabled(b);
        jb2_6.setEnabled(b);
        jb2_7.setEnabled(b);
        jb2_8.setEnabled(b);
    }
    
    /**
     * set animal1 JLabel text
     * @param s String to set
     */
    public void setAnimal1(String s){
        animal1.setText("Animal: "+s);
    }

    /**
     * set animal2 JLabel text
     * @param s String to set
     */
    public void setAnimal2(String s){
        animal2.setText("Animal: "+s);
    }

    /**
     * gets animal1 JLabel text
     * @return animal 1 JLabel text
     */
    public String getAnimal1(){
        return animal1.getText();
    }

    /**
     * gets animal2 JLabel text
     * @return animal 2 JLabel text
     */
    public String getAnimal2(){
        return animal2.getText();
    }

    /**
     * set color1 JLabel text
     * @param c String to set
     */
    public void setColorLabel1(String c){
        color1.setText("Color: "+c);
    }

    /**
     * set color2 JLabel text
     * @param c String to set
     */
    public void setColorLabel2(String c){
        color2.setText("Color: "+c);
    }

    /**
     * sets Name for p1
     * @param n String to set as name
     */
    public void setNameP1(String n){
        p1name=n;
    }

    /**
     * sets Color for p1
     * @param c String to set as color
     */
    public void setColorP1(String c){
        p1color=c;
    }

    /**
     * sets Name for p2
     * @param n String to set as name
     */
    public void setNameP2(String n){
        p2name=n;
    }

    /**
     * sets Color for p2
     * @param c String to set as color
     */
    public void setColorP2(String c){
        p2color=c;
    }

    /**
     * gets name for p1
     * @return name of p1
     */
    public String getNameP1(){
        return p1name;
    }

    /**
     * gets color for p1
     * @return color of p1
     */
    public String getColorP1(){
        return p1color;
    }

    /**
     * gets name for p2
     * @return name of p2
     */
    public String getNameP2(){
        return p2name;
    }

    /**
     * gets color for p2
     * @return color of p2
     */
    public String getColorP2(){
        return p2color;
    }
   
}