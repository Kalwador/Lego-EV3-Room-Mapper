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

        return toolBar;
    }

}
