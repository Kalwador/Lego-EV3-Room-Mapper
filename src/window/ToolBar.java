package window;


import static core.VisualizationGUI.a;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;



import javax.swing.JToolBar;
import matrix.Matrix;


public class ToolBar{

    public static JToolBar toolBar;
    public Matrix<Short> matrix;


    JButton previous;
    JButton up;
    JButton down;
    JButton next;

    JButton zoomIn;
    JButton zoomOut;
    JButton gridButton;
    JButton copy;
    JButton paste;
    JButton cut;
    JButton drawWhite;
    JButton drawRed;
    JButton drawBlue;

    public ToolBar() {
    }

    public JToolBar getToolBar(JRootPane root) {

        toolBar = new JToolBar("Navigation", JToolBar.VERTICAL);

        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Edit24White.png"));
            drawWhite = new JButton(new ImageIcon(buttonIcon7));
            drawWhite.addActionListener((e) -> {
                a=0;
            });
            toolBar.add(drawWhite);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Edit24Red.png"));
            drawRed = new JButton(new ImageIcon(buttonIcon7));
            drawRed.addActionListener((e) -> {
                a=1;

            });
            toolBar.add(drawRed);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Edit24Blue.png"));
            drawBlue = new JButton(new ImageIcon(buttonIcon7));
            drawBlue.addActionListener((e) -> {

                a=2;
            });
            toolBar.add(drawBlue);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        toolBar.add(new JToolBar.Separator(new Dimension(0, 20)));

        try {
            BufferedImage buttonIcon1 = ImageIO.read(new File("toolbarButtonGraphics/ZoomIn24.gif"));
            zoomIn = new JButton(new ImageIcon(buttonIcon1));
            zoomIn.addActionListener((e) -> {
                utils.Camera.plusCameraZoom();

            });
            toolBar.add(zoomIn);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        try {
            BufferedImage buttonIcon2 = ImageIO.read(new File("toolbarButtonGraphics/ZoomOut24.gif"));
            zoomOut = new JButton(new ImageIcon(buttonIcon2));
            zoomOut.addActionListener((e) -> {
                utils.Camera.minusCameraZoom();
            });
            toolBar.add(zoomOut);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        try {
            BufferedImage buttonIcon3 = ImageIO.read(new File("toolbarButtonGraphics/Grid24.gif"));
            gridButton = new JButton(new ImageIcon(buttonIcon3));
            gridButton.addActionListener((e) -> {
                if(window.ContentPane.isGrid) window.ContentPane.isGrid = false;
                else window.ContentPane.isGrid = true;
                core.VisualizationGUI.contentPane.repaint();
            });
            toolBar.add(gridButton);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

//        try {
//            BufferedImage buttonIcon4 = ImageIO.read(new File("toolbarButtonGraphics/Copy24.gif"));
//            copy = new JButton(new ImageIcon(buttonIcon4));
//            copy.addActionListener((e) -> {
//
//            });
//            toolBar.add(copy);
//        } catch (Exception io) {
//            JOptionPane.showMessageDialog(null, io);
//        }
//
//        try {
//            BufferedImage buttonIcon5 = ImageIO.read(new File("toolbarButtonGraphics/Paste24.gif"));
//            paste = new JButton(new ImageIcon(buttonIcon5));
//            paste.addActionListener((e) -> {
//
//            });
//            toolBar.add(paste);
//        } catch (Exception io) {
//            JOptionPane.showMessageDialog(null, io);
//        }
//
//        try {
//            BufferedImage buttonIcon6 = ImageIO.read(new File("toolbarButtonGraphics/Cut24.gif"));
//            cut = new JButton(new ImageIcon(buttonIcon6));
//            cut.addActionListener((e) -> {
//
//            });
//            toolBar.add(cut);
//        } catch (Exception io) {
//            JOptionPane.showMessageDialog(null, io);
//        }

        return toolBar;
    }
}
