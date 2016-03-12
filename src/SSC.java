import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


public class SSC extends JFrame implements KeyListener{
    private final Interface draw;
    public static String[][] input;
    public static String highlighted=""; //"s", "u", "v", "a", "t", " ",
    public static String latex="";
    public static String find="";
    public static boolean solveMode = true;
    

    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(Character.getNumericValue(e.getKeyChar()));
    }

    public SSC(){
        this.draw=new Interface();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public static void main(String[] args) {
        input = new String[5][64];
        if(containsData(input[0])){
            System.out.println("--> null <--");
            throw new NullPointerException();
        }
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SSC frame = new SSC();
                frame.setTitle("SSC");
                frame.setResizable(false);
                frame.setSize(1300, 750);
                frame.setMinimumSize(new Dimension(1300, 750));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(frame.draw);
                frame.pack();
                frame.setVisible(true);
                frame.getContentPane().setBackground(Color.decode("#F3F3F3"));
            }
        });
    }
    
    public static boolean over(int x1, int x2, int y1, int y2, int x, int y){
        if(x1<x&&x<x2&&y1<y&&y<y2){
            return true;
        }
        return false;
    }
    
    public static boolean containsData(String[] array){
        for(int i=0;i<array.length;i++){
            if(array[i]!=null){
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
    
    public static int nNotNull(String[] s){
        int a=0;
        while(true){
            if(s[a]==null){
                return a;
            }
            a++;
        }
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
        System.out.println(m);
        
        //Checking too see if valid data was entered
        if(m.length()!=3||find.equals("")){
            return "Make\\ sure\\ that\\ you\\ have\\ entered\\ information\\\\into\\ exactly\\ three\\ boxes,\\ and\\ that\\ you\\ have\\\\selected\\ a\\ value\\ that\\ is\\ not\\ already\\ known!";
        }
        for(int i=0;i<m.length();i++){
            if(m.charAt(i)==find.charAt(0)){
                return "Make\\ sure\\ that\\ you\\ have\\ entered\\ information\\\\into\\ exactly\\ three\\ boxes,\\ and\\ that\\ you\\ have\\\\selected\\ a\\ value\\ that\\ is\\ not\\ already\\ known!";
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
        if(!"".equals(merged[0])){
            s=Double.parseDouble(merged[0]);
        }
        if(!"".equals(merged[1])){
            u=Double.parseDouble(merged[1]);
        }
        if(!"".equals(merged[2])){
            v=Double.parseDouble(merged[2]);
        }
        if(!"".equals(merged[3])){
            a=Double.parseDouble(merged[3]);
        }
        if(!"".equals(merged[4])){
            t=Double.parseDouble(merged[4]);
        }
        
        //send the values to the approriate solve method, and return the solution
        switch(m){
            case "sat": if("u".equals(m)){return solve.sat_u(s,a,t);}else if("v".equals(m)){return solve.sat_v(s,a,t);}else{return "Error";}
            case "sut": if("v".equals(m)){return solve.sut_v(s,u,t);}else if("a".equals(m)){return solve.sut_a(s,u,t);}else{return "Error";}
            case "svt": if("u".equals(m)){return solve.svt_u(s,v,t);}else if("a".equals(m)){return solve.svt_a(s,v,t);}else{return "Error";}
            case "sua": if("v".equals(m)){return solve.sua_v(s,u,a);}else if("t".equals(m)){return solve.sua_t(s,u,a);}else{return "Error";}
            case "sva": if("u".equals(m)){return solve.sva_u(s,v,a);}else if("t".equals(m)){return solve.sva_t(s,v,a);}else{return "Error";}
            case "suv": if("a".equals(m)){return solve.suv_a(s,u,v);}else if("t".equals(m)){return solve.suv_t(s,u,v);}else{return "Error";}
            case "uvt": if("s".equals(m)){return solve.uvt_s(u,v,t);}else if("a".equals(m)){return solve.uvt_a(u,v,t);}else{return "Error";}
            case "uat": if("s".equals(m)){return solve.uat_s(u,a,t);}else if("v".equals(m)){return solve.uat_v(u,a,t);}else{return "Error";}
            case "uva": if("s".equals(m)){return solve.uva_s(u,v,a);}else if("t".equals(m)){return solve.uva_t(u,v,a);}else{return "Error";}
            case "vat": if("s".equals(m)){return solve.vat_s(v,a,t);}else if("u".equals(m)){return solve.vat_u(v,a,t);}else{return "Error";}
        }
        return "Error";
    }
}