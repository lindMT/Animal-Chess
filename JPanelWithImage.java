import java.awt.*;
import javax.swing.*;
/** This class is the subclass of JPanel 
* @author Alyssa Ysabelle Meneses
* @author Lind Matthew Tan
* @version 1.0
*/
public class JPanelWithImage extends JPanel {
    private Image image;
    /** 
     * constructor for the JPanelWithImage
     * @param image image to be set
     */
    public JPanelWithImage(Image image) {
        this.image = image;
    }
    /** 
     * this method paints the component
     * @param g Graphics to be painted
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
    /** 
     * this method gets the image
     * @return image of the panel
     */
    protected Image getImage(){
        return image;
    }
}
