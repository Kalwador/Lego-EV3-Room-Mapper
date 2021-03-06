package window;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
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

    public static JToolBar toolBar;
    private Brush brush;

    //creating new buttons
    JToggleButton gridButton;
    
    JToggleButton drawWhite;
    JToggleButton drawRed;
    JToggleButton drawBlue;
    ButtonGroup buttonGroup;

    //creating new toggle buttons
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
        buttonGroup= new ButtonGroup();
        //Adding button to tool bar, which allows to draw in white color
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Edit24White.png"));
            drawWhite = new JToggleButton(new ImageIcon(buttonIcon7));
            drawWhite.addActionListener((e) -> {
                utils.Brush.choosedColor = 0;
            });
            toolBar.add(drawWhite);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }
        buttonGroup.add(drawWhite);
        //Adding button to tool bar, which allows to draw in RED color
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Edit24Red.png"));
            drawRed = new JToggleButton(new ImageIcon(buttonIcon7));
            drawRed.addActionListener((e) -> {
                utils.Brush.choosedColor = 1;
            });
            toolBar.add(drawRed);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }
        buttonGroup.add(drawRed);
        //Blue Color
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Edit24Blue.png"));
            drawBlue = new JToggleButton(new ImageIcon(buttonIcon7));
            drawBlue.addActionListener((e) -> {
                utils.Brush.choosedColor = 2;
            });
            toolBar.add(drawBlue);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }
        buttonGroup.add(drawBlue);
        // separator
        toolBar.add(new JToolBar.Separator(new Dimension(0, 20)));

        //Dot Brush
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Brush24.png"));
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

        //Roller
        try {
            BufferedImage buttonIcon8 = ImageIO.read(new File("toolbarButtonGraphics/Roller.png"));
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

        //separator
        toolBar.add(new JToolBar.Separator(new Dimension(0, 20)));

        //Adding button to tool bar, which allows to draw grid
        try {
            BufferedImage buttonIcon3 = ImageIO.read(new File("toolbarButtonGraphics/Grid24.gif"));
            gridButton = new JToggleButton(new ImageIcon(buttonIcon3));
            gridButton.addActionListener((e) -> {
                if (gridButton.isSelected()) {
                    window.ContentPane.isGrid = true;
                } else {
                    window.ContentPane.isGrid = false;
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
