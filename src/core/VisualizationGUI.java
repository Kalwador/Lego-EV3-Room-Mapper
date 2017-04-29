package core;

import window.canvas.Axis;
import window.canvas.Grid;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import matrix.Matrix;
import window.MainPane;
import static window.MainPane.camera;

/**
 * Class contain Frame and hadle his actions
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
    public static short RESOLUTION;
    JButton button;

    /**
     * Matrix contains data from robot
     * 0 - 
     * 1 - 
     * 2 - 
     */
    private Matrix<Short> matrix;

    private window.MainPane mainPane;
    private window.MenuBar menuBar;
    private window.ToolBar toolBar;
    private window.ToolBarTwo toolBarTwo;
//       private window.canvas.Axis axis;
//    private window.canvas.Grid grid;



    /**
     * Default Constructor set up main options
     */
    public VisualizationGUI() {

        /**
         * Default size and zoom of every rectangle
         */
        RESOLUTION = 10;

        matrix = new Matrix(100, 100);
        
    }

    /**
     * Main method that runs all program
     */
    public void run() {

        //Create and set up the window.
        JFrame frame = new JFrame("Obstacle Visualization for EV3 Robot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new window.MenuBar();
        frame.setJMenuBar(menuBar.getMenuBar(this.getRootPane()));
        
         toolBar = new window.ToolBar();
        add(toolBar.getToolBar(this.getRootPane()), BorderLayout.SOUTH);
        
        toolBarTwo = new window.ToolBarTwo();
        add(toolBarTwo.getToolBarTwo(this.getRootPane()), BorderLayout.NORTH);

        //Create and set up the content pane.
        //JComponent newContentPane = new MainPane(matrix);
        JComponent newContentPane = new MainPane(matrix);
        newContentPane.setOpaque(true); //content panes must be opaque
       // frame.setContentPane(newContentPane);
        frame.add(newContentPane,BorderLayout.CENTER);
        
        newContentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouse) {
                System.out.println(mouse.getX() + "   " + mouse.getY());
            }
        });
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);

//        stara metoda
//        frame.add("Center", new MyCanvas());

        //Display the window.
        frame.setSize(windowWidth, windowHeight);
        frame.setResizable(true);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //obsługa klawiatury
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

//    class MyCanvas extends Canvas {
//
//        @Override
//        public void paint(Graphics graphics) {
//            Graphics2D g = (Graphics2D) graphics;
//            grid.drawGrid(camera, g);
//            axis.drawAxis(camera, g);
//        }
//    }
}
