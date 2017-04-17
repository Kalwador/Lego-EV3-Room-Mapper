package utils;

/**
 *
 * @author Kalvador
 */
public class Camera {
    /**
     * Scalar of view zoom in.
     */
    private short cameraZoom;
    
    private int xCameraStart;
    private int xCameraEnd = xCameraStart + 800;
    private int yCameraStart;
    private int yCameraEnd = yCameraStart + 600;
    
    public Camera() {
        this.cameraZoom = 100;
    }
    
    public void plusCameraZoom(){
        this.cameraZoom += 10;
    }
    public void minusCameraZoom(){
        this.cameraZoom -= 10;
    }
    /**
     * Value beetwen <1 to 20>, 10 is normal.
     * @param value value to set
     */
    public void setCameraZoom(int value){
        this.cameraZoom = (short) (value * 10);
    }
}
