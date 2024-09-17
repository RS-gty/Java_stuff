package figure;

import camera.Camera;

import java.awt.*;

public class Renderer {
    private FigureSet figureSet ;
    private Camera camera ;
    private int width, height;

    public Renderer(FigureSet figureSet, Camera camera, int width, int height){
        this.figureSet = figureSet;
        this.camera = camera;
        this.width = width;
        this.height = height;
    }

    public void render(Graphics g){
        for (int i = 0; i < this.figureSet.length; i++) {
            switch(this.figureSet.tags[i]){
                case "dot":
                    double[] position = camera.getRelativePosition(this.figureSet.figures[i].position);
                    g.setColor(Color.RED);
                    g.fillOval((int) ((1 + position[0]) * this.width / 2)-10, (int) ((1 + position[1]) * this.height / 2)-10,
                            20, 20);
                    break;
                case "figure":
                    g.setColor(Color.CYAN);
                    g.fillOval(100, 100, 50, 50);
                    break;
            }
        }
    }
}
