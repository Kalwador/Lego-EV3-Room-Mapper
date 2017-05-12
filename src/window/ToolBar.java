package window;

import static core.VisualizationGUI.choosedColor;
import static core.VisualizationGUI.frame;
import static core.VisualizationGUI.mouseX;
import static core.VisualizationGUI.mouseY;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import matrix.RectangleMatrix;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import utils.Brushes;


/**
 * @author Kalvador
 * @author Wilk
 */

public class ToolBar{
    
    public static JToolBar toolBar;

    JButton zoomIn;
    JButton zoomOut;
    JButton gridButton;
    JButton drawWhite;
    JButton drawRed;
    JButton drawBlue;
    JToggleButton dot;
    JToggleButton square;
    JToggleButton brush;
//    JButton copy;
//    JButton paste;
//    JButton cut;

    /**
     * Default constructor set up whole tool bar
     */
    public ToolBar() {
    }
    /**
     * Method that allows to get tool bar
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
            drawWhite.addActionListener((e) -> {choosedColor=0; });
            toolBar.add(drawWhite);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }
        
        //Adding button to tool bar, which allows to draw in red color
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Edit24Red.png"));
            drawRed = new JButton(new ImageIcon(buttonIcon7));
            drawRed.addActionListener((e) -> { choosedColor=1; });
            toolBar.add(drawRed);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }
        
        //Adding button to tool bar, which allows to draw in blue color
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Edit24Blue.png"));
            drawBlue = new JButton(new ImageIcon(buttonIcon7));
            drawBlue.addActionListener((e) -> { choosedColor=2;});
            toolBar.add(drawBlue);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        try {
            BufferedImage buttonIcon8 = ImageIO.read(new File("toolbarButtonGraphics/Brush24.png"));
            brush = new JToggleButton(new ImageIcon(buttonIcon8));
            brush.addActionListener((e) -> { 
           
                 try{
                utils.Brushes.paintBrush();
                }catch(Exception ie){
                     JOptionPane.showMessageDialog(null, ie+". Paint Brush.");
                }
                

    

            });
            toolBar.add(brush);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }
        
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Dot24.png"));
            dot = new JToggleButton(new ImageIcon(buttonIcon7));
            dot.addActionListener((e) -> { 
           
                try{
                utils.Brushes.paintDot();
                }catch(Exception ie){
                     JOptionPane.showMessageDialog(null, ie+". Paint Dot.");
                }
                
                
                });
            toolBar.add(dot);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }
        
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/Square24.png"));
            square = new JToggleButton(new ImageIcon(buttonIcon7));
            square.addActionListener((e) -> {
                
                  try{
                      utils.Brushes.paintSquare();
//                 paintSquare(core.VisualizationGUI.mouseX,core.VisualizationGUI. mouseY,choosedColor);
                }catch(Exception ie){
                     JOptionPane.showMessageDialog(null, ie+". Paint Square.");
                }

                
                });
            toolBar.add(square);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }
        
        //Adding tool bar separator
        toolBar.add(new JToolBar.Separator(new Dimension(0, 20)));

        //Adding button to tool bar, which allows to zoom in
        try {
            BufferedImage buttonIcon1 = ImageIO.read(new File("toolbarButtonGraphics/ZoomIn24.gif"));
            zoomIn = new JButton(new ImageIcon(buttonIcon1));
            zoomIn.addActionListener((e) -> { utils.Camera.plusCameraZoom(); });
            toolBar.add(zoomIn);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        //Adding button to tool bar, which allows to zoom out
        try {
            BufferedImage buttonIcon2 = ImageIO.read(new File("toolbarButtonGraphics/ZoomOut24.gif"));
            zoomOut = new JButton(new ImageIcon(buttonIcon2));
            zoomOut.addActionListener((e) -> { utils.Camera.minusCameraZoom(); });
            toolBar.add(zoomOut);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        //Adding button to tool bar, which allows to draw grid
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
