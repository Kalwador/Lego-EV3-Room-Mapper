package window;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import matrix.RectangleMatrix;
import core.VisualizationGUI;
import java.awt.Color;

/**
 * Rectangles are filled with collors, and are diplayed on scrren
 * @author Kalwador
 */
public class Obstacles {

    //new matrix for awt.Rectangle
    private matrix.RectangleMatrix rectalngleMatrix;

    public Obstacles() {
        rectalngleMatrix = new RectangleMatrix(
                core.VisualizationGUI.matrix.getHeight(),
                core.VisualizationGUI.matrix.getWidth());
        updateObstacles();
    }

    public void updateObstacles() {
        /**
         * determining vertices of squares in the grid
         */
        for (int y = 0; y < rectalngleMatrix.getHeight(); y++) {
            for (int x = 0; x < rectalngleMatrix.getWidth(); x++) {
                rectalngleMatrix.getMatrix()[y][x] = new Rectangle2D.Double(
                        x * VisualizationGUI.RESOLUTION,
                        y * VisualizationGUI.RESOLUTION,
                        VisualizationGUI.RESOLUTION,
                        VisualizationGUI.RESOLUTION);
            }
        }
    }

    /**
     * Drawing obstacles on screen
     *
     * @param g - grapic
     */
    public void drawOBstacles(Graphics2D g) {
        
        //loop on rectangle matrix
        for (int j = 0; j < rectalngleMatrix.getHeight(); j++) {
            for (int i = 0; i < rectalngleMatrix.getWidth(); i++) {
                
                //if color in matrix is RED
                if ((Short) core.VisualizationGUI.matrix.getMatrix()[j][i] == 1) {
                    g.setPaint(Color.RED);
                    g.fill((Rectangle2D) rectalngleMatrix.getMatrix()[j][i]);
                }
                
                //if color in matrix is BLUE
                if ((Short) core.VisualizationGUI.matrix.getMatrix()[j][i] == 2) {
                    g.setPaint(Color.BLUE);
                    g.fill((Rectangle2D) rectalngleMatrix.getMatrix()[j][i]);
                }
            }
        }
    }
}
