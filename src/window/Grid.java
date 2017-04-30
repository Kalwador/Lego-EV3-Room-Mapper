package window;

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

    public Grid(matrix.Matrix<Short> matrix, utils.Camera camera) {
        rectalngleMatrix = new RectangleMatrix(matrix.getWidth(), matrix.getHeight());

        /**
         * Wyznaczenie wierzchołków kwadratów w siatce
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

    public void drawGrid(matrix.Matrix<Short> matrix, Graphics2D g) {
        boolean a = true;
        for (int i = 0; i < rectalngleMatrix.getWidth(); i++) {
            for (int j = 0; j < rectalngleMatrix.getHeight(); j++) {
                g.setPaint(Color.GRAY);
                
                if((Short)matrix.getMatrix()[j][i] == 1){
                    g.setPaint(Color.RED);
                }
                if((Short)matrix.getMatrix()[j][i] == 2){
                    g.setPaint(Color.BLUE);
                }
            g.fill((Rectangle2D) rectalngleMatrix.getMatrix()[i][j]);
        }
    }
}

//    public void updateGrid(utils.Camera camera) {
//        for (int i = 0; i < rectalngleMatrix.getWidth(); i++) {
//            for (int j = 0; j < rectalngleMatrix.getHeight(); j++) {
//                rectalngleMatrix.getMatrix()[i][j] = new Rectangle2D.Double(
//                        i * VisualizationGUI.RESOLUTION,
//                        j * VisualizationGUI.RESOLUTION,
//                        VisualizationGUI.RESOLUTION,
//                        VisualizationGUI.RESOLUTION);
//            }
//        }
//        System.out.println("ywołuje update grid");
//    }
}
