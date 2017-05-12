package utils;

import static core.VisualizationGUI.choosedColor;
import java.awt.MouseInfo;


public class Brushes {
    
//    private  double xStart;
//    private  double yStart;
//    private  double xEnd;
//    private  double yEnd;
//    
//    public void paintSquare(Double x, Double y, Object object){
//        
//       x =  MouseInfo.getPointerInfo().getLocation().getX() - core.VisualizationGUI.frame.getLocationOnScreen().x;
//       y =  MouseInfo.getPointerInfo().getLocation().getY() - core.VisualizationGUI.frame.getLocationOnScreen().y;
//            
//        core.VisualizationGUI.mouseX -= 84;
//        core.VisualizationGUI. mouseY -= 89;
//
//        xStart = x-3;
//        if(xStart < 0){
//        xStart = 0;
//        } 
//
//        xEnd =  x+3;
//        if(xEnd >  core.VisualizationGUI.matrix.getWidth()){
//        xEnd =  core.VisualizationGUI.matrix.getWidth();
//        }
//
//        yStart = y-3;
//        if(yStart < 0){
//        yStart = 0;
//        } 
//
//        yEnd = y+3;
//        if(yEnd > core.VisualizationGUI.matrix.getHeight()){
//        yEnd = core.VisualizationGUI.matrix.getHeight();
//        }
//
//        for(int i = (int) xStart; i <= xEnd; i++){
//                for(int j = (int) yStart; j <= yEnd; j++){
//                        core.VisualizationGUI.matrix.putObject(i,j,core.VisualizationGUI.choosedColor);
//        }
//                core.VisualizationGUI.scroll.repaint();
//        }
//
//    }
//    
//    public static void paintBrush(){
//        
//    }
//    
//    public static void paintDot(){
//        
//    }
  public static void paintDot(){

           
        core.VisualizationGUI.mouseX =  MouseInfo.getPointerInfo().getLocation().getX() - core.VisualizationGUI.frame.getLocationOnScreen().x;
        core.VisualizationGUI.mouseY =  MouseInfo.getPointerInfo().getLocation().getY() - core.VisualizationGUI.frame.getLocationOnScreen().y;
            
//        core.VisualizationGUI.mouseX -= 84;
//        core.VisualizationGUI. mouseY -= 89;
//        

            
        core.VisualizationGUI.matrix.putObject(
                    ((int) ((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)),
                    ((int) ((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)),
                    choosedColor);  
        core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+1)),
                    choosedColor);  
        core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)-1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)-1)),
                    choosedColor);  
        core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10))),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+1)),
                    choosedColor);  
        core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10))),
                    choosedColor);  
        core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)-1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10))),
                    choosedColor);  
        core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10))),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)-1)),
                    choosedColor);            
        core.VisualizationGUI. matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+1)),
                    choosedColor);  
        core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)-1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+1)),
                    choosedColor);  
        core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)-1)),
                    choosedColor);
        core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+2)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10))),
                    choosedColor); 
        core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10))),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+2)),
                    choosedColor); 
        core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)-2)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10))),
                    choosedColor); 
        core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10))),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)-2)),
                    choosedColor); 
    }
    public static void paintSquare(){
        
        core.VisualizationGUI.mouseX =  MouseInfo.getPointerInfo().getLocation().getX() - core.VisualizationGUI.frame.getLocationOnScreen().x;
        core.VisualizationGUI.mouseY =  MouseInfo.getPointerInfo().getLocation().getY() - core.VisualizationGUI.frame.getLocationOnScreen().y;
            
//        core.VisualizationGUI.mouseX -= 84;
//        core.VisualizationGUI. mouseY -= 89;
        
            core.VisualizationGUI.matrix.putObject(
                    ((int) ((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)),
                    ((int) ((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)),
                    choosedColor);  
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+1)),
                    choosedColor);  
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)-1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)-1)),
                    choosedColor);  
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10))),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+1)),
                    choosedColor);  
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10))),
                    choosedColor);  
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)-1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10))),
                    choosedColor);  
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10))),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)-1)),
                    choosedColor);            
            core.VisualizationGUI. matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+1)),
                    choosedColor);  
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)-1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+1)),
                    choosedColor);  
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)-1)),
                    choosedColor);
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+2)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10))),
                    choosedColor); 
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10))),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+2)),
                    choosedColor); 
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)-2)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10))),
                    choosedColor); 
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10))),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)-2)),
                    choosedColor); 
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)-2)),
                    choosedColor);
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)-1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)-2)),
                    choosedColor);
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)-2)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)-2)),
                    choosedColor);
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)-2)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)-1)),
                    choosedColor);
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+2)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)-2)),
                    choosedColor);
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+2)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)-1)),
                    choosedColor);
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10))),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)-2)),
                    choosedColor);
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)-2)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+1)),
                    choosedColor);
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+2)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+1)),
                    choosedColor);
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+2)),
                    choosedColor);
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)+2)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+2)),
                    choosedColor);
                        core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)-1)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+2)),
                    choosedColor);
            core.VisualizationGUI.matrix.putObject(
                    ((int) (((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)-2)),
                    ((int) (((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)+2)),
                    choosedColor);
        
    }
    
    public static void paintBrush(){
        core.VisualizationGUI.mouseX =  MouseInfo.getPointerInfo().getLocation().getX() - core.VisualizationGUI.frame.getLocationOnScreen().x;
        core.VisualizationGUI.mouseY =  MouseInfo.getPointerInfo().getLocation().getY() - core.VisualizationGUI.frame.getLocationOnScreen().y;
                
//        core.VisualizationGUI.mouseX -= 84;
//        core.VisualizationGUI. mouseY -= 89;
                
        core.VisualizationGUI.matrix.putObject( 
                    ((int) ((core.VisualizationGUI.mouseY + core.VisualizationGUI.scroll.getVerticalScrollBar().getValue())/ 10)),
                    ((int) ((core.VisualizationGUI.mouseX + core.VisualizationGUI.scroll.getHorizontalScrollBar().getValue())/ 10)),
                    choosedColor);   
        
    }
}

   