package window;

import static core.VisualizationGUI.matrix;
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
import utils.ExportAsImage;

/**
 *
 * @author Kalwador
 * @author Wilk
 */
public class MenuBar {

    JMenuBar menuBar;

    JMenu menuFirst;
    JMenu exportMenu;
    JMenu menuThird;

    JMenuItem newFile;
    JMenuItem open;
    JMenuItem save;
    JMenuItem saveAs;
    JMenuItem exit;
    JMenuItem jpgExport;
    JMenuItem pngExport;
    JMenuItem bmpExport;
    JMenuItem delete;
    JMenuItem info;

    private utils.ExportAsImage exportAsImage;

//    public  Matrix<Short> matrix;
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
        menuFirst = new JMenu("File");
        menuBar.add(menuFirst);

        newFile = new JMenuItem("New");
        menuFirst.add(newFile);

        //Creating new project
        newFile.addActionListener((e) -> {
        });

        open = new JMenuItem("Open");
        menuFirst.add(open);

        //Opening file from files
        open.addActionListener((e) -> {

            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = jfc.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                core.VisualizationGUI.path = selectedFile.getAbsolutePath();
                utils.TXT.loadData();

                //odświerzenie całego okna
            }
        });

        save = new JMenuItem("Save");
        menuFirst.add(save);

        //Saving files
        save.addActionListener((e) -> {
            PrintWriter save = null;
            try {
                save = new PrintWriter(new File(core.VisualizationGUI.path));
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error occured during save data to file");
            }
            save.write(utils.TXT.saveData());
            save.close();
            JOptionPane.showMessageDialog(null, "File saved.");
        });

        // Saving as files
        saveAs = new JMenuItem("Save as");
        menuFirst.add(saveAs);
        saveAs.addActionListener((e) -> {
            File fileToSave = null;
            JFileChooser fs = new JFileChooser();
            fs.setDialogTitle("Save File");

            fs.setFileFilter(new FileNameExtensionFilter("TXT File", "txt"));
            int result = fs.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                fileToSave = fs.getSelectedFile();
            }

            PrintWriter save = null;
            try {
                save = new PrintWriter(fileToSave);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error occured during save data to file");
            }
            save.println(utils.TXT.saveData());
            save.close();
            JOptionPane.showMessageDialog(null, "File saved.");
        });

        exit = new JMenuItem("Exit");
        menuFirst.add(exit);

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

        delete = new JMenuItem("Delete");
        exportMenu.add(delete);
        delete.addActionListener((e) -> {

            //If delete...
        });

        //Creating third menu
        menuThird = new JMenu("Help");
        menuBar.add(menuThird);

        info = new JMenuItem("Info");
        menuThird.add(info);
        info.addActionListener((e) -> {

            //Displaying information
            JOptionPane.showMessageDialog(null,
                    "Program used to drawing obstacles for EV3 LEGO robot.\n"
                    + "Made by Piotr Szpila and Adrian Wilk.");
        });

        return menuBar;
    }
}
