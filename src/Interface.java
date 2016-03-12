import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
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
        
        if(SSC.solveMode){
            
        }else{
            
        }
        //Paint the LaTeX
        if(!"".equals(SSC.latex)){
            TeXFormula formula = new TeXFormula(SSC.latex);
            TeXIcon icon = formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY).setSize(20).build();
            BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = image.createGraphics();
            g2.setColor(Color.white);
            g2.fillRect(0,0,icon.getIconWidth(),icon.getIconHeight());
            JLabel jl = new JLabel();
            jl.setForeground(new Color(0, 0, 0));
            icon.paintIcon(jl, g2, 0, 0);
            g.drawImage(image, 875, 75, this);
        }
        //End of painting the LaTeX
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