 
package java2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;


public class MyLine extends MyShape{
   
   public MyLine(int x1,int y1, int x2, int y2, Paint paint, Stroke stroke )
   {
      super(x1,y1,x2,y2,paint,stroke);
      
   }
   public MyLine()
   {
      super(0,0,0,0,Color.BLACK,new BasicStroke());
   }
   
   @Override
   public void draw(Graphics2D g)
   {
      g.setPaint(super.getPaint());
      g.setStroke(super.getStroke());
      g.drawLine(super.getX1(),super.getY1(),super.getX2(),super.getY2());
   }
   
   
   
}
