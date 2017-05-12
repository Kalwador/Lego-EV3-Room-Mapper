package utils;

import java.io.*;
import java.io.IOException;
import java.util.Random;
import matrix.Matrix;

/**
 *
 * @author Kalwador
 */
public class TXT {

    //Load matrix from txt data
    public static Matrix loadData() {
        Short[][] matrix = new Short[100][100];
        try {
            FileReader file = new FileReader(core.VisualizationGUI.path);
            BufferedReader bufor = new BufferedReader(file);
            String linia;

            int i = 0;
            int j = 0;

            while ((linia = bufor.readLine()) != null) {
                String[] pola = linia.split(",");
                for (String string : pola) {
                    matrix[i][j] = Short.valueOf(string);
                    j++;
                }
                i++;
                j = 0;
            }
            file.close();
        } catch (FileNotFoundException w1) {
            System.out.println("SAVE FILE NOT FOUND");
        } catch (IOException w2) {
            System.out.println("DATA LOAD FILURE - IO EXCEPTION");
        } catch (NumberFormatException w3) {
            System.out.println("WRONG NUMBER FORMAT");
        }
        return new Matrix<Short>(matrix);
    }

    //Save matrix to txt data
    public static String saveData() {
        StringBuilder fullLinia = new StringBuilder();

        for (int i = 0; i < core.VisualizationGUI.matrix.getHeight(); i++) {
            for (int j = 0; j < core.VisualizationGUI.matrix.getWidth(); j++) {
                fullLinia.append(core.VisualizationGUI.matrix.getMatrix()[i][j]);
                if(j < core.VisualizationGUI.matrix.getWidth() - 1){
                    fullLinia.append(",");
                }
            }
            fullLinia.append("\r\n");
        }
        return fullLinia.toString();
    }
     
    //Generate Random Matrix
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

    //Generate Row designed Matrix
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

    public static void main(String[] args) throws IOException {
        generateRandom("matrix", 100, 100);
    }
}
