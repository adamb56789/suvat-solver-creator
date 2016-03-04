
import javax.swing.*;

public class SSC {
    
    public static void main(String[] args) {
        JFrame f=new JFrame("");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Interface ui = new Interface();
        f.add(ui);
        f.setSize(696, 719);
        f.setVisible(true);
    }
    
}
