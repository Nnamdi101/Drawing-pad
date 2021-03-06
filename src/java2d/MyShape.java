
package java2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import static java.lang.Math.abs;

public abstract class MyShape {
   private int x1;
   private int y1;
   private int x2;
   private int y2;
   private Paint paint;
   private Stroke stroke;
   
   public MyShape()
   {
      setX1(0);
      setY2(0);
      setX2(0);
      setY2(0);
      setPaint(Color.BLACK);
      setStroke(new BasicStroke());
   }
   
   public MyShape(int x1,int y1, int x2, int y2, Paint paint, Stroke stroke)
   {
      setX1(x1);
      setY1(y1);
      setX2(x2);
      setY2(y2);
      setPaint(paint);
      setStroke(stroke);
      
   }
  
   
   public int getX1() {
      return x1;
   }

   
   public void setX1(int x1) {
      if(x1>=0)
         this.x1=x1;
      else
         this.x1=0;    
   }

   public int getY1() {
      return y1;
   }

  
   public void setY1(int y1) {
      if(y1>=0)
         this.y1=y1;
      else
         this.y1=0;
   }

   public int getX2() {
      return x2;
   }

   public void setX2(int x2) {
      if(x2>=0)
         this.x2=x2;
      else
         this.x2=0;
   }

  
   public int getY2() {
      return y2;
   }

  
   public void setY2(int y2) {
      if(y2>=0)
         this.y2=y2;
      else
         this.y2=0;
   }

   
   public Paint getPaint() {
      return paint;
   }

   
   public void setPaint(Paint paint) {
      this.paint = paint;
   }
   
   public Stroke getStroke()
   {
      return stroke;
   }
   
   public void setStroke(Stroke stroke)
   {
      this.stroke = stroke;
   }

   public abstract void draw(Graphics2D g);
   
   
   
   
   
}
