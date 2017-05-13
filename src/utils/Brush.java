package utils;

import java.awt.Point;
import javax.swing.JOptionPane;

public class Brush {

    public static Short choosedColor;

    public boolean dotBrush = false;
    public boolean rectangleBrush = false;
    public boolean rollBrush = false;
    
    public Point rollStart = null;
    public Point rollEnd = null;

    /**
     * Paint Selected shape
     *
     */
    public void paint(Point p) {
        if (choosedColor != null) {
            if (checkPointIsInMatrix(p)) {
                if (dotBrush) {
                    paintDot(p);
                }
                if (rectangleBrush) {
                    paintRectangle(p);
                }
                if (rollBrush) {
                    paintDot(p);
                }
            }
        } else {
            if ((dotBrush || rectangleBrush || rollBrush)) {
                JOptionPane.showMessageDialog(null, "Wybierz kolor");
            }
        }
    }

    /**
     * Sprawdza czy punkt kliknięty w macierzy nie przekracza zakresu macierzy
     *
     * @param p Punkt kliknięcia w macierzy
     * @return true - jeśli punkt mieści się w macierzy, false w przeciwnym
     * wypadku
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

    private void paintDot(Point p) {
        
        core.VisualizationGUI.matrix.put(p.y, p.x, choosedColor);
        core.VisualizationGUI.visualizationGUI.contentPane.repaint();
    }

    /**
     * Rysuje kwadrat o wielkości 6x6 w piejscu kursora
     * @param p point where mouse is 
     */
    private void paintRectangle(Point p) {
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
        core.VisualizationGUI.visualizationGUI.contentPane.repaint();
    }

    public void paintRoll(Point p) {
          

        double rollStartX;
        double rollStartY;
        double rollEndX;
        double rollEndY;

              
        rollStartX = rollStart.x;
        if (rollStartX < 0) {
            rollStartX = 0;
        }

        rollEndX = rollEnd.x;
        if (rollEndX >= core.VisualizationGUI.matrix.getWidth()) {
            rollEndX = core.VisualizationGUI.matrix.getWidth() - 1;
        }

        rollStartY = rollStart.y;
        if (rollStartY < 0) {
            rollStartY = 0;
        }

        rollEndY = rollEnd.y;
        if (rollEndY >= core.VisualizationGUI.matrix.getHeight()) {
            rollEndY = core.VisualizationGUI.matrix.getHeight() - 1;
        }

              for (int i = rollStart.y; i < rollEnd.y; i++) {
                  for (int j = rollStart.x; j < rollEnd.x; j++) {
                      paintRoll(rollStart); 
                  }
              }
        
        core.VisualizationGUI.visualizationGUI.contentPane.repaint();

    }

    public static Short getChoosedColor() {
        return choosedColor;
    }

    public boolean isDotBrush() {
        return dotBrush;
    }

    public boolean isRectangleBrush() {
        return rectangleBrush;
    }

    public boolean isRollBrush() {
        return rollBrush;
    }
}
