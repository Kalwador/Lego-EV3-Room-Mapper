package utils;

import core.VisualizationGUI;

/**
 * Class
 *
 * @author Kalvador
 */
public class Camera {

    /**
     * Scalar of view, zoom in.
     */
    private int xPointWhereCameraStart;
    private int xPointWhereCameraEnds;
    private int yPointWhereCameraStart;
    private int yPointWhereCameraEnds;

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
        xPointWhereCameraStart -= cameraStep * core.VisualizationGUI.RESOLUTION;
        if (xPointWhereCameraStart < 0) {
            xPointWhereCameraStart = 0;
        }
        xPointWhereCameraEnds = xPointWhereCameraStart + core.VisualizationGUI.windowPreferedWidth;
    }

    /**
     * Moves Camera in RIGHT direction, by 10 rectangles.
     */
    public void moveCameraRIGHT() {
        xPointWhereCameraStart += cameraStep * core.VisualizationGUI.RESOLUTION;
        if (xPointWhereCameraStart > xCameraMaxPosition) {
            xPointWhereCameraStart = xCameraMaxPosition;
        }
        xPointWhereCameraEnds = xPointWhereCameraStart + core.VisualizationGUI.windowPreferedWidth;
    }

    /**
     * Moves Camera in UP direction, by 10 rectangles.
     */
    public void moveCameraUP() {
        yPointWhereCameraStart -= cameraStep * VisualizationGUI.RESOLUTION;
        if (yPointWhereCameraStart < 0) {
            yPointWhereCameraStart = 0;
        }
        yPointWhereCameraEnds = yPointWhereCameraStart + VisualizationGUI.windowPreferedHeight;
    }

    /**
     * Moves Camera in DOWN direction, by 10 rectangles.
     */
    public void moveCameraDOWN() {
        yPointWhereCameraStart += cameraStep * VisualizationGUI.RESOLUTION;
        if (yPointWhereCameraStart > yCameraMaxPosition) {
            yPointWhereCameraStart = yCameraMaxPosition;
        }
        yPointWhereCameraEnds = yPointWhereCameraStart + VisualizationGUI.windowPreferedHeight;
    }

    /**
     * Adds one step of camera zoom.
     */
    public void plusCameraZoom() {
        VisualizationGUI.RESOLUTION += 1;
        if (VisualizationGUI.RESOLUTION > 20) {
            VisualizationGUI.RESOLUTION = 20;
        }
    }

    /**
     * Substract one step of camera zoom.
     */
    public void minusCameraZoom() {
        VisualizationGUI.RESOLUTION -= 1;
        if (VisualizationGUI.RESOLUTION < 1) {
            VisualizationGUI.RESOLUTION = 1;
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
        VisualizationGUI.RESOLUTION = (short) value;
    }

    private void updateCenterOfMatrixView(Vector matrixDimensions) {
        int widthOfMatrixInPixels = matrixDimensions.getX() * core.VisualizationGUI.RESOLUTION;
//        System.out.println("1. " + widthOfMatrixInPixels);

        int heightOfMatrixInPixels = matrixDimensions.getY() * core.VisualizationGUI.RESOLUTION;
//        System.out.println("2. " + heightOfMatrixInPixels);

        xPointWhereCameraStart = (widthOfMatrixInPixels / 2) - (core.VisualizationGUI.windowPreferedWidth / 2);
//        System.out.println("3. " + xPointWhereCameraStart);

        yPointWhereCameraStart = (heightOfMatrixInPixels / 2) - (core.VisualizationGUI.windowPreferedHeight / 2);
//        System.out.println("4. " + yPointWhereCameraStart);

        xCameraMaxPosition = widthOfMatrixInPixels - core.VisualizationGUI.windowPreferedWidth;
//        System.out.println("5. " + xPointWhereCameraEnds);

        yCameraMaxPosition = heightOfMatrixInPixels - core.VisualizationGUI.windowPreferedHeight;
//        System.out.println("6. " + yPointWhereCameraEnds);

        //Zabezpieczenie aby kamera nie wyszła przed sitake
        if (xPointWhereCameraStart < 0) {
            xPointWhereCameraStart = 0;
        }

        if (yPointWhereCameraStart < 0) {
            yPointWhereCameraStart = 0;
        }

        xPointWhereCameraEnds = xPointWhereCameraStart + core.VisualizationGUI.windowPreferedWidth;
//        System.out.println("7. " + xPointWhereCameraEnds);

        yPointWhereCameraEnds = yPointWhereCameraStart + core.VisualizationGUI.windowPreferedHeight;
//        System.out.println("8. " + yPointWhereCameraEnds);

        //Zabezpieczenie aby kamera nie wyszła poza siatkę
        if (xPointWhereCameraEnds > xCameraMaxPosition) {
            xPointWhereCameraEnds = xCameraMaxPosition;
        }
        if (yPointWhereCameraEnds > yCameraMaxPosition) {
            yPointWhereCameraEnds = yCameraMaxPosition;
        }
    }

    public int getxCameraStart() {
        return xPointWhereCameraStart;
    }

    public void setxCameraStart(int xCameraStart) {
        this.xPointWhereCameraStart = xCameraStart;
    }

    public int getxCameraEnd() {
        return xPointWhereCameraEnds;
    }

    public void setxCameraEnd(int xCameraEnd) {
        this.xPointWhereCameraEnds = xCameraEnd;
    }

    public int getyCameraStart() {
        return yPointWhereCameraStart;
    }

    public void setyCameraStart(int yCameraStart) {
        this.yPointWhereCameraStart = yCameraStart;
    }

    public int getyCameraEnd() {
        return yPointWhereCameraEnds;
    }

    public void setyCameraEnd(int yCameraEnd) {
        this.yPointWhereCameraEnds = yCameraEnd;
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