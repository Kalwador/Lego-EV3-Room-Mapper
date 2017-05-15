package window;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import matrix.RectangleMatrix;
import core.VisualizationGUI;
import java.awt.Color;

/**
 *
 * @author Kalwador
 */
public class Obstacles {

    private matrix.RectangleMatrix rectalngleMatrix;

    public Obstacles() {
        rectalngleMatrix = new RectangleMatrix(
                core.VisualizationGUI.matrix.getWidth(), 
                core.VisualizationGUI.matrix.getHeight());
        updateObstacles();
    }

    public void updateObstacles() {
        /**
         * determining vertices of squares in the grid
         */
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

    /**
     * Drawing obstacles on screen
     *@param g
     * 
     */
    public void drawOBstacles(Graphics2D g){
        for (int i = 0; i < rectalngleMatrix.getWidth(); i++) {
            for (int j = 0; j < rectalngleMatrix.getHeight(); j++) {
                if ((Short) core.VisualizationGUI.matrix.getMatrix()[j][i] == 1) {
                    g.setPaint(Color.RED);
                    g.fill((Rectangle2D) rectalngleMatrix.getMatrix()[i][j]);
                }
                if ((Short) core.VisualizationGUI.matrix.getMatrix()[j][i] == 2) {
                    g.setPaint(Color.BLUE);
                    g.fill((Rectangle2D) rectalngleMatrix.getMatrix()[i][j]);
                }
            }
        }
    }
}
