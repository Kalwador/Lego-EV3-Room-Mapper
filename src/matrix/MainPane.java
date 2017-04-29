package window;

import window.canvas.Corner;
import window.canvas.Rule;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import matrix.Matrix;
import window.canvas.Axis;
import window.canvas.Grid;
import window.canvas.ScrollablePane;
import static window.canvas.ScrollablePane.camera;

/**
 *
 * @author Kalvador
 * @author Wilk
 */
public class MainPane extends JPanel {
    
    
    class MyCanvas extends Canvas {

        @Override
        public void paint(Graphics graphics) {
            Graphics2D g = (Graphics2D) graphics;
            grid.drawGrid(camera, g);
            axis.drawAxis(camera, g);          
        }
    }

    private window.ToolBar toolBar;
    private window.ToolBarTwo toolBarTwo;

    private Rule columnView;
    private Rule rowView;

    public int width;
    public int height;

    private window.canvas.ScrollablePane scrollPane;

    /**
     * Class that contains camera movement information for drawing
     */
    public static utils.Camera camera;

    private window.canvas.Axis axis;
    private window.canvas.Grid grid;

    public MainPane(matrix.Matrix<Short> matrix) {

        camera = new utils.Camera(matrix.getSize());

        axis = new Axis();
        axis.updateAxis(camera);

        grid = new Grid();
        grid.updateGrid(camera);

        width = matrix.getWidth() * core.VisualizationGUI.RESOLUTION;
        height = matrix.getHeight() * core.VisualizationGUI.RESOLUTION;

        setLayout(new BorderLayout());

        toolBar = new window.ToolBar();
        add(toolBar.getToolBar(this.getRootPane()), BorderLayout.SOUTH);
        
        toolBarTwo = new window.ToolBarTwo();
        add(toolBarTwo.getToolBarTwo(this.getRootPane()), BorderLayout.NORTH);

        //Create the row and column headers.
        columnView = new Rule(Rule.HORIZONTAL);
        rowView = new Rule(Rule.VERTICAL);

        if (width > 320 && height > 480) {
            columnView.setPreferredWidth(width);
            rowView.setPreferredHeight(height);
        } else {
            columnView.setPreferredWidth(720);
            rowView.setPreferredHeight(980);
        }

        //Create the corners.
        JPanel buttonCorner = new JPanel(); //use FlowLayout

        //Set up the scroll pane.
//        ImageIcon image= new ImageIcon("C:/Users/adria/Desktop/flyingBee.jpg");
//        scrollPane = new ScrollablePane(columnView.getIncrement(),image);

        scrollPane = new ScrollablePane(columnView.getIncrement(),axis,grid,camera);
        JScrollPane canvas = new JScrollPane(scrollPane);
        canvas.setPreferredSize(new Dimension(300, 250));
        canvas.setViewportBorder(
                BorderFactory.createLineBorder(Color.black));

        canvas.setColumnHeaderView(columnView);
        canvas.setRowHeaderView(rowView);

        canvas.setCorner(JScrollPane.UPPER_LEFT_CORNER,
                buttonCorner);
        canvas.setCorner(JScrollPane.LOWER_LEFT_CORNER,
                new Corner());
        canvas.setCorner(JScrollPane.UPPER_RIGHT_CORNER,
                new Corner());

      //Put it in this panel.
       
        add(canvas);
        
        
        add("Center", new MyCanvas());
        
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
 
    }
}
