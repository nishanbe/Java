package Exercise4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.animation.AnimationTimer;


import java.lang.reflect.GenericArrayType;

public class Exercise4 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private GraphicsContext g;
    private Canvas canvas;
    private int die1;
    private int die2;
    private Button button;
    private int frame;

    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            die1 = (int)(Math.random()*6) + 1;
            die2 = (int)(Math.random()*6) + 1;
            draw();
            frame++;
            if (frame == 100) {
                timer.stop();
                button.setDisable(false);
            }
        }
    };

    public void start(Stage stage) {
        canvas = new Canvas(400, 400);
        canvas.setOnMousePressed(e -> mousePressed(e));

        BorderPane root = new BorderPane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Dice");
        stage.setResizable(true);

        button = new Button("Roll!");
        button.setMinWidth(80);
        button.setText("Roll");
        HBox buttonBar = new HBox( 20, button);
        buttonBar.setAlignment(Pos.CENTER);
        button.setTextFill(Color.BLACK);
        button.setOnAction( e -> rollTheDice() ); // When clicked, roll the dice.

        root.setCenter(canvas);
//        root.setBottom(button);
        root.setBottom(buttonBar);

        stage.show();
        rollTheDice();
        draw();

    }

    private void draw() {
        g = canvas.getGraphicsContext2D();
        g.setFill(Color.rgb(255,255,255));
        g.fillRect(0, 0, 800, 600);

        createDie(g, die1, 20, 20);
        createDie(g, die2, 80, 20);

    }

    private void createDie(GraphicsContext g, int number, int x, int y) {
        g.setFill(Color.YELLOW);
        g.fillRoundRect(x-1, y-1, 38, 38, 20, 20);

        g.setStroke(Color.BLACK);
        g.strokeRoundRect(x-1, y-1, 38, 38, 20, 20);

        g.setFill(Color.BLACK);
        if (number > 1)  // upper left dot
            g.fillOval(x+3, y+3, 9, 9);
        if (number > 3)  // upper right dot
            g.fillOval(x+23, y+3, 9, 9);
        if (number == 6) // middle left dot
            g.fillOval(x+3, y+13, 9, 9);
        if (number % 2 == 1) // middle dot (for odd-numbered val's)
            g.fillOval(x+13, y+13, 9, 9);
        if (number == 6) // middle right dot
            g.fillOval(x+23, y+13, 9, 9);
        if (number > 3)  // bottom left dot
            g.fillOval(x+3, y+23, 9, 9);
        if (number > 1)  // bottom right dot
            g.fillOval(x+23, y+23, 9,9);
    }

    private void rollTheDice() {
//        die1 = (int) (Math.random() * 6 + 1);
//        die2 = (int) (Math.random() * 6 + 1);
//        draw();
        frame = 0;
        button.setDisable(true);
        timer.start(); // start an animation
    }

    public void mousePressed(MouseEvent evt) {
        rollTheDice();
        System.out.print(die1);
        System.out.print(", " +die2 + "\n");
    }
}
