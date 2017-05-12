package window;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kalvador
 */
public class Grid {

    private matrix.Matrix<Short> matrix;
    private List<Line2D> horizontalList;
    private List<Line2D> verticalList;

    public Grid(matrix.Matrix<Short> matrix) {
        this.matrix = matrix;
        horizontalList = new ArrayList<>();
        verticalList = new ArrayList<>();
        updateGrid();
    }

    /**
     * Used to update grid after zooming
     *
     * @param width
     * @param height
     */
    public void updateGrid() {
        for (int i = 1; i <= matrix.getHeight(); i++) {
            horizontalList.add(new Line2D.Double(
                    i * core.VisualizationGUI.RESOLUTION,
                    0,
                    i * core.VisualizationGUI.RESOLUTION,
                    matrix.getHeight() * core.VisualizationGUI.RESOLUTION));
        }
        for (int i = 1; i <= matrix.getWidth(); i++) {
            verticalList.add(new Line2D.Double(
                    0,
                    i * core.VisualizationGUI.RESOLUTION,
                    matrix.getWidth() * core.VisualizationGUI.RESOLUTION,
                    i * core.VisualizationGUI.RESOLUTION));

        }
    }

    /**
     * Drawing grid on screen
     *
     * @param width
     * @param height
     * @param g
     */
    public void drawGrid(int width, int height, Graphics2D g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < horizontalList.size(); i++) {
            g.draw(horizontalList.get(i));
        }
        for (int i = 0; i < verticalList.size(); i++) {
            g.draw(verticalList.get(i));
        }
    }
}
