package Exercise2;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;


/**
 * A simple demonstration of MouseEvents.  Shapes are drawn
 * on a white background when the user clicks the canvas.  If
 * the user right-clicks, the canvas is cleared.  If the user
 * shift-clicks the canvas, a blue oval is drawn.  Otherwise,
 * when the user clicks, a red rectangle is drawn.  If the user
 * did not right-click, then ovals or rects continue to be
 * drawn as the user drags the mouse.
 */
public class Exercise2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private double xRed;
    private double yRed;
    private double xBlue;
    private double yBlue;

    private boolean dragging;
    private double prevShapeX, prevShapeY;
    private GraphicsContext g;
    private Canvas canvas;  // The canvas/background

    public void start(Stage stage) {

        Canvas canvas = new Canvas(500, 380);

        g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, 500, 380);
        g.setStroke(Color.BLACK); // stroke color never changes

        canvas.setOnMouseDragged(e -> mouseDragged(e));

        initMyShapes();

        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-color: black; -fx-border-width: 12px");

        Scene scene = new Scene(root);
//        scene.setOnKeyPressed(e -> myKeyPressed(e));
        scene.setOnKeyPressed(e -> {
            // If user pressed ESCAPE, move squares
            // back to starting positions, and redraw.
            System.out.println(e.getCode() + " pressed");
            if (e.getCode() == KeyCode.ESCAPE) {
                xRed = 10;
                yRed = 10;
                xBlue = 50;
                yBlue = 10;
                clearMyShape(xRed, yRed);
                initMyShapes();
            }
        });
        stage.setScene(scene);
        stage.setTitle("Mouse Drag Demo");
        stage.setResizable(false);
        stage.show();

    } // end start()

    private void drawCanvas() {
        g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, 500, 380);
        g.setStroke(Color.BLACK); // stroke color never changes
    }


    private void initMyShapes() {
        xRed = 50;
        yRed = 50;
        xBlue = 150;
        yBlue = 50;
        drawMyShape(xRed, yRed, Color.RED);
        drawMyShape(xBlue, yBlue, Color.BLUE);

    }

    public void mouseDragged(MouseEvent evt) {
        double x = evt.getX();  // x-coordinate where user clicked.
        double y = evt.getY();  // y-coordinate where user clicked.
        clearMyShape(xRed, yRed);
        if (Math.abs(x - xRed) > 20 || Math.abs(y - yRed) > 20) {
            return;
        } else {
            xRed = x;
            yRed = y;
        }


        clearMyShape(xRed, yRed);

        if (evt.isShiftDown()) {
            drawMyShape(x, y, Color.BLUE);
        } else {
            // Draw a red rectangle centered at (x,y).
            drawMyShape(x, y, Color.RED);
        }

    } // end mouseDragged();

    // Draw shapes bases on given parameters
    private void drawMyShape(double x, double y, Color myColor) {
        g.setFill(myColor);
        g.fillRect(x - 30, y - 15, 60, 30);
        g.strokeRect(x - 30, y - 15, 60, 30);

    }

    // Clear shapes
    private void clearMyShape(double x, double y) {
        g.setFill(Color.WHITE);
        g.fillRect(x - 31, y - 16, 500, 380);
//        canvasGraphics.strokeRect( x - 31, y - 16, 120, 60 );

    }


} // end class SimpleStamperWithDrag