package utils;

/**
 * @author Wilk
 * @author Kalwador
 */
import java.awt.Point;
import javax.swing.JOptionPane;

public class Brush {

    //Choosed Color
    //0 - white
    //1 - Red
    //2 - Blue
    public static Short choosedColor;

    
    //Actual chooced Brush
    public boolean dotBrush = false;
    public boolean rectangleBrush = false;
    public boolean rollBrush = false;

    //Point 
    public Point rollFirstPoint = null;
    
    public static boolean isChanged = false;

    /**
     * Paint Selected shape
     *
     */
    public void paint(Point p) {
        if (dotBrush || rectangleBrush || rollBrush) {
            if (choosedColor != null) {
                if (checkPointIsInMatrix(p)) {
                    if (dotBrush) {
                        paintDot(p);
                    }
                    if (rectangleBrush) {
                        paintRectangle(p);
                    }
                    if (rollBrush) {
                        paintRoll(p);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Choose color.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Choose brush.");
        }
    }

    /**
     * chceck if clicked point does not exceed matrix range
     *
     * @param p clicked point on matrix
     * @return true - if point is in matrix, false in opposite case
     *
     */
    private boolean checkPointIsInMatrix(Point p) {
        if (p.x >= 0 && p.y >= 0) {
            if (p.x < core.VisualizationGUI.matrix.getWidth()
                    && p.y < core.VisualizationGUI.matrix.getHeight()) {
                return true;
            }
        }
        return false;
    }

    /**
     * set up no brush
     */
    public void setNoBrush() {
        rectangleBrush = false;
        rollBrush = false;
        dotBrush = false;
    }

    /**
     * set up brush to dot brush
     */
    public void setDotBrush() {
        rectangleBrush = false;
        rollBrush = false;
        dotBrush = true;
    }

    /**
     * set up brush to rectangle brush
     */
    public void setRectangleBrush() {
        dotBrush = false;
        rollBrush = false;
        rectangleBrush = true;
    }

    /**
     * set up brush to big rectangle brush
     */
    public void setRollBrush() {
        dotBrush = false;
        rectangleBrush = false;
        rollBrush = true;
    }

    /**
     * paint dot on matrix
     *
     * @param p point where mouse is
     */
    public void paintDot(Point p) {
        isChanged = true;
        
        core.VisualizationGUI.matrix.put(p.y, p.x, choosedColor);
    }

    /**
     *
     * Drawing a rectangle of size 6x6
     *
     * @param p point where mouse is
     */
    public void paintRectangle(Point p) {
        
        isChanged = true;
        
        double xStart;
        double yStart;
        double xEnd;
        double yEnd;

        xStart = p.x - 3;
        if (xStart < 0) {
            xStart = 0;
        }

        xEnd = p.x + 3;
        if (xEnd >= core.VisualizationGUI.matrix.getWidth()) {
            xEnd = core.VisualizationGUI.matrix.getWidth() - 1;
        }

        yStart = p.y - 3;
        if (yStart < 0) {
            yStart = 0;
        }

        yEnd = p.y + 3;
        if (yEnd >= core.VisualizationGUI.matrix.getHeight()) {
            yEnd = core.VisualizationGUI.matrix.getHeight() - 1;
        }

        for (int j = (int) yStart; j <= yEnd; j++) {
            for (int i = (int) xStart; i <= xEnd; i++) {
                core.VisualizationGUI.matrix.put(j, i, choosedColor);
            }
        }
    }

    /**
     *
     * Drawing marked place on a matrix
     *
     * @param p point where mouse is
     */
    public void paintRoll(Point p) {
        
        isChanged = true;
        
        //Jeśli true to znaczy że rysujemy nowy kształt
        if (rollFirstPoint == null) {
            rollFirstPoint = p;
        } else {
            //setting points
            int xStart = rollFirstPoint.x;
            int yStart = rollFirstPoint.y;
            int xEnd = p.x;
            int yEnd = p.y;

            //chcecking if figure is not drawing from right to left
            if (xStart > xEnd) {
                int temp = (int) xStart;
                xStart = xEnd;
                xEnd = temp;
            }
            //chcecking if figure is not drawing from down to up
            if (yStart > yEnd) {
                int temp = (int) yStart;
                yStart = yEnd;
                yEnd = temp;
            }
            //Drawing a figure
            for (int j = (int) yStart; j <= yEnd; j++) {
                for (int i = (int) xStart; i <= xEnd; i++) {
                    core.VisualizationGUI.matrix.put(j, i, choosedColor);
                }
            }
            rollFirstPoint = null;
        }
    }

    /**
     *
     * @return choosedColor
     */
    public static Short getChoosedColor() {
        return choosedColor;
    }

    /**
     *
     * @return dotBrush
     */
    public boolean isDotBrush() {
        return dotBrush;
    }

    /**
     *
     * @return rectangleBrush
     */
    public boolean isRectangleBrush() {
        return rectangleBrush;
    }

    /**
     *
     * @return rollBrush
     */
    public boolean isRollBrush() {
        return rollBrush;
    }
}
