package beta;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

public class RainfallVisualiser_beta extends Application {

    String mode = "Monthly";

    String filePath = "resources/MountSheridanStationCNS.csv";

    public void start(Stage stage) throws Exception {
        stage.setTitle("Rainfall Visualiser");
        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis = new CategoryAxis();
        final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        barChart.setAnimated(false);

        BorderPane root = new BorderPane();
        Label heading = new Label("Welcome to the Rainfall Analyser");
        Label subheading = new Label("To start, click 'File' on the top left");
        Label aboutMessage = new Label("© Designed & developed by: Nishan Bedrossian\n");
        Label thankMessage = new Label("Special thanks to:\nDr. Dmitry Konovalov\nMr. Jason Holdsworth");
        heading.setFont(Font.font("Helvetica Nune", 34));
        subheading.setFont(Font.font("Helvetica Nune", 18));
        aboutMessage.setFont(Font.font("Helvetica Nune", 18));
        thankMessage.setFont(Font.font("Helvetica Nune", 14));

        heading.setStyle("-fx-padding: 20px;");
        subheading.setStyle("-fx-padding: 20px;");
        thankMessage.setStyle("-fx-padding: 20px;");

        FileInputStream input = new FileInputStream("resources/rainfall_logo.png");
        Image logo = new Image(input);
        ImageView imageView = new ImageView(logo);
        VBox messages = new VBox(heading, imageView, subheading);
        VBox creditMessages = new VBox(aboutMessage, thankMessage);
        messages.setAlignment(Pos.CENTER);
        creditMessages.setAlignment(Pos.CENTER);
        messages.setStyle("-fx-fill-height: 50px");
        root.setCenter(messages);

        Label statsLabel = new Label();
        statsLabel.setOpacity(0);
        Font f = new Font("Helvetica Nune", 12);
        statsLabel.setStyle("-fx-background-color:rgb(64,64,64);" + "-fx-text-fill: WHITE;" + "-fx-padding: 7;");
        statsLabel.setFont(f);

        Scene scene = new Scene(root, 1280, 600);

        HBox bottomPanelHBox = new HBox(); // top panel VBox contains the navigation bar and station loader HBox
        bottomPanelHBox.setBackground(new Background(new BackgroundFill(Color.rgb(104, 99, 105), null, null)));
        bottomPanelHBox.setStyle("-fx-padding: 15px;");

        HBox bottomLeftBox = new HBox();
        HBox bottomMiddleBox = new HBox();
        HBox bottomRightBox = new HBox();
        bottomLeftBox.setAlignment(Pos.CENTER_LEFT);
        bottomMiddleBox.setAlignment(Pos.CENTER);
        bottomRightBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(bottomLeftBox, Priority.ALWAYS);
        HBox.setHgrow(bottomMiddleBox, Priority.ALWAYS);
        HBox.setHgrow(bottomRightBox, Priority.ALWAYS);

        VBox topPanelVBox = new VBox(); // top panel VBox contains the navigation bar and station loader HBox
        FileChooser chooser = new FileChooser();

        Button findDataFiles = new Button("Find Data Files");

        Button clearButton = new Button("Clear");

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu aboutMenu = new Menu("About");
        MenuItem creditMenuItem = new MenuItem("Credit");
        Menu sampleMenuItem = new Menu("Sample Files");
        Menu recentMenuItem = new Menu("Recent files");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem exitMenuItem = new MenuItem("Exit");

        //Creating menu items for the sub item edit
        MenuItem sample1 = new MenuItem("Mount Sheridan");
        MenuItem sample2 = new MenuItem("Sydney Historic");

        //Toggle buttons
        Button monthlyButton = new Button("Monthly");
        monthlyButton.setStyle("-fx-background-color: #0098c8; -fx-text-fill: white;");

        Button yearlyButton = new Button("Yearly");

        topPanelVBox.getChildren().addAll(menuBar);
        bottomLeftBox.getChildren().addAll(monthlyButton, yearlyButton);
        bottomMiddleBox.getChildren().addAll(statsLabel);
        bottomRightBox.getChildren().addAll(findDataFiles, clearButton);
        bottomPanelHBox.getChildren().addAll(bottomLeftBox, bottomMiddleBox, bottomRightBox);

        root.setTop(topPanelVBox);
        root.setBottom(bottomPanelHBox);

        // Make to top menu bar and add: File
        menuBar.getMenus().addAll(fileMenu, aboutMenu);


        // For File add menu items to select from
        fileMenu.getItems().addAll(openMenuItem, sampleMenuItem, recentMenuItem, exitMenuItem);
        sampleMenuItem.getItems().addAll(sample1, sample2);
        aboutMenu.getItems().addAll(creditMenuItem);


        // ---------------- Actions ------------


        //Credit
        creditMenuItem.setOnAction(action -> {
            root.setCenter(creditMessages);
            statsLabel.setOpacity(0);
        });

        //Exit
        exitMenuItem.setOnAction(action -> Platform.exit());

        //Monthly
        monthYearToggle(yAxis, xAxis, barChart, root, monthlyButton, yearlyButton);

        //Yearly
        monthYearToggle(yAxis, xAxis, barChart, root, yearlyButton, monthlyButton);

        //Open
        openMenuItem.setOnAction(event -> {
            try {
                getNewFilePath(stage, chooser);

                //Stats
                formStats(statsLabel);
                //Analyse after check whether the mode is monthly or yearly
                modeAwareAnalysis(mode);

                //Generate menu item as a recent file
                String recentFileName = filePath.substring(filePath.lastIndexOf('/') + 1);
                MenuItem menuItem = new MenuItem(recentFileName);
                recentMenuItem.getItems().add(menuItem);

                drawAndTitleChart(yAxis, xAxis, barChart, root, filePath);
                refresh(stage);

            } catch (Exception e) {
                Label fileErrorMessage = new Label();
                fileErrorMessage.setText("File Error: Unable to load the file.");
                fileErrorMessage.setStyle("-fx-text-fill:rgb(134,0,0); -fx-font-size:18");
                root.setCenter(fileErrorMessage);

                statsLabel.setOpacity(0);
            }

        });

        //Sample files
        sample1.setOnAction(event -> {
            filePath = "resources/MountSheridanStationCNS.csv";
            formStats(statsLabel);
            modeAwareAnalysis(mode);
            drawAndTitleChart(yAxis, xAxis, barChart, root, filePath);
            refresh(stage);

        });

        sample2.setOnAction(event -> {
            filePath = "resources/Sydney_Historic.csv";
            String stats = showStatistic(filePath);
            statsLabel.setOpacity(1);
            statsLabel.setText(stats);
            modeAwareAnalysis(mode);
            drawAndTitleChart(yAxis, xAxis, barChart, root, filePath);
            refresh(stage);
        });

        recentMenuItem.setOnAction(event -> {
            drawAndTitleChart(yAxis, xAxis, barChart, root, filePath);
            refresh(stage);
        });
        stage.setScene(scene);

        try {
            showBarChart(yAxis, xAxis, barChart);
        } catch (Exception e) {
//            System.out.println("Unable to load the file.");
        }

        //Find Data Files Button link
        String bomURL = "http://www.bom.gov.au/climate/data/index.shtml";
        findDataFiles.setOnAction(e -> getHostServices().showDocument(bomURL));

        //Clear button
        clearButton.setOnAction(event -> {
            root.setCenter(clearData(barChart));
            statsLabel.setOpacity(0);
        });
        stage.show();
    }

