package window;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JToolBar;

public class ToolBar {

    public static JToolBar toolBar;

    JButton previous;
    JButton up;
    JButton down;
    JButton next;
    
    JButton zoomIn;
    JButton zoomOut;
    JButton delete;
    JButton copy;
    JButton paste;
    JButton cut;
    JButton draw;

    public ToolBar() {
    }

    public JToolBar getToolBar(JRootPane root) {

        toolBar = new JToolBar("Navigation");

        try {
            BufferedImage buttonIcon1 = ImageIO.read(new File("toolbarButtonGraphics/navigation/Back24.gif"));
            previous = new JButton(new ImageIcon(buttonIcon1));
        } catch (Exception io) {
            previous.setText("Previous");
            JOptionPane.showMessageDialog(null, io);
        }
        previous.addActionListener((e) -> {

        });
        toolBar.add(previous);

        try {
            BufferedImage buttonIcon2 = ImageIO.read(new File("toolbarButtonGraphics/navigation/Up24.gif"));
            up = new JButton(new ImageIcon(buttonIcon2));
        } catch (Exception io) {
            up.setText("Up");
            JOptionPane.showMessageDialog(null, io);
        }
        up.addActionListener((e) -> {

        });
        toolBar.add(up);

        try {
            BufferedImage buttonIcon3 = ImageIO.read(new File("toolbarButtonGraphics/navigation/Down24.gif"));
            down = new JButton(new ImageIcon(buttonIcon3));
        } catch (Exception io) {
            down.setText("Down");
            JOptionPane.showMessageDialog(null, io);
        }
        down.addActionListener((e) -> {

        });
        toolBar.add(down);

        try {
            BufferedImage buttonIcon4 = ImageIO.read(new File("toolbarButtonGraphics/navigation/Forward24.gif"));
            next = new JButton(new ImageIcon(buttonIcon4));
        } catch (Exception io) {
            next.setText("Next");
            JOptionPane.showMessageDialog(null, io);
        }
        next.addActionListener((e) -> {

        });
        toolBar.add(next);
        
         try {
            BufferedImage buttonIcon1 = ImageIO.read(new File("toolbarButtonGraphics/general/ZoomIn16.gif"));
            zoomIn = new JButton(new ImageIcon(buttonIcon1));
        } catch (Exception io) {
            zoomIn.setText("ZoomIn");
            JOptionPane.showMessageDialog(null, io);
        }
        zoomIn.addActionListener((e) -> {

        });
        toolBar.add(zoomIn);

        try {
            BufferedImage buttonIcon2 = ImageIO.read(new File("toolbarButtonGraphics/general/ZoomOut16.gif"));
            zoomOut = new JButton(new ImageIcon(buttonIcon2));
        } catch (Exception io) {
            zoomOut.setText("ZoomOut");
            JOptionPane.showMessageDialog(null, io);
        }
        zoomOut.addActionListener((e) -> {

        });
        toolBar.add(zoomOut);

        try {
            BufferedImage buttonIcon3 = ImageIO.read(new File("toolbarButtonGraphics/general/Delete16.gif"));
            delete = new JButton(new ImageIcon(buttonIcon3));
        } catch (Exception io) {
            delete.setText("Delete");
            JOptionPane.showMessageDialog(null, io);
        }
        delete.addActionListener((e) -> {

        });
        toolBar.add(delete);

        try {
            BufferedImage buttonIcon4 = ImageIO.read(new File("toolbarButtonGraphics/general/Copy16.gif"));
            copy = new JButton(new ImageIcon(buttonIcon4));
        } catch (Exception io) {
            copy.setText("Copy");
            JOptionPane.showMessageDialog(null, io);
        }
        copy.addActionListener((e) -> {

        });
        toolBar.add(copy);

        try {
            BufferedImage buttonIcon5 = ImageIO.read(new File("toolbarButtonGraphics/general/Paste16.gif"));
            paste = new JButton(new ImageIcon(buttonIcon5));
        } catch (Exception io) {
            paste.setText("Paste");
            JOptionPane.showMessageDialog(null, io);
        }
        paste.addActionListener((e) -> {

        });
        toolBar.add(paste);

        try {
            BufferedImage buttonIcon6 = ImageIO.read(new File("toolbarButtonGraphics/general/Cut16.gif"));
            cut = new JButton(new ImageIcon(buttonIcon6));
        } catch (Exception io) {
            cut.setText("Cut");
            JOptionPane.showMessageDialog(null, io);
        }
        cut.addActionListener((e) -> {

        });
        toolBar.add(cut);

        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/general/Edit16.gif"));
            draw = new JButton(new ImageIcon(buttonIcon7));
        } catch (Exception io) {
            draw.setText("Draw");
            JOptionPane.showMessageDialog(null, io);
        }
        draw.addActionListener((e) -> {

        });
        toolBar.add(draw);

        return toolBar;
    }
}
