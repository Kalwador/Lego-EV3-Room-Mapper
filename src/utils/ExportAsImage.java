/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

/**
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

        //do testów
        int i = 0;
        long k;

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

                //Do testów
                i++;

                try {
                    //Metoda createScreenCapture tworzy screen ekranu o położeniu wyznaczonym przez screenRectangle
                    final BufferedImage tempImage = new Robot().createScreenCapture(screenRect);
                    //metoda ta łączy dotąd zrobione obrazy z nowym
                    graphic.drawImage(tempImage, null, actualImageWidth, actualImageHeight);
                    ImageIO.write(tempImage, "png", new File("export/" + i + ".png"));
                } catch (AWTException ex) {
                    System.out.println("AWTE Exception - image join failure");
                } catch (IOException ex) {
                    System.out.println("IO Exception - image save failure");
                }

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

    public void JPG() {
        BufferedImage image = getMatrixAsBufferedImage();
        
        try {
            ImageIO.write(image, "jpg", new File("export/rgb.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage getMatrixAsBufferedImage() {

        int arrayWidth = core.VisualizationGUI.visualizationGUI.matrix.getWidth();
        int arrayHeight = core.VisualizationGUI.visualizationGUI.matrix.getHeight();

        //Czysty putno na którym zmieniane będą kolory pixeli na odpowiadające im dane z macierzy
        BufferedImage image = new BufferedImage(arrayWidth, arrayHeight, BufferedImage.TYPE_3BYTE_BGR);

        //pętle do iteracji po macierzy
        for (int height = 0; height < arrayWidth; height++) {
            for (int width = 0; width < arrayWidth; width++) {
                switch ((Short) core.VisualizationGUI.visualizationGUI.matrix.getMatrix()[height][width]) {
                    case 0: {
                        //przypdek 0 - kolor biały
                        image.getRaster().setSample(height, width, 0, 500);
                        image.getRaster().setSample(height, width, 1, 500);
                        image.getRaster().setSample(height, width, 2, 500);
                    }
                    case 1: {
                        //przypdek 1 - kolor czerwony
                        image.getRaster().setSample(height, width, 0, 125);
                    }
                    case 2: {
                        //przypdek 2 - kolor niebieski
                        image.getRaster().setSample(height, width, 2, 125);
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
