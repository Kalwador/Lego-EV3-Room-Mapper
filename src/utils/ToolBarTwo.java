package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JToolBar;

public class ToolBarTwo {

    public static JToolBar toolBarTwo;

    JButton zoomIn;
    JButton zoomOut;
    JButton delete;
    JButton copy;
    JButton paste;
    JButton cut;
    JButton draw;

    public ToolBarTwo() {
    }

    public JToolBar getToolBarTwo(JRootPane root) {

        toolBarTwo = new JToolBar("Tools");

        try {
            BufferedImage buttonIcon1 = ImageIO.read(new File("toolbarButtonGraphics/general/ZoomIn16.gif"));
            zoomIn = new JButton(new ImageIcon(buttonIcon1));
        } catch (Exception io) {
            zoomIn.setText("ZoomIn");
            JOptionPane.showMessageDialog(null, io);
        }
        zoomIn.addActionListener((e) -> {

        });
        toolBarTwo.add(zoomIn);

        try {
            BufferedImage buttonIcon2 = ImageIO.read(new File("toolbarButtonGraphics/general/ZoomOut16.gif"));
            zoomOut = new JButton(new ImageIcon(buttonIcon2));
        } catch (Exception io) {
            zoomOut.setText("ZoomOut");
            JOptionPane.showMessageDialog(null, io);
        }
        zoomOut.addActionListener((e) -> {

        });
        toolBarTwo.add(zoomOut);

        try {
            BufferedImage buttonIcon3 = ImageIO.read(new File("toolbarButtonGraphics/general/Delete16.gif"));
            delete = new JButton(new ImageIcon(buttonIcon3));
        } catch (Exception io) {
            delete.setText("Delete");
            JOptionPane.showMessageDialog(null, io);
        }
        delete.addActionListener((e) -> {

        });
        toolBarTwo.add(delete);

        try {
            BufferedImage buttonIcon4 = ImageIO.read(new File("toolbarButtonGraphics/general/Copy16.gif"));
            copy = new JButton(new ImageIcon(buttonIcon4));
        } catch (Exception io) {
            copy.setText("Copy");
            JOptionPane.showMessageDialog(null, io);
        }
        copy.addActionListener((e) -> {

        });
        toolBarTwo.add(copy);

        try {
            BufferedImage buttonIcon5 = ImageIO.read(new File("toolbarButtonGraphics/general/Paste16.gif"));
            paste = new JButton(new ImageIcon(buttonIcon5));
        } catch (Exception io) {
            paste.setText("Paste");
            JOptionPane.showMessageDialog(null, io);
        }
        paste.addActionListener((e) -> {

        });
        toolBarTwo.add(paste);

        try {
            BufferedImage buttonIcon6 = ImageIO.read(new File("toolbarButtonGraphics/general/Cut16.gif"));
            cut = new JButton(new ImageIcon(buttonIcon6));
        } catch (Exception io) {
            cut.setText("Cut");
            JOptionPane.showMessageDialog(null, io);
        }
        cut.addActionListener((e) -> {

        });
        toolBarTwo.add(cut);

        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/general/Edit16.gif"));
            draw = new JButton(new ImageIcon(buttonIcon7));
        } catch (Exception io) {
            draw.setText("Draw");
            JOptionPane.showMessageDialog(null, io);
        }
        draw.addActionListener((e) -> {

        });
        toolBarTwo.add(draw);

        return toolBarTwo;
    }

}
