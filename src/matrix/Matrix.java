package matrix;

/**
 * Class which allows build two dimmesnions arrays of generic type.
 *
 * @author Kalvador
 * @param <T>
 * @since 23.03.2017
 */
public class Matrix<T> extends AbstractMatrix {

    private AbstractMatrix<T> matrix;

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

    @Override
    public void put(int x, int y, int value) {
        if (x >= super.getSixeX()) {
            matrix.ExpadDown(10);
        }
        if (x < 0) {
            matrix.ExpadUp(10);
        }
        if (y >= super.getSixeY()) {
            matrix.ExpadRight(10);
        }
        if (y < 0) {
            matrix.ExpadLeft(10);
        }
        matrix.put(x, y, value);
    }
}
