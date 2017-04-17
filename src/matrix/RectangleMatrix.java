/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.awt.geom.Rectangle2D;

/**
 *
 * @author Kalvador
 */
public class RectangleMatrix extends Matrix<Rectangle2D>{

    public RectangleMatrix() {
        super();
    }

    public RectangleMatrix(Rectangle2D[][] matrix) {
        super(matrix);
    }

    public RectangleMatrix(int witdh, int height) {
        super(witdh, height);
    }
    
}
