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

    //point marks the real starting point of the window on the screen
    private Point windowStartPoint;

    //full size of contentPane, how big is matrix * resolution
    private int contentPaneWidth;
    private int contentPaneHeight;

    //the size of the scrollbar window needed to calculate the number of images to be glued
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

        //Loops to scan the entire ContentPane window by moving  scroll bars
        //screening individual pieces and combining them into one large picture
        //These loops go through the entire width of ContentPane 
        int actualImageWidth = 0;
        int actualImageHeight = 0;

        //variables that determine how wide / long the screen should be made
        int makeScreenWidth = 0;
        int makeScreenHeight = 0;

        while (actualImageHeight < contentPaneHeight) {
            while (actualImageWidth < contentPaneWidth) {
                System.out.println("Pętla we H=" + actualImageHeight + "   W=" + actualImageWidth);
                //check that the width of the ContentPane is bigger than the visible width
                if ((contentPaneWidth - actualImageWidth) < scrollWidth) {
                    //full visible window width
                    makeScreenWidth = contentPaneWidth - actualImageWidth;
                } else {
                    //rest window width
                    makeScreenWidth = scrollWidth - 50;
                }

                //check that the height of the ContentPane is bigger than the visible height
                if ((contentPaneHeight - actualImageHeight) < scrollHeight) {
                    //full visible window height
                    makeScreenHeight = contentPaneHeight - actualImageHeight;
                } else {
                    //rest window height
                    makeScreenHeight = scrollHeight - 50;
                }

                //screenRect determines the area that is currently displayed on conntenPane
                Rectangle screenRect = new Rectangle(
                        windowStartPoint.x,
                        windowStartPoint.y,
                        scrollWidth,
                        scrollHeight);
//                        (makeScreenWidth + windowStartPoint.x),
//                        (makeScreenHeight + windowStartPoint.y));

                try {
                    //Method createScreenCapture creates screen about position set by screenRectangle
                    final BufferedImage tempImage = new Robot().createScreenCapture(screenRect);
                    //method connects images with new one 
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
                    }
                    case 1: {
                        //red
                        rgb[0] = 255;
                    }
                    case 2: {
                        //blue
                        rgb[2] = 255;
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
     * setting start point
     *
     */
    private void setStartPoint() {
        windowStartPoint = new Point(core.VisualizationGUI.visualizationGUI.contentPane.getLocation());
        SwingUtilities.convertPointToScreen(windowStartPoint, core.VisualizationGUI.visualizationGUI.contentPane);
    }

    /**
     * setting contentPane size
     *
     */
    private void setContentPaneSize() {
        contentPaneWidth = core.VisualizationGUI.visualizationGUI.contentPane.getPreferredSize().width;
        contentPaneHeight = core.VisualizationGUI.visualizationGUI.contentPane.getPreferredSize().height;
    }

    /**
     * setting scrollBar size
     *
     */
    private void setScrollSize() {
        //size of scrollBar window, needed to calculate the number of images to be glued
        scrollWidth = core.VisualizationGUI.visualizationGUI.scroll.getWidth();
        scrollHeight = core.VisualizationGUI.visualizationGUI.scroll.getHeight();
    }
}
