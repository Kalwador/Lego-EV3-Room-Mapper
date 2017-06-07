package utils;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Kalvador
 */
public class Coursor {

    public static int coursorShiftHeight = -107;
    public static int coursorShiftWidth = -100;

    public static int pointerShiftHeight = -107;
    public static int pointerShiftWidth = -100;

    public static boolean isPointerOn = false;

    private static String coursorPath = "toolbarButtonGraphics/coursor.data";

    /**
     *
     * @param contentPane
     */
    public void setUpCoursor(window.ContentPane contentPane) {
        loadData();
        if (isPointerOn) {
            setCoursorImage(contentPane);
        }
    }

    /**
     * Set up pointer coursor in content pane
     *
     * @param contentPane
     */
    private void setCoursorImage(window.ContentPane contentPane) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        File file = new File("toolbarButtonGraphics/cursor.png");

        //if file exist
        if (file.exists()) {
            Image image = toolkit.getImage(file.getAbsolutePath());

            //position based on coursor settings in system
            Cursor c = toolkit.createCustomCursor(image,
                    new Point(
                            toolkit.getBestCursorSize(0, 0).width - 1,
                            toolkit.getBestCursorSize(0, 0).height - 1),
                    "img");

            //setting up coursor
            contentPane.setCursor(c);
        }
    }

    /**
     * Set up default coursor
     *
     * @param contentPane
     */
    private void setDefaultCoursorImage(window.ContentPane contentPane) {
        Cursor defCoursor = new Cursor(Cursor.DEFAULT_CURSOR);
        contentPane.setCursor(defCoursor);
    }

    /**
     *
     */
    public void newCoursorSettingsWindow() {
        JFrame newFrame = new JFrame("Coursor Settings");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        //######################################
        JPanel panelLabel = new JPanel();
        panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.PAGE_AXIS));
        JLabel label1;
        if (isPointerOn) {
            label1 = new JLabel("Set shift of pointer");
        } else {
            label1 = new JLabel("Set shift of coursor");
        }
        panelLabel.setMinimumSize(new Dimension(190, 190));

        panelLabel.add(new JToolBar.Separator(new Dimension(20, 20)));
        panelLabel.add(label1);
        panelLabel.add(new JToolBar.Separator(new Dimension(20, 20)));
        //######################################
        JPanel panelData = new JPanel();
        panelData.setLayout(new BoxLayout(panelData, BoxLayout.PAGE_AXIS));

        JPanel panelData1 = new JPanel();
        panelData1.setLayout(new FlowLayout());

        JLabel labelData1 = new JLabel("Width:  ");

        JSpinner widthData;
        if (isPointerOn) {
            widthData = new JSpinner(new SpinnerNumberModel(pointerShiftWidth, -500, 500, 1));
        } else {
            widthData = new JSpinner(new SpinnerNumberModel(coursorShiftWidth, -500, 500, 1));
        }

        JLabel labelUnit1 = new JLabel("[px]");

        panelData1.add(labelData1);
        panelData1.add(widthData);
        panelData1.add(labelUnit1);

        JPanel panelData2 = new JPanel();
        panelData2.setLayout(new FlowLayout());

        JLabel labelData2 = new JLabel("Height:  ");

        JSpinner heightData;

        if (isPointerOn) {
            heightData = new JSpinner(new SpinnerNumberModel(pointerShiftHeight, -500, 500, 1));
        } else {
            heightData = new JSpinner(new SpinnerNumberModel(coursorShiftHeight, -500, 500, 1));
        }
        JLabel labelUnit2 = new JLabel("[px]");

        panelData2.add(labelData2);
        panelData2.add(heightData);
        panelData2.add(labelUnit2);

        panelData.add(panelData1);
        panelData.add(panelData2);

        //######################################
        JPanel panelBox = new JPanel();
        panelBox.setLayout(new FlowLayout());

        JLabel labelBox = new JLabel("Pointer");
        JCheckBox pointerBox = new JCheckBox();
        if (isPointerOn) {
            pointerBox.setSelected(true);
        } else {
            pointerBox.setSelected(false);
        }

        panelBox.add(new JToolBar.Separator(new Dimension(20, 20)));
        panelBox.add(labelBox);
        panelBox.add(pointerBox);
        panelBox.add(new JToolBar.Separator(new Dimension(20, 20)));
        //######################################

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());

        JButton buttonOK = new JButton();
        buttonOK.setText("OK");
        buttonOK.addActionListener(e -> {
            try {
                if (isPointerOn) {
                    pointerShiftHeight = (int) heightData.getValue();
                    pointerShiftWidth = (int) widthData.getValue();
                } else {
                    coursorShiftHeight = (int) heightData.getValue();
                    coursorShiftWidth = (int) widthData.getValue();
                }
                
                //if ther is change
                if (pointerBox.isSelected() != isPointerOn) {
                    if (pointerBox.isSelected()) {
                        System.out.println("zminiam na pointer");
                        isPointerOn = true;
                        setCoursorImage(core.VisualizationGUI.visualizationGUI.contentPane);

                    } else {
                        System.out.println("zmieniam na kursor");
                        isPointerOn = false;
                        setDefaultCoursorImage(core.VisualizationGUI.visualizationGUI.contentPane);
                    }
                }

                //saving data to file
                saveData();

                JOptionPane.showMessageDialog(null,
                        "Settings are saved");

                newFrame.dispose();
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
        panel.add(panelBox);
        panel.add(panelButtons);

        newFrame.add(panel);
        newFrame.setSize(300, 300);
        newFrame.setLocationRelativeTo(null);
        newFrame.setResizable(false);
        newFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        newFrame.setVisible(true);
    }

    /**
     * Load data of previus setting about coursor shift
     *
     * @return matrix
     */
    private void loadData() {
        File data = new File(coursorPath);
        if (data.exists()) {
            try {
                FileReader file = new FileReader(data);
                BufferedReader bufor = new BufferedReader(file);
                String linia = bufor.readLine();
                String[] pola = linia.split(";");
                coursorShiftHeight = Integer.valueOf(pola[0]);
                coursorShiftWidth = Integer.valueOf(pola[1]);

                if (pola[2].equals("true")) {
                    isPointerOn = true;
                } else {
                    isPointerOn = false;
                }

                pointerShiftHeight = Integer.valueOf(pola[3]);
                pointerShiftWidth = Integer.valueOf(pola[4]);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "ERROR DURING COURSOR DATA REDER");
            }
        }
    }

    private void saveData() {
        PrintWriter save = null;
        try {
            save = new PrintWriter(new File(coursorPath));

            //coursor shift data
            String data = coursorShiftHeight + ";" + coursorShiftWidth + ";";

            //is pointer on/off
            if (isPointerOn) {
                data += "true";
            } else {
                data += "false";
            }

            //pointer shift data
            data += ";" + pointerShiftHeight + ";" + pointerShiftWidth;

            save.write(data);
            save.close();
        } catch (FileNotFoundException e1) {
        } catch (ArrayIndexOutOfBoundsException e2) {
        } finally {
            save.close();
        }
    }
}
