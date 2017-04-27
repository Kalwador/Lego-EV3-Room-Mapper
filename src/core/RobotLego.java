package core;

/**
 * @author Wilk
 * @author Kalwador
 * @since 02.04.2017
 */
public class RobotLego{

    /**
     * Main for tests, will be deleted when program will join to full project.
     * @param args 
     */
    public static void main(String[] args) {
        start();
    }
    
    /**
     * Run this metod to start program
     */
    public static void start(){
        VisualizationGUI visualizationGUI = new VisualizationGUI();
        visualizationGUI.run();
    }
}
