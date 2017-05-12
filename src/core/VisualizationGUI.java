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

    //Size of visualization window
    public int windowPreferedWidth = 1200;
    public int windowPreferedHeight = 700;

    //Default dimension of every rectangle in pixels
    public static short RESOLUTION;

    /**
     * Matrix contains data from robot
     *
     * @see 0 - obszar pusty;
     * @see 1 - obszar zajety;
     * @see 2 - obszar nieznany;
     */
    public static Matrix<Short> matrix;

    //Main Frame, contains everything
    public JFrame frame;

    //Scroll contains Content Pane
    public JScrollPane scroll;

    //Contains all graphic 
    public window.ContentPane contentPane;

    // Top bar, 
    private window.MenuBar menuBar;

    //Side bar
    private window.ToolBar toolBar;

    // Rules outside the cavnas
    private Rule columnView;
    private Rule rowView;

    //Class that contains camera movement information for drawing
    public static utils.Camera camera;

    // Brushes used to paint
    private Brush brush;

    public static String path = "matrix.txt";

    public static VisualizationGUI visualizationGUI;

    // Default Constructor set up main options
    public VisualizationGUI() {
        visualizationGUI = this;

        //Default size and zoom of every rectangle         
        RESOLUTION = 10;

        matrix = utils.TXT.loadData();

        brush = new Brush();

        camera = new utils.Camera(matrix.getWidth(), matrix.getHeight());

        contentPane = new ContentPane(matrix, camera);

        columnView = new Rule(Rule.HORIZONTAL, true);
        rowView = new Rule(Rule.VERTICAL, true);
    }

    /**
     * Main method that runs all program
     */
    public void run() {

        // Create Window
        frame = new JFrame("Obstacle Visualization for EV3 Robot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Top Menu
        menuBar = new window.MenuBar();
        frame.setJMenuBar(menuBar.getMenuBar(this.getRootPane()));

        toolBar = new window.ToolBar(brush);
        frame.add(toolBar.getToolBar(this.getRootPane()), BorderLayout.WEST);

        // Canvas
        scroll = new JScrollPane(contentPane);
        scroll.setViewportBorder(
                BorderFactory.createLineBorder(Color.black));
        scroll.getVerticalScrollBar().setUnitIncrement(30); //Scroll speed
        scroll.addMouseListener(this); //Scroll Pane mouse Listener

        // Rules
        columnView.setPreferredWidth(camera.contentPaneWidth);
        rowView.setPreferredHeight(camera.contentPaneHeight);

        scroll.setColumnHeaderView(columnView);
        scroll.setRowHeaderView(rowView);

        frame.add(scroll, BorderLayout.CENTER);

        //Display the window
        frame.pack();
        frame.setSize(windowPreferedWidth, windowPreferedHeight);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        brush.paint(getMousePositionInContentPane());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Pressed będzie Ci potrzebny do Rollera da Ci punkt rozpoczącia
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        contentPane.repaint();
        //Released da Ci punkt końca do rollera
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

    /**
     * Wyznacza punkt który odpowiada zaznaczonemu miejscu w macierzy
     *
     * @return punkt w macierzy
     */
    private Point getMousePositionInContentPane() {

        //współżędne na ekranie
        int x = (int) MouseInfo.getPointerInfo().getLocation().getX() - frame.getLocationOnScreen().x;
        int y = (int) MouseInfo.getPointerInfo().getLocation().getY() - frame.getLocationOnScreen().y;

        //Some pixels from window border
        x -= 84;
        y -= 89;

        //Dodanie przesunięcia na scrollach
        x += scroll.getHorizontalScrollBar().getValue();
        y += scroll.getVerticalScrollBar().getValue();

        //Podzielenie przez rozdzielczość wyświetlania
        x /= RESOLUTION;
        y /= RESOLUTION;

        return new Point(x, y);
    }
}
