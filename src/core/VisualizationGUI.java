package core;

import drawing.Axis;
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
    private drawing.Axis axis;
    public static utils.Camera camera;

    private utils.MenuBar menuBar;
    private utils.ToolBar toolBar;
    private utils.ToolBarTwo toolBarTwo;

    public VisualizationGUI() {
        /**
         * Default size and zoom of every rectangle
         */
        resoulution = 10;

        matrix = new Matrix(100, 100);
        camera = new utils.Camera(matrix.getSize());

        // Setting menu bar
        menuBar = new utils.MenuBar();
        setJMenuBar(menuBar.getMenuBar(this.rootPane));

        toolBar = new utils.ToolBar();
        add(toolBar.getToolBar(this.rootPane), BorderLayout.NORTH);

        toolBarTwo = new utils.ToolBarTwo();
        add(toolBarTwo.getToolBarTwo(this.rootPane), BorderLayout.EAST);

        setResizable(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void run() {
        add("Center", new MyCanvas());

        //shapes[1] = new Rectangle2D.Double(10.0, 100.0, 200.0, 200.0);
        axis = new Axis();
        axis.updateAxis(camera);

        setSize(windowWidth, windowHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    class MyCanvas extends Canvas {

        @Override
        public void paint(Graphics graphics) {
            Graphics2D g = (Graphics2D) graphics;
            axis.drawAxis(g);
        }
    }
}
