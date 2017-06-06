package window;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Kalvador
 * @author Wilk
 */
public class ContentPane extends JPanel {

    //Obstacles, their posionion and wrawing them
    public window.Obstacles obstacles;
    
    //Grid on the screen
    private window.Grid grid;
    
    //Two black lines on the end of showed matrix
    private BlackLinesAtCanvasEnd blackLinesAtCanvasEnd;
    
    //predicate controls showing grid on screen
    public static boolean isGrid = false;


    public ContentPane(matrix.Matrix<Short> matrix, utils.Camera camera) {

        blackLinesAtCanvasEnd = new BlackLinesAtCanvasEnd();
        obstacles = new Obstacles();
        grid = new Grid(matrix);

        // setup size of scrolledPane to size of matrix 
        // multiplied by dimension of every rectangle
        setPreferredSize(new Dimension(camera.contentPaneWidth,camera.contentPaneHeight));
        setOpaque(true); // minimalize panel to minimal size
    }

    @Override
    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);

        Graphics2D g = (Graphics2D) graphics;

        //drawng obstacles
        obstacles.drawOBstacles(g);

        
        //drawing grid if is turned ON
        if (window.ContentPane.isGrid) {
            grid.drawGrid(g);
        }
        
        //drawng two thick black lines
        blackLinesAtCanvasEnd.drawLines(g);
    }
}
