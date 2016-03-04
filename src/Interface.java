import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.event.*;

public class Interface extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
    
//    public List<Shape> shapes = new ArrayList<>();
    public static boolean var = true;
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (var){
            addMouseListener(this);
            addMouseMotionListener(this);
            addKeyListener(this);
            var = false;
        }
        if (SSC.mode.equals("Solve")){
            
        }if (SSC.mode.equals("Create")){
            
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}