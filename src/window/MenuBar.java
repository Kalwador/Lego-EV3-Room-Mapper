package window;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author Kalvador
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

    public MenuBar() {
    }
    
    
    public JMenuBar getMenuBar(JRootPane root) {
        
        
        menuBar = new JMenuBar();

        menuFirst = new JMenu("File");
        menuBar.add(menuFirst);

        newFile = new JMenuItem("New");
        menuFirst.add(newFile);
        newFile.addActionListener((e) -> {
            //Creating new project
        });

        open = new JMenuItem("Open");
        menuFirst.add(open);
        open.addActionListener((e) -> {            
            
            JFileChooser fc = new JFileChooser();
            File selectedFile;

            if (fc.showOpenDialog(root) == JFileChooser.APPROVE_OPTION){

            try{   
                selectedFile = fc.getSelectedFile();
                JOptionPane.showMessageDialog(null, "File selected.");
                }catch(Exception r){
                    JOptionPane.showMessageDialog(null,r);
                   }
            }   
        
        });

        save = new JMenuItem("Save");
        menuFirst.add(save);
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

        
        // od tąd Twoja działka
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
        exit.addActionListener((e) -> {           
            root.setVisible(false);
            System.exit(0);
        });

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

        menuThird = new JMenu("Help");
        menuBar.add(menuThird);

        info = new JMenuItem("Info");
        menuThird.add(info);
        info.addActionListener((e)->{
            JOptionPane.showMessageDialog(null, "Information!");
        });

        return menuBar;
    }
}
