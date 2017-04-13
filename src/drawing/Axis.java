package drawing;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import utils.Vector;

/**
 *
 * @author Kalvador
 */
public class Axis {

    private Shape vertical;
    private Shape horizontal;
    private double width;
    private double height;

    public void updateAxis(Vector camera) {
        updateAxisSize(camera);
        vertical = new Line2D.Double(width, 0.0, width, width * 2);
        horizontal = new Line2D.Double(0.0, height, width * 2, height);
    }

    private void updateAxisSize(Vector camera) {
        this.width = (camera.getX() / 2);
        this.height = (camera.getY() / 2);
    }

    public void drawAxis(Graphics2D g) {
        g.draw(vertical);
        g.draw(horizontal);
    }
}
