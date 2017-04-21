package core;

//import drawing.Axis;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import matrix.Matrix;

/**
 *
 * @author Kalvador
 * @since 02.04.2017
 */
public class VisualizationGUI extends JFrame implements ActionListener {

    public static int windowWidth = 800;
    public static int windowHeight = 600;
    public static JTextArea textArea;
    public static JScrollPane scrollPane;
    public static String newline = "\n";
    

    private Matrix matrix;
//    private drawing.Axis axis;
    public static utils.Vector camera;
    private utils.MenuBar menuBar;
    private utils.ToolBar toolBar;
    private utils.ToolBarTwo toolBarTwo;


    public VisualizationGUI() {
        

        
        textArea = new JTextArea(5, 30);
        textArea.setEditable(true);
        
        scrollPane = new JScrollPane(textArea);
        
        //matrix = new Matrix(100, 100);
       // camera = new utils.Vector(windowWidth, windowHeight);
        
        // Setting menu bar
        menuBar = new utils.MenuBar();
        setJMenuBar(menuBar.getMenuBar(this.rootPane));
        
        toolBar= new utils.ToolBar();
        add(toolBar.getToolBar(this.rootPane), BorderLayout.WEST);
        add(scrollPane, BorderLayout.PAGE_END);
        
        toolBarTwo= new utils.ToolBarTwo();
        add(toolBarTwo.getToolBarTwo(this.rootPane), BorderLayout.EAST);
        add(scrollPane, BorderLayout.CENTER);
        
        
        setResizable(true);       

        
    }
  

    @Override
    public void actionPerformed(ActionEvent e) {
   
    }

    public void run() {
        //add("Center", new MyCanvas());

        //shapes[1] = new Rectangle2D.Double(10.0, 100.0, 200.0, 200.0);
//        axis = new Axis();
//        axis.updateAxis(camera);


        setSize(windowWidth, windowHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);      
    }


    class MyCanvas extends Canvas {

        @Override
        public void paint(Graphics graphics) {
            Graphics2D g = (Graphics2D) graphics;
//            axis.drawAxis(g);
        }
    }
}
