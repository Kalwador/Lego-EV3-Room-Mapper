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
    JMenuItem paste;
    JMenuItem cut;
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

            JFileChooser fc = new JFileChooser();

            if (fc.showOpenDialog(root) == JFileChooser.APPROVE_OPTION) {

                try {
                    //nie rozumiem dlaczego nie chce działać- nie wywala błędu
                    core.VisualizationGUI.path = fc.getSelectedFile().toString();
                    matrix = utils.TXTMatrixLoader.loadData(core.VisualizationGUI.path);
                    //contentPane.repaint();
                    //contentPane.updateContentPane();
                    core.VisualizationGUI.visualizationGUI.contentPane.repaint();

                    core.VisualizationGUI.visualizationGUI.scroll.repaint();
                    JOptionPane.showMessageDialog(null, "File selected. " + core.VisualizationGUI.path);

                } catch (Exception r) {
                    JOptionPane.showMessageDialog(null, r + " " + core.VisualizationGUI.path);
                }
            }

        });

        save = new JMenuItem("Save");
        menuFirst.add(save);

        //Saving files
        save.addActionListener((e) -> {

            File selectedFile = null;
            try {
                PrintWriter save = new PrintWriter(selectedFile);
                save.close();
            } catch (FileNotFoundException q) {
                JOptionPane.showMessageDialog(null, q);
            }
            JOptionPane.showMessageDialog(null, "File saved.");
        });

        // Saving as files
        saveAs = new JMenuItem("Save as");
        menuFirst.add(saveAs);
        saveAs.addActionListener((e) -> {

            JFileChooser fc = new JFileChooser();

            if (fc.showSaveDialog(root) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fc.getSelectedFile();
                try {
                    PrintWriter save = new PrintWriter(selectedFile);
                    save.close();
                } catch (FileNotFoundException q) {

                    JOptionPane.showMessageDialog(null, q);
                }
                JOptionPane.showMessageDialog(null, "File saved.");
            }
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

        paste = new JMenuItem("Paste");
        exportMenu.add(paste);
        paste.addActionListener((e) -> {

            //If paste...
        });

        cut = new JMenuItem("Cut");
        exportMenu.add(cut);
        cut.addActionListener((e) -> {

            //If cut...
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
