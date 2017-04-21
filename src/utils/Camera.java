package utils;

import core.VisualizationGUI;

/**
 * Class
 *
 * @author Kalvador
 */
public class Camera {

    /**
     * Corners of camera view
     */
    private int xCameraStart;
    private int xCameraEnd;
    private int yCameraStart;
    private int yCameraEnd;

    /**
     * Maximum position that camera can reach
     */
    private int xCameraMaxPosition;
    private int yCameraMaxPosition;

    /**
     * Default value of step, that camera do whitch every move
     */
    private final int cameraStep = 10;

    /**
     * Default constructor Set zoom on 100. Set Corners of camera in right
     * places
     */
    public Camera(Vector matrixDimensions) {
        updateCenterOfMatrixView(matrixDimensions);
    }

    /**
     * Moves Camera in LEFT direction, by 10 rectangles.
     */
    public void moveCameraLEFT() {
        xCameraStart -= cameraStep * core.VisualizationGUI.resoulution;
        if (xCameraStart < 0) {
            xCameraStart = 0;
        }
        xCameraEnd = xCameraStart + core.VisualizationGUI.windowWidth;
    }

    /**
     * Moves Camera in RIGHT direction, by 10 rectangles.
     */
    public void moveCameraRIGHT() {
        xCameraStart += cameraStep * core.VisualizationGUI.resoulution;
        if (xCameraStart > xCameraMaxPosition) {
            xCameraStart = xCameraMaxPosition;
        }
        xCameraEnd = xCameraStart + core.VisualizationGUI.windowWidth;
    }

    /**
     * Moves Camera in UP direction, by 10 rectangles.
     */
    public void moveCameraUP() {
        yCameraStart -= cameraStep * VisualizationGUI.resoulution;
        if (yCameraStart < 0) {
            yCameraStart = 0;
        }
        yCameraEnd = yCameraStart + VisualizationGUI.windowHeight;
    }

    /**
     * Moves Camera in DOWN direction, by 10 rectangles.
     */
    public void moveCameraDOWN() {
        yCameraStart += cameraStep * VisualizationGUI.resoulution;
        if (yCameraStart > yCameraMaxPosition) {
            yCameraStart = yCameraMaxPosition;
        }
        yCameraEnd = yCameraStart + VisualizationGUI.windowHeight;
    }

    /**
     * Adds one step of camera zoom.
     */
    public void plusCameraZoom() {
        VisualizationGUI.resoulution += 1;
        if (VisualizationGUI.resoulution > 20) {
            VisualizationGUI.resoulution = 20;
        }
    }

    /**
     * Substract one step of camera zoom.
     */
    public void minusCameraZoom() {
        VisualizationGUI.resoulution -= 1;
        if (VisualizationGUI.resoulution < 1) {
            VisualizationGUI.resoulution = 1;
        }
    }

    /**
     * Value beetwen <1 to 20>, 10 is normal.
     *
     * @param value value to set
     */
    public void setCameraZoom(int value) {
        if (value > 20) {
            value = 20;
        }
        if (value < 1) {
            value = 1;
        }
        VisualizationGUI.resoulution = (short) value;
    }

    private void updateCenterOfMatrixView(Vector matrixDimensions) {
        int widthOfMatrixInPixels = matrixDimensions.getX() * core.VisualizationGUI.resoulution;
        System.out.println("1. " + widthOfMatrixInPixels);
        
        int heightOfMatrixInPixels = matrixDimensions.getY() * core.VisualizationGUI.resoulution;
        System.out.println("2. " + heightOfMatrixInPixels);
        
        xCameraStart = (widthOfMatrixInPixels / 2) - (core.VisualizationGUI.windowWidth / 2);
        System.out.println("3. " + xCameraStart);
        
        yCameraStart = (heightOfMatrixInPixels / 2) - (core.VisualizationGUI.windowHeight / 2);
        System.out.println("4. " + yCameraStart);
        
        xCameraMaxPosition = widthOfMatrixInPixels - core.VisualizationGUI.windowWidth;
        System.out.println("5. " + xCameraMaxPosition);
        
        yCameraMaxPosition = heightOfMatrixInPixels - core.VisualizationGUI.windowHeight;
        System.out.println("6. " + yCameraMaxPosition);

        //Zabezpieczenia niedopracowane, nie wiem jeszcze jak będzie się to zmieniało
        if (xCameraStart < 0) {
            xCameraStart = 0;
        }

        if (yCameraStart < 0) {
            yCameraStart = 0;
        }

        xCameraEnd = xCameraStart + core.VisualizationGUI.windowWidth;
        System.out.println("7. " + xCameraEnd);
        
        yCameraEnd = yCameraStart + core.VisualizationGUI.windowHeight;
        System.out.println("8. " + yCameraEnd);
    }

    public int getxCameraStart() {
        return xCameraStart;
    }

    public void setxCameraStart(int xCameraStart) {
        this.xCameraStart = xCameraStart;
    }

    public int getxCameraEnd() {
        return xCameraEnd;
    }

    public void setxCameraEnd(int xCameraEnd) {
        this.xCameraEnd = xCameraEnd;
    }

    public int getyCameraStart() {
        return yCameraStart;
    }

    public void setyCameraStart(int yCameraStart) {
        this.yCameraStart = yCameraStart;
    }

    public int getyCameraEnd() {
        return yCameraEnd;
    }

    public void setyCameraEnd(int yCameraEnd) {
        this.yCameraEnd = yCameraEnd;
    }

    public int getxCameraMaxPosition() {
        return xCameraMaxPosition;
    }

    public void setxCameraMaxPosition(int xCameraMaxPosition) {
        this.xCameraMaxPosition = xCameraMaxPosition;
    }

    public int getyCameraMaxPosition() {
        return yCameraMaxPosition;
    }

    public void setyCameraMaxPosition(int yCameraMaxPosition) {
        this.yCameraMaxPosition = yCameraMaxPosition;
    }

}
