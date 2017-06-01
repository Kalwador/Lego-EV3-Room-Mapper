package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Optional;
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

    //Main Frame, contains everything
    public JFrame frame;

    //Scroll contains Content Pane
    public JScrollPane scroll;

    public static String path = "";

    /**
     * Matrix contains data from robot
     *
     * @see 0 - obszar pusty;
     * @see 1 - obszar zajety;
     * @see 2 - obszar nieznany;
     */
    public static Matrix<Short> matrix = utils.TXT.loadDataOnProgramStart();

    //Contains all graphic 
    public static boolean isContentPaneEmpty = false;
    public window.ContentPane contentPane;

    // Top bar, 
    public window.MenuBar menuBar;

    //Side bar
    private window.ToolBar toolBar;

    // Rules outside the cavnas
    private Rule columnView;
    private Rule rowView;

    //Class that contains camera movement information for drawing
    public utils.Camera camera;

    // Brushes used to paint
    private Brush brush;

    public static VisualizationGUI visualizationGUI;

    // Default Constructor set up main options
    public VisualizationGUI() {
        visualizationGUI = this;

        Optional<Matrix<Short>> optional = Optional.ofNullable(matrix);
        if (!optional.isPresent()) {
            matrix = new Matrix<>();
            isContentPaneEmpty = true;
        }

        //Default size and zoom of every rectangle         
        RESOLUTION = 10;

        brush = new Brush();

        camera = new utils.Camera();

        contentPane = new ContentPane(matrix, camera);

        columnView = new Rule(Rule.HORIZONTAL);
        rowView = new Rule(Rule.VERTICAL);

    }

    /**
     * Main method that runs all program
     */
    public void run() {
        // Create Window
        frame = new JFrame();

     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Top Menu
        menuBar = new window.MenuBar();
        frame.setJMenuBar(menuBar.getMenuBar(this.getRootPane()));

        // If there is no matrix loaded
        if (isContentPaneEmpty) {

            //turn off active buttons in menu bar
            menuBar.turnOffUnactiveButtons();

            frame.setTitle("Obstacle Visualization for EV3 Robot");
            //frame empty so is smaller
            frame.setSize(350, 350);
        } else {
            //active buttons in menu bar
//            menuBar.turnOnActiveButtons();

            //setting up window name
            String title = "Obstacle Visualization for EV3 Robot  - " + path;
            frame.setTitle(title);

            //Tool bar
            toolBar = new window.ToolBar(brush);
            frame.add(toolBar.getToolBar(this.getRootPane()), BorderLayout.WEST);

            //main canvas
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
            frame.setSize(windowPreferedWidth, windowPreferedHeight);
        }

        //Display the window
        frame.setResizable(true);
        frame.setVisible(true);
    }

    //When mouse is clicked draw a fiugre
    @Override
    public void mouseClicked(MouseEvent e) {
        brush.paint(getMousePositionInContentPane());
    }

    //When mouse is pressed draw a figure
    @Override
    public void mousePressed(MouseEvent e) {
        brush.paint(getMousePositionInContentPane());
        contentPane.repaint();
    }

    //When mouse is released draw a figure
    @Override
    public void mouseReleased(MouseEvent e) {
        brush.paint(getMousePositionInContentPane());
        contentPane.repaint();
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
     * determines marked point in the matrix
     *
     * @return matrix point
     */
    private Point getMousePositionInContentPane() {

        //coordinates
        int x = (int) MouseInfo.getPointerInfo().getLocation().getX() - frame.getLocationOnScreen().x;
        int y = (int) MouseInfo.getPointerInfo().getLocation().getY() - frame.getLocationOnScreen().y;

        //Some pixels from window border
        x -= 84;
        y -= 89;

        //Adding movement on scrolls
        x += scroll.getHorizontalScrollBar().getValue();
        y += scroll.getVerticalScrollBar().getValue();

        //Dividing by display resolution
        x /= RESOLUTION;
        y /= RESOLUTION;

        //return new Point(x, y);
        return new Point(y, x);
    }
}
