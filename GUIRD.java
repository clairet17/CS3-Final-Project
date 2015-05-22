import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUIRD implements ActionListener
{
   private Controller c;
   private JCheckBox[] checkboxs;
   private JLabel[] labels;
   private JButton button;
   private JFrame frame;
   private JPanel panelbox;
   private JPanel panellabel;
   private JLabel instructions;
   
   public GUIRD(Controller c)
   {
      this.c=c;
   }
   
   public void promptUser(String SButton, String SLabel, JFrame frame, Die[] previousHand)
   {
      this.frame=frame;
      frame.setLayout(new GridLayout());
      checkboxs=new JCheckBox[5];
      labels=new JLabel[5];
      for(int ii=0; ii<5; ii++)
      {
         checkboxs[ii]=new JCheckBox();
         labels[ii]=new JLabel("Die "+(ii+1)+": "+previousHand[ii].getValueOfDie());
      }
      button=new JButton("Roll");
      button.addActionListener(this);
      panelbox=new JPanel(new GridLayout());
      panellabel=new JPanel(new GridLayout());
      instructions=new JLabel(SLabel);
      for(int pp=0; pp<5; pp++)
      {
         panelbox.add(checkboxs[pp], BorderLayout.CENTER);
         panellabel.add(labels[pp], BorderLayout.CENTER);
      }
      frame.add(panelbox, BorderLayout.EAST);
      frame.add(panellabel, BorderLayout.CENTER);
      frame.add(instructions, BorderLayout.NORTH);
      frame.add(button, BorderLayout.SOUTH);
      frame.pack();
      frame.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent event)
   {
      c.roll(checkboxs[0].isSelected(), checkboxs[1].isSelected(), checkboxs[2].isSelected(),
                      checkboxs[3].isSelected(), checkboxs[4].isSelected());
      frame.remove(panelbox);
      frame.remove(panellabel);
      frame.remove(instructions);
      frame.remove(button);
   }
}