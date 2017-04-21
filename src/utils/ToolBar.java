
package utils;

import javax.swing.JButton;
import javax.swing.JRootPane;
import javax.swing.JToolBar;


public class ToolBar {
    
static final private String PREVIOUS = "previous";
static final private String UP = "up";
static final private String NEXT = "next";
    
public static JToolBar toolBar;
    
    JButton previous;
    JButton up;
    JButton next;
    

    public ToolBar() {
//         super(new BorderLayout());
    }
    
    public JToolBar getToolBar(JRootPane root){
        
        toolBar= new JToolBar("TOOLS");       
        
        previous= new JButton("PREVIOUS");        
        previous.addActionListener((e)->{
                        
            String description = "taken you to the previous <something>.";
            displayResult("If this were a real app, it would have "
                + description);
            
        });
        toolBar.add(previous);
        
        up= new JButton("UP");
        up.addActionListener((e)->{
             
            String description = "taken you to the Up <something>.";
            displayResult("If this were a real app, it would have "
                + description);
            
        });
        toolBar.add(up);
        
        next= new JButton("NEXT");
        next.addActionListener((e)->{
            
            String description = "taken you to the Forward <something>.";
            displayResult("If this were a real app, it would have "
                + description);
            
        });
        toolBar.add(next);
        
        
        
        return toolBar;
    }
      protected void displayResult(String actionDescription) {
      core.VisualizationGUI.textArea.append(actionDescription + core.VisualizationGUI.newline);
      core.VisualizationGUI.textArea.setCaretPosition( core.VisualizationGUI.textArea.getDocument().getLength());
  }
    
    
    
}
