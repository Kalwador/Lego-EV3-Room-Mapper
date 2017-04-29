package window.canvas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import window.canvas.Axis;
import window.canvas.Grid;


public class ScrollablePane extends JLabel
        implements Scrollable,
        MouseMotionListener {
    
   
    public static utils.Camera camera;
    private int maxUnitIncrement = 1;
    private window.canvas.Axis axis;
    private window.canvas.Grid grid;
    

    public ScrollablePane(int m, Axis axis, Grid grid, utils.Camera camera) {
//        public ScrollablePane(int m,ImageIcon i) {
//        super(i);
//        super();
        
        
        setHorizontalAlignment(CENTER);
        setOpaque(true);
        setBackground(Color.yellow);
        
        maxUnitIncrement = m;

        //Let the user scroll by dragging to outside the window.
        setAutoscrolls(true); //enable synthetic drag events
        addMouseMotionListener(this); //handle mouse drags     

        add(new MyCanvas(),BorderLayout.CENTER);
    }

    //Methods required by the MouseMotionListener interface:
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //The user is dragging us, so scroll!
        Rectangle r = new Rectangle(e.getX(), e.getY(), 1, 1);
        scrollRectToVisible(r);
    }

    public Dimension getPreferredSize(matrix.RectangleMatrix matrix) {
        int width = matrix.getWidth() * core.VisualizationGUI.RESOLUTION;
        int height = matrix.getHeight() * core.VisualizationGUI.RESOLUTION;
        if (width < 320 && height < 480) {
            return new Dimension(320, 480);
        } else {
            return new Dimension(width, height);
        }
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return getPreferredSize();
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect,
            int orientation,
            int direction) {
        //Get the current position.
        int currentPosition = 0;
        if (orientation == SwingConstants.HORIZONTAL) {
            currentPosition = visibleRect.x;
        } else {
            currentPosition = visibleRect.y;
        }

        //Return the number of pixels between currentPosition
        //and the nearest tick mark in the indicated direction.
        if (direction < 0) {
            int newPosition = currentPosition
                    - (currentPosition / maxUnitIncrement)
                    * maxUnitIncrement;
            return (newPosition == 0) ? maxUnitIncrement : newPosition;
        } else {
            return ((currentPosition / maxUnitIncrement) + 1)
                    * maxUnitIncrement
                    - currentPosition;
        }
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect,
            int orientation,
            int direction) {
        if (orientation == SwingConstants.HORIZONTAL) {
            return visibleRect.width - maxUnitIncrement;
        } else {
            return visibleRect.height - maxUnitIncrement;
        }
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

    public void setMaxUnitIncrement(int pixels) {
        maxUnitIncrement = pixels;
        
        
    }
    
         class MyCanvas extends Canvas {

        @Override
        public void paint(Graphics graphics) {
            Graphics2D g =  (Graphics2D) graphics;
            grid.drawGrid(camera, g);
            axis.drawAxis(camera, g);          
        }
    }
}
