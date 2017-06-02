package utils;

import core.VisualizationGUI;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import matrix.Matrix;

/**
 *
 * @author Kalvador
 */
public class NewCanvas {

    public static int HEIGHT = 0;
    public static int WIDTH = 0;

    public static void newCanvasWindow() {
        JFrame newFrame = new JFrame("New Canvas");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        //######################################
        JPanel panelLabel = new JPanel();
        panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.PAGE_AXIS));

        JLabel label1 = new JLabel("Set size of new Canvas");
        JLabel label2 = new JLabel("        1 [dm] = 10 [cm]");
        panelLabel.setMinimumSize(new Dimension(190, 190));

        panelLabel.add(new JToolBar.Separator(new Dimension(20, 20)));
        panelLabel.add(label1);
        panelLabel.add(label2);
        panelLabel.add(new JToolBar.Separator(new Dimension(20, 20)));
        //######################################
        JPanel panelData = new JPanel();
        panelData.setLayout(new BoxLayout(panelData, BoxLayout.PAGE_AXIS));

        JPanel panelData1 = new JPanel();
        panelData1.setLayout(new FlowLayout());

        JLabel labelData1 = new JLabel("Width:  ");
        TextField textData1 = new TextField("10");
        JLabel labelUnit1 = new JLabel("[dm]");

        panelData1.add(labelData1);
        panelData1.add(textData1);
        panelData1.add(labelUnit1);

        JPanel panelData2 = new JPanel();
        panelData2.setLayout(new FlowLayout());

        JLabel labelData2 = new JLabel("Height:  ");
        TextField textData2 = new TextField("10");
        JLabel labelUnit2 = new JLabel("[dm]");

        panelData2.add(labelData2);
        panelData2.add(textData2);
        panelData2.add(labelUnit2);

        panelData.add(panelData1);
        panelData.add(panelData2);

        //######################################
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());

        JButton buttonOK = new JButton();
        buttonOK.setText("OK");
        buttonOK.addActionListener(e -> {
            try {
                HEIGHT = Integer.parseInt(textData2.getText());
                WIDTH = Integer.parseInt(textData1.getText());

                core.VisualizationGUI.matrix = new Matrix<Short>(HEIGHT, WIDTH);
                core.VisualizationGUI.matrix.fillMatrixWithZero();
                core.VisualizationGUI.visualizationGUI.frame.dispose();
                core.VisualizationGUI.visualizationGUI = new VisualizationGUI();
                core.VisualizationGUI.isContentPaneEmpty = false;
                core.VisualizationGUI.path = "";
                core.VisualizationGUI.visualizationGUI.run();
                core.VisualizationGUI.visualizationGUI.scroll.repaint();
                newFrame.dispose();
                JOptionPane.showMessageDialog(null,
                        "New canvas was successfully created.");
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(null, "WRONG SIZE NUMBER FORMAT");
            }
        });

        JButton buttonCancel = new JButton();
        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(e -> {
            newFrame.dispose();
        });

        panelButtons.add(buttonOK);
        panelButtons.add(buttonCancel);

        //######################################
        panel.add(panelLabel);
        panel.add(panelData);
        panel.add(panelButtons);

        newFrame.add(panel);
        newFrame.setSize(300, 300);
        newFrame.setLocationRelativeTo(null);
        newFrame.setResizable(false);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setVisible(true);
    }
}
