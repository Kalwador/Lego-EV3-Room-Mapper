package window.canvas;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import matrix.RectangleMatrix;
import core.VisualizationGUI;
import java.awt.Color;

/**
 *
 * @author Kalvador
 */
public class Grid {
    
    private matrix.RectangleMatrix rectalngleMatrix;

    public Grid() {
        int numberOfRectanglesWidth = VisualizationGUI.windowWidth / VisualizationGUI.RESOLUTION;
        int numberOfRectanglesHeight = (VisualizationGUI.windowHeight - 100) / VisualizationGUI.RESOLUTION;
        rectalngleMatrix = new RectangleMatrix(numberOfRectanglesWidth, numberOfRectanglesHeight);
        System.out.println(rectalngleMatrix.getSize().toString());
    }

    public void drawGrid(utils.Camera camera, Graphics2D g) {
        updateGrid(camera);
        g.setColor(Color.GRAY);
        for (int i = 0; i < rectalngleMatrix.getWidth(); i++) {
            for (int j = 0; j < rectalngleMatrix.getHeight(); j++) {
                g.draw((Rectangle2D)rectalngleMatrix.getMatrix()[i][j]);
            }
        }
    }

    public void updateGrid(utils.Camera camera) {
        for (int i = 0; i < rectalngleMatrix.getWidth(); i++) {
            for (int j = 0; j < rectalngleMatrix.getHeight(); j++) {
                rectalngleMatrix.getMatrix()[i][j] = new Rectangle2D.Double(
                        i * VisualizationGUI.RESOLUTION, 
                        j * VisualizationGUI.RESOLUTION, 
                        VisualizationGUI.RESOLUTION,
                        VisualizationGUI.RESOLUTION);
            }
        }
    }
}
