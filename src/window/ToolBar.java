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
    JToggleButton dotBrush;
    JToggleButton rectangleBrush;
    JToggleButton rollBrush;

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

        //Blue Color
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

          //Roller
        try {
            BufferedImage buttonIcon8 = ImageIO.read(new File("toolbarButtonGraphics/Brush24.png"));
            rollBrush = new JToggleButton(new ImageIcon(buttonIcon8));
            rollBrush.addActionListener((e) -> {
                if (brush.isRollBrush()) {
                    rollBrush.setSelected(false);
                    brush.setNoBrush();
                } else {
                    brush.setRollBrush();
                    dotBrush.setSelected(false);
                    rectangleBrush.setSelected(false);
                    rollBrush.setSelected(true);
                }
            });
            toolBar.add(rollBrush);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }
        
        //Dot Brush
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Dot24.png"));
            dotBrush = new JToggleButton(new ImageIcon(buttonIcon7));
            dotBrush.addActionListener((e) -> {
                if (brush.isDotBrush()) {
                    dotBrush.setSelected(false);
                    brush.setNoBrush();
                } else {
                    brush.setDotBrush();
                    dotBrush.setSelected(true);
                    rectangleBrush.setSelected(false);
                    rollBrush.setSelected(false);
                }
            });
            toolBar.add(dotBrush);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        //Rectangle
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Square24.png"));
            rectangleBrush = new JToggleButton(new ImageIcon(buttonIcon7));
            rectangleBrush.addActionListener((e) -> {
                if (brush.isRectangleBrush()) {
                    rectangleBrush.setSelected(false);
                    brush.setNoBrush();
                } else {
                    brush.setRectangleBrush();
                    dotBrush.setSelected(false);
                    rectangleBrush.setSelected(true);
                    rollBrush.setSelected(false);
                }
            });
            toolBar.add(rectangleBrush);
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
//                utils.Camera.plusCameraZoom();
                
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
//                utils.Camera.minusCameraZoom();
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
                core.VisualizationGUI.visualizationGUI.contentPane.repaint();
            });
            toolBar.add(gridButton);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }
        toolBar.setFloatable(false);
        return toolBar;
    }
}
