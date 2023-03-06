import java.awt.event.*;
import java.util.*;
/** This class is the controller for pGUI
* @author Alyssa Ysabelle Meneses
* @author Lind Matthew Tan
* @version 1.0
*/
public class pController implements ActionListener//, DocumentListener
{
	private pGUI pgui;
    
    /**
     * constructor for the pController
     * @param pgui player gui
     */
	public pController (pGUI pgui)
	{
		this.pgui = pgui;

		pgui.setListener (this);
        pgui.enableFinish(false);
	}
	
    /**
     * this method is the action listener for pController
     * @param e action event
     */
	public void actionPerformed (ActionEvent e)
	{
        
        
        if (e.getActionCommand ().equals ("Save P1 Name")){
            pgui.setNameP1(pgui.getTFcontent1());
            pgui.enableSaveName(1, false);
        }
        else if (e.getActionCommand ().equals("Save P2 Name")){
            pgui.setNameP2(pgui.getTFcontent2());
            pgui.enableSaveName(2, false);
        }
        
        /////////////////////////////////////////////////////////
        else if (e.getActionCommand ().equals("P1 Random Animal")){
            Random rand = new Random();
            pgui.setAnimal1(animalList.getRandomAnimal(rand.nextInt(8)));
            pgui.enableButtons1(false);
            if (pgui.getAnimal1().equals(pgui.getAnimal2())){// check if same animal
                pgui.enableButtons1(true);
                pgui.enableButtons2(true);
                pgui.setAnimal1("none");
                pgui.setAnimal2("none");
            }
        }

        else if (e.getActionCommand ().equals("P2 Random Animal")){
            Random rand = new Random();
            pgui.setAnimal2(animalList.getRandomAnimal(rand.nextInt(8)));
            pgui.enableButtons2(false);       
            if (pgui.getAnimal1().equals(pgui.getAnimal2())){// check if same animal
                pgui.enableButtons1(true);
                pgui.enableButtons2(true);
                pgui.setAnimal1("none");
                pgui.setAnimal2("none");
            }
        }
        ////////////////////////////////////////////////////////
        else if(e.getActionCommand ().equals("P1 Red")){
            pgui.setColorLabel1("Red");
            pgui.setColorP1("Red");
            pgui.disableColors(1);
        }
        else if(e.getActionCommand ().equals("P1 Blue")){
            pgui.setColorLabel1("Blue");
            pgui.setColorP1("Blue");
            pgui.disableColors(1);
        }
        else if(e.getActionCommand ().equals("P2 Red")){
            pgui.setColorLabel2("Red");
            pgui.setColorP2("Red");
            pgui.disableColors(2);
        }
        else if(e.getActionCommand ().equals("P2 Blue")){
            pgui.setColorLabel2("Blue");
            pgui.setColorP2("Blue");
            pgui.disableColors(2);
        }
 ////////////////////
        if (pgui.getNameP1() != null  &&pgui.getNameP2() != null && !pgui.getAnimal1().contains("none")&& !pgui.getAnimal2().contains("none")){
            pgui.enableFinish(true);
        }

        if(e.getActionCommand ().equals("Finish")){
            // call the constructors based on the animal choice and stuff lol 
            /// pgui.enableFinishTrue();

            GUI g = new GUI();
            Player firstP, secondP;



            if(animalList.linearSearch(pgui.getAnimal1().substring(8)) > animalList.linearSearch(pgui.getAnimal2().substring(8))){
                
                if(pgui.getColorP1().equalsIgnoreCase("Red")){
                    firstP = new Player(pgui.getNameP1(), "Red", true, 1);
                    secondP = new Player(pgui.getNameP2(), "Blue", false, 2);
                }
                else{
                    firstP = new Player(pgui.getNameP1(), "Blue", true, 1);
                    secondP = new Player(pgui.getNameP2(), "Red", false, 2);
                }

            }
            else{
                if(pgui.getColorP2().equalsIgnoreCase("Red")){
                    firstP = new Player(pgui.getNameP2(), "Red", true, 1);
                    secondP = new Player(pgui.getNameP1(), "Blue", false, 2);
                }
                else{
                    firstP = new Player(pgui.getNameP2(), "Blue", true, 1);
                    secondP = new Player(pgui.getNameP1(), "Red", false, 2);
                }

            }


            Controller c = new Controller(g, firstP, secondP);
            System.out.println("Successfully setup players, below is their info:");
            System.out.println("Name:"+firstP.getName()+"/"+firstP.getColor());
            System.out.println("Name:"+secondP.getName()+"/"+secondP.getColor());
            System.out.println();
            pgui.enableFinish(false);
        }
        
	}

}
