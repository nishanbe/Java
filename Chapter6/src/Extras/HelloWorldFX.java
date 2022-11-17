package Extras;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;

public class HelloWorldFX extends Application {
//    private Paint paint;

    public void start(Stage stage) {

        Label message = new Label("First FX Application!");
        message.setFont( new Font(40) );
//        message.setTextFill(Color.color(200,200,200));

        Label message2 = new Label("Second FX");
        message2.setFont(new Font(20));

        Button helloButton = new Button("Say Hello");
        helloButton.setOnAction( e -> message.setText("Hello World!") );

        Button goodbyeButton = new Button("Say Goodbye");
        goodbyeButton.setOnAction( e -> message.setText("Goodbye!!") );

        Button quitButton = new Button("Quit");
        quitButton.setOnAction( e -> Platform.exit() );

        Button noMore = new Button("No More");
//        Color myColor = Color.color(222, 141, 23, 1);
        noMore.setOnAction(e -> message2.setText("Random number from you: " + (int)(Math.random()*100)));

        Button randomBtn = new Button("Randomise");
        randomBtn.setOnMouseClicked(e -> message2.setText("This is another random number: " + (int)(Math.random()*50)));

        HBox buttonBar = new HBox( 20, helloButton, goodbyeButton, quitButton, noMore, randomBtn);
        buttonBar.setAlignment(Pos.CENTER);
//        setPaint();

        BorderPane root = new BorderPane();
//        root.setRight(myColor);
        root.setTop(message2);
        root.setCenter(message);
        root.setBottom(buttonBar);

        Scene scene = new Scene(root, 650, 200);
        stage.setScene(scene);
        stage.setTitle("JavaFX Test1");
        stage.show();

    } // end start();

    public static void main(String[] args) {
        launch(args);  // Run this Application.
    }

} // end class HelloWorldFX