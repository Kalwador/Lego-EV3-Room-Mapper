package utils;

import core.VisualizationGUI;

/**
 * Class
 *
 * @author Kalwador
 */
public class Camera {

    /**
     * Size of Pane, used in length of 'Rules' and prefered size of 'ScrolledPane'
     */
    public int contentPaneWidth = 0;
    public int contentPaneHeight = 0;

    /**
     * Default constructor Set zoom on 100. Set Corners of camera in right
     * places
     */
    public Camera(int width, int height) {
//        updateCenterOfMatrixView(width, height);
        contentPaneWidth = width * core.VisualizationGUI.RESOLUTION;
        contentPaneHeight = height * core.VisualizationGUI.RESOLUTION;
    }

    /**
     * Adds one step of camera zoom.
     */
    public static void plusCameraZoom() {
        VisualizationGUI.RESOLUTION += 1;
        if (VisualizationGUI.RESOLUTION > 15) {
            VisualizationGUI.RESOLUTION = 15;
        }
    }

    /**
     * Substract one step of camera zoom.
     */
    public static void minusCameraZoom() {
        VisualizationGUI.RESOLUTION -= 1;
        if (VisualizationGUI.RESOLUTION < 5) {
            VisualizationGUI.RESOLUTION = 5;
        }
    }

    /**
     * Value beetwen <1 to 20>, 10 is normal.
     *
     * @param value value to set
     */
    public static void setCameraZoom(int value) {
        if (value > 20) {
            value = 20;
        }
        if (value < 1) {
            value = 1;
        }
        VisualizationGUI.RESOLUTION = (short) value;
    }
}
