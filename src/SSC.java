import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


public class SSC extends JFrame implements KeyListener{
    private final Interface draw;

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
        String[] array;
        array = new String[10];
        array[0]="1";
        array[0]=null;
        System.out.println(array[0]);
        
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
}