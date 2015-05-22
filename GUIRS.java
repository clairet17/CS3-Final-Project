import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUIRS implements ActionListener
{
   private JFrame frame;
   private String SS;
   private JLabel label;
   private JTextField field;
   private JButton button;
   private JPanel panel;
   
   public GUIRS()
   {
      String SS=null;   
   }
   
   public void promptUser(String SButton, String SLabel, JFrame frame)
   {
      this.frame=frame;
      frame.setLayout(new GridLayout());
      button=new JButton(SButton);
      button.addActionListener(this);
      label=new JLabel(SLabel);
      field=new JTextField(20);
      panel=new JPanel(new FlowLayout());
      frame.add(button, BorderLayout.SOUTH);
      frame.add(field, BorderLayout.NORTH);
      panel.add(label);
      frame.add(panel, BorderLayout.CENTER);
      frame.setVisible(true);
   }
   
   public String getString()
   {
      return SS;
   }
   
   public void actionPerformed(ActionEvent event)
   {
      String temp=field.getText();
      SS=temp;
      frame.remove(panel);
   }
}

