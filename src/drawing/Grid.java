package drawing;

import java.awt.geom.Rectangle2D;
import matrix.RectangleMatrix;

/**
 *
 * @author Kalvador
 */
public class Grid {
    private matrix.RectangleMatrix rectalngleMatrix;

    public Grid() {
        rectalngleMatrix = new RectangleMatrix();
    }
    public void draw(){
        
    }
//    public void calculateRectanglePosition(){
//        for (int i = 0; i < rectalngleMatrix.getSixeY(); i++) {
//            for (int j = 0; j < rectalngleMatrix.getSixeX(); j++) {
//                rectalngleMatrix.getMatrix()[0][0] = new Rectangle2D.Double(j, i, 0, 0);
//            }
//        }
//    }
}
