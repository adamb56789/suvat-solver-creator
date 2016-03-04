import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Interface extends JPanel{
    
    public List<Shape> shapes = new ArrayList<>();
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(Shape s : shapes){
            g2d.draw(s);
        }
    }
    
    public void addRect() {
        shapes.add(new Rectangle(100,100,100,100));
        repaint();
    }
}