package figure;

import camera.Camera;
import linalg.Vector3d;

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
    public void render_polygon(PolygonFigure figure, Graphics g){
        int[] xpos = new int[0];
        int[] ypos = new int[0];
        double[] temp;
        for (int j = 0; j < figure.length; j++){
            temp = camera.getRelativePosition(figure.Dots[j].position);
            if (temp != null) {
                int[] newxpos = new int[xpos.length + 1];
                int[] newypos = new int[ypos.length + 1];
                System.arraycopy(xpos, 0, newxpos, 0, xpos.length);
                System.arraycopy(ypos, 0, newypos, 0, ypos.length);

                newxpos[newxpos.length - 1] = (int) ((1 + temp[0]) * this.width / 2);
                newypos[newypos.length - 1] = (int) ((1 + temp[1]) * this.height / 2);
                xpos = newxpos;
                ypos = newypos;
            }
        }
        g.setColor(Color.getHSBColor((float) figure.def_color[0], (float) figure.def_color[1], (float) figure.def_color[2]));
        g.fillPolygon(xpos, ypos, xpos.length);
    }

    public void render(Graphics g){
        for (int i = 0; i < this.figureSet.length; i++) {
            switch(this.figureSet.tags[i]){
                case "dot":
                    double[] position = camera.getRelativePosition(this.figureSet.figures[i].position);
                    if (position != null){
                        double r = this.figureSet.figures[i].radius;
                        g.setColor(Color.RED);
                        g.fillOval((int) ((1 + position[0]) * this.width / 2 - r), (int) ((1 + position[1]) * this.height / 2 - r),
                                (int) (2*r), (int) (2*r));
                    }
                    break;
                case "linefigure":
                    LineFigure figure = (LineFigure) this.figureSet.figures[i];
                    double[] origin = camera.getRelativePosition(figure.position);
                    double[] end = camera.getRelativePosition(figure.end_position);
                    if (origin != null && end != null){
                        g.setColor(Color.GREEN);
                        g.drawLine((int) ((1 + origin[0]) * this.width / 2), (int) ((1 + origin[1]) * this.height / 2),
                                (int) ((1 + end[0]) * this.width / 2), (int) ((1 + end[1]) * this.height / 2));
                    }
                    break;
                case "polygonfigure":
                    PolygonFigure figure1 = (PolygonFigure) this.figureSet.figures[i];
                    render_polygon(figure1, g);
                    break;
            }
        }
    }
}
