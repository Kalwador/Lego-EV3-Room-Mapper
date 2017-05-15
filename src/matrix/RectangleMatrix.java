package matrix;

import java.awt.geom.Rectangle2D;

/**
 *
 * @author Kalwador
 */

public class RectangleMatrix extends Matrix<Rectangle2D>{

    public RectangleMatrix() {
        super();
    }
    public RectangleMatrix(int width, int height) {
        super(width,height);
    }

    public RectangleMatrix(Rectangle2D[][] matrix) {
        super(matrix);
    }
}
