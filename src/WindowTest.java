import java.awt.*;
import javax.swing.*;

public class WindowTest extends JFrame {
    Timer timer;
    
    public WindowTest() {
        setSize(100,250);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(30, 30, 20, 20);
    }
    
    public static void main(String[] args) {
        WindowTest frame = new WindowTest();        
    }
}