import java.awt.event.*;
/** This class is the controller for the menu
* @author Alyssa Ysabelle Meneses
* @author Lind Matthew Tan
* @version 1.0
*/
public class mController implements ActionListener
{
	private mGUI mgui;

	/** 
	 * constructor for the controller 
	 * @param mgui menu gui
	 */
	public mController (mGUI mgui)
	{
		this.mgui = mgui;

		mgui.setListener (this);
	}
	/** 
	 * this method is for the action listener in mController
	 * @param e action event
	 */
	public void actionPerformed (ActionEvent e)
	{
        if (e.getActionCommand ().equals ("Begin Setup.")){
            pGUI playerGUI= new pGUI();////////////////////////////////////////////
       		pController playerController= new pController(playerGUI);//////////////
			mgui.enablePlayerbtn(false);
		}
    
	}
	
}
