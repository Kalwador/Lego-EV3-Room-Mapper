package matrix;

import utils.Vector;

/**
 * Abstract Matrix
 *
 * @author Kalvador
 */
public abstract class AbstractMatrix<T> implements ExpandMatrix {

    private T[][] matrix;
    private int sizeX;
    private int sizeY;

    public AbstractMatrix() {
        this.sizeX = 100;
        this.sizeY = 100;
        this.matrix = (T[][]) new Object[sizeX][sizeY];
    }

    public AbstractMatrix(Object[][] matrix) {
        this.matrix = (T[][]) matrix;
        this.sizeX = matrix.length;
        this.sizeY = matrix[0].length;
    }

    public AbstractMatrix(int witdh, int height) {
        this.sizeX = witdh;
        this.sizeY = height;
        this.matrix = (T[][]) new Object[sizeX][sizeY];
    }

    @Override
    public void ExpadRight(int size) {
        this.sizeX = this.sizeX + size;

        Object[][] tempMatrix = (T[][]) new Object[sizeX][sizeY];

        for (int i = 0; i < sizeY; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, sizeX);
        }
        this.matrix = (T[][]) tempMatrix;
    }

    @Override
    public void ExpadLeft(int size) {
        this.sizeX = this.sizeX + size;

        Object[][] tempMatrix = (T[][]) new Object[sizeX][sizeY];

        for (int i = 0; i < sizeY; i++) {
            System.arraycopy(matrix[i], size, tempMatrix[i], size, sizeX - size);
        }
        this.matrix = (T[][]) tempMatrix;
    }

    @Override
    public void ExpadUp(int size) {
        this.sizeY = this.sizeY + size;

        Object[][] tempMatrix = (T[][]) new Object[sizeX][sizeY];

        for (int i = size; i < sizeY; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, sizeX);
        }
        this.matrix = (T[][]) tempMatrix;
    }

    @Override
    public void ExpadDown(int size) {
        this.sizeY = this.sizeY + size;

        Object[][] tempMatrix = (T[][]) new Object[sizeX][sizeY];

        for (int i = 0; i < sizeY; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, sizeX);
        }
        this.matrix = (T[][]) tempMatrix;
    }

    public T[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(T[][] matrix) {
        this.matrix = matrix;
    }

    public int getSizeX() {
        return (sizeX - 1);
    }

    public int getSizeY() {
        return (sizeY - 1);
    }

    public utils.Vector getSize() {
        return new Vector(sizeX - 1, sizeY - 1);
    }

    public abstract void put(int x, int y, int value);
}
