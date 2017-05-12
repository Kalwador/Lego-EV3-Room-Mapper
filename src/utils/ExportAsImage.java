/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import core.VisualizationGUI;
import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Utile to Export Content View as various types
 *
 * @author Kalvador
 */
public class ExportAsImage {

    //punkt pt wyznacza realny punkt rozpoczoczęcia się okna na ekarnie
    private Point windowStartPoint;

    //pełna wielkość contentPane, czyli jak duża jest macież * resolution
    private int contentPaneWidth;
    private int contentPaneHeight;

    //wielkość okna scroll bar, potrzebne by wyliczyć ilość obrazków do sklejenia
    int scrollWidth;
    int scrollHeight;

    public void ScreenView() {
        core.VisualizationGUI.visualizationGUI.scroll.getViewport().setViewPosition(new Point(0, 0));

        setStartPoint();
        setContentPaneSize();
        setScrollSize();

        //create a new buffer and draw two image into the new image
        BufferedImage fullImage = new BufferedImage(contentPaneWidth, contentPaneHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphic = fullImage.createGraphics();

        //Pętle do przeskanowania całego okna ContentPane, przesówając połozenie ScrollBarów
        //Screenując poszczególne kawałki i łącząc je w jeden duży obraz
        //pętla te przechodzi po całej szerokośći ContentPane
        int actualImageWidth = 0;
        int actualImageHeight = 0;

        //zmienne które wyznaczają jak szeroki/długi ma być wykonany screen
        int makeScreenWidth = 0;
        int makeScreenHeight = 0;

        while (actualImageHeight < contentPaneHeight) {
            while (actualImageWidth < contentPaneWidth) {
                System.out.println("Pętla we H=" + actualImageHeight + "   W=" + actualImageWidth);
                //sprawdzenie czy pozostała szerokość ContentPane jest jest większa od widocznej
                if ((contentPaneWidth - actualImageWidth) < scrollWidth) {
                    //pełna widoczna szerokośc okna
                    makeScreenWidth = contentPaneWidth - actualImageWidth;
                } else {
                    //pozostała szerokośc okna
                    makeScreenWidth = scrollWidth - 50;
                }

                //sprawdzenie czy pozostała wysokość ContentPane jest jest większa od widocznej
                if ((contentPaneHeight - actualImageHeight) < scrollHeight) {
                    //pełna widoczna wyskokość okna
                    makeScreenHeight = contentPaneHeight - actualImageHeight;
                } else {
                    //pozostała wysokość okna
                    makeScreenHeight = scrollHeight - 50;
                }

                //screenRect wyznacza obszar jaki obecnie jest wyświetlany na conntenPane
                Rectangle screenRect = new Rectangle(
                        windowStartPoint.x,
                        windowStartPoint.y,
                        scrollWidth,
                        scrollHeight);
//                        (makeScreenWidth + windowStartPoint.x),
//                        (makeScreenHeight + windowStartPoint.y));

                try {
                    //Metoda createScreenCapture tworzy screen ekranu o położeniu wyznaczonym przez screenRectangle
                    final BufferedImage tempImage = new Robot().createScreenCapture(screenRect);
                    //metoda ta łączy dotąd zrobione obrazy z nowym
                    graphic.drawImage(tempImage, null, actualImageWidth, actualImageHeight);
                } catch (AWTException ex) {
                    System.out.println("AWTE Exception - image join failure");

                    actualImageWidth += makeScreenWidth;
//                core.VisualizationGUI.scroll.getHorizontalScrollBar().setValue(actualImageWidth);
                    core.VisualizationGUI.visualizationGUI.scroll.getViewport().setViewPosition(new Point(actualImageWidth, actualImageHeight));
//                core.VisualizationGUI.scroll.repaint();
                }
                actualImageWidth = 0;
                actualImageHeight += makeScreenHeight;

//            core.VisualizationGUI.scroll.getHorizontalScrollBar().setValue(actualImageWidth);
                core.VisualizationGUI.visualizationGUI.scroll.getViewport().setViewPosition(new Point(actualImageWidth, actualImageHeight));
                core.VisualizationGUI.visualizationGUI.scroll.repaint();
            }
            graphic.dispose();
//        try {
//            ImageIO.write(fullImage, "png", new File("export/export.png"));
//        } catch (IOException ex) {
//            System.out.println("IO Exception - image save failure");
//        }
////        przemalowanie scrolla by unikąć NPE
//        core.VisualizationGUI.scroll.getHorizontalScrollBar()
//                .setValue(0);
//        core.VisualizationGUI.scroll.getVerticalScrollBar()
//                .setValue(0);
            core.VisualizationGUI.visualizationGUI.scroll.repaint();
        }
    }

    /**
     * Save Content pane as JPG Image
     */
    public void JPG() {
        BufferedImage image = getMatrixAsBufferedImage();
        FileFilter fileFilter = new FileNameExtensionFilter(".jpg", "JPG Image");
        File file = chooseFileJPG(fileFilter);
        try {
            ImageIO.write(image, "jpg", new File(file.getCanonicalPath() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save Content pane as PNG Image
     */
    public void PNG() {
        BufferedImage image = getMatrixAsBufferedImage();
        FileFilter fileFilter = new FileNameExtensionFilter(".png", "PNG Image");
        File file = chooseFileJPG(fileFilter);
        try {
            ImageIO.write(image, "png", new File(file.getCanonicalPath() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save Content pane as BMP Image
     */
    public void BMP() {
        BufferedImage image = getMatrixAsBufferedImage();
        FileFilter fileFilter = new FileNameExtensionFilter(".bmp", "BMP Image");
        File file = chooseFileJPG(fileFilter);
        try {
            System.out.println(file.getCanonicalPath());
            ImageIO.write(image, "bmp", new File(file.getCanonicalPath() + ".bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Open Save dialog window and create new file
     *
     * @param fileFilter What type of should be saved
     * @return new File to save
     */
    public File chooseFileJPG(FileFilter fileFilter) {
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

        int[] data = new int[arrayWidth * arrayHeight * 2 * VisualizationGUI.RESOLUTION];

        int red = 0;
        int green = 0;
        int blue = 0;

        BufferedImage image = new BufferedImage(
                arrayWidth * VisualizationGUI.RESOLUTION,
                arrayHeight * VisualizationGUI.RESOLUTION,
                BufferedImage.TYPE_3BYTE_BGR);

        int[] rgb = new int[3];

        for (int height = 0; height < arrayWidth * VisualizationGUI.RESOLUTION; height += VisualizationGUI.RESOLUTION) {
            for (int width = 0; width < arrayWidth * VisualizationGUI.RESOLUTION; width += VisualizationGUI.RESOLUTION) {

                //resetowanie wartości
                rgb[0] = 0;
                rgb[1] = 0;
                rgb[2] = 0;

                //sprawdzanie wartośći z macierzy
                switch ((Short) core.VisualizationGUI.matrix.getMatrix()[height / VisualizationGUI.RESOLUTION][width / VisualizationGUI.RESOLUTION]) {
                    case 0: {
                        //biały
                        rgb[0] = 255;
                        rgb[1] = 255;
                        rgb[2] = 255;
                    }
                    case 1: {
                        //czerwony
                        rgb[0] = 255;
                    }
                    case 2: {
                        //niebieski
                        rgb[2] = 255;
                    }
                }

                //pętla po wysokości pixela
                for (int j = height; j < (height + VisualizationGUI.RESOLUTION); j++) {
                    //pętla po szerokośći pixela
                    for (int k = width; k < (width + VisualizationGUI.RESOLUTION); k++) {
                        //pętla po rgb
                        for (int l = 0; l < 3; l++) {
                            //rysuje tylko rgb jest różne od zera
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

    private void setStartPoint() {
        windowStartPoint = new Point(core.VisualizationGUI.visualizationGUI.contentPane.getLocation());
        SwingUtilities.convertPointToScreen(windowStartPoint, core.VisualizationGUI.visualizationGUI.contentPane);
    }

    private void setContentPaneSize() {
        contentPaneWidth = core.VisualizationGUI.visualizationGUI.contentPane.getPreferredSize().width;
        contentPaneHeight = core.VisualizationGUI.visualizationGUI.contentPane.getPreferredSize().height;
    }

    private void setScrollSize() {
        //wielkość okna scroll bar, potrzebne by wyliczyć ilość obrazków do sklejenia
        scrollWidth = core.VisualizationGUI.visualizationGUI.scroll.getWidth();
        scrollHeight = core.VisualizationGUI.visualizationGUI.scroll.getHeight();
    }
}
