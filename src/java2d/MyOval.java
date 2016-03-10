
package java2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import static java.lang.Math.abs;

public class MyOval extends MyShape {
  
   private boolean filled;
   
   //This is one constructor with parameters
   public MyOval(int x1, int y1, int x2, int y2,Paint paint,Stroke stroke, boolean filled)
   {
      super(x1,y1,x2,y2,paint,stroke);
      setFilled(filled);
      
   }
   
   //This is another constructor without paramemeters
   public MyOval()
   {
      super(0,0,0,0,Color.BLACK,new BasicStroke());
      setFilled(false);
      
   }
   
   public int getUpperLeftX()
   {
      if(this.getX1()-this.getX2()>0)
         return this.getX2();
      else 
         return this.getX1();
   }
   public int getUpperLeftY()
   {
      if(this.getY1()-this.getY2()>0)
         return this.getY2();
      else 
         return this.getY1();
   }
   
   public int getWidth()
   {
      return abs(this.getX1()-this.getX2());
   }
   
   public int getHeight()
   {
      return abs(this.getY1()-this.getY2());
   }
   
   public boolean isFilled() {
      return filled;
   }

   public void setFilled(boolean filled) {
      this.filled = filled;
   }
   //The draw method
   @Override
   public void draw(Graphics2D g)
   {
      g.setPaint(super.getPaint());
      g.setStroke(super.getStroke());
      if(isFilled())
         g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
      else
         g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
    
   }
   
  
   
   
   
   
   
}
