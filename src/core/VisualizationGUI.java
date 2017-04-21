package core;

import window.Axis;
import window.Grid;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import matrix.Matrix;

/**
 * Object of this clas contains method 'run'
 *
 * @author Kalvador
 * @author Wilk
 * @since 02.04.2017
 */
public class VisualizationGUI extends JFrame implements ActionListener {

    /**
     * Size of visualization window
     */
    public static int windowWidth = 800;
    public static int windowHeight = 600;

    /**
     * Default dimension of every rectangle in pixels
     */
    public static short resoulution;

    private Matrix matrix;
    private window.Axis axis;
    private window.Grid grid ;
    public static utils.Camera camera;

    private window.MenuBar menuBar;
    private window.ToolBar toolBar;
    private window.ToolBarTwo toolBarTwo;

    public VisualizationGUI() {
        /**
         * Default size and zoom of every rectangle
         */
        resoulution = 10;

        matrix = new Matrix(100, 100);
        camera = new utils.Camera(matrix.getSize());

        // Setting menu bar
        menuBar = new window.MenuBar();
        setJMenuBar(menuBar.getMenuBar(this.rootPane));

        toolBar = new window.ToolBar();
        add(toolBar.getToolBar(this.rootPane), BorderLayout.PAGE_END);

        toolBarTwo = new window.ToolBarTwo();
        add(toolBarTwo.getToolBarTwo(this.rootPane), BorderLayout.NORTH);

        setResizable(true);
        setTitle("Obstacle Visualization for EV3 Robot");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //obsługa klawiatóry
    }

    public void run() {
        add("Center", new MyCanvas());

        //shapes[1] = new Rectangle2D.Double(10.0, 100.0, 200.0, 200.0);
        axis = new Axis();
        axis.updateAxis(camera);
        
        grid = new Grid();
        grid.updateGrid(camera);
        
        setSize(windowWidth, windowHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    class MyCanvas extends Canvas {

        @Override
        public void paint(Graphics graphics) {
            Graphics2D g = (Graphics2D) graphics;
            grid.drawGrid(camera, g);
            axis.drawAxis(camera, g);
        }
    }
}
