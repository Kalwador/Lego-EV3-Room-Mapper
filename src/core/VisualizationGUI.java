package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import matrix.Matrix;
import window.ContentPane;

/**
 * Class contain Frame and hadle his actions
 *
 * @author Kalvador
 * @author Wilk
 * @since 02.04.2017
 */
public class VisualizationGUI extends JFrame implements MouseListener {

    /**
     * Size of visualization window
     */
    public static int windowPreferedWidth = 800;
    public static int windowPreferedHeight = 600;

    /**
     * Default dimension of every rectangle in pixels
     */
    public static short RESOLUTION;

    private window.ContentPane contentPane;

    /**
     * Matrix contains data from robot 0 - 1 - 2 -
     */
    private Matrix<Short> matrix;

    JFrame frame;

    private window.MenuBar menuBar;
    private window.ToolBar toolBar;

    /**
     * Default Constructor set up main options
     */
    public VisualizationGUI() {

        /**
         * Default size and zoom of every rectangle
         */
        RESOLUTION = 10;

        matrix = new Matrix(100, 100);
        
        contentPane = new ContentPane(matrix);
    }

    /**
     * Main method that runs all program
     */
    public void run() {

        //Create and set up the window.
        frame = new JFrame("Obstacle Visualization for EV3 Robot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new window.MenuBar();
        frame.setJMenuBar(menuBar.getMenuBar(this.getRootPane()));

        frame.add("Center", contentPane);
        
        toolBar = new window.ToolBar();
        frame.add(toolBar.getToolBar(this.getRootPane()), BorderLayout.SOUTH);

        
//        stara metoda
//        frame.add("Center", new MyCanvas());


        frame.addMouseListener(this);
        //Display the window.
        frame.pack();
        frame.setSize(windowPreferedWidth, windowPreferedHeight);
        frame.setResizable(true);
        frame.setVisible(true);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        //obsługa klawiatury
//
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//
//    }
//    class MyCanvas extends Canvas {
//
//        @Override
//        public void paint(Graphics graphics) {
//            Graphics2D g = (Graphics2D) graphics;
//            grid.drawGrid(camera, g);
//            axis.drawAxis(camera, g);
//        }
//    }
    @Override
    public void mouseClicked(MouseEvent e) {
        double mouseX = MouseInfo.getPointerInfo().getLocation().getX() - frame.getLocationOnScreen().x;
        double mouseY = MouseInfo.getPointerInfo().getLocation().getY() - frame.getLocationOnScreen().y;

        System.out.println("x=" + mouseX + "   y=" + mouseY);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
