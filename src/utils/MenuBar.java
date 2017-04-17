package utils;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

    public MenuBar() {
    }
    
    
    public JMenuBar getMenuBar(JRootPane root) {
        menuBar = new JMenuBar();

        menuFirst = new JMenu("File");
        menuBar.add(menuFirst);

        newFile = new JMenuItem("New");
        menuFirst.add(newFile);
        newFile.addActionListener((e) -> {
            
        });

        open = new JMenuItem("Open");
        menuFirst.add(open);
//        open.addActionListener(this);

        save = new JMenuItem("Save");
        menuFirst.add(save);
//        save.addActionListener(this);

        
        // od tąd Twoja działka
        JMenuItem saveAs = new JMenuItem("Save as");
        menuFirst.add(saveAs);
//        saveAs.addActionListener(this);

        JMenuItem exit = new JMenuItem("Exit");
        menuFirst.add(exit);
        exit.addActionListener((e) -> {
            System.out.println("Siemanero");
            root.setVisible(false);
            System.exit(0);
        });

        menuSecond = new JMenu("Edit");
        menuBar.add(menuSecond);

        JMenuItem copy = new JMenuItem("Copy");
        menuSecond.add(copy);
//        copy.addActionListener(this);

        JMenuItem paste = new JMenuItem("Paste");
        menuSecond.add(paste);
//        paste.addActionListener(this);

        JMenuItem cut = new JMenuItem("Cut");
        menuSecond.add(cut);
//        cut.addActionListener(this);

        JMenuItem delete = new JMenuItem("Delete");
        menuSecond.add(delete);
//        delete.addActionListener(this);

        menuThird = new JMenu("Help");
        menuBar.add(menuThird);

        JMenuItem info = new JMenuItem("Info");
        menuThird.add(info);
//        info.addActionListener(this);

        return menuBar;
    }
}
