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

    protected AbstractMatrix() {
        this.width = 150;
        this.height = 150;
        this.matrix = (T[][]) new Object[height][width];
    }

    protected AbstractMatrix(Object[][] matrix) {
        this.matrix = (T[][]) matrix;
        this.width = matrix.length;
        this.height = matrix[0].length;
    }

    protected AbstractMatrix(int witdh, int height) {
        this.width = witdh;
        this.height = height;
        this.matrix = (T[][]) new Object[height][witdh];
    }

    @Override
    public void ExpadRight(int size) {
        Object[][] tempMatrix = (T[][]) new Object[height][width + size];

        for (int i = 0; i < height; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, width);
        }
        this.matrix = (T[][]) tempMatrix;
        this.width += size;
    }

    @Override
    public void ExpadLeft(int size) {
        Object[][] tempMatrix = (T[][]) new Object[height][width + size];

        for (int i = 0; i < height; i++) {
            System.arraycopy(matrix[i], size, tempMatrix[i], size, width - size);
        }
        this.matrix = (T[][]) tempMatrix;
        this.width += size;
    }

    @Override
    public void ExpadUp(int size) {
        Object[][] tempMatrix = (T[][]) new Object[height + size][width];

        for (int i = size; i < height; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, width);
        }
        this.matrix = (T[][]) tempMatrix;
        this.height += size;
    }

    @Override
    public void ExpadDown(int size) {
        Object[][] tempMatrix = (T[][]) new Object[height + size][width];

        for (int i = 0; i < height; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, width);
        }
        this.matrix = (T[][]) tempMatrix;
        this.height += size;
    }

    public T[][] getMatrix() {
        return matrix;
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

    protected void putObject(int x, int y, Object object) {
        matrix[x][y] = (T) object;
    }


    protected void printMatrix() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println("");
        }
    }


    protected void adjust() {
        int prefferedWidth = width;
        int prefferedHeight = height;

        int lastIndexInWidth = 0;
        int lastIndexInHeight = 0;

        for (T t : matrix[0]) {
            if (t == null) {
                break;
            }
            lastIndexInWidth++;
        }

        for (int i = 0; i < height; i++) {
            if (matrix[i][0] == null) {
                break;
            }
            lastIndexInHeight++;
        }

        Object[][] tempMatrix = (T[][]) new Object[lastIndexInHeight][lastIndexInWidth];
        
        for (int i = 0; i < lastIndexInHeight; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, lastIndexInWidth);
        }
        this.matrix = (T[][]) tempMatrix;
        this.width = lastIndexInWidth;
        this.height = lastIndexInHeight;
        
    }
}
