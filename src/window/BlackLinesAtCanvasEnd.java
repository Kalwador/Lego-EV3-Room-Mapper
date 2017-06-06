/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * Black lines at the ofas of opened canvas
 * Helps see end of the canvas
 * 
 * @author Kalvador
 */
public class BlackLinesAtCanvasEnd {

    //SIze of line
    public static int borderThickness = 3;
    Rectangle2D horizontalLine;
    Rectangle2D verticalLine;

    public BlackLinesAtCanvasEnd() {
        
        //Two lines
        this.horizontalLine = new Rectangle2D.Double();
        this.verticalLine = new Rectangle2D.Double();
        updateLines();
    }

    public void updateLines() {

        //Calculate start and end point of the lines
        horizontalLine = new Rectangle2D.Double(
                0,
                core.VisualizationGUI.matrix.getHeight() * core.VisualizationGUI.RESOLUTION,
                core.VisualizationGUI.matrix.getWidth() * core.VisualizationGUI.RESOLUTION + borderThickness,
                borderThickness);

        verticalLine = new Rectangle2D.Double(
                core.VisualizationGUI.matrix.getWidth() * core.VisualizationGUI.RESOLUTION,
                0,
                borderThickness,
                core.VisualizationGUI.matrix.getHeight() * core.VisualizationGUI.RESOLUTION +borderThickness);
    }

    /**
     * Drawing lines on the screen
     *
     * @param g
     */
    public void drawLines(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fill(horizontalLine);
        g.fill(verticalLine);
    }
}
