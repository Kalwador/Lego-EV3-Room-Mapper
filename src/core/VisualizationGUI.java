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
import utils.Coursor;

/**
 * Class contain Frame and hadle his actions
 *
 * @author Kalwador
 * @author Wilk
 * @since 02.04.2017
 */
public class VisualizationGUI extends JFrame implements MouseListener, MouseMotionListener {

    //Size of visualization window
    public int windowPreferedWidth = 800;
    public int windowPreferedHeight = 600;

    //Default dimension of every rectangle in pixels   
    public static short RESOLUTION = 10;

    //Main Frame, contains everything
    public static JFrame frame;

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
    public static Matrix<Short> matrix = utils.MatrixData.loadDataOnProgramStart();

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

    //Coursor used in Content Pane
    public utils.Coursor coursor;
    
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

        //Brushes on side 
        brush = new Brush();

        //Contains data of Content Pane
        camera = new utils.Camera();
        
        coursor = new utils.Coursor();

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

        // Top Menu
        menuBar = new window.MenuBar();
        frame.setJMenuBar(menuBar.getMenuBar(this.getRootPane()));

        // If there is no matrix loaded
        if (isContentPaneEmpty) {

            //turn off active buttons in menu bar
            menuBar.turnOffUnactiveButtons();

            //Defoault close operation
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Setting up Title of Wwndow
            frame.setTitle("Obstacle Visualization for EV3 Robot");

            //frame empty so is smaller
            frame.setSize(350, 350);
        } else {

            //active buttons in menu bar
            menuBar.turnOnActiveButtons();

            //Listener of exiting window, check if ther are unsaved
            //changes, if ther are he ask to save
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {
                    if (utils.Brush.isChanged) {
                        menuBar.saveFileBeforeClose();
                    }
                    System.exit(0);
                }
            });

            //Setting up window name
            String title = "Obstacle Visualization for EV3 Robot  - " + path;
            frame.setTitle(title);

            //Side Tool bar
            toolBar = new window.ToolBar(brush);
            frame.add(toolBar.getToolBar(this.getRootPane()), BorderLayout.WEST);

            //main canvas
            scroll = new JScrollPane(contentPane);
            scroll.setViewportBorder(
                    BorderFactory.createLineBorder(Color.black));

            //Scroll speed
            scroll.getVerticalScrollBar().setUnitIncrement(30);

            //Scroll Pane mouse Listener
            scroll.addMouseListener(this);
            
            //Setting up coursor graphic and settings
            coursor.setUpCoursor(contentPane);

            //New Rules
            columnView.setPreferredWidth(camera.contentPaneWidth);
            rowView.setPreferredHeight(camera.contentPaneHeight);

            //Adding Rules on side od ContentPane
            scroll.setColumnHeaderView(columnView);
            scroll.setRowHeaderView(rowView);

            //Scroll in to centoer of Frmae
            frame.add(scroll, BorderLayout.CENTER);

            //Window size
            frame.setSize(windowPreferedWidth, windowPreferedHeight);
        }

        //Display the window
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
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
     * Determines marked point in the matrix Gets Mouse position in COntent pane
     *
     * @return matrix point
     */
    private Point getMousePositionInContentPane() {

        PointerInfo pi = MouseInfo.getPointerInfo();

        //Mouse position in window - frame posiotion
        int x = (int) MouseInfo.getPointerInfo().getLocation().getX() - frame.getLocationOnScreen().x;
        int y = (int) MouseInfo.getPointerInfo().getLocation().getY() - frame.getLocationOnScreen().y;

        //Some pixels from window border
        x += utils.Coursor.WIDTH;
        y += utils.Coursor.HEIGHT;

        //Adding movement on scrolls
        x += scroll.getHorizontalScrollBar().getValue();
        y += scroll.getVerticalScrollBar().getValue();

        //Dividing by display resolution
        x /= RESOLUTION;
        y /= RESOLUTION;

        return new Point(x, y);
    }
}
