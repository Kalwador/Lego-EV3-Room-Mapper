package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import window.ContentPane;
import window.Rule;
import matrix.Matrix;
import utils.Brush;

/**
 * Class contain Frame and hadle his actions
 *
 * @author Kalwador
 * @author Wilk
 * @since 02.04.2017
 */
public class VisualizationGUI extends JFrame implements MouseListener, MouseMotionListener {

    /**
     * Size of visualization window
     */
    public static int windowPreferedWidth = 1200;
    public static int windowPreferedHeight = 700;

    /**
     * Default dimension of every rectangle in pixels
     */
    public static short RESOLUTION;

    public static window.ContentPane contentPane;

    /**
     * Matrix contains data from robot
     *
     * @see 0 - obszar pusty;
     * @see 1 - obszar zajety;
     * @see 2 - obszar nieznany;
     */
    public static Matrix<Short> matrix;

    /**
     * Main Frame, contains everything
     */
    public static JFrame frame;
    public static JScrollPane scroll;

    /**
     * Those variables contain actual mouse position in window. There are
     * actualized on 'click' action.
     */
    public static double mouseX;
    public static double mouseY;

    /**
     * Top bar, and side bar
     */
    private window.MenuBar menuBar;
    private window.ToolBar toolBar;

    /**
     * Rules outside the cavnas
     */
    private Rule columnView;
    private Rule rowView;
    public static String path;

    /**
     * Class that contains camera movement information for drawing
     */
    public static utils.Camera camera;

    /**
     * Brushes used to paint
     */
    private Brush brush;

    /**
     * Default Constructor set up main options
     */
    public VisualizationGUI() {

        /**
         * Default size and zoom of every rectangle
         */
        RESOLUTION = 10;

        path = "matrix.txt";
        matrix = utils.TXTMatrixLoader.loadData(path);
//        matrix = new Matrix<>(400, 400);

        camera = new utils.Camera(matrix.getWidth(), matrix.getHeight());

        contentPane = new ContentPane(matrix, camera);

        columnView = new Rule(Rule.HORIZONTAL, true);
        rowView = new Rule(Rule.VERTICAL, true);

        brush = new Brush();
    }

    /**
     * Main method that runs all program
     */
    public void run() {

        /**
         * Create Window
         */
        frame = new JFrame("Obstacle Visualization for EV3 Robot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Top Menu
         */
        menuBar = new window.MenuBar();
        frame.setJMenuBar(menuBar.getMenuBar(this.getRootPane()));

        toolBar = new window.ToolBar(brush);
        frame.add(toolBar.getToolBar(this.getRootPane()), BorderLayout.WEST);

        /**
         * Canvas
         */
        scroll = new JScrollPane(contentPane);
        scroll.setViewportBorder(
                BorderFactory.createLineBorder(Color.black));
        scroll.getVerticalScrollBar().setUnitIncrement(30); //Scroll speed
        scroll.addMouseListener(this); //Scroll Pane mouse Listener

        /**
         * Rules
         */
        columnView.setPreferredWidth(camera.contentPaneWidth);
        rowView.setPreferredHeight(camera.contentPaneHeight);

        scroll.setColumnHeaderView(columnView);
        scroll.setRowHeaderView(rowView);

        frame.add(scroll, BorderLayout.CENTER);

        /**
         * Display the window.
         */
        frame.pack();
        frame.setSize(windowPreferedWidth, windowPreferedHeight);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //współżedne końcowe
        mouseX = MouseInfo.getPointerInfo().getLocation().getX() - frame.getLocationOnScreen().x;
        mouseY = MouseInfo.getPointerInfo().getLocation().getY() - frame.getLocationOnScreen().y;

        /**
         * Some pixels from window border
         */
        mouseX -= 84;
        mouseY -= 89;

        System.out.println("mouse clicked");
        brush.paint((int) mouseX, (int) mouseY);
        VisualizationGUI.contentPane.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //współżedne końcowe
        mouseX = MouseInfo.getPointerInfo().getLocation().getX() - frame.getLocationOnScreen().x;
        mouseY = MouseInfo.getPointerInfo().getLocation().getY() - frame.getLocationOnScreen().y;

        /**
         * Some pixels from window border
         */
        mouseX -= 84;
        mouseY -= 89;

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        //współżedne końcowe
        mouseX = MouseInfo.getPointerInfo().getLocation().getX() - frame.getLocationOnScreen().x;
        mouseY = MouseInfo.getPointerInfo().getLocation().getY() - frame.getLocationOnScreen().y;

        /**
         * Some pixels from window border
         */
        mouseX -= 84;
        mouseY -= 89;
        VisualizationGUI.contentPane.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }
}
