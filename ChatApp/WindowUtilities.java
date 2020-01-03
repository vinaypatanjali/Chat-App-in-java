import javax.swing.*;
import java.awt.*;
import java.io.*;
public class WindowUtilities {
  public static void setNativeLookAndFeel() {
 try{
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
 }catch(ClassNotFoundException e){
	 
 }
 catch(InstantiationException e){
	 
 }
 catch(IllegalAccessException e){
	 
 
 }
 catch(UnsupportedLookAndFeelException e){}
  }

  public static void setJavaLookAndFeel() {
  try{
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
  }catch(ClassNotFoundException e){
	 
 }
 catch(InstantiationException e){
	 
 }
 catch(IllegalAccessException e){
	 
 
 }
 catch(UnsupportedLookAndFeelException e){}
  }
   
  

   public static void setMotifLookAndFeel() {
   try{
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
   }
   catch(ClassNotFoundException e){
	 
 }
 catch(InstantiationException e){
	 
 }
 catch(IllegalAccessException e){
	 
 
 }
 catch(UnsupportedLookAndFeelException e){}
  }
  



  public static JFrame openInJFrame(Container content,
                                    int width,
                                    int height,
                                    String title,
                                    Color bgColor) {  
    JFrame frame = new JFrame(title);
    frame.setBackground(bgColor);
    content.setBackground(bgColor);
    frame.setSize(width, height);
    frame.setContentPane(content);
 
    frame.setVisible(true);
    return(frame);
  }

  

  public static JFrame openInJFrame(Container content,
                                    int width,
                                    int height,
                                    String title) {
    return(openInJFrame(content, width, height, title, Color.white));
  }

  

  public static JFrame openInJFrame(Container content,
                                    int width,
                                    int height) {
    return(openInJFrame(content, width, height,
                        content.getClass().getName(),
                        Color.white));
  }
}
