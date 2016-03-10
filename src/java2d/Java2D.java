
package java2d;
import javax.swing.JFrame;
import java.awt.Dimension;

public class Java2D {

   
   public static void main(String[] args) {
      DrawFrame newframe = new DrawFrame();
      newframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      newframe.setSize(900,900);
      //newframe.setMinimumSize(new Dimension(800,800));
      newframe.setVisible(true);
      
   }
   
}
