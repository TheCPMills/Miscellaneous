package main.gui.Swing;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @version Version
 * @since 
 */

@SuppressWarnings("raw")
public class Combo extends JFrame implements ActionListener {
   String[] messageStrings = {"Message 1", "Message 2", "Message 3"};
   JComboBox cmbMessageList = new JComboBox(messageStrings);
   JLabel lblText = new JLabel();
   public Combo() {
       setLayout(new FlowLayout());
       setSize(400, 300);
       setTitle("JComboBox Example");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       cmbMessageList.setSelectedIndex(1);
       cmbMessageList.addActionListener(this);
       add(cmbMessageList);
       add(lblText);
   }
   public void actionPerformed(ActionEvent e) {
       if(e.getSource() == cmbMessageList) {
           JComboBox cb = (JComboBox)e.getSource();
           String msg = (String)cb.getSelectedItem();
           switch(msg) {
               case "Message 1": lblText.setText("Bad");
                     break;
               case "Message 2": lblText.setText("Okay");
                     break;
               case "Message 3": lblText.setText("Good");
                     break;
               default: lblText.setText("Uh-Oh");
           }
       }
   }
   public static void main(String[] asrgs) {
       Combo fr = new Combo();
       //centerFrame(fr);
       //maximizeFrame(fr);
       fr.setVisible(true);
   }
}