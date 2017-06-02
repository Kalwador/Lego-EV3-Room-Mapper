package window;

import core.VisualizationGUI;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import matrix.Matrix;
import utils.ExportAsImage;
import utils.MatrixData;

/**
 *
 * @author Kalwador
 * @author Wilk
 */
public class MenuBar {

    //Creating main menu
    public JMenuBar menuBar;

    //Creating menu options
    public JMenu menuFile;
    public JMenu exportMenu;
    public JMenu helpMenu;

    //Creating menu items
    public JMenuItem newFile;
    public JMenuItem open;
    public JMenuItem close;
    public JMenuItem save;
    public JMenuItem saveAs;
    public JMenuItem exit;
    public JMenuItem jpgExport;
    public JMenuItem pngExport;
    public JMenuItem bmpExport;
    public JMenuItem info;

    private utils.ExportAsImage exportAsImage;

    /**
     * Default constructor set up whole menu bar
     */
    public MenuBar() {
        exportAsImage = new ExportAsImage();
    }

    /**
     * Method that allows to get menu bar
     *
     * @param root
     * @return menuBar
     */
    public JMenuBar getMenuBar(JRootPane root) {

        // Create the menu bar       
        menuBar = new JMenuBar();

        // Create the menu first
        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        newFile = new JMenuItem("New");
        menuFile.add(newFile);

        //Creating new project
        newFile.addActionListener((e) -> {
            if (utils.Brush.isChanged) {
                saveFileBeforeClose();
                utils.Brush.isChanged = false;
            }
            utils.NewCanvas.newCanvasWindow();
        });

        open = new JMenuItem("Open");
        menuFile.add(open);

        //Opening file from files
        open.addActionListener((e) -> {

            if (utils.Brush.isChanged) {
                saveFileBeforeClose();
                utils.Brush.isChanged = false;
            }

            matrix.Matrix<Short> matrix = MatrixData.loadDataOnProgramStart();

            Optional<matrix.Matrix<Short>> optional = Optional.ofNullable(matrix);
            if (optional.isPresent()) {
                core.VisualizationGUI.matrix = matrix;
                core.VisualizationGUI.visualizationGUI.frame.dispose();
                core.VisualizationGUI.visualizationGUI = new VisualizationGUI();
                core.VisualizationGUI.isContentPaneEmpty = false;
                core.VisualizationGUI.visualizationGUI.run();
                core.VisualizationGUI.visualizationGUI.scroll.repaint();
                JOptionPane.showMessageDialog(null,
                        "Data was successfully reloaded.");
            }
        });

        close = new JMenuItem("Close");
        menuFile.add(close);

        //Opening file from files
        close.addActionListener((e) -> {

            if (utils.Brush.isChanged) {
                saveFileBeforeClose();
                utils.Brush.isChanged = false;
            }

            core.VisualizationGUI.path = "";
            core.VisualizationGUI.matrix = new Matrix<>();
            core.VisualizationGUI.visualizationGUI.frame.dispose();
            core.VisualizationGUI.visualizationGUI = new VisualizationGUI();
            core.VisualizationGUI.isContentPaneEmpty = true;
            core.VisualizationGUI.visualizationGUI.run();
        });

        save = new JMenuItem("Save");
        menuFile.add(save);

        //Saving files
        save.addActionListener((e) -> {
            PrintWriter save = null;
            if (!core.VisualizationGUI.path.equals("")) {
                try {
                    save = new PrintWriter(new File(core.VisualizationGUI.path));
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error occured during save data to file.");
                }
                save.write(utils.MatrixData.saveData());
                save.close();
                utils.Brush.isChanged = false;
                JOptionPane.showMessageDialog(null, "File saved.");
            } else {
                JOptionPane.showMessageDialog(null, "No specifed path \t\r\nPlease use option 'Save as'");
            }
        });

        // Saving as files
        saveAs = new JMenuItem("Save as");
        menuFile.add(saveAs);
        saveAs.addActionListener((e) -> {
            File fileToSave = null;
            JFileChooser fs = new JFileChooser();
            fs.setDialogTitle("Save File");
            fs.setFileFilter(new FileNameExtensionFilter("MATRIX File", "matrix"));
            int result = fs.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                if (!fs.getSelectedFile().toString().endsWith(".matrix")) {
                    fileToSave = new File(fs.getSelectedFile() + ".matrix");
                } else {
                    fileToSave = new File(fs.getSelectedFile().toString());
                }
                PrintWriter save = null;
                try {
                    save = new PrintWriter(fileToSave);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error occured during save data to file.");
                }
                save.println(utils.MatrixData.saveData());
                save.close();
                utils.Brush.isChanged = false;
                JOptionPane.showMessageDialog(null, "File saved.");
            }
        });

        exit = new JMenuItem("Exit");
        menuFile.add(exit);

        //Exit the program
        exit.addActionListener((e) -> {
            if (utils.Brush.isChanged) {
                saveFileBeforeClose();
                utils.Brush.isChanged = false;
            }
            VisualizationGUI.frame.dispatchEvent(new WindowEvent(VisualizationGUI.frame,
                    WindowEvent.WINDOW_CLOSING));
        });

        //Creating second menu
        exportMenu = new JMenu("Edit");
        menuBar.add(exportMenu);

        jpgExport = new JMenuItem("Export as JPG");
        exportMenu.add(jpgExport);
        jpgExport.addActionListener((e) -> {
            exportAsImage.JPG();
        });

        pngExport = new JMenuItem("Export as PNG");
        exportMenu.add(pngExport);
        pngExport.addActionListener((e) -> {
            exportAsImage.PNG();
        });

        bmpExport = new JMenuItem("Export as BMP");
        exportMenu.add(bmpExport);
        bmpExport.addActionListener((e) -> {
            exportAsImage.BMP();
        });

        //Creating third menu
        helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        info = new JMenuItem("Info");
        helpMenu.add(info);
        info.addActionListener((e) -> {
            //Displaying information
            JOptionPane.showMessageDialog(null,
                    "Program used to drawing obstacles for EV3 LEGO robot.\n"
                    + "Made by Piotr Szpila and Adrian Wilk.");
        });

        return menuBar;
    }

    public void turnOffSaveWhenNewFile() {
        save.setEnabled(false);
    }

    public void turnOnSave() {
        save.setEnabled(true);
    }

    public void turnOffUnactiveButtons() {
        close.setEnabled(false);
        save.setEnabled(false);
        saveAs.setEnabled(false);
        jpgExport.setEnabled(false);
        pngExport.setEnabled(false);
        bmpExport.setEnabled(false);
    }

    public void turnOnActiveButtons() {
        close.setEnabled(true);
        save.setEnabled(true);
        saveAs.setEnabled(true);
        jpgExport.setEnabled(true);
        pngExport.setEnabled(true);
        bmpExport.setEnabled(true);
    }

    public void saveFileBeforeClose() {

        int confirmed = JOptionPane.showConfirmDialog(null,
                "Do you want to save changes?", "Changes", JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {

            PrintWriter save = null;
            try {
                save = new PrintWriter(new File(core.VisualizationGUI.path));
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error occured during save data to file.");
            }
            save.write(utils.MatrixData.saveData());
            save.close();
        }
    }
}