    private void monthYearToggle(NumberAxis yAxis, CategoryAxis xAxis, BarChart<String, Number> barChart,
                                 BorderPane root, Button monthlyButton, Button yearlyButton) {
        monthlyButton.setOnAction(action -> {
            mode = detectButtonMode(monthlyButton, mode);
            filePath = filePath.replace("_analysed", "");
            monthlyButton.setStyle("-fx-background-color: #0098c8; -fx-text-fill: white;");
            yearlyButton.setStyle("-fx-background-color: white; -fx-text-fill: black;");
            modeAwareAnalysis(mode);
            drawAndTitleChart(yAxis, xAxis, barChart, root, filePath);
        });
    }

    private void formStats(Label statsLabel) {
        String stats = showStatistic(filePath);
        statsLabel.setStyle("-fx-background-color:rgb(64,64,64);" + "-fx-text-fill: WHITE;" + "-fx-padding: 7;");
        statsLabel.setOpacity(1);
        statsLabel.setText(stats);
    }

    private void modeAwareAnalysis(String mode) {
        if (mode.equals("Monthly")) {
            Analyser userFilePath = new Analyser(filePath);
            filePath = userFilePath.processFile(filePath);

        } else if (mode.equals("Yearly")) {
            YearlyAnalyser userFilePath = new YearlyAnalyser(filePath);
            filePath = userFilePath.processFile(filePath);
        }
    }

