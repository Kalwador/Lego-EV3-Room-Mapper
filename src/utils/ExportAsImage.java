package utils;

import core.VisualizationGUI;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
        FileFilter fileFilter = new FileNameExtensionFilter(".jpg", "JPG Image");
        File file = chooseFile(fileFilter);
        try {
            ImageIO.write(image, "jpg", new File(file.getCanonicalPath() + ".jpg"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
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
        FileFilter fileFilter = new FileNameExtensionFilter(".png", "PNG Image");
        File file = chooseFile(fileFilter);
        try {
            ImageIO.write(image, "png", new File(file.getCanonicalPath() + ".png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
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
        FileFilter fileFilter = new FileNameExtensionFilter(".bmp", "BMP Image");
        File file = chooseFile(fileFilter);
        try {
            System.out.println(file.getCanonicalPath());
            ImageIO.write(image, "bmp", new File(file.getCanonicalPath() + ".bmp"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
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
        int arrayWidth = core.VisualizationGUI.visualizationGUI.matrix.getWidth();
        int arrayHeight = core.VisualizationGUI.visualizationGUI.matrix.getHeight();

        BufferedImage image = new BufferedImage(
                arrayWidth * VisualizationGUI.RESOLUTION,
                arrayHeight * VisualizationGUI.RESOLUTION,
                BufferedImage.TYPE_3BYTE_BGR);

        int[] rgb = new int[3];

        for (int height = 0; height < arrayHeight * VisualizationGUI.RESOLUTION; height += VisualizationGUI.RESOLUTION) {
            for (int width = 0; width < arrayWidth * VisualizationGUI.RESOLUTION; width += VisualizationGUI.RESOLUTION) {

                //values restart
                rgb[0] = 0;
                rgb[1] = 0;
                rgb[2] = 0;

                //checking values from matrix
                switch ((Short) core.VisualizationGUI.matrix.getMatrix()[height / VisualizationGUI.RESOLUTION][width / VisualizationGUI.RESOLUTION]) {
                    case 0: {
                        //white
                        rgb[0] = 255;
                        rgb[1] = 255;
                        rgb[2] = 255;
                        break;
                    }
                    case 1: {
                        //red
                        rgb[0] = 255;
                        break;
                    }
                    case 2: {
                        //blue
                        rgb[2] = 255;
                        break;
                    }
                }

                //loop after height of pixel
                for (int j = height; j < (height + VisualizationGUI.RESOLUTION); j++) {
                    //loop after width of pixel
                    for (int k = width; k < (width + VisualizationGUI.RESOLUTION); k++) {
                        //loop after rgb
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

        int[] rgb = new int[3];

        int xAxisCount = 1;
        int yAxisCount = 1;

        for (int height = 0; height < arrayHeight; height++) {
            for (int width = 0; width < arrayWidth; width++) {

                //values restart
                rgb[0] = 0;
                rgb[1] = 0;
                rgb[2] = 0;

                //checking values from matrix
                switch ((Short) core.VisualizationGUI.matrix.getMatrix()[height][width]) {
                    case 0: {
                        //white
                        rgb[0] = 255;
                        rgb[1] = 255;
                        rgb[2] = 255;
                        break;
                    }
                    case 1: {
                        //red
                        rgb[0] = 255;
                        break;
                    }
                    case 2: {
                        //blue
                        rgb[2] = 255;
                        break;
                    }
                }
                //loop after height of pixel
                for (int j = height * VisualizationGUI.RESOLUTION + yAxisCount; j < height * VisualizationGUI.RESOLUTION + VisualizationGUI.RESOLUTION + yAxisCount; j++) {
                    //loop after width of pixel
                    for (int k = width * VisualizationGUI.RESOLUTION + xAxisCount; k < width * VisualizationGUI.RESOLUTION + VisualizationGUI.RESOLUTION + xAxisCount; k++) {
                        //loop after rgb
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
