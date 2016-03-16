import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import org.scilab.forge.jlatexmath.*;

public class Interface extends JComponent implements MouseListener, MouseMotionListener{

    int x;
    int y;

    @Override
    public void paintComponent(Graphics g) {
        addMouseListener(this);
        addMouseMotionListener(this);
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        Image gradient;
        gradient=new ImageIcon("Images/gradient.png").getImage();
        
        g.drawImage(gradient, 0, 0, this);
        
        if(SSC.solveMode){
            g2.setStroke(new BasicStroke(1));
            g2.setColor(Color.darkGray);
            g2.draw(new Line2D.Float(875, 0, 875, 93));
            g2.draw(new Line2D.Float(875, 93, 1350, 93));
            g2.draw(new Line2D.Float(1025, 0, 1025, 93));
            
            g2.setColor(Color.decode("#778899"));
            g2.fillRect(876, 0, 149, 93);
            g2.fillRect(876, 94, 475, 657);
            
            g2.setColor(Color.darkGray);
            g2.draw(new Line2D.Float(0, 0, 433, 0));
            g2.draw(new Line2D.Float(433, 0, 433, 93));
            g2.draw(new Line2D.Float(433, 93, 875, 93));
            g2.draw(new Line2D.Float(875, 93, 875, 650));
            g2.draw(new Line2D.Float(0, 650, 875, 650));
            g2.draw(new Line2D.Float(875, 650, 875, 720));
            g2.draw(new Line2D.Float(0, 721, 875, 721));
            g2.draw(new Line2D.Float(0, 721, 0, 650));
            
            //Input boxes
            g2.draw(new Line2D.Float());
            
            //Text
            Font big=new Font("Segeo UI", Font.PLAIN, 36);
            g.setFont(big);
            g.drawString("Solver", 155, 55);
        }else{
            
        }
        //Paint the LaTeX
        if(!"".equals(SSC.latex)){
            TeXFormula formula = new TeXFormula(SSC.latex);
            TeXIcon icon = formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY).setSize(20).build();
            BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g3 = image.createGraphics();
            g3.setColor(Color.white);
            g3.fillRect(0,0,icon.getIconWidth(),icon.getIconHeight());
            JLabel jl = new JLabel();
            jl.setForeground(new Color(0, 0, 0));
            icon.paintIcon(jl, g3, 0, 0);
            g.drawImage(image, 876, 94, this);
        }
        //End of painting the LaTeX
        
        //Paint the right side
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        SSC.latex=SSC.solve();
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

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