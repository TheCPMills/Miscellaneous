package main.math;
import java.awt.*;
import javax.swing.*;
import net.objecthunter.exp4j.*;

public class Graph extends JFrame {
    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;
    private Container drawable;
    private JPanel canvas;

    public Graph() {
        super("Graph");
        drawable = getContentPane();
        canvas = new GraphCanvas();
        drawable.add(canvas);
        setSize(WIDTH, HEIGHT);
    }

    public class GraphCanvas extends JPanel {
        Expression e = new ExpressionBuilder("0.5sin(x+pi/2)+2").variables("x").build();
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            for(double x = 0; x < 9; x += 0.01) {
                double y = e.setVariable("x", x).evaluate();
                if(!(Math.abs(y) > 490)) {
                    if(y < 0) {
                        y = Math.abs(y) * 100 + 500;
                    } else {
                        y = 500 - y * 100;
                    }
                } else {
                    y = 10;
                }
                double y1 = e.setVariable("x", x + 0.01).evaluate();
                if (!(Math.abs(y1) > 490)) {
                    if (y1 < 0) {
                        y1 = Math.abs(y1) * 100 + 500;
                    } else {
                        y1 = 500 - y1 * 100;
                    }
                } else {
                    y1 = 10;
                }
                g2.drawLine((int) (x * 100), (int) y, (int) ((x + 0.01) * 100), (int) y1);
            }
            // g2.drawLine(200, 10, 300, 10);
            g2.drawLine(0, 500, 1000, 500);
        }
    }

    public static void main(String[] args) {
        Frame f = new Graph();
        f.setVisible(true);
    }
}