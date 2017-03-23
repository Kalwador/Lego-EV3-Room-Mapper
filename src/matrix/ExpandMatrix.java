package matrix;

/**
 * Class store matrix expands methods in any direction
 * @author Kalvador
 */
public interface ExpandMatrix {
    /**
     * Method that expands given metrix by size in RIGHT direction
     *
     * @param size size to add
     */
    public void ExpadRight(int size);
    
    /**
     * Method that expands given metrix by size in LEFT direction
     *
     * @param size size to add
     */
    public void ExpadLeft(int size);
    
    /**
     * Method that expands given metrix by size in UP direction
     *
     * @param size size to add
     */
    public void ExpadUp(int size);
    
    
    /**
     * Method that expands given metrix by size in DOWN direction
     *
     * @param size size to add
     */
    public void ExpadDown(int size);
}
