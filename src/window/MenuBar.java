package window;

import core.VisualizationGUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import matrix.Matrix;
import utils.ExportAsImage;
import utils.TXT;

/**
 *
 * @author Kalwador
 * @author Wilk
 */
public class MenuBar {

    //Creating main menu
    JMenuBar menuBar;

    //Creating menu options
    JMenu menuFile;
    JMenu exportMenu;
    JMenu helpMenu;

    //Creating menu items
    JMenuItem newFile;
    JMenuItem open;
    JMenuItem save;
    JMenuItem saveAs;
    JMenuItem exit;
    JMenuItem jpgExport;
    JMenuItem pngExport;
    JMenuItem bmpExport;
    JMenuItem screenShoot;
    JMenuItem info;

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
            utils.NewCanvas.newCanvasWindow();
        });

        open = new JMenuItem("Open");
        menuFile.add(open);

        //Opening file from files
        open.addActionListener((e) -> {

            JFileChooser jfc = new JFileChooser();
            jfc.setDialogTitle("Open Data");
            jfc.setCurrentDirectory(FileSystemView.getFileSystemView().getHomeDirectory());
            jfc.setFileFilter(new FileNameExtensionFilter("TXT DATA", "txt"));

            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                // TUTAJ ZMIEN TYTUL OKNA NA: "Obstacle Visualization for EV3 Robot - " + selectedFile.getAbsolutePath().toString()
                core.VisualizationGUI.path = selectedFile.getAbsolutePath();
                core.VisualizationGUI.matrix = TXT.reloadData();
                core.VisualizationGUI.visualizationGUI.frame.dispose();
                core.VisualizationGUI.visualizationGUI = new VisualizationGUI();
                core.VisualizationGUI.visualizationGUI.run();
                core.VisualizationGUI.visualizationGUI.scroll.repaint();
            }
            JOptionPane.showMessageDialog(null,
                    "Data was successfully reloaded.");
        });

        save = new JMenuItem("Save");
        menuFile.add(save);

        //Saving files
        save.addActionListener((e) -> {
            PrintWriter save = null;
            try {
                save = new PrintWriter(new File(core.VisualizationGUI.path));
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error occured during save data to file.");
            }
            save.write(utils.TXT.saveData());
            save.close();
//            JOptionPane.showMessageDialog(null, "File saved.");
        });

        // Saving as files
        saveAs = new JMenuItem("Save as");
        menuFile.add(saveAs);
        saveAs.addActionListener((e) -> {
            File fileToSave = null;
            JFileChooser fs = new JFileChooser();
            fs.setDialogTitle("Save File");
            fs.setFileFilter(new FileNameExtensionFilter("TXT File", "txt"));
            int result = fs.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                fileToSave = new File(fs.getSelectedFile() + ".txt");
            }

            PrintWriter save = null;
            try {
                save = new PrintWriter(fileToSave);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error occured during save data to file.");
            }
            save.println(utils.TXT.saveData());
            save.close();
//            JOptionPane.showMessageDialog(null, "File saved.");
        });

        exit = new JMenuItem("Exit");
        menuFile.add(exit);

        //Exit the program
        exit.addActionListener((e) -> {
            root.setVisible(false);
            System.exit(0);
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
}
