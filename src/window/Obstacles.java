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
    private matrix.Matrix<Short> matrix;

    public Obstacles(matrix.Matrix<Short> matrix) {
        this.matrix = matrix;
        rectalngleMatrix = new RectangleMatrix(matrix.getWidth(), matrix.getHeight());
        updateObstacles();
    }

    public void updateObstacles() {
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

    public void drawOBstacles(matrix.Matrix<Short> matrix, Graphics2D g){
        boolean a = true;
//        try{
        for (int i = 0; i < rectalngleMatrix.getWidth(); i++) {
            for (int j = 0; j < rectalngleMatrix.getHeight(); j++) {
                if ((Short) matrix.getMatrix()[j][i] == 1) {
                    g.setPaint(Color.RED);
                    g.fill((Rectangle2D) rectalngleMatrix.getMatrix()[i][j]);
                }
                if ((Short) matrix.getMatrix()[j][i] == 2) {
                    g.setPaint(Color.BLUE);
                    g.fill((Rectangle2D) rectalngleMatrix.getMatrix()[i][j]);
                }
            }
        }
//        }catch(Exception e){
//             JOptionPane.showMessageDialog(null,"Choose a color.");
//             scroll.repaint();
//            
//        
        
    }
}
