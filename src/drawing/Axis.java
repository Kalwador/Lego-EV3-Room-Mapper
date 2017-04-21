package drawing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import core.VisualizationGUI;

/**
 *
 * @author Kalvador
 */
public class Axis {

    private Shape vertical;
    private Shape horizontal;

    double x1, x2, x3, x4;
    double y1, y2, y3, y4;

    public void updateAxis(utils.Camera camera) {
        x1 = 400;
        x2 = 0;
        x3 = 400;
        x4 = 600;

        y1 = 0;
        y3 = 800;

        vertical = new Line2D.Double(
                x1,
                x2,
                x3,
                x4);
        horizontal = new Line2D.Double(
                y1,
                y2,
                y3,
                y4
        );
    }

    public void drawAxis(Graphics2D g) {
        g.setColor(Color.red);
        g.draw(vertical);
        g.draw(horizontal);
    }
}
