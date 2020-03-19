package v1ch12.checkBox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A frame with a sample text label and check boxes for selecting font
 * attributes.
 */
public class CheckBoxFrame extends JFrame
{
   private JLabel label;
   private JCheckBox bold;
   private JCheckBox italic;
   private static final int FONTSIZE = 24;

   public CheckBoxFrame()
   {
      // add the sample text label

      label = new JLabel("The quick brown fox jumps over the lazy dog.");
      // label.setFont(new Font("Serif", Font.BOLD, FONTSIZE));
      add(label, BorderLayout.CENTER);

      // this listener sets the font attribute of
      // the label to the check box state

      ActionListener listener = event -> {
         int mode = 0;
         if (bold.isSelected()) mode += Font.BOLD;
         if (italic.isSelected()) mode += Font.ITALIC;
         label.setFont(new Font("Serif", mode, FONTSIZE));
      };

      // add the check boxes

      JPanel buttonPanel = new JPanel();

      bold = initCheckBox("Bold", listener, buttonPanel);
      italic = initCheckBox("Italic", listener, buttonPanel);

      add(buttonPanel, BorderLayout.SOUTH);

      bold.doClick();
      pack();
   }

   private JCheckBox initCheckBox(String name, ActionListener listener, JPanel panel){
       JCheckBox box = new JCheckBox(name);
       box.addActionListener(listener);
       panel.add(box);
       return box;
   }
}