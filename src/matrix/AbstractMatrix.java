package matrix;

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
        Object[][] tempMatrix = (T[][]) new Object[width + size][height];

        for (int i = 0; i < height; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, width);
        }
        this.matrix = (T[][]) tempMatrix;
        this.width += size;
    }

    @Override
    public void ExpadLeft(int size) {
        Object[][] tempMatrix = (T[][]) new Object[width + size][height];

        for (int i = 0; i < height; i++) {
            System.arraycopy(matrix[i], size, tempMatrix[i], size, width - size);
        }
        this.matrix = (T[][]) tempMatrix;
        this.width += size;
    }

    @Override
    public void ExpadUp(int size) {
        Object[][] tempMatrix = (T[][]) new Object[width][height + size];

        for (int i = size; i < height; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, width);
        }
        this.matrix = (T[][]) tempMatrix;
        this.height += size;
    }

    @Override
    public void ExpadDown(int size) {
        Object[][] tempMatrix = (T[][]) new Object[width][height + size];

        for (int i = 0; i < height; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, width);
        }
        this.matrix = (T[][]) tempMatrix;
        this.height += size;
    }

    public T[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(T[][] matrix) {
        this.matrix = matrix;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void putObject(int x, int y, Object object) {
        matrix[x][y] = (T) object;
    }

    public void printMatrix() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println("");
        }
    }
}
