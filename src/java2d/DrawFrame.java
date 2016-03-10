
package java2d;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class DrawFrame extends JFrame {
  
   private final DrawPanel DrawPad;
   private final JPanel MenuPanel;
   private final JPanel Statusbar;
   private final JLabel status= new JLabel("move the mouse");
   private final JButton Undo;
   private final JButton Clear;
   private final JComboBox<String> options;
   private final String[] array = {"Line","Oval","Rectangle"};
   private final JLabel Shape;
   private final JLabel Filled;
   private final JCheckBox fCheck;
   private final JCheckBox Grad;
   private final JButton C1;
   private final JButton C2;
   private final JLabel lw; //line width label
   private final JLabel dl; //line length label
   private final JLabel dashed; //dashed label
   private final JTextField w;//line width
   private final JTextField l; //line length
   private final JCheckBox d; //for dashed lines
   private Color color1 = Color.BLACK;
   private Color color2 = Color.BLACK;
   
 
   public DrawFrame()
   {
      super("Welcome to 2D drawing");
      setLayout(new BorderLayout());
      
      DrawPad = new DrawPanel(status);
      //DrawPad.setBackground(Color.WHITE);
      add(DrawPad, BorderLayout.CENTER);
      
      MenuPanel= new JPanel();
      //MenuPanel.setBackground(Color.YELLOW);
      add(MenuPanel, BorderLayout.NORTH);
      
      Statusbar = new JPanel();
      //Statusbar.setBackground(Color.RED);
      add(Statusbar, BorderLayout.SOUTH);
      
      MenuPanel.setPreferredSize(new Dimension(350,100));
      
      
      
      Undo= new JButton("Undo");
      MenuPanel.add(Undo);
      
      Clear = new JButton("Clear");
      MenuPanel.add(Clear);
      
      Shape = new JLabel("Shape:");
      MenuPanel.add(Shape);
      
      options = new JComboBox<>(array);
      options.setMaximumRowCount(3);
      options.setSelectedIndex(0);
      //handleer for mouse
      options.addItemListener(
              new ItemListener()
              {
                 @Override
                 public void itemStateChanged(ItemEvent event)
                 {
                    if(event.getStateChange()== ItemEvent.SELECTED)
                       DrawPad.setshapeType(options.getSelectedIndex());
                    
                 }
                 
              }
     
      );
      
      
      
      MenuPanel.add(options);
      
      fCheck = new JCheckBox();
      MenuPanel.add(fCheck);
      
      Filled = new JLabel("Filled");
      MenuPanel.add(Filled);
      
      Grad = new JCheckBox("Use Gradient");
      MenuPanel.add(Grad);
     
      
      C1 = new JButton("1st Color");
      MenuPanel.add(C1);
      
      C2 = new JButton("2nd Color");
      MenuPanel.add(C2);
      
      lw = new JLabel("Line Width");
      MenuPanel.add(lw);
      
      w = new JTextField(3);
      MenuPanel.add(w);
      
      dl = new JLabel("Dash Length");
      MenuPanel.add(dl);
      
      l = new JTextField(3);
      MenuPanel.add(l);
      
      d = new JCheckBox();
      MenuPanel.add(d);
      
      dashed = new JLabel("Dashed");
      MenuPanel.add(dashed);
      
      
       Statusbar.add(status);
       Statusbar.setLayout(new FlowLayout(FlowLayout.LEFT));
       
    //register event handlers
      TextFieldHandler TxHandler = new TextFieldHandler();
      l.addActionListener(TxHandler);
      w.addActionListener(TxHandler);
      
      
      ButtonHandler BtHandler = new ButtonHandler();
      Undo.addActionListener(BtHandler);
      Clear.addActionListener(BtHandler);
      C1.addActionListener(BtHandler);
      C2.addActionListener(BtHandler);
      
      
      CheckBoxHandler CkHandler = new CheckBoxHandler();
      fCheck.addItemListener(CkHandler);
      Grad.addItemListener(CkHandler);
      d.addItemListener(CkHandler);
   
   }
   
    private class CheckBoxHandler implements ItemListener
   {
      @Override
      public void itemStateChanged(ItemEvent event)
      {
         DrawPad.setfilledShape(fCheck.isSelected());
         DrawPad.setgradpaint(Grad.isSelected());
         DrawPad.setDashed(d.isSelected());
         
         
      }    
   }
    
   private class ButtonHandler implements ActionListener
   {
      @Override
      public void actionPerformed(ActionEvent event)
      {
            if(event.getSource()==Undo)
            {
               DrawPad.clearLastShape();
            }
            else if(event.getSource() == Clear)
            {
               DrawPad.clearDrawing();
            }
            else if(event.getSource()==C1)
            {
               color1=JColorChooser.showDialog(null,"pick your color",color1);
               DrawPad.setColor1(color1);
               //DrawPad.setcurrentPaint(color1);
            }
            else if(event.getSource()==C2)
            {
               color2=JColorChooser.showDialog(null,"pick your color",color2);
               DrawPad.setColor2(color2);
            }
            
            repaint();
            
      }
      
      
   }
   
  
   
   private class TextFieldHandler implements ActionListener
   {
      @Override
      public void actionPerformed(ActionEvent event)
      {
         if(event.getSource()==w)
            DrawPad.setWidth(Integer.parseInt(event.getActionCommand()));
         else
            DrawPad.setLength(Integer.parseInt(event.getActionCommand()));
         
      }
   }
 
   
}