    private void refresh(Stage stage) {
        stage.hide();
        stage.show();
    }

    private void drawAndTitleChart(NumberAxis yAxis, CategoryAxis xAxis, BarChart<String, Number> barChart, BorderPane root, String filePath) {
        root.setCenter(clearData(barChart));
        root.setCenter(showBarChart(yAxis, xAxis, barChart));
        String formattedName = "Station: " + filePath.substring(filePath.lastIndexOf('/') + 1,
                filePath.lastIndexOf('_')).replace("_", " ") + " (" + mode + " Analysis)";
        barChart.setTitle(getFileName(formattedName));
    }

    private void getNewFilePath(Stage stage, FileChooser chooser) {
        File file = chooser.showOpenDialog(stage);
        String path = file.getAbsolutePath();
        filePath = path;
    }

    private BarChart<String, Number> showBarChart(NumberAxis yAxis, CategoryAxis xAxis, BarChart<String, Number> barChart) {

        yAxis.setLabel("Rainfall (mm)");
        xAxis.setLabel("Timeline");
        barChart.setTitle("Rainfall Visualiser");

        XYChart.Series seriesTotal = new XYChart.Series();
        XYChart.Series seriesMin = new XYChart.Series();
        XYChart.Series seriesMax = new XYChart.Series();

        seriesTotal.setName("Total");
        seriesMin.setName("Min");
        seriesMax.setName("Max");

        try {

            Reader in = new FileReader(filePath);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withSkipHeaderRecord().withHeader("Year", "Month", "Total",
                    "Min", "Max").parse(in);
            for (CSVRecord record : records) {
                // Convert days months and years from stings to ints
                int year = Integer.parseInt(record.get("Year"));
                int month = Integer.parseInt(record.get("Month"));
                double total = Double.parseDouble(record.get("Total"));
                double min = Double.parseDouble(record.get("Min"));
                double max = Double.parseDouble(record.get("Max"));
                String monthAndYear = null;
                if (mode.equals("Monthly")) {
                    monthAndYear = month + " / " + year;
                } else if (mode.equals("Yearly")) {
                    monthAndYear = String.valueOf(year);
                }

                // Represent series (categories: total, min, max)
                seriesTotal.getData().add(new XYChart.Data(monthAndYear, total));
                seriesMin.getData().add(new XYChart.Data(monthAndYear, min));
                seriesMax.getData().add(new XYChart.Data(monthAndYear, max));

            }
            barChart.getData().addAll(seriesTotal, seriesMin, seriesMax);
        } catch (Exception e) {
//            System.out.println("File Error Occurred");

        }

        createToolTip(barChart);

        return barChart;
    }

    private void createToolTip(BarChart<String, Number> barChart) {
        for (XYChart.Series<String, Number> series : barChart.getData()) {
            for (XYChart.Data<String, Number> data : series.getData()) {
                Tooltip tooltip = new Tooltip();
                tooltip.setShowDelay(Duration.seconds(0));
                tooltip.setHideDelay(Duration.seconds(2));
                tooltip.setFont(Font.font("", 14));

                tooltip.setText(
                        "Details\n-------------------\n" +
                                "Period:\t" + data.getXValue() +
                                "\n" + series.getName() + ":\t" + data.getYValue().toString() + "mm");

                Tooltip.install(data.getNode(), tooltip);
            }
        }
    }

    private Node clearData(BarChart<String, Number> barChart) {
        barChart.getData().clear();
        return null;
    }

    private static String getFileName(String path) {
        File f = new File(path);
        return f.getName();
    }

    private String detectButtonMode(Button theButton, String mode) {
        mode = theButton.getText();
        return mode;
    }

    private String showStatistic(String filePath) {
        Statistics stats = new Statistics(filePath);
        try {
            stats.countRecord();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stats.getSummaryInline();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
