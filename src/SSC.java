    import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.util.Arrays;


public class SSC extends JFrame implements KeyListener{
    private final Interface draw;
    public static String[][] input;
    public static int[] length;
    public static String highlighted=""; //"s", "u", "v", "a", "t", " ",
    public static String createHighlighted=""; //"q", "n"
    public static String[][] createInput;
    public static int[] createLength;
    public static int decimalPlaces=0;
    public static int GNum=0;
    public static String gravity[];
    public static String latex="Solutions\\ will\\ appear\\ here";
    public static String find="";
    public static String version = "0.3";
    public static String docName = "";
    public static boolean[] includeQuestions;
    public static boolean[] difficulties;
    public static boolean makeAnswers=true;
    public static boolean solveMode = true;
    

    @Override
    public void keyPressed(KeyEvent e) {
        if (solveMode) {
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                switch (highlighted) {
                    case "":                        
                        break;
                    case "s":
                        if (length[0] != 0) {
                            input[0][length[0] - 1] = null;
                            length[0]--;
                        }
                        break;
                    case "u":
                        if (length[1] != 0) {
                            input[1][length[1] - 1] = null;
                            length[1]--;
                        }
                        break;
                    case "v":
                        if (length[2] != 0) {
                            input[2][length[2] - 1] = null;
                            length[2]--;
                        }
                        break;
                    case "a":
                        if (length[3] != 0) {
                            input[3][length[3] - 1] = null;
                            length[3]--;
                        }
                        break;
                    case "t":
                        if (length[4] != 0) {
                            input[4][length[4] - 1] = null;
                            length[4]--;
                        }
                        break;
                }
            }
            
            if (e.getKeyCode() == KeyEvent.VK_TAB) {
                if (solveMode) {
                    switch (highlighted) {
                        case "":                            
                            break;
                        case "s":
                            highlighted = "u";
                            break;
                        case "u":
                            highlighted = "v";
                            break;
                        case "v":
                            highlighted = "a";
                            break;
                        case "a":
                            highlighted = "t";
                            break;
                        case "t":
                            highlighted = "s";
                            break;
                    }
                }
            }
        }else{//Create mode
            if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                switch(createHighlighted){
                    case "":
                        break;
                    case "q":
                        if (createLength[0] != 0) {
                            createInput[0][createLength[0] - 1] = null;
                            createLength[0]--;
                        }
                        break;
                    case "n":
                        if (createLength[1] != 0) {
                            createInput[1][createLength[1] - 1] = null;
                            createLength[1]--;
                        }
                        break;
                }
            }
            if(e.getKeyCode()==KeyEvent.VK_SPACE){
                switch(createHighlighted){
                    case "":
                        break;
                    case "q":
                        createInput[0][createLength[0]] = " ";
                        createLength[0]++;
                        break;
                    case "n":
                        createInput[1][createLength[1]] = " ";
                        createLength[1]++;
                        break;
                }
            }
        }
        repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {
        
        if (solveMode) {
            if (!isAcceptable(e.getKeyChar())) {
                return;
            }
            switch (highlighted) {
                case "":                    
                    break;
                case "s":
                    input[0][length[0]] = "" + e.getKeyChar();
                    length[0]++;
                    break;
                case "u":
                    input[1][length[1]] = "" + e.getKeyChar();
                    length[1]++;
                    break;
                case "v":
                    input[2][length[2]] = "" + e.getKeyChar();
                    length[2]++;
                    break;
                case "a":
                    input[3][length[3]] = "" + e.getKeyChar();
                    length[3]++;
                    break;
                case "t":
                    input[4][length[4]] = "" + e.getKeyChar();
                    length[4]++;
                    break;
            }
        }else{//Create mode
            if(Character.isLetterOrDigit(e.getKeyChar())){
                switch(createHighlighted){
                    case "":
                        break;
                    case "q":
                        createInput[0][createLength[0]] = "" + e.getKeyChar();
                        createLength[0]++;
                        break;
                    case "n":
                        createInput[1][createLength[1]] = "" + e.getKeyChar();
                        createLength[1]++;
                        break;
                }
            }
        }      
        repaint();
    }

    public SSC(){
        this.draw=new Interface();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public static void main(String[] args) {
        input = new String[5][15];
        createInput = new String[2][64];
        length = new int[5];
        createLength = new int[2];
        includeQuestions = new boolean[20];
        includeQuestions = allTrue(includeQuestions);
        difficulties = new boolean[2];
        difficulties = allTrue(difficulties);
        gravity = new String[7];
        gravity[0] = "Earth (9.81)";
        gravity[1] = "Moon (1.62)";
        gravity[2] = "Mars (3.75)";
        gravity[3] = "Jupiter (26)";
        gravity[4] = "Pluto (0.61";
        gravity[5] = "Sun (273)";
        gravity[6] = "Random";
        javax.swing.SwingUtilities.invokeLater(() -> {
            SSC frame = new SSC();
            frame.setTitle("Suvat Solver Creator "+version);
            frame.setResizable(false);
            frame.setSize(1300, 750);
            frame.setMinimumSize(new Dimension(1300, 750));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(frame.draw);
            frame.pack();
            frame.setLocationRelativeTo(frame);
            frame.setVisible(true);
            frame.getContentPane().setBackground(Color.decode("#F3F3F3"));
        });
    }
    
    public static boolean over(int x1, int x2, int y1, int y2, int x, int y){
        return x1-1<x&&x<x2&&y1-1<y&&y<y2;
    }
    
    public static boolean containsData(String[] array){
        for (String array1 : array) {
            if (array1 != null) {
                return true;
            }
        }
        return false;
    }
    
    public static void reset(String[] array){
      int len = array.length;

      if (len > 0){
        array[0] = null;
      }

      for (int i = 1; i < len; i += i) 
      {
        System.arraycopy(array, 0, array, i, ((len - i) < i) ? (len - i) : i);
      }
}
    
    public static void resetInput(){
        for(int i=0;i<5;i++){
            reset(input[i]);
        }
    }
    
    public static void resetLength(){
        for(int i=0;i<5;i++){
            length[i]=0;
        }
    }
    
    public static boolean[] allTrue(boolean[] array){
        for(int i=0;i<array.length;i++){
            array[i]=true;
        }
        return array;
    }
    
    public static boolean[] allFalse(boolean[] array){
        for(int i=0;i<array.length;i++){
            array[i]=false;
        }
        return array;
    }
    
    public static int nNotNull(String[] s){
        int a=0;
        while(true){
            if(s[a]==null){
                return a;
            }
            a++;
        }
    }
    
    public static String arrayToString(String[] array){
        String string="";
        for(int i=0;i<nNotNull(array);i++){
            string+=array[i];
        }
        return string;
    }
    
    public static boolean isAcceptable(char c){
        switch (c) {
            case '0':
                return true;
            case '1':
                return true;
            case '2':
                return true;
            case '3':
                return true;
            case '4':
                return true;
            case '5':
                return true;
            case '6':
                return true;
            case '7':
                return true;
            case '8':
                return true;
            case '9':
                return true;
            case '.':
                return true;
            case '-':
                return true;
            default:
                break;
        }
        return false;
    }
    
    public static int swap(int a){
        return (a-1)*(a-1);
    }
    
    public static String solve(){
        
        //Getting the list of entered values
        String m="";
        for(int i=0;i<5;i++){
            if(containsData(input[i])){
                switch(i){
                    case 0: m+="s";
                        break;
                    case 1: m+="u";
                        break;
                    case 2: m+="v";
                        break;
                    case 3: m+="a";
                        break;
                    case 4: m+="t";
                        break;
                }
            }
        }

        //Checking too see if valid data was entered
        if(m.length()!=3||find.equals("")){
            return "Make\\ sure\\ that\\ you\\ have\\ entered\\ information\\\\into\\ exactly\\ three\\ boxes,\\ and\\ that\\ you\\ have\\\\selected\\ a\\ value\\ that\\ is\\ not\\ already\\ known";
        }
        for(int i=0;i<m.length();i++){
            if(m.charAt(i)==find.charAt(0)){
                return "Make\\ sure\\ that\\ you\\ have\\ entered\\ information\\\\into\\ exactly\\ three\\ boxes,\\ and\\ that\\ you\\ have\\\\selected\\ a\\ value\\ that\\ is\\ not\\ already\\ known";
            }
        }
        
        //Turning the input array into numbers
        double s=0;
        double u=0;
        double v=0;
        double a=0;
        double t=0;
        String[] merged={"","","","",""};
        for (int i=0;i<5;i++) {
            if (containsData(input[i])) {
                for (int j = 0; j < nNotNull(input[i]); j++) {
                    merged[i] += input[i][j];
                }
            }
        }
        try {
            if (!"".equals(merged[0])) {
                s = Double.parseDouble(merged[0]);
            }
            if (!"".equals(merged[1])) {
                u = Double.parseDouble(merged[1]);
            }
            if (!"".equals(merged[2])) {
                v = Double.parseDouble(merged[2]);
            }
            if (!"".equals(merged[3])) {
                a = Double.parseDouble(merged[3]);
            }
            if (!"".equals(merged[4])) {
                t = Double.parseDouble(merged[4]);
            }
        } catch (NumberFormatException numberFormatException) {return "Make\\ sure\\ that\\ you\\\\ have\\ only\\ entered\\ numbers.";}
        
        //send the values to the approriate solve method, and return the solution
        switch(m){
            case "sat": if("u".equals(find)){return solve.sat_u(s,a,t);}else if("v".equals(find)){return solve.sat_v(s,a,t);}else{return "Error";}
            case "sut": if("v".equals(find)){return solve.sut_v(s,u,t);}else if("a".equals(find)){return solve.sut_a(s,u,t);}else{return "Error";}
            case "svt": if("u".equals(find)){return solve.svt_u(s,v,t);}else if("a".equals(find)){return solve.svt_a(s,v,t);}else{return "Error";}
            case "sua": if("v".equals(find)){return solve.sua_v(s,u,a);}else if("t".equals(find)){return solve.sua_t(s,u,a);}else{return "Error";}
            case "sva": if("u".equals(find)){return solve.sva_u(s,v,a);}else if("t".equals(find)){return solve.sva_t(s,v,a);}else{return "Error";}
            case "suv": if("a".equals(find)){return solve.suv_a(s,u,v);}else if("t".equals(find)){return solve.suv_t(s,u,v);}else{return "Error";}
            case "uvt": if("s".equals(find)){return solve.uvt_s(u,v,t);}else if("a".equals(find)){return solve.uvt_a(u,v,t);}else{return "Error";}
            case "uat": if("s".equals(find)){return solve.uat_s(u,a,t);}else if("v".equals(find)){return solve.uat_v(u,a,t);}else{return "Error";}
            case "uva": if("s".equals(find)){return solve.uva_s(u,v,a);}else if("t".equals(find)){return solve.uva_t(u,v,a);}else{return "Error";}
            case "vat": if("s".equals(find)){return solve.vat_s(v,a,t);}else if("u".equals(find)){return solve.vat_u(v,a,t);}else{return "Error";}
        }
        return "Error";
    }
    
    public static String create(){
        
        return "Created";
    }
}