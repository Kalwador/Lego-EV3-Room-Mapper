package window;

import static core.VisualizationGUI.path;
import static core.VisualizationGUI.matrix;
import static core.VisualizationGUI.contentPane;
import static core.VisualizationGUI.scroll;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import matrix.Matrix;




/**
 *
 * @author Kalwador
 * @author Wilk
 */
public class MenuBar {
    
    
    JMenuBar menuBar;
    
    JMenu menuFirst;
    JMenu menuSecond;
    JMenu menuThird;
    
    JMenuItem newFile;
    JMenuItem open;
    JMenuItem save;
    JMenuItem saveAs;
    JMenuItem exit;
    JMenuItem copy;
    JMenuItem paste;
    JMenuItem cut;
    JMenuItem delete;
    JMenuItem info;
    

//    public  Matrix<Short> matrix;
    /**
     * Default constructor set up whole menu bar
     */
    public MenuBar() {
    }
    
    /**
     * Method that allows to get menu bar
     * @param root
     * @return  menuBar
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
        newFile.addActionListener((e) -> { });

        open = new JMenuItem("Open");
        menuFirst.add(open);
        
        //Opening file from files
        open.addActionListener((e) -> {            
                      
            JFileChooser fc = new JFileChooser();
            

            if (fc.showOpenDialog(root) == JFileChooser.APPROVE_OPTION){

            try{   
                //nie rozumiem dlaczego nie chce działać- nie wywala błędu
                path = fc.getSelectedFile().toString();               
                matrix=utils.TXTMatrixLoader.loadData(path);                              
                //contentPane.repaint();
                //contentPane.updateContentPane();
                 core.VisualizationGUI.contentPane.repaint();

                scroll.repaint();
                JOptionPane.showMessageDialog(null, "File selected. "+path);
                
                }catch(Exception r){
                    JOptionPane.showMessageDialog(null,r+" "+path);
                   }
            }   
        
        });

        save = new JMenuItem("Save");
        menuFirst.add(save);
        
        //Saving files
        save.addActionListener((e)->{
        
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
        saveAs.addActionListener((e)->{
            
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
        menuSecond = new JMenu("Edit");
        menuBar.add(menuSecond);

        copy = new JMenuItem("Copy");
        menuSecond.add(copy);
        copy.addActionListener((e)->{
            
            //If copy...
        });

        paste = new JMenuItem("Paste");
        menuSecond.add(paste);
        paste.addActionListener((e)->{
        
            //If paste...
        });

        cut = new JMenuItem("Cut");
        menuSecond.add(cut);
        cut.addActionListener((e)->{
        
            //If cut...
        });

        delete = new JMenuItem("Delete");
        menuSecond.add(delete);
        delete.addActionListener((e)->{
        
            //If delete...
        });

        //Creating third menu
        menuThird = new JMenu("Help");
        menuBar.add(menuThird);

        info = new JMenuItem("Info");
        menuThird.add(info);
        info.addActionListener((e)->{
            
            //Displaying information
            JOptionPane.showMessageDialog(null, 
                    "Program used to drawing obstacles for EV3 LEGO robot.\n"
                    + "Made by Piotr Szpila and Adrian Wilk.");
        });

        return menuBar;
    }
}
