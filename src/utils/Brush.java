package utils;

public class Brush {

    public static Short choosedColor;

    public boolean dotBrush = false;
    public boolean rectangleBrush = false;
    public boolean rollBrush = false;

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
//    public static void paint(){
//        
//    }
//    
//    public static void paintDot(){
//        
//    }
    /**
     * Paint Selected shape
     *
     * @param x xMouse Position
     * @param y yMouse Position
     */
    public void paint(int x, int y) {
        if (dotBrush) {
            paintDot(x, y);
        }
        if (rectangleBrush) {
            paintRectangle(x, y);
        }
        if (rollBrush) {
            paintDot(x, y);
        }
    }

    //set up brush to dot brush
    public void setDotBrush() {
        rectangleBrush = false;
        rollBrush = false;
        if (dotBrush) {
            dotBrush = false;
        } else {
            dotBrush = true;
        }
    }

    //set up brush to rectangle brush
    public void setRectangleBrush() {
        dotBrush = false;
        rollBrush = false;
        System.out.println("ustawiam rectangle brush");
        if (rectangleBrush) {
            rectangleBrush = false;
        } else {
            rectangleBrush = true;
        }
    }

    //set up brush to big rectangle brush
    public void setRollBrush() {
        dotBrush = false;
        rectangleBrush = false;
        if (rollBrush) {
            rollBrush = false;
        } else {
            rollBrush = true;
        }
    }

    private void paintDot(int x, int y) {

    }

    private void paintRectangle(int x, int y) {
        System.out.println("wykonuje paint Rectangle");
        double xStart;
        double yStart;
        double xEnd;
        double yEnd;

        xStart = x - 3;
        if (xStart < 0) {
            xStart = 0;
        }

        xEnd = x + 3;
        if (xEnd > core.VisualizationGUI.matrix.getWidth()) {
            xEnd = core.VisualizationGUI.matrix.getWidth();
        }

        yStart = y - 3;
        if (yStart < 0) {
            yStart = 0;
        }

        yEnd = y + 3;
        if (yEnd > core.VisualizationGUI.matrix.getHeight()) {
            yEnd = core.VisualizationGUI.matrix.getHeight();
        }

        for (int i = (int) xStart; i <= xEnd; i++) {
            for (int j = (int) yStart; j <= yEnd; j++) {
                System.out.println("rysuje w x="+i+"  y="+j+" kolor:"+choosedColor);
                core.VisualizationGUI.matrix.putObject(i, j, choosedColor);
            }
        }
        core.VisualizationGUI.scroll.repaint();
    }

    private void paintRoll(int x, int y) {

    }
}
