package utils;

import core.VisualizationGUI;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Utile to Export Content View as various types
 *
 * @author Kalvador
 */
public class ExportAsImage {

    /**
     * Save Content pane as JPG Image
     */
    public void JPG() {
        BufferedImage image;
        if (window.ContentPane.isGrid) {
            image = getMatrixAsBufferedImageWidthGrid();
        } else {
            image = getMatrixAsBufferedImage();
        }

        //Filter for only specified type of files
        FileFilter fileFilter = new FileNameExtensionFilter(".jpg", "JPG Image");
        File file = chooseFile(fileFilter);
        Optional<File> optional = Optional.ofNullable(file);
        if (optional.isPresent()) {
            try {
                if (!file.getCanonicalPath().endsWith(".jpg")) {
                    ImageIO.write(image, "jpg", new File(file.getCanonicalPath() + ".jpg"));
                } else {
                    ImageIO.write(image, "jpg", new File(file.getCanonicalPath()));
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    /**
     * Save Content pane as PNG Image
     */
    public void PNG() {
        BufferedImage image;
        if (window.ContentPane.isGrid) {
            image = getMatrixAsBufferedImageWidthGrid();
        } else {
            image = getMatrixAsBufferedImage();
        }

        //Filter for only specified type of files
        FileFilter fileFilter = new FileNameExtensionFilter(".png", "PNG Image");
        File file = chooseFile(fileFilter);
        Optional<File> optional = Optional.ofNullable(file);
        if (optional.isPresent()) {
            try {
                if (!file.getCanonicalPath().endsWith(".png")) {
                    ImageIO.write(image, "png", new File(file.getCanonicalPath() + ".png"));
                } else {
                    ImageIO.write(image, "png", new File(file.getCanonicalPath()));
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    /**
     * Save Content pane as BMP Image
     */
    public void BMP() {
        BufferedImage image;
        if (window.ContentPane.isGrid) {
            image = getMatrixAsBufferedImageWidthGrid();
        } else {
            image = getMatrixAsBufferedImage();
        }

        //Filter for only specified type of files
        FileFilter fileFilter = new FileNameExtensionFilter(".bmp", "BMP Image");
        File file = chooseFile(fileFilter);
        Optional<File> optional = Optional.ofNullable(file);
        if (optional.isPresent()) {
            try {
                if (!file.getCanonicalPath().endsWith(".bmp")) {
                    ImageIO.write(image, "bmp", new File(file.getCanonicalPath() + ".bmp"));
                } else {
                    ImageIO.write(image, "bmp", new File(file.getCanonicalPath()));
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    /**
     * Open Save dialog window and create new file
     *
     * @param fileFilter What type of should be saved
     * @return new File to save
     */
    public File chooseFile(FileFilter fileFilter) {
        File fileToSave = null;
        JFileChooser fs = new JFileChooser();
        fs.setDialogTitle("Save File");
        fs.setFileFilter(fileFilter);
        int result = fs.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            fileToSave = fs.getSelectedFile();
        }

        return fileToSave;
    }

    /**
     * Method scann all Content Pane, and save values into buffered Image
     *
     * @return Created Image
     */
    private BufferedImage getMatrixAsBufferedImage() {

        //dimensions of arrary needed to save in image
        int arrayWidth = core.VisualizationGUI.matrix.getWidth();
        int arrayHeight = core.VisualizationGUI.matrix.getHeight();

        //image dimmension is matrix * resolution + (noumber of axis + 1)
        BufferedImage image = new BufferedImage(
                (arrayWidth * VisualizationGUI.RESOLUTION),
                (arrayHeight * VisualizationGUI.RESOLUTION),
                BufferedImage.TYPE_3BYTE_BGR);

        //table with colors value (0-255) for raster usage
        int[] rgb = new int[3];

        //loop for evry cell in matrix
        for (int height = 0; height < arrayHeight; height++) {
            for (int width = 0; width < arrayWidth; width++) {

                //values restart
                rgb[0] = 0;
                rgb[1] = 0;
                rgb[2] = 0;

                //checking values from matrix
                switch ((Short) core.VisualizationGUI.matrix.getMatrix()[height][width]) {
                    case 0: {
                        //white color
                        rgb[0] = 255;
                        rgb[1] = 255;
                        rgb[2] = 255;
                        break;
                    }
                    case 1: {
                        //red color
                        rgb[0] = 255;
                        break;
                    }
                    case 2: {
                        //blue color
                        rgb[2] = 255;
                        break;
                    }
                }
                //loop after height of cell
                for (int j = height * VisualizationGUI.RESOLUTION; j < height * VisualizationGUI.RESOLUTION + VisualizationGUI.RESOLUTION; j++) {
                    //loop after width of cell
                    for (int k = width * VisualizationGUI.RESOLUTION; k < width * VisualizationGUI.RESOLUTION + VisualizationGUI.RESOLUTION; k++) {
                        //loop after colors
                        for (int l = 0; l < 3; l++) {
                            //drawing only if rgb is different from 0
                            if (rgb[l] != 0) {
                                image.getRaster().setSample(k, j, l, rgb[l]);
                            }
                        }
                    }
                }
            }
        }
        return image;
    }

    /**
     * Method scann all Content Pane, and save values into buffered Image
     *
     * @return Created Image
     */
    private BufferedImage getMatrixAsBufferedImageWidthGrid() {

        //dimensions of arrary needed to save in image
        int arrayWidth = core.VisualizationGUI.matrix.getWidth();
        int arrayHeight = core.VisualizationGUI.matrix.getHeight();

        int widhtAxisCount = arrayWidth + 1;
        int heightAxisCount = arrayHeight + 1;

        //image dimmension is matrix * resolution + (noumber of axis + 1)
        BufferedImage image = new BufferedImage(
                (arrayWidth * VisualizationGUI.RESOLUTION) + widhtAxisCount,
                (arrayHeight * VisualizationGUI.RESOLUTION) + heightAxisCount,
                BufferedImage.TYPE_3BYTE_BGR);

        //table with colors value (0-255) for raster usage
        int[] rgb = new int[3];

        //variables usage in count of drawed lines in grid
        int xAxisCount = 1;
        int yAxisCount = 1;

        //loop for evry cell in matrix
        for (int height = 0; height < arrayHeight; height++) {
            for (int width = 0; width < arrayWidth; width++) {

                //values restart
                rgb[0] = 0;
                rgb[1] = 0;
                rgb[2] = 0;

                //checking values from matrix
                switch ((Short) core.VisualizationGUI.matrix.getMatrix()[height][width]) {
                    case 0: {
                        //white color
                        rgb[0] = 255;
                        rgb[1] = 255;
                        rgb[2] = 255;
                        break;
                    }
                    case 1: {
                        //red color
                        rgb[0] = 255;
                        break;
                    }
                    case 2: {
                        //blue color
                        rgb[2] = 255;
                        break;
                    }
                }
                //loop after height of cell
                for (int j = height * VisualizationGUI.RESOLUTION + yAxisCount; j < height * VisualizationGUI.RESOLUTION + VisualizationGUI.RESOLUTION + yAxisCount; j++) {
                    //loop after width of cell
                    for (int k = width * VisualizationGUI.RESOLUTION + xAxisCount; k < width * VisualizationGUI.RESOLUTION + VisualizationGUI.RESOLUTION + xAxisCount; k++) {
                        //loop after colors
                        for (int l = 0; l < 3; l++) {
                            //drawing only if rgb is different from 0
                            if (rgb[l] != 0) {
                                image.getRaster().setSample(k, j, l, rgb[l]);
                            }
                        }
                    }
                }
                xAxisCount++;
            }
            xAxisCount = 1;
            yAxisCount++;
        }
        return image;
    }
}
