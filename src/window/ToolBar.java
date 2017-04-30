package window;

import java.awt.Dimension;
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
    JButton drawWhite;
    JButton drawRed;
    JButton drawBlue;

    public ToolBar() {
    }

    public JToolBar getToolBar(JRootPane root) {

        toolBar = new JToolBar("Navigation", JToolBar.VERTICAL);

        try {
            BufferedImage buttonIcon1 = ImageIO.read(new File("toolbarButtonGraphics/navigation/Back24.gif"));
            previous = new JButton(new ImageIcon(buttonIcon1));
            previous.addActionListener((e) -> {

            });
            toolBar.add(previous);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        try {
            BufferedImage buttonIcon2 = ImageIO.read(new File("toolbarButtonGraphics/navigation/Up24.gif"));
            up = new JButton(new ImageIcon(buttonIcon2));
            up.addActionListener((e) -> {

            });
            toolBar.add(up);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        try {
            BufferedImage buttonIcon3 = ImageIO.read(new File("toolbarButtonGraphics/navigation/Down24.gif"));
            down = new JButton(new ImageIcon(buttonIcon3));
            down.addActionListener((e) -> {

            });
            toolBar.add(down);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        try {
            BufferedImage buttonIcon4 = ImageIO.read(new File("toolbarButtonGraphics/navigation/Forward24.gif"));
            next = new JButton(new ImageIcon(buttonIcon4));
            next.addActionListener((e) -> {

            });
            toolBar.add(next);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        toolBar.add(new JToolBar.Separator(new Dimension(0, 20)));

        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/general/Edit24White.png"));
            drawWhite = new JButton(new ImageIcon(buttonIcon7));
            drawWhite.addActionListener((e) -> {

            });
            toolBar.add(drawWhite);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/general/Edit24Red.png"));
            drawRed = new JButton(new ImageIcon(buttonIcon7));
            drawRed.addActionListener((e) -> {

            });
            toolBar.add(drawRed);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }
        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/general/Edit24Blue.png"));
            drawBlue = new JButton(new ImageIcon(buttonIcon7));
            drawBlue.addActionListener((e) -> {

            });
            toolBar.add(drawBlue);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        toolBar.add(new JToolBar.Separator(new Dimension(0, 20)));

        try {
            BufferedImage buttonIcon1 = ImageIO.read(new File("toolbarButtonGraphics/general/ZoomIn24.gif"));
            zoomIn = new JButton(new ImageIcon(buttonIcon1));
            zoomIn.addActionListener((e) -> {

            });
            toolBar.add(zoomIn);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        try {
            BufferedImage buttonIcon2 = ImageIO.read(new File("toolbarButtonGraphics/general/ZoomOut24.gif"));
            zoomOut = new JButton(new ImageIcon(buttonIcon2));
            zoomOut.addActionListener((e) -> {

            });
            toolBar.add(zoomOut);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        try {
            BufferedImage buttonIcon3 = ImageIO.read(new File("toolbarButtonGraphics/general/Delete24.gif"));
            delete = new JButton(new ImageIcon(buttonIcon3));
            delete.addActionListener((e) -> {

            });
            toolBar.add(delete);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        try {
            BufferedImage buttonIcon4 = ImageIO.read(new File("toolbarButtonGraphics/general/Copy24.gif"));
            copy = new JButton(new ImageIcon(buttonIcon4));
            copy.addActionListener((e) -> {

            });
            toolBar.add(copy);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        try {
            BufferedImage buttonIcon5 = ImageIO.read(new File("toolbarButtonGraphics/general/Paste24.gif"));
            paste = new JButton(new ImageIcon(buttonIcon5));
            paste.addActionListener((e) -> {

            });
            toolBar.add(paste);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        try {
            BufferedImage buttonIcon6 = ImageIO.read(new File("toolbarButtonGraphics/general/Cut24.gif"));
            cut = new JButton(new ImageIcon(buttonIcon6));
            cut.addActionListener((e) -> {

            });
            toolBar.add(cut);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        try {
            BufferedImage buttonIcon7 = ImageIO.read(new File("toolbarButtonGraphics/general/Edit24.gif"));
            drawWhite = new JButton(new ImageIcon(buttonIcon7));
            drawWhite.addActionListener((e) -> {

            });
            toolBar.add(drawWhite);
        } catch (Exception io) {
            JOptionPane.showMessageDialog(null, io);
        }

        return toolBar;
    }
}
