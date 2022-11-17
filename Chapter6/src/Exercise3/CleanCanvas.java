package Exercise3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;  // For key press
import javafx.scene.input.MouseEvent;   // For mouse actions

public class CleanCanvas extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //Variables
    private Canvas canvas;
    GraphicsContext g;
    boolean redClicked = false;

    public void start(Stage stage) {
        canvas = new Canvas(100, 100);
        canvas.setOnMousePressed(e -> mousePressed(e));
        canvas.setOnMouseDragged(e -> mouseDragged(e));
        canvas.setOnMouseReleased(e -> mouseReleased(e));

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Title");
        stage.setResizable(false);
        stage.show();
        draw();

    }

    // Draw shapes with size and colours specified
    private void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();

        // Use "g" to create a shape. Always start with g.setFill
        g.setFill(Color.RED);
        g.fillRect(0, 0, 20, 20);

        g.setFill(Color.BLUE);
        g.fillOval(0, 30, 20, 20);

        g.setFill(Color.rgb(24,130,0));
        g.fillPolygon(new double[]{0, 10, 20}, new double[]{80, 60, 80}, 3);
    }

    // Function to do when mouse is pressed
    public void mousePressed(MouseEvent evt) {
        double x = evt.getX();  // Location where user clicked.
        double y = evt.getY();

        // Detect clicked location
        if(x <20 && y<20){
            redClicked = true;
            System.out.println("Red Clicked");
        }
    }

    // Function to do when mouse is dragged
    public void mouseDragged(MouseEvent evt) {
        g = canvas.getGraphicsContext2D();
        double x = evt.getX();  // Location where user clicked.
        double y = evt.getY();


        g.setFill(Color.WHITE);
        g.fillRect(0, 0, 100, 100);

        g.setFill(Color.RED);
        g.fillRect(x-10, y-10, 20, 20);
    }

    // Function to do when mouse is released
    public void mouseReleased(MouseEvent evt) {
        g.setFill(Color.YELLOW);
        g.fillRect(0, 0, 100, 100);
    }
}
