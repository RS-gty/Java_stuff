import figure.Dot;
import figure.Figure;
import figure.FigureSet;
import figure.Renderer;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
    private FigureSet figureSet;
    private Renderer renderer;
    private static int width;
    private static int height;

    public Display(FigureSet figureSet, int width, int height) {
        this.figureSet = figureSet;
        this.width = width;
        this.height = height;
        renderer = new Renderer(figureSet, width, height);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderer.render(g);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FigureSet figureSet = new FigureSet();
        Dot dot = new Dot(1, 2, 1);
        dot.register(figureSet);

        Display panel = new Display(figureSet, 1920, 1080);

        frame.setSize(width, height);

        panel.setBackground(Color.BLACK);
        frame.add(panel);
        frame.setVisible(true);
    }
}
