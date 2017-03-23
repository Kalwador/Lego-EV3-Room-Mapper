package matrix;

/**
 *
 * @author Kalvador
 */
public abstract class AbstractMatrix implements ExpandMatrix{
    
    private int[][] matrix;
    private int sizeX;
    private int sizeY;

    /**
     * New Matrix 100x100
     */
    public AbstractMatrix() {
        this.sizeX = 100;
        this.sizeY = 100;
        this.matrix = new int[sizeX][sizeY];
    }
    

    public AbstractMatrix(int[][] matrix, int sizeX, int sizeY) {
        this.matrix = matrix;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    /**
     * New Empty Matrix
     *
     * @param witdh requested width
     * @param height requested height
     */
    public AbstractMatrix(int witdh, int height) {
        this.sizeX = witdh;
        this.sizeY = height;
        this.matrix = new int[sizeX][sizeY];
    }
    
    @Override
    public void ExpadRight(int size) {
        this.sizeX = this.sizeX + size;

        int[][] tempMatrix = new int[sizeX][sizeY];
        
        for (int i = 0; i < sizeY; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, sizeX);
        }
        this.matrix = tempMatrix;
    }

    @Override
    public void ExpadLeft(int size) {
        this.sizeX = this.sizeX + size;
        
        int[][] tempMatrix = new int[sizeX][sizeY];
      
        for (int i = 0; i < sizeY; i++) {
            System.arraycopy(matrix[i], size, tempMatrix[i], size, sizeX - size);
        }
        this.matrix = tempMatrix;
    }

    @Override
    public void ExpadUp(int size) {
        this.sizeY = this.sizeY + size;

        int[][] tempMatrix = new int[sizeX][sizeY];
        
        for (int i = size; i < sizeY; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, sizeX);
        }
        this.matrix = tempMatrix;
    }

    @Override
    public void ExpadDown(int size) {
        this.sizeY = this.sizeY + size;

        int[][] tempMatrix = new int[sizeX][sizeY];
        
        for (int i = 0; i < sizeY; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, sizeX);
        }
        this.matrix = tempMatrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getSixeX() {
        return sizeX;
    }

    public void setSixeX(int sixeX) {
        this.sizeX = sixeX;
    }

    public int getSixeY() {
        return sizeY;
    }

    public void setSixeY(int sixeY) {
        this.sizeY = sixeY;
    }
    public abstract void put(int x, int y, int value);
}
