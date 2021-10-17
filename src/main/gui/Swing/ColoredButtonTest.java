package main.gui.Swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ColoredButtonTest extends JFrame {
    private JButton redButton;
    private JButton blueButton;
    public ColoredButtonTest()
    {   super("Button Program");
        redButton = new ColoredButton("Test", Color.RED, Color.BLUE, Color.GREEN);
        blueButton = new ColoredButton("Test", Color.BLUE, Color.GREEN, Color.RED);
        redButton.setFont(new Font( "Arial", Font.BOLD, 18));
        redButton.setBorderPainted(false);
        blueButton.setFont(new Font( "Arial", Font.BOLD, 18));
        blueButton.setBorderPainted(false);
        Container c = getContentPane();
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
        c.setLayout(fl);
        c.add(redButton);
        c.add(blueButton);
        ButtonHandler handler = new ButtonHandler();
        redButton.addActionListener(handler);
        blueButton.addActionListener(handler);
        setSize(400, 300);
        setVisible(true);
    }
    
    public static void main(String [] args)
    {   ColoredButtonTest f = new ColoredButtonTest();
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
        {   if(e.getSource() == redButton)
            {   System.out.println("Red Button has been pressed.");
            }
            if(e.getSource() == blueButton)
            {   System.out.println("Blue Button has been pressed.");
            }
        }
    }
}
class ColoredButton extends JButton
{   private Color pressedColor;
    private Color rolloverColor;
    private Color normalColor;
    public ColoredButton(String text, Color normal, Color pressed, Color rollover)
    {   super(text);
        pressedColor = pressed;
        rolloverColor = rollover;
        normalColor = normal;
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(true);
        setBackground(normalColor);
        setForeground(Color.WHITE);
        setFont(new Font("Tahoma", Font.BOLD, 12));
        setText(text);
        addChangeListener(new ChangeListener()
        {   @Override
            public void stateChanged(ChangeEvent evt)
            {   if (getModel().isPressed())
                {   setBackground(pressedColor);
                }
                else if (getModel().isRollover())
                {   setBackground(rolloverColor);
                }
                else
                {   setBackground(normalColor);
                }
            }
        }
        );
    }
}