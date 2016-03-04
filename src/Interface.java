import java.awt.*; //imports library needed for UI
import javax.swing.*; //imports library needed for UI
public class UserInterface extends JPanel{
    public void paintComponent(Graphics g) {
        super.paintComponent (g); //
        this.setBackground(Color./*color*/);//Sets background color
        g.setColor(Color./*color*/); //sets color
        g.fillRect(/*n*/, /*n*/, /*n*/, /*n*/); //uses color to draw rectangle
        g.drawString(“Text”, /*x*/, /*y*/); //draws text
    }
}