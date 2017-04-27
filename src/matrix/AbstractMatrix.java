package matrix;

import utils.Vector;

/**
 * Abstract Matrix
 *
 * @author Kalwador
 * @param <T>
 */
public abstract class AbstractMatrix<T> implements ExpandMatrix {

    private T[][] matrix;
    private int width;
    private int height;

    public AbstractMatrix() {
        this.width = 100;
        this.height = 100;
        this.matrix = (T[][]) new Object[width][height];
    }

    public AbstractMatrix(Object[][] matrix) {
        this.matrix = (T[][]) matrix;
        this.width = matrix.length;
        this.height = matrix[0].length;
    }

    public AbstractMatrix(int witdh, int height) {
        this.width = witdh;
        this.height = height;
        this.matrix = (T[][]) new Object[width][this.height];
    }

    @Override
    public void ExpadRight(int size) {
        this.width = this.width + size;

        Object[][] tempMatrix = (T[][]) new Object[width][height];

        for (int i = 0; i < height; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, width);
        }
        this.matrix = (T[][]) tempMatrix;
    }

    @Override
    public void ExpadLeft(int size) {
        this.width = this.width + size;

        Object[][] tempMatrix = (T[][]) new Object[width][height];

        for (int i = 0; i < height; i++) {
            System.arraycopy(matrix[i], size, tempMatrix[i], size, width - size);
        }
        this.matrix = (T[][]) tempMatrix;
    }

    @Override
    public void ExpadUp(int size) {
        this.height = this.height + size;

        Object[][] tempMatrix = (T[][]) new Object[width][height];

        for (int i = size; i < height; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, width);
        }
        this.matrix = (T[][]) tempMatrix;
    }

    @Override
    public void ExpadDown(int size) {
        this.height = this.height + size;

        Object[][] tempMatrix = (T[][]) new Object[width][height];

        for (int i = 0; i < height; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, width);
        }
        this.matrix = (T[][]) tempMatrix;
    }

    public T[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(T[][] matrix) {
        this.matrix = matrix;
    }

    public int getWidth() {
        return (width - 1);
    }

    public int getHeight() {
        return (height - 1);
    }

    public utils.Vector getSize() {
        return new Vector(width - 1, height - 1);
    }

    public void putObject(int x, int y, Object object) {
        matrix[x][y] = (T) object;
    }
}
