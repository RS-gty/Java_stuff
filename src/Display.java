import camera.Camera;
import figure.*;
import figure.Renderer;
import linalg.Vector3d;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JPanel {
    private FigureSet figureSet;
    private static Camera camera;
    private Renderer renderer;
    private static int width;
    private static int height;
    private static double t = 0;

    public Display(FigureSet figureSet,Camera pcamera, int width, int height) {
        this.figureSet = figureSet;
        this.width = width;
        this.height = height;

        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t += 0.03;// 更新动画状态
                camera = new Camera(new Vector3d(-5, t, 0), 0,0, 0, 2*Math.PI/4,
                        2*Math.PI/4, new double[]{(double)1, (double)1});
                renderer = new Renderer(figureSet, camera, width, height);
                repaint();  // 重新绘制
            }
        });
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderer.render(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FigureSet figureSet = new FigureSet();
        Dot dot = new Dot(1, 1, 1, 2);
        Dot dot2 = new Dot(1, 1, -1, 2);
        Dot dot3 = new Dot(1, -1, 1, 2);
        Dot dot4 = new Dot(1, -1, -1, 2);
        Dot dot5 = new Dot(3, 1, 1, 2);
        Dot dot6 = new Dot(3, 1, -1, 2);
        Dot dot7 = new Dot(3, -1, 1, 2);
        Dot dot8 = new Dot(3, -1, -1, 2);
        PolygonFigure p1 = new PolygonFigure(new Dot[]{dot, dot2, dot4, dot3});
        PolygonFigure p2 = new PolygonFigure(new Dot[]{dot, dot2, dot6, dot5});
        PolygonFigure p3 = new PolygonFigure(new Dot[]{dot7, dot8, dot6, dot5});
        PolygonFigure p4 = new PolygonFigure(new Dot[]{dot, dot3, dot7, dot5});
        PolygonFigure p5 = new PolygonFigure(new Dot[]{dot4, dot8, dot6, dot2});
        PolygonFigure p6 = new PolygonFigure(new Dot[]{dot3, dot4, dot8, dot7});
        dot.register(figureSet);
        dot2.register(figureSet);
        dot3.register(figureSet);
        dot4.register(figureSet);
        dot5.register(figureSet);
        dot6.register(figureSet);
        dot7.register(figureSet);
        dot8.register(figureSet);

        p2.register(figureSet);
        p3.register(figureSet);
        p4.register(figureSet);
        p5.register(figureSet);
        p6.register(figureSet);
        p1.register(figureSet);


        double[] ratio = {1, 1};

        Display panel = new Display(figureSet, camera, 1000, 1080);

        frame.setSize(width, height);

        panel.setBackground(Color.BLACK);
        frame.add(panel);
        frame.setVisible(true);
    }
}
