package matrix;

/**
 * Matrix Model
 *
 * @author Kalvador
 * @since 23.03.2017
 */
public class Matrix extends AbstractMatrix {

    private AbstractMatrix matrix;

    public Matrix() {
    }

    public Matrix(int[][] matrix, int sizeX, int sizeY) {
        super(matrix, sizeX, sizeY);
    }

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
