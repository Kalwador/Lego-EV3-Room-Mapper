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
        x1 = (camera.getxCameraStart() + (VisualizationGUI.windowWidth / 2));
        x2 = camera.getyCameraStart();
        x3 = (camera.getxCameraEnd() - (VisualizationGUI.windowWidth / 2));
        x4 = camera.getyCameraEnd();

        y1 = camera.getxCameraStart();
        y2 = (camera.getyCameraStart() + (VisualizationGUI.windowHeight / 2));
        y3 = camera.getxCameraEnd();
        y4 = (camera.getyCameraEnd() - (VisualizationGUI.windowHeight / 2));

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
        System.out.println(x1 + " x " + x2 + " x " + x3 + " x " + x4);
        System.out.println(y1 + " x " + y2 + " x " + y3 + " x " + y4);
        g.setColor(Color.red);
        g.draw(vertical);
        g.draw(horizontal);
    }
}
