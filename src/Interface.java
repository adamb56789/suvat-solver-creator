import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import org.scilab.forge.jlatexmath.*;

public class Interface extends JComponent implements MouseListener, MouseMotionListener{

    int x;
    int y;
    String hovering="";
    String pressing="";
    boolean pressed=false;

    @Override
    public void paintComponent(Graphics g) {
        addMouseListener(this);
        addMouseMotionListener(this);
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        Image gradient;
        gradient=new ImageIcon("Images/gradient.png").getImage();
        
        Image Normal;
        Normal=new ImageIcon("Images/Normal.png").getImage();
        
        Image Selected;
        Selected=new ImageIcon("Images/Selected.png").getImage();
        
        Image logo;
        logo=new ImageIcon("Images/logo.png").getImage();
        
        if(SSC.solveMode){        
            
            g.drawImage(gradient, 0, -20, this);
            g.drawImage(gradient, 433, 103, 442, -93, this);
            
            g2.setColor(Color.decode("#F3F3F3"));
            g2.fillRect(433, 94, 442, 9);
            
            g2.setColor(Color.decode("#778899"));
            g2.fillRect(876, 0, 149, 93);
            g2.fillRect(876, 94, 475, 657);
            
            g2.setColor(Color.darkGray);
            g2.draw(new Line2D.Float(875, 0, 875, 93));
            g2.draw(new Line2D.Float(875, 93, 1350, 93));
            g2.draw(new Line2D.Float(1025, 0, 1025, 93));
            g2.setStroke(new BasicStroke(2));
            g2.draw(new Line2D.Float(0, 1, 433, 1));
            g2.draw(new Line2D.Float(433, 0, 433, 93));
            g2.draw(new Line2D.Float(433, 93, 875, 93));
            g2.setStroke(new BasicStroke(1));
            g2.draw(new Line2D.Float(875, 93, 875, 650));
            g2.draw(new Line2D.Float(0, 650, 875, 650));
            g2.draw(new Line2D.Float(875, 650, 875, 720));
            g2.draw(new Line2D.Float(0, 721, 875, 721));
            g2.draw(new Line2D.Float(0, 721, 0, 650));
            
            //Input boxes
            g.drawRect(300, 160, 200, 30);
            g.drawRect(300, 260, 200, 30);
            g.drawRect(300, 360, 200, 30);
            g.drawRect(300, 460, 200, 30);
            g.drawRect(300, 560, 200, 30);
            
            g.setColor(Color.decode("#7A9CD3"));
            switch(SSC.highlighted){
                case "": 
                    break;
                case "s": g.drawRect(300, 160, 200, 30);g.setColor(Color.decode("#A0C2F9"));g.drawRect(299, 159, 202, 32);
                    break;
                case "u": g.drawRect(300, 260, 200, 30);g.setColor(Color.decode("#A0C2F9"));g.drawRect(299, 259, 202, 32);
                    break;
                case "v": g.drawRect(300, 360, 200, 30);g.setColor(Color.decode("#A0C2F9"));g.drawRect(299, 359, 202, 32);
                    break;
                case "a": g.drawRect(300, 460, 200, 30);g.setColor(Color.decode("#A0C2F9"));g.drawRect(299, 459, 202, 32);
                    break;
                case "t": g.drawRect(300, 560, 200, 30);g.setColor(Color.decode("#A0C2F9"));g.drawRect(299, 559, 202, 32);
                    break;
            }
            
            g.setColor(Color.white);
            g.fillRect(301,161,199,29);
            g.fillRect(301,261,199,29);
            g.fillRect(301,361,199,29);
            g.fillRect(301,461,199,29);
            g.fillRect(301,561,199,29);
            
            //Buttons
            g.setColor(Color.decode("#D8D8D8"));
            if(hovering.equals("Submit")){
                g.setColor(Color.decode("#C8C8C8"));
            }
            g.fillRect(0, 650, 875, 100);
            g.drawImage(Normal, 675, 168, this);
            g.drawImage(Normal, 675, 268, this);
            g.drawImage(Normal, 675, 368, this);
            g.drawImage(Normal, 675, 468, this);
            g.drawImage(Normal, 675, 568, this);
            
            switch(SSC.find){
                case "": 
                    break;
                case "s": g.drawImage(Selected, 675, 168, this);
                    break;
                case "u": g.drawImage(Selected, 675, 268, this);
                    break;
                case "v": g.drawImage(Selected, 675, 368, this);
                    break;
                case "a": g.drawImage(Selected, 675, 468, this);
                    break;
                case "t": g.drawImage(Selected, 675, 568, this);
                    break;
            }
                        
            //Text
            Font small=new Font("Segeo UI", Font.PLAIN, 24);
            Font big=new Font("Segeo UI", Font.PLAIN, 36);
            
            g.setFont(big);
            g.setColor(Color.darkGray);
            g.drawString("Solver", 155, 55);
            g.drawString("Creator", 590, 55);
            g.drawString("Solve", 370, 700);
            g.setFont(small);
            g.drawString(SSC.arrayToString(SSC.input[0]),300,185);
            g.drawString(SSC.arrayToString(SSC.input[1]),300,285);
            g.drawString(SSC.arrayToString(SSC.input[2]),300,385);
            g.drawString(SSC.arrayToString(SSC.input[3]),300,485);
            g.drawString(SSC.arrayToString(SSC.input[4]),300,585);
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
        
        //Logo
        g.drawImage(logo,1143,2,this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("CLick");
//        //Input boxes
//        if(SSC.over(300, 500, 160, 214, x, y)){
//            SSC.highlighted="s";
//        }else if(SSC.over(300, 500, 260, 314, x, y)){
//            SSC.highlighted="u";
//        }else if(SSC.over(300, 500, 360, 414, x, y)){
//            SSC.highlighted="v";
//        }else if(SSC.over(300, 500, 460, 514, x, y)){
//            SSC.highlighted="a";
//        }else if(SSC.over(300, 500, 560, 614, x, y)){
//            SSC.highlighted="t";
//        }else{
//            SSC.highlighted="";
//        }
//        
//        
//        //Buttons
//        if(SSC.over(675, 691, 168, 184, x, y)){
//            SSC.find="s";
//        }else if(SSC.over(675, 691, 268, 284, x, y)){
//            SSC.find="u";
//        }else if(SSC.over(675, 691, 368, 384, x, y)){
//            SSC.find="v";
//        }else if(SSC.over(675, 691, 468, 484, x, y)){
//            SSC.find="a";
//        }else if(SSC.over(675, 691, 568, 584, x, y)){
//            SSC.find="t";
//        }
//        
//        //Submit
//        if(SSC.over(0,875,650,750,x,y)){
//            SSC.latex=SSC.solve();
//        }
//        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        if(!pressed){
            
            //Input boxes
            if(SSC.over(300, 500, 160, 214, x, y)){
                SSC.highlighted="s";
            }else if(SSC.over(300, 500, 260, 314, x, y)){
                SSC.highlighted="u";
            }else if(SSC.over(300, 500, 360, 414, x, y)){
                SSC.highlighted="v";
            }else if(SSC.over(300, 500, 460, 514, x, y)){
                SSC.highlighted="a";
            }else if(SSC.over(300, 500, 560, 614, x, y)){
                SSC.highlighted="t";
            }else{
                SSC.highlighted="";
            }


            //Buttons
            if(SSC.over(675, 691, 168, 184, x, y)){
                SSC.find="s";
            }else if(SSC.over(675, 691, 268, 284, x, y)){
                SSC.find="u";
            }else if(SSC.over(675, 691, 368, 384, x, y)){
                SSC.find="v";
            }else if(SSC.over(675, 691, 468, 484, x, y)){
                SSC.find="a";
            }else if(SSC.over(675, 691, 568, 584, x, y)){
                SSC.find="t";
            }

            //Submit
            if(SSC.over(0,875,650,750,x,y)){
                SSC.latex=SSC.solve();
                if(!"Make\\ sure\\ that\\ you\\ have\\ entered\\ information\\\\into\\ exactly\\ three\\ boxes,\\ and\\ that\\ you\\ have\\\\selected\\ a\\ value\\ that\\ is\\ not\\ already\\ known".equals(SSC.latex)){
                    SSC.resetInput();
                    SSC.resetLength();
                    SSC.find="";
                }
            }
            repaint();
            pressed=true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressed=false;
    }

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
        
        //Hovering over submit
        if(SSC.over(0,875,650,750,x,y)){
            hovering="Submit";
            repaint();
        }else{
            hovering="";
            repaint();
        }
    }
}