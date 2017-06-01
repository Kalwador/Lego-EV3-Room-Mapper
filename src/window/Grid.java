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

    private List<Line2D> horizontalList;
    private List<Line2D> verticalList;

    public Grid(matrix.Matrix<Short> matrix) {
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
        for (int i = 1; i <= core.VisualizationGUI.matrix.getHeight(); i++) {
            horizontalList.add(new Line2D.Double(
                    i * core.VisualizationGUI.RESOLUTION,
                    0,
                    i * core.VisualizationGUI.RESOLUTION,
                    core.VisualizationGUI.matrix.getWidth()* core.VisualizationGUI.RESOLUTION));
        }
        for (int i = 1; i <= core.VisualizationGUI.matrix.getWidth(); i++) {
            verticalList.add(new Line2D.Double(
                    0,
                    i * core.VisualizationGUI.RESOLUTION,
                    core.VisualizationGUI.matrix.getHeight() * core.VisualizationGUI.RESOLUTION,
                    i * core.VisualizationGUI.RESOLUTION));
        }
    }

    /**
     * Drawing grid on screen
     *
     * @param g
     */
    public void drawGrid(Graphics2D g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < horizontalList.size(); i++) {
            g.draw(horizontalList.get(i));
        }
        for (int i = 0; i < verticalList.size(); i++) {
            g.draw(verticalList.get(i));
        }
    }
}
