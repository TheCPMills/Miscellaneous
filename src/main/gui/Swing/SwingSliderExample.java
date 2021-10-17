package main.gui.Swing;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SwingSliderExample extends JPanel {

  public SwingSliderExample()
  {   super(true);
    this.setLayout(new BorderLayout());
    JSlider slider = new JSlider(JSlider.HORIZONTAL, 6, 15, 8);
    slider.setMinorTickSpacing(1);
    slider.setMajorTickSpacing(2);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);
    slider.setLabelTable(slider.createStandardLabels(1));
    add(slider, BorderLayout.CENTER);
    slider.addChangeListener(new SliderListener());
  }

  public static void main(String s[]) {
    SwingSliderExample t = new SwingSliderExample();
    JFrame frame = new JFrame("Slider Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(t);
    frame.pack();
    frame.setVisible(true);
  }
}
class SliderListener implements ChangeListener {
    public void stateChanged(ChangeEvent e) {
      JSlider slider = (JSlider) e.getSource();
      int i = slider.getValue();
      System.out.println(i);
    }
} 
       