package figure;

import camera.Camera;

import java.awt.*;

public class Renderer {
    private FigureSet figureSet ;
    private Camera camera ;
    private int width, height;

    public Renderer(FigureSet figureSet, int width, int height){
        this.figureSet = figureSet;
        this.width = width;
        this.height = height;
    }

    public void render(Graphics g){
        for (int i = 0; i < this.figureSet.length; i++) {
            switch(this.figureSet.tags[i]){
                case "dot":
                    g.setColor(Color.RED);
                    g.fillOval(100, 100, 50, 50);
                    break;
                case "figure":
                    g.setColor(Color.CYAN);
                    g.fillOval(100, 100, 50, 50);
                    break;
            }
        }
    }
}
