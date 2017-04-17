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

    private Matrix matrix;
//    private drawing.Axis axis;
    public static utils.Vector camera;
    private utils.MenuBar menuBar;

    public VisualizationGUI() {
        matrix = new Matrix(100, 100);
        camera = new utils.Vector(windowWidth, windowHeight);
        
        // Setting menu bar
        menuBar = new utils.MenuBar();
        setJMenuBar(menuBar.getMenuBar(this.rootPane));
        
        setResizable(true);       

        
    }
    File selectedFile;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("New")) {

            //If creating new file...
        } else if (e.getActionCommand().equals("Open")) {

            try {
                JFileChooser fc = new JFileChooser();
                if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fc.getSelectedFile();
                    JOptionPane.showMessageDialog(null, "File selected.");
                    //...
                }
            } catch (Exception r) {
                JOptionPane.showMessageDialog(null, r);
            }

        } else if (e.getActionCommand().equals("Save")) {

            try {
                PrintWriter save = new PrintWriter(selectedFile);
                save.close();
            } catch (FileNotFoundException q) {
                JOptionPane.showMessageDialog(null, q);
            }
            JOptionPane.showMessageDialog(null, "File saved.");

        } else if (e.getActionCommand().equals("Save as")) {

            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fc.getSelectedFile();
                try {
                    PrintWriter save = new PrintWriter(selectedFile);
                    save.close();
                } catch (FileNotFoundException q) {

                    JOptionPane.showMessageDialog(null, q);
                }
                JOptionPane.showMessageDialog(null, "File saved.");
            }

        } else if (e.getActionCommand().equals("Exit")) {

            this.setVisible(false);
            System.exit(0);

        } else if (e.getActionCommand().equals("Copy")) {

            //If copy...
        } else if (e.getActionCommand().equals("Paste")) {

            //If paste...
        } else if (e.getActionCommand().equals("Cut")) {

            //If cut...
        } else if (e.getActionCommand().equals("Delete")) {

            //If delete...
        } else if (e.getActionCommand().equals("Info")) {

            JOptionPane.showMessageDialog(null, "Information!");
        }

    }

    public void run() {
        add("Center", new MyCanvas());

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
