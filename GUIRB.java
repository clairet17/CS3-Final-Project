import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUIRB implements ActionListener
{
   private JFrame frame;
   private JPanel panel;
   private JButton button;
   private JLabel label;
   private boolean happened;
   
   public GUIRB()
   {
      happened=false;
      
   }
   
   public void promptUser(String Sbutton, String Slabel, JFrame frame)
   {
      this.frame=frame;
      panel=new JPanel(new FlowLayout());
      button=new JButton(Sbutton);
      button.addActionListener(this);
      label=new JLabel(Slabel);
      panel.add(label);
      panel.add(button);
      frame.add(panel, BorderLayout.CENTER);
      frame.setVisible(true);
             
   }
   
   public void actionPerformed(ActionEvent event)
   {
      happened=true;
      frame.remove(panel);
   }
   
   public boolean didHappen()
   {
      return happened;
   }
   
   
}