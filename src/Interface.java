import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Interface extends JComponent implements MouseListener, MouseMotionListener{

    int x;
    int y;
    boolean calculator = true;

    @Override
    public void paintComponent(Graphics g) {
        addMouseListener(this);
        addMouseMotionListener(this);
        super.paintComponent(g);
        
        //Calculator mode
        if(calculator){
            
        }
        
        //Creation mode
        if(!calculator){
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
}