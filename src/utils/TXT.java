package utils;

import static core.VisualizationGUI.isContentPaneEmpty;
import static core.VisualizationGUI.matrix;
import java.io.*;
import java.io.IOException;
import java.util.Optional;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import matrix.Matrix;

/**
 * @author WIlk
 * @author Kalwador
 */
public class TXT {

    /**
     * Load matrix from txt data Only when program starts
     *
     * @return matrix
     */
    public static matrix.Matrix<Short> loadDataOnProgramStart() {
        matrix.Matrix<Short> matrix = null;

        File fileToOpen = null;
        JFileChooser fs = new JFileChooser();
        fs.setDialogTitle("Open Data");
        fs.setCurrentDirectory(FileSystemView.getFileSystemView().getHomeDirectory());
        fs.setFileFilter(new FileNameExtensionFilter("TXT DATA", "txt"));
        int result = fs.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            fileToOpen = fs.getSelectedFile();
            core.VisualizationGUI.path = fileToOpen.getAbsolutePath();
            matrix = reloadData();
            Optional<Matrix<Short>> optional = Optional.ofNullable(matrix);
            if (!optional.isPresent()) {
                return loadDataOnProgramStart();
            }
        } else if (result == JFileChooser.CANCEL_OPTION) {
            core.VisualizationGUI.path = "";
        }
        return matrix;
    }

    /**
     * Reload matrix from txt data
     *
     * @return matrix
     */
    public static matrix.Matrix<Short> reloadData() {
        matrix.Matrix<Short> matrix = new Matrix<>();

        try {
            //setting up path of new file

            try (FileReader file = new FileReader(new File(core.VisualizationGUI.path))) {
                BufferedReader bufor = new BufferedReader(file);
                String linia;

                int i = 0;
                int j = 0;

                while ((linia = bufor.readLine()) != null) {
                    String[] pola = linia.split(",");
                    for (String wartosc : pola) {
                        if (wartosc.equals("0") || wartosc.equals("1") || wartosc.equals("2")) {
                            matrix.put(i, j, Short.valueOf(wartosc));
                            j++;
                        } else {
                            JOptionPane.showMessageDialog(null, "Error ocured during parsing file\r\t\nLine: " + i + "  Column: " + j + "  Value: " + wartosc + "\r\t\nPlease select other file");
                            return null;
                        }
                    }
                    i++;
                    j = 0;
                }
            }
        } catch (FileNotFoundException w1) {
            JOptionPane.showMessageDialog(null, "Saved file not found.");
        } catch (IOException w2) {
            JOptionPane.showMessageDialog(null, "Data load failure.");
        } catch (NumberFormatException w3) {
            JOptionPane.showMessageDialog(null, "Wrong number format.");
        }
        matrix.adjust();
        return matrix;
    }

    /**
     * Save matrix to txt data
     *
     * @return fullLinia.toString() or data from matrix
     */
    public static String saveData() {
        StringBuilder fullLinia = new StringBuilder();

        for (int i = 0; i < core.VisualizationGUI.matrix.getHeight(); i++) {
            for (int j = 0; j < core.VisualizationGUI.matrix.getWidth(); j++) {
                fullLinia.append(core.VisualizationGUI.matrix.getMatrix()[i][j]);
                if (j < core.VisualizationGUI.matrix.getWidth() - 1) {
                    fullLinia.append(",");
                }
            }
            if (i < core.VisualizationGUI.matrix.getHeight() - 1) {
                fullLinia.append("\r\n");
            }
        }
        return fullLinia.toString();
    }

    /**
     * generate random matrix
     *
     * @param path file path
     * @param width of matrix
     * @param height of matrix
     * @throws IOException throwing imput-output exception
     */
    public static void generateRandom(String path, int width, int height) throws IOException {
        File file = new File(path + ".txt");

        // creates the file
        file.createNewFile();

        // creates a FileWriter Object
        FileWriter writer = new FileWriter(file);

        Random r = new Random();

        // Writes the content to the file
        for (int i = 0; i < height; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < width; j++) {
                int x = r.nextInt(100);
                if (x < 2) {
                    s.append("2");
                    if (j < (height - 1)) {
                        s.append(",");
                    }
                } else if (x < 20) {
                    s.append("1");
                    if (j < (height - 1)) {
                        s.append(",");
                    }
                } else if (x < 100) {
                    s.append("0");
                    if (j < (height - 1)) {
                        s.append(",");
                    }
                }
            }
            writer.write(s.toString() + "\r\n");
        }
        writer.flush();
        writer.close();
    }

    /**
     * generate row designed matrix
     *
     * @param path file path
     * @param width of matrix
     * @param height of matrix
     * @throws IOException throwing imput-output exception
     */
    public static void generateRowColored(String path, int width, int height) throws IOException {
        File file = new File(path + ".txt");

        // creates the file
        file.createNewFile();

        // creates a FileWriter Object
        FileWriter writer = new FileWriter(file);

        int linia = 0;
        int zmiana = 1;

        // Writes the content to the file
        for (int i = 0; i < height; i++) {
            zmiana = 0;
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < width; j++) {
                if (j < linia) {
                    s.append(zmiana + ",");
                    if (zmiana == 1) {
                        zmiana = 2;
                    } else {
                        zmiana = 1;
                    }
                } else {
                    s.append(zmiana + ",");
                }

            }
            linia++;
            zmiana = 0;
            writer.write(s.toString() + "\r\n");
        }
        writer.flush();
        writer.close();
    }
}
