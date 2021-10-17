package main.gui.Swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jdesktop.swingx.*;

public class BackgroundButton extends JFrame
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JXButton frame;
    public BackgroundButton()
    {   frame = new JXButton();
        frame.setBackgroundPainter(new org.jdesktop.swingx.painter.MattePainter(Color.RED));
        Container c = getContentPane();
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
        c.setLayout(fl);
        c.add(frame);
        ButtonHandler handler = new ButtonHandler();
        frame.addActionListener(handler);
        setSize(400, 300);
        setVisible(true);
    }
    
    public static void main(String [] args)
    {   BackgroundButton f = new BackgroundButton();
        f.addWindowListener(new WindowAdapter()
        {   public void windowClosing(WindowEvent e)
            {   System.out.println("");
                System.exit(0);
            }
        }
        );
    }
    
    class ButtonHandler implements ActionListener
    {   public void actionPerformed(ActionEvent e)
        {   if(e.getSource() == frame)
            {   System.out.println("Button #1 has been pressed.");
            }
        }
    }
}