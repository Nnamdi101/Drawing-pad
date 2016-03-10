
package java2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import static java.lang.Math.abs;

public class MyRectangle extends MyShape{
   
   private boolean filled;
   
   //This is one constructor with parameters
   public MyRectangle(int x1, int y1, int x2, int y2, Paint paint,Stroke stroke, boolean filled)
   {
      super(x1,y1,x2,y2,paint,stroke);
      setFilled(filled);
   }
   
   //This is another constructor without paramemeters
   public MyRectangle()
   {
      super(0,0,0,0,Color.BLACK,new BasicStroke());
      setFilled(false);
      
   }
   
   
   
   
   public int getUpperLeftX()
   {
      return Math.min(getX1(), getX2());
   }
   public int getUpperLeftY()
   {
      return Math.min(getY1(), getY2());
   }
   
   public int getWidth()
   {
      return abs(this.getX1()-this.getX2());
   }
   
   public int getHeight()
   {
      return abs(this.getY1()-this.getY2());
   }
   
   //The draw method
   @Override
   public void draw(Graphics2D g)
   {
      g.setPaint(super.getPaint());
      g.setStroke(super.getStroke());
      
      if(isFilled())
         g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
      else
         g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
         

   }
  

   public boolean isFilled() {
      return filled;
   }

   public void setFilled(boolean filled) {
      this.filled = filled;
   }
   
   
   
}
