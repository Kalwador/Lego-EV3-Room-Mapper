package matrix;

import java.awt.Dimension;

/**
 * Class which allows build two dimmesnions arrays of generic type.
 *
 * @author Kalwador
 * @param <T> any kind of Referenced Type of object
 * @since 23.03.2017
 */
public class Matrix<T> extends AbstractMatrix {

    /**
     * New Matrix 100x100
     */
    public Matrix() {
        super();
    }

    /**
     * Copy Constructor
     *
     * @param matrix
     */
    public Matrix(T[][] matrix) {
        super(matrix);
    }

    /**
     * New Empty Matrix with specified dimension
     *
     * @param witdh requested width
     * @param height requested height
     */
    public Matrix(int witdh, int height) {
        super(witdh, height);
    }

    /**
     * Puts element in chosen widht and height
     *
     * @param height - y parameter
     * @param width - x parameter
     * @param object - object to put
     */
    public void put(int height, int width, T object) {
        if (height >= super.getHeight()) {
            super.ExpadDown(50);
            put(height, width, object);
        } else {
            if (height < 0) {
                super.ExpadUp(50);
                put(height, width, object);
            } else {
                if (width >= super.getWidth()) {
                    super.ExpadRight(50);
                    put(height, width, object);
                } else {
                    if (width < 0) {
                        super.ExpadLeft(50);
                        put(height, width, object);
                    } else {
                        super.putObject(height, width, object);
                    }
                }
            }
        }
    }

    /**
     * Print matrix values in standar output
     */
    @Override
    public void printMatrix() {
        super.printMatrix();
    }

    /**
     * This method adjust matrix to her real size Cuts of rows and columns null
     * of null value
     */
    @Override
    public void adjust() {
        super.adjust();
    }

    public void fillMatrixWithZero() {
        for (int i = 0; i < super.getHeight(); i++) {
            for (int j = 0; j < super.getWidth(); j++) {
                Short temp = 0;
                put(i, j,(T) temp);
            }
        }
    }

    /**
     * Returns width od matrix
     *
     * @return
     */
    @Override
    public int getWidth() {
        return super.getWidth();
    }

    /**
     * Returns height od matrix
     *
     * @return
     */
    @Override
    public int getHeight() {
        return super.getHeight();
    }
    
    public Dimension getSize() {
        return new Dimension(getHeight(), getWidth());
    }
}
