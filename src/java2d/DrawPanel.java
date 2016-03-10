
package java2d;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;

public class DrawPanel extends JPanel {
   
    private MyShape[] shapes = new MyShape[100]; 
    private int shapeCount;
    private int shapeType;
    private MyShape currentShape;
    private Paint currentPaint;
    private boolean filledShape; //f
    private boolean gradpaint; //
    private boolean dashed;
    private final JLabel statusLabel;
    private Stroke currentStroke;
    private Paint p=Color.BLACK;
    private Color color1=Color.BLACK;
    private Color color2= Color.BLACK;
    private float length=0;
    private int width=0;
    private float[] dashes = new float[1];
   
      
     
   public  DrawPanel(JLabel lab)
   {
    statusLabel = lab;  
    shapeCount=0;
    shapeType=0;
    currentShape=null;
    currentStroke=new BasicStroke();
    currentPaint=Color.BLACK;
    filledShape=false;
    length=0;
    width=0;
    setBackground(Color.WHITE);
   
    
    //register mouse handler
    MouseHandler handler = new MouseHandler();
    addMouseListener(handler);
    addMouseMotionListener(handler);
    
   }
   
   @Override
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      super.paintComponent(g2);
      
      for(int i=0; i<shapeCount;i++)
       shapes[i].draw(g2);
      if(currentShape!=null)   
      currentShape.draw(g2);
   }
   
   public void setshapeType(int s)
   {
      shapeType=s;
   }
   
   public void setcurrentPaint(Paint p)
   {
      currentPaint=p;
   }
   public void setgradpaint(boolean f)
   {
      gradpaint = f;
   }
   
   public void setfilledShape(boolean f)
   {
      filledShape=f;
   }
   public void setStroke(Stroke s)
   {
      currentStroke=s;
   }
   public void clearLastShape()
   {
      shapeCount--;
      repaint(); 
   }
   public void clearDrawing()
   {
      shapeCount=0;
      repaint();
   }
   public void setDashed(boolean d)
   {
      dashed=d;
   }
   public void setColor1(Color color1) {
      this.color1 = color1;
   }
   public void setColor2(Color color2) {
      this.color2 = color2;
   }

   
   public void setLength(float length) {
      this.length = length;
   }

   public void setWidth(int width) {
      this.width = width;
   }
  
   
   
   
  
  
   
   private class MouseHandler extends MouseAdapter implements MouseMotionListener
   {
     
      @Override
      public void mousePressed(MouseEvent event)
      {
         int xpos = event.getX();
         int ypos = event.getY();
     
         
         /*************************************************/
         
         setcurrentPaint(color1);//initial current paint to color1
         setLength(length);
         setWidth(width);
         setStroke(new BasicStroke(width,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
         
         
         if(gradpaint&&dashed)
         {
            setcurrentPaint(new GradientPaint(0,0,color1,50,50,color2,true));
            setStroke(new BasicStroke(width,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL,0,new float[]{10,length},0));
            
         }
         
         else if(gradpaint)
         {
            
            setcurrentPaint(new GradientPaint(0,0,color1,50,50,color2,true));
            
         }
         else if (filledShape)
         {
            setfilledShape(true);
            
         }
         else if(dashed)
         {
            setStroke(new BasicStroke(width,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL,0,new float[]{10,length},0));
         }
         else
         {
            setfilledShape(false);
            setcurrentPaint(color1);
            setStroke(new BasicStroke(width,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
            
         }
         
  
         if(shapeType==0)
         {
            currentShape= new MyLine();
            currentShape.setX1(xpos);
            currentShape.setY1(ypos);
            currentShape.setPaint(currentPaint); 
            currentShape.setStroke(currentStroke);
         }
         
         if(shapeType==1)
         {
            currentShape = new MyOval(xpos,ypos,xpos,ypos,currentPaint,currentStroke,filledShape);
           
         }
         if(shapeType==2)
         {
            currentShape = new MyRectangle(xpos,ypos,xpos,ypos,currentPaint,currentStroke,filledShape);
            
         }
     
         
      }
      
      @Override
      public void mouseReleased(MouseEvent event)
      {
         int xpos = event.getX();
         int ypos = event.getY();
         
         currentShape.setX2(xpos);
         currentShape.setY2(ypos);
         
         shapes[shapeCount]=currentShape;
         shapeCount++;
         currentShape=null;
         repaint();
         
      }
      
      //To show coordinates on status bar
      @Override
      public void mouseMoved(MouseEvent event)
      {
         statusLabel.setText("("+event.getX()+","+event.getY()+")");
      }
      
      //To allow the user to see shape while being dragged
      @Override
      public void mouseDragged(MouseEvent event)
      {
         int xpos = event.getX();
         int ypos = event.getY();
       
         currentShape.setX2(xpos);
         currentShape.setY2(ypos);
         
         statusLabel.setText("("+event.getX()+","+event.getY()+")");
         
         repaint();
      }
      
   }
   
   
}
