package core;

import drawing.Axis;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import matrix.Matrix;

/**
 *
 * @author Kalvador
 * @since 02.04.2017
 */
public class VisualizationGUI extends JFrame {

    public static int windowWidth = 800;
    public static int windowHeight = 600;
    
    private Matrix matrix;
    private drawing.Axis axis;
    public static utils.Vector camera;

    public VisualizationGUI() {
        matrix = new Matrix(100, 100);
        camera = new utils.Vector(windowWidth, windowHeight);
    }

    public void run() {
        add("Center", new MyCanvas());
        
        //shapes[1] = new Rectangle2D.Double(10.0, 100.0, 200.0, 200.0);
        axis = new Axis();
        axis.updateAxis(camera);
        
        setSize(windowWidth,windowHeight);
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
