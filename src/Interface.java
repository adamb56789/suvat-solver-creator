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
    int all=0;
    int none=0;
    int decimalBox=0;
    int decimalHover=0;
    int GBox=0;
    int GHover=0;
    int questionNumberBox=0;
    int docNameBox=0;
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
        
        Image checkNormal;
        checkNormal=new ImageIcon("Images/checkNormal.png").getImage();

        Image checkSelected;
        checkSelected=new ImageIcon("Images/checkSelected.png").getImage();
        
        Image buttonNormal;
        buttonNormal=new ImageIcon("Images/buttonNormal.png").getImage();
        
        Image buttonHover;
        buttonHover=new ImageIcon("Images/buttonHover.png").getImage();
        
        Image buttonHold;
        buttonHold=new ImageIcon("Images/buttonHold.png").getImage();
        
        Image comboBoxNormal;
        comboBoxNormal=new ImageIcon("Images/comboBoxNormal.png").getImage();
        
        Image comboBoxSelected;
        comboBoxSelected=new ImageIcon("Images/comboBoxSelected.png").getImage();
        /*Image x;
        x=new ImageIcon("Images/x.png").getImage();*/
        g2.setRenderingHint(
        RenderingHints.KEY_TEXT_ANTIALIASING,
        RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        
        String font="Segeo UI";
        Font minuscule=new Font(font, Font.PLAIN,14);
        Font tiny=new Font("Consolas", Font.PLAIN,20);
        Font smallish=new Font(font, Font.PLAIN,16);
        Font small=new Font(font, Font.PLAIN, 20);
        Font medium=new Font(font, Font.PLAIN, 24);
        Font big=new Font(font, Font.PLAIN, 36);
            
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
            for(int i=160;i<561;i+=100){
                g.drawRoundRect(300, i, 200, 30,2,2);
            }
            
            for(int i=161;i<562;i+=100){
                g.setColor(Color.white);
                g.fillRect(301,i,199,29);
                g.setColor(Color.DARK_GRAY);
                g.drawLine(301, i, 301, i);
                g.drawLine(499, i, 499, i);
                g.drawLine(301,i+28,301,i+28);
                g.drawLine(499,i+28,499,i+28);
            }
            
            g.setColor(Color.decode("#7A9CD3"));
            switch (SSC.highlighted) {
                case "":                        
                    break;
                case "s":
                    g.drawRect(300, 160, 200, 30);
                    g.setColor(Color.decode("#A0C2F9"));
                    g.drawRect(299, 159, 202, 32);
                    g.setColor(Color.white);
                    g.fillRect(301, 161, 199, 29);
                    break;
                case "u":
                    g.drawRect(300, 260, 200, 30);
                    g.setColor(Color.decode("#A0C2F9"));
                    g.drawRect(299, 259, 202, 32);
                    g.setColor(Color.white);
                    g.fillRect(301, 261, 199, 29);
                    break;
                case "v":
                    g.drawRect(300, 360, 200, 30);
                    g.setColor(Color.decode("#A0C2F9"));
                    g.drawRect(299, 359, 202, 32);
                    g.setColor(Color.white);
                    g.fillRect(301, 361, 199, 29);
                    break;
                case "a":
                    g.drawRect(300, 460, 200, 30);
                    g.setColor(Color.decode("#A0C2F9"));
                    g.drawRect(299, 459, 202, 32);
                    g.setColor(Color.white);
                    g.fillRect(301, 461, 199, 29);
                    break;
                case "t":
                    g.drawRect(300, 560, 200, 30);
                    g.setColor(Color.decode("#A0C2F9"));
                    g.drawRect(299, 559, 202, 32);
                    g.setColor(Color.white);
                    g.fillRect(301, 561, 199, 29);
                    break;
            }
            
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
            
            g.setFont(big);
            g.setColor(Color.darkGray);
            g.drawString("Solver", 155, 55);
            g.drawString("Creator", 590, 55);
            g.drawString("Solve", 370, 700);
            g.setFont(small);
            g.drawString("S (Displacement)", 20, 180);
            g.drawString("U (Initial Velocity)", 20, 280);
            g.drawString("V (Final Velocity)", 20, 380);
            g.drawString("A (Acceleration)", 20, 480);
            g.drawString("T (Time)", 20, 580);
            g.drawString("Value to be found", 610, 135);
            g.setFont(medium);
            g.drawString("Input",372,130);
            g.drawString(SSC.arrayToString(SSC.input[0]),303,185);
            g.drawString(SSC.arrayToString(SSC.input[1]),303,285);
            g.drawString(SSC.arrayToString(SSC.input[2]),303,385);
            g.drawString(SSC.arrayToString(SSC.input[3]),303,485);
            g.drawString(SSC.arrayToString(SSC.input[4]),303,585);
        }else{
            g.drawImage(gradient, 433, -20,442,93, this);
            g.drawImage(gradient, -8, 103, 442, -93, this);
            
            g2.setColor(Color.decode("#F3F3F3"));
            g2.fillRect(0, 94, 442, 9);
            
            g2.setColor(Color.decode("#778899"));
            g2.fillRect(876, 0, 149, 93);
            g2.fillRect(876, 94, 475, 657);
            
            g2.setColor(Color.darkGray);
            g2.draw(new Line2D.Float(875, 93, 1350, 93));
            g2.draw(new Line2D.Float(1025, 0, 1025, 93));
            g2.setStroke(new BasicStroke(2));
            g2.draw(new Line2D.Float(876, 0, 876, 93));
            g2.draw(new Line2D.Float(0, 93, 433, 93));
            g2.draw(new Line2D.Float(433, 0, 433, 93));
            g2.draw(new Line2D.Float(433, 1, 875, 1));
            g2.setStroke(new BasicStroke(1));
            g2.draw(new Line2D.Float(875, 93, 875, 650));
            g2.draw(new Line2D.Float(0, 650, 875, 650));
            g2.draw(new Line2D.Float(875, 650, 875, 720));
            g2.draw(new Line2D.Float(0, 721, 875, 721));
            g2.draw(new Line2D.Float(0, 721, 0, 650));
            
            g.setColor(Color.decode("#D8D8D8"));
            if(hovering.equals("Submit")){
                g.setColor(Color.decode("#C8C8C8"));
            }
            g.fillRect(0, 650, 875, 100);
            
            //Checkboxes
            for(int i=147,j=0;i<418;i+=30,j+=2){
                if(SSC.includeQuestions[j]){
                    g.drawImage(checkSelected,610,i,this);
                }else{
                    g.drawImage(checkNormal,610,i,this);
                }
                if(SSC.includeQuestions[j+1]){
                    g.drawImage(checkSelected,770,i,this);
                }else{
                    g.drawImage(checkNormal,770,i,this);
                }

            }
            
            //easy/hard
            for(int i=0,j=335;i<2;i++,j+=120){
                if(SSC.difficulties[i]){
                    g.drawImage(checkSelected,j,362,this);
                }else{
                    g.drawImage(checkNormal,j,362,this);
                }
            }
            
            //makeAnswers
            if(SSC.makeAnswers){
                g.drawImage(checkSelected,260,422,this);
            }else{
                g.drawImage(checkNormal,260,422,this);
            }
            
            //Combo Boxes
            if(decimalBox==0){
                g.drawImage(comboBoxNormal, 295, 173, this);
            }else if(decimalBox==1){
                g.drawImage(comboBoxSelected, 295, 173, this);
            }
            
            if(GBox==0){
                g.drawImage(comboBoxNormal, 295, 233, this);
            }else if(GBox==1){
                g.drawImage(comboBoxSelected, 295, 233, this);
            }
            
            //All/none buttons
            if(all==0){
                g.drawImage(buttonNormal,580,445,this);
            }else if(all==1){
                g.drawImage(buttonHover,580,445,this);
            }else if(all==2){
                g.drawImage(buttonHold,580,445,this);
            }
            
            if(none==0){
                g.drawImage(buttonNormal,660,445,this);
            }else if(none==1){
                g.drawImage(buttonHover,660,445,this);
            }else if(none==2){
                g.drawImage(buttonHold,660,445,this);
            }
            
            //Keyboard input boxes
            if(questionNumberBox==0){
                g.setColor(Color.white);
                g.fillRect(296, 114, 125, 30);
                g.setColor(Color.DARK_GRAY);
                g.drawRoundRect(295, 113, 126, 31, 2, 2);
                g.drawLine(296, 114, 296, 114);
                g.drawLine(420, 114, 420, 114);
                g.drawLine(296, 143, 296, 143);
                g.drawLine(420, 143, 420, 143);
            }else{
                g.setColor(Color.white);
                g.fillRect(296, 114, 125, 30);
                g.setColor(Color.decode("#7A9CD3"));
                g.drawRect(295, 113, 126, 31);
                g.setColor(Color.decode("#A0C2F9"));
                g.drawRect(294, 112, 128, 33);
            }
            
            if(docNameBox==0){
                g.setColor(Color.white);
                g.fillRect(256, 294, 225, 30);
                g.setColor(Color.DARK_GRAY);
                g.drawRoundRect(255, 293, 226, 31, 2, 2);
                g.drawLine(256, 294, 256, 294);
                g.drawLine(480, 294, 480, 294);
                g.drawLine(256, 323, 256, 323);
                g.drawLine(480, 323, 480, 323);
            }else{
                g.setColor(Color.white);
                g.fillRect(256, 294, 225, 30);
                g.setColor(Color.decode("#7A9CD3"));
                g.drawRect(255, 293, 226, 31);
                g.setColor(Color.decode("#A0C2F9"));
                g.drawRect(254, 292, 228, 33);
            }
            
            //Text
            g.setColor(Color.darkGray);
            
            g.setFont(minuscule);
            g.drawString("All",596,460);
            g.drawString("None",667,460);
            
            g.setFont(big);
            g.drawString("Solver", 155, 55);
            g.drawString("Creator", 590, 55);
            g.drawString("Create", 370, 700);
            
            g.setFont(medium);
            g.drawString(SSC.arrayToString(SSC.createInput[0]),298,139);
            g.drawString(SSC.arrayToString(SSC.createInput[1]),258,319);
            g.drawString(SSC.decimalPlaces+"", 310, 198);
            
            g.setFont(small);
            g.drawString("Include questions with these values", 500, 135);
            
            g.setFont(smallish);
            g.drawString(SSC.gravity[SSC.GNum], 300, 255);
            g.drawString("Number of questions", 100, 135);
            g.drawString("Number of decimal places", 100, 195);
            g.drawString("Possible values of G", 100, 255);
            g.drawString("Name of document", 100, 315);
            g.drawString("Difficulty of questions", 100, 375);
            g.drawString("Create answer sheet", 100, 435);
            g.drawRect(498,115,310,25);
            
            g.setFont(tiny);
            g.drawString("Easier",260,375);
            g.drawString("Harder",380,375);
            g.drawString("sat -> u", 500, 160);
            g.drawString("sat -> v", 660, 160);
            g.drawString("sut -> v", 500, 190);
            g.drawString("sut -> a", 660, 190);
            g.drawString("svt -> u", 500, 220);
            g.drawString("svt -> a", 660, 220);
            g.drawString("sua -> v", 500, 250);
            g.drawString("sua -> t", 660, 250);
            g.drawString("sva -> u", 500, 280);
            g.drawString("sva -> t", 660, 280);
            g.drawString("suv -> a", 500, 310);
            g.drawString("suv -> t", 660, 310);
            g.drawString("uvt -> s", 500, 340);
            g.drawString("uvt -> a", 660, 340);
            g.drawString("uat -> s", 500, 370);
            g.drawString("uat -> v", 660, 370);
            g.drawString("uva -> s", 500, 400);
            g.drawString("uva -> t", 660, 400);
            g.drawString("vat -> s", 500, 430);
            g.drawString("vat -> u", 660, 430);
            
            //ComboBox drop downs
            if(decimalBox==1){
                g.drawRect(295, 204, 126, 133);
                g.setColor(Color.white);
                g.fillRect(296, 205, 125, 132);
                g.setColor(Color.decode("#EEEEEE"));
                if(decimalHover!=0){
                    g.fillRect(296, 211+30*(decimalHover-1), 125, 30);
                }
                g.setFont(medium);
                g.setColor(Color.DARK_GRAY);
                for(int i=0;i<4;i++){
                    g.drawString(i+"", 310, 234+30*i);
                }
            }
            
            if(GBox==1){
                g.drawRect(295, 264, 126, 223);
                g.setColor(Color.white);
                g.fillRect(296, 265, 125, 222);
                g.setColor(Color.decode("#EEEEEE"));
                if(GHover!=0){
                    g.fillRect(296, 270+30*(GHover-1), 125, 30);
                }
                g.setFont(smallish);
                g.setColor(Color.DARK_GRAY);
                g.drawString(SSC.gravity[SSC.GNum], 300, 255);
                for(int i=0;i<7;i++){
                    g.drawString(SSC.gravity[i], 300, 290+30*i);
                }
            }
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
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        
        if(!pressed){
            
            if(SSC.over(0, 433, 0, 93, x, y)){
                SSC.solveMode=true;
            }
            
            if(SSC.over(433, 875, 0, 93, x, y)){
                SSC.solveMode=false;
            }
            
            if(SSC.solveMode){
                //Input boxes
                if (SSC.over(300, 500, 160, 214, x, y)) {
                    SSC.highlighted = "s";
                } else if (SSC.over(300, 500, 260, 314, x, y)) {
                    SSC.highlighted = "u";
                } else if (SSC.over(300, 500, 360, 414, x, y)) {
                    SSC.highlighted = "v";
                } else if (SSC.over(300, 500, 460, 514, x, y)) {
                    SSC.highlighted = "a";
                } else if (SSC.over(300, 500, 560, 614, x, y)) {
                    SSC.highlighted = "t";
                } else {
                    SSC.highlighted = "";
                }

                //Buttons
                if (SSC.over(675, 691, 168, 184, x, y)) {
                    SSC.find = "s";
                } else if (SSC.over(675, 691, 268, 284, x, y)) {
                    SSC.find = "u";
                } else if (SSC.over(675, 691, 368, 384, x, y)) {
                    SSC.find = "v";
                } else if (SSC.over(675, 691, 468, 484, x, y)) {
                    SSC.find = "a";
                } else if (SSC.over(675, 691, 568, 584, x, y)) {
                    SSC.find = "t";
                }

                //Submit
                if (SSC.over(0, 875, 650, 750, x, y)) {
                    SSC.latex = SSC.solve();
                    if (!"Make\\ sure\\ that\\ you\\ have\\ entered\\ information\\\\into\\ exactly\\ three\\ boxes,\\ and\\ that\\ you\\ have\\\\selected\\ a\\ value\\ that\\ is\\ not\\ already\\ known".equals(SSC.latex)) {
                        SSC.resetInput();
                        SSC.resetLength();
                        SSC.find = "";
                    }
                }
            }else{//create mode
                
                if(decimalBox==1){//Decimal box is highlighted
                    decimalBox=0;
                    for(int i=0;i<4;i++){
                        if(SSC.over(295, 421, 210+30*i, 240+30*i, x, y)){
                            SSC.decimalPlaces=i;
                            decimalHover=0;
                        }
                    }
                }else if(GBox==1){//G box is highlighted
                    GBox=0;
                    for(int i=0;i<7;i++){
                        if(SSC.over(295, 421, 270+30*i, 300+30*i, x, y)){
                            SSC.GNum=i;
                            GHover=0;
                        }
                    }
                }else{
                    if (SSC.over(0, 875, 650, 750, x, y)) {
                        SSC.latex = SSC.create();
                    }

                    //Include questions with these values
                    for (int i = 147, j = 0; i < 418; i += 30, j += 2) {
                        if (SSC.over(610, 626, i, i + 16, x, y)) {
                            SSC.includeQuestions[j] ^= true;
                        }
                        if (SSC.over(770, 786, i, i + 16, x, y)) {
                            SSC.includeQuestions[j + 1] ^= true;
                        }
                    }

                    //easy/hard
                    for (int i = 0, j = 335; i < 2; i++, j += 120) {
                        if (SSC.over(j, j + 16, 362, 378, x, y)) {
                            if (SSC.difficulties[SSC.swap(i)]) {
                                SSC.difficulties[i] ^= true;
                            } else {
                                SSC.difficulties[i] ^= true;
                                SSC.difficulties[SSC.swap(i)] ^= true;
                            }
                        }
                    }
                    
                    //makeAnswers
                    if(SSC.over(260, 276, 422, 438, x, y)){
                        SSC.makeAnswers^=true;
                    }

                    //select all
                    if (SSC.over(580, 626, 445, 466, x, y)) {
                        all = 2;
                    }

                    //select none
                    if (SSC.over(660, 706, 445, 466, x, y)) {
                        none = 2;
                    }

                    //decimalBox
                    if (SSC.over(295, 422, 173, 205, x, y)) {
                        decimalBox = SSC.swap(decimalBox);
                    } else {
                        decimalBox = 0;
                    }

                    //GBox
                    if (SSC.over(295, 422, 233, 265, x, y)) {
                        GBox = SSC.swap(GBox);
                    } else {
                        GBox = 0;
                    }

                    //questionNumberBox
                    if (SSC.over(295, 421, 113, 144, x, y)) {
                        questionNumberBox = 1;
                        SSC.createHighlighted = "q";
                    } else {
                        questionNumberBox = 0;
                        SSC.createHighlighted = "";
                    }

                    //docNameBox
                    if (SSC.over(255, 481, 293, 324, x, y)) {
                        docNameBox = 1;
                        SSC.createHighlighted = "n";
                    } else if ("n".equals(SSC.createHighlighted)) {
                        docNameBox = 0;
                        SSC.createHighlighted = "";
                    }
                }
            }
            repaint();
            pressed=true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressed=false;
        //all
        if(SSC.over(580, 626, 445, 466, x, y)){
            SSC.includeQuestions=SSC.allTrue(SSC.includeQuestions);
        }
        //none
        if(SSC.over(660, 706, 445, 466, x, y)){
            SSC.includeQuestions=SSC.allFalse(SSC.includeQuestions);
        }
        all=0;
        none=0;
        repaint();
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
        
        //Hovering over select all/none
        if(!SSC.solveMode){
            if (SSC.over(580, 626, 445, 466, x, y)) {
                all = 1;
            } else {
                all = 0;
            }
            if (SSC.over(660, 706, 445, 466, x, y)) {
                none = 1;
            } else {
                none = 0;
            }
            
            //Combo boxes
            for(int i=0;i<4;i++){
                if(SSC.over(295, 421, 211+30*i, 241+30*i, x, y)){
                    decimalHover=i+1;
                }
            }
            
            for(int i=0;i<7;i++){
                if(SSC.over(295, 421, 270+30*i, 300+30*i, x, y)){
                    GHover=i+1;
                }
            }
        }
    }
}