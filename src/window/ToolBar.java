package window;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import utils.Brush;

/**
 * @author Kalvador
 * @author Wilk
 */
public class ToolBar {

    public static JToolBar toolBar; //PO CO STATYCZNY TOOLBAR PRZYJŻEĆ SIĘ TEMU!!!
    private Brush brush;

    JButton zoomIn;
    JButton zoomOut;
    JButton gridButton;
    JButton drawWhite;
    JButton drawRed;
    JButton drawBlue;
    JToggleButton dot;
    JToggleButton square;
    JToggleButton brushRectangle;

    /**
     * Default constructor set up whole tool bar
     */
    public ToolBar(Brush brush) {
        this.brush = brush;
    }

    /**
     * Method that allows to get tool bar
     *
     * @param root
     * @return toolBar
     */
    public JToolBar getToolBar(JRootPane root) {

        //Creating tool bar      
        toolBar = new JToolBar("Navigation", JToolBar.VERTICAL);

        //Adding button to tool bar, which allows to draw in white color
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Edit24White.png"));
            drawWhite = new JButton(new ImageIcon(buttonIcon7));
            drawWhite.addActionListener((e) -> {
                utils.Brush.choosedColor = 0;
            });
            toolBar.add(drawWhite);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        //Adding button to tool bar, which allows to draw in RED color
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Edit24Red.png"));
            drawRed = new JButton(new ImageIcon(buttonIcon7));
            drawRed.addActionListener((e) -> {
                utils.Brush.choosedColor = 1;
            });
            toolBar.add(drawRed);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        //Adding button to tool bar, which allows to draw in BLUE color
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Edit24Blue.png"));
            drawBlue = new JButton(new ImageIcon(buttonIcon7));
            drawBlue.addActionListener((e) -> {
                utils.Brush.choosedColor = 2;
            });
            toolBar.add(drawBlue);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        // separator
        toolBar.add(new JToolBar.Separator(new Dimension(0, 20)));

        //Pierwszy pędzel to okrąg
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Dot24.png"));
            dot = new JToggleButton(new ImageIcon(buttonIcon7));
            dot.addActionListener((e) -> {
                brush.setDotBrush();
            });
            toolBar.add(dot);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        //Drugi pędzel to kwadrat
        try {
            BufferedImage buttonIcon8 = ImageIO.read(new File("toolbarButtonGraphics/Brush24.png"));
            brushRectangle = new JToggleButton(new ImageIcon(buttonIcon8));
            brushRectangle.addActionListener((e) -> {
                brush.setRectangleBrush();
            });
            toolBar.add(brushRectangle);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        //Trzeci pędzel to roller
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Square24.png"));
            square = new JToggleButton(new ImageIcon(buttonIcon7));
            square.addActionListener((e) -> {
                brush.setRollBrush();
            });
            toolBar.add(square);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        //separator
        toolBar.add(new JToolBar.Separator(new Dimension(0, 20)));

        //Adding button to tool bar, which allows to zoom in
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

        //Adding button to tool bar, which allows to zoom out
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

        //Adding button to tool bar, which allows to draw grid
        try {
            BufferedImage buttonIcon3 = ImageIO.read(new File("toolbarButtonGraphics/Grid24.gif"));
            gridButton = new JButton(new ImageIcon(buttonIcon3));
            gridButton.addActionListener((e) -> {
                if (window.ContentPane.isGrid) {
                    window.ContentPane.isGrid = false;
                } else {
                    window.ContentPane.isGrid = true;
                }
                core.VisualizationGUI.contentPane.repaint();
            });
            toolBar.add(gridButton);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }
        return toolBar;
    }
}
