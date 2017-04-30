package window;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Kalvador
 * @author Wilk
 */
public class ContentPane extends Canvas {

    private window.ToolBar toolBar;


    /**
     * Class that contains camera movement information for drawing
     */
    public static utils.Camera camera;

    private window.Axis axis;
    private window.Grid grid;

    public ContentPane(matrix.Matrix<Short> matrix) {
//
//        camera = new utils.Camera(matrix.getSize());
//
//        axis = new Axis();
//        axis.updateAxis(camera);
//
//        grid = new Grid();
//        grid.updateGrid(camera);
//
//        setLayout(new BorderLayout());
//
//        //Put it in this panel.
//        add("Center", new DrawingCanvas());
//        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

//    private class DrawingCanvas extends java.awt.Canvas {
//
//        @Override
//        public void print(Graphics graphics) {
//            Graphics2D g = (Graphics2D) graphics;
//            grid.drawGrid(camera, g);
//            axis.drawAxis(camera, g);
//        }
//    }
}
