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
        reset(input[0]);
        if(containsData(input[0])){
            System.out.println("--> null <--");
            throw new NullPointerException();
        }
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SSC frame = new SSC();
                frame.setTitle("Square Move Practice");
                frame.setResizable(false);
                frame.setSize(1300, 750);
                frame.setMinimumSize(new Dimension(1300, 750));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(frame.draw);
                frame.pack();
                frame.setVisible(true);
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
    
    public static String solve(){
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
        
        switch(m){
            case "sat": if(m=="u"){}else if(m=="v"){}
                break;
            case "sut": 
                break;
            case "svt": 
                break;
            case "sua": 
                break;
            case "sva": 
                break;
            case "suv": 
                break;
            case "uvt": 
                break;
            case "uat": 
                break;
            case "uva": 
                break;
            case "vat": 
                break;
        }
        return "Error";
    }
}