import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;

class JInternalFrameTest extends JFrame {
            
    JInternalFrameTest()
    {
        setTitle("JInternalFrame");
        setJInternalFrame();
        setSize(700,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    void setJInternalFrame()
    {
        JInternalFrame jn = new JInternalFrame("InternalFrame",true,true,true);
        jn.setLayout(new FlowLayout());
        jn.add(new JButton("JButton"));
        jn.setVisible(true);
        add(jn);
    }
}
 
public class Javaapp {
  
    public static void main(String[] args) {
        
        JInternalFrameTest jn = new JInternalFrameTest();
    }
}