package main.gui.Swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Choices extends JFrame {
    private JButton myFirstButton;
    private JButton mySecondButton;
    private JButton myThirdButton;
    private JButton myFourthButton;
    public Choices()
    {   super("Button Program");
        myFirstButton = new JButton("A");
        myFirstButton.setFont(new Font( "Arial", Font.BOLD, 18));
        myFirstButton.setBackground(Color.RED);
        mySecondButton = new JButton("B");
        mySecondButton.setFont(new Font( "Arial", Font.BOLD, 18));
        mySecondButton.setBackground(Color.yellow);
        myThirdButton = new JButton("C");
        myThirdButton.setFont(new Font( "Arial", Font.BOLD, 18));
        myThirdButton.setBackground(Color.green);
        myFourthButton = new JButton("D");
        myFourthButton.setFont(new Font( "Arial", Font.BOLD, 18));
        myFourthButton.setBackground(Color.blue);
        Container c = getContentPane();
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
        c.setLayout(fl);
        c.add (myFirstButton);
        c.add (mySecondButton);
        c.add (myThirdButton);
        c.add (myFourthButton);
        ButtonHandler handler = new ButtonHandler();
        myFirstButton.addActionListener(handler);
        mySecondButton.addActionListener(handler);
        myThirdButton.addActionListener(handler);
        myFourthButton.addActionListener(handler);
        setSize(400, 300);
        setVisible(true);
    }
    
    public static void main(String [] args)
    {   Choices f = new Choices();
        f.addWindowListener(
        new WindowAdapter()
        {   public void windowClosing(WindowEvent e)
            {   System.out.println("");
                System.exit(0);
            }
        }
        );
    }
    
    class ButtonHandler implements ActionListener
    {   public void actionPerformed(ActionEvent e)
        {   if(e.getSource() == myFirstButton)
            {   System.out.println("Button #1 has been pressed.");
            }
            if(e.getSource() == mySecondButton)
            {   System.out.println("Button #2 has been pressed.");
            }
            if(e.getSource() == myThirdButton)
            {   System.out.println("Button #3 has been pressed.");
            }
            if(e.getSource() == myFourthButton)
            {   System.out.println("Button #4 has been pressed.");
            }
        }
    }
}