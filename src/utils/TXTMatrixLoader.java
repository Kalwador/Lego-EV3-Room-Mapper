package utils;

import matrix.Matrix;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Kalvador
 */
public class TXTMatrixLoader {

    public static Matrix loadData(String path) {
        Short[][] matrix = new Short[100][100];
        try {
            FileReader file = new FileReader(path);
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


//        Matrix<Short> matrix = new Matrix<>();
//        try {
//            FileReader file = new FileReader(path);
//            BufferedReader bufor = new BufferedReader(file);
//            String linia;
//
//            int i = 0;
//            int j = 0;
//
//            while ((linia = bufor.readLine()) != null) {
//                String[] pola = linia.split(",");
//                for (String string : pola) {
//                    matrix.put(i,j, Short.valueOf(string));
//                    j++;
//                }
//                i++;
//                j = 0;
//            }
//            file.close();
//        } catch (FileNotFoundException w1) {
//            System.out.println("SAVE FILE NOT FOUND");
//        } catch (IOException w2) {
//            System.out.println("DATA LOAD FILURE - IO EXCEPTION");
//        } catch (NumberFormatException w3) {
//            System.out.println("WRONG NUMBER FORMAT");
//        }
//        return matrix;
//    }
}
