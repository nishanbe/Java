package Exercise2;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

/**
 * A program that shows a red square and a blue square that the user
 * can drag with the mouse.   The user can drag the squares off
 * the canvas and drop them.  Pressing the escape key will restore
 * both squares to their original positions.
 */
public class DragTwoSquares extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //---------------------------------------------------------------------


    private double xRed = 10, yRed = 10;   // Coords of top-left corner of the red square.
    private double xBlue = 50, yBlue = 10;   // Coords of top-left corner of the blue square.

    private Canvas canvas;  // The canvas where the sqaures are drawn.


    /**
     *  The start method sets up the GUI.  It adds mouse event handlers to
     *  the canvas to implement dragging.  It adds a key pressed handler
     *  to the scene that will restore the squares to their original
     *  positions when the user presses the escape key.
     */
    public void start(Stage stage) {

        canvas = new Canvas(300,250);
        draw(); // show squares in original positions

        canvas.setOnMousePressed( e -> mousePressed(e) );
        canvas.setOnMouseDragged( e -> mouseDragged(e) );
        canvas.setOnMouseReleased( e -> mouseReleased(e) );

        Pane root = new Pane(canvas);

        Scene scene = new Scene(root);

        scene.setOnKeyPressed( e -> {
            // If user pressed ESCAPE, move squares
            // back to starting positions, and redraw.
            if ( e.getCode() == KeyCode.ESCAPE ) {
                xRed = 10;
                yRed = 10;
                xBlue = 50;
                yBlue = 10;
                draw();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Drag the squares!");
        stage.setResizable(false);
        stage.show();
    }


    /**
     * Draw the canvas, showing the squares in their current positions.
     */
    private void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.rgb(230,255,230)); // light green
        g.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        g.setFill(Color.RED);
        g.fillRect(xRed, yRed, 30, 30);
        g.setFill(Color.BLUE);
        g.fillRect(xBlue, yBlue, 30, 30);
    }


    //-----------------  Variables and methods for responding to drags -----------

    private boolean dragging;      // Set to true when a drag is in progress.

    private boolean dragRedSquare; // True if red square is being dragged, false
    //    if blue square is being dragged.

    private double offsetX, offsetY;  // Offset of mouse-click coordinates from the
    //   top-left corner of the square that was
    //   clicked.

    /**
     * Respond when the user presses the mouse on the canvas.
     * Check which square the user clicked, if any, and start
     * dragging that square.
     */
    public void mousePressed(MouseEvent evt) {

        if (dragging)  // Exit if a drag is already in progress.
            return;

        double x = evt.getX();  // Location where user clicked.
        double y = evt.getY();

        if (x >= xBlue && x < xBlue +30 && y >= yBlue && y < yBlue+30) {
            // It's the blue square (which should be checked first,
            // since it's drawn on top of the red square.)
            dragging = true;
            dragRedSquare = false;
            offsetX = x - xBlue;  // Distance from corner of square to (x,y).
            offsetY = y - yBlue;
        }
        else if (x >= xRed && x < xRed +30 && y >= yRed && y < yRed+30) {
            // It's the red square.
            dragging = true;
            dragRedSquare = true;
            offsetX = x - xRed;  // Distance from corner of square to (x,y).
            offsetY = y - yRed;
        }

    }

    /**
     * Dragging stops when user releases the mouse button.
     */
    public void mouseReleased(MouseEvent evt) {
        dragging = false;
    }

    /**
     * Respond when the user drags the mouse.  If a square is
     * not being dragged, then exit. Otherwise, change the position
     * of the square that is being dragged to match the position
     * of the mouse.  Note that the corner of the square is placed
     * in the same relative position with respect to the mouse that it
     * had when the user started dragging it.
     */
    public void mouseDragged(MouseEvent evt) {
        if (dragging == false)
            return;
        double x = evt.getX();
        double y = evt.getY();
        if (dragRedSquare) {  // Move the red square.
            xRed = x - offsetX;
            yRed = y - offsetY;
        }
        else {   // Move the blue square.
            xBlue = x - offsetX;
            yBlue = y - offsetY;
        }
        draw();  // (Calls the draw() to show squares in new positions.)
    }

} // end class DragTwoSquares
