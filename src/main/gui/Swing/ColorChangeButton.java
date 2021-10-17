package main.gui.Swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ColorChangeButton
{   public static void main (String arg[])
    {   EventQueue.invokeLater(new Runnable()
        {   public void run()
            {   ColorChanger buttonFrame = new ColorChanger();
        	buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	buttonFrame.setVisible(true);
            }
        }
        );
    }
}
class ColorChanger extends JFrame
{   private ButtonPanel buttonPanel;
    public ColorChanger()
    {   setSize(300,200);
        setLocation(570,350);
        setTitle("Button Test");
        buttonPanel=new ButtonPanel();
        add(buttonPanel);
    }
    
    private class ButtonPanel extends JPanel
    {   public ButtonPanel()
        {   JButton redButton=new JButton("Red");
            JButton yellowButton=new JButton("Yellow");
            JButton greenButton=new JButton("Green");
            add(redButton);
            add(yellowButton);
            add(greenButton);
            ColorAction setRed=new ColorAction(Color.RED);
            ColorAction setYellow=new ColorAction(Color.YELLOW);
            ColorAction setGreen=new ColorAction(Color.GREEN);
            redButton.addActionListener(setRed);
            yellowButton.addActionListener(setYellow);
            greenButton.addActionListener(setGreen);
        }
    }
    
    private class ColorAction implements ActionListener
    {   private Color bgColor;
        public ColorAction(Color c)
        {   bgColor = c;
        }
        
        public void actionPerformed(ActionEvent e)
        {   buttonPanel.setBackground(bgColor);
        }
    }
}