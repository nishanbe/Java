package alpha;

import com.opencsv.exceptions.CsvValidationException;
import javafx.scene.chart.*;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RainfallVisualiser_alpha extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Rainfall Visualiser");
        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis = new CategoryAxis();
        final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        showBarChart(yAxis, xAxis, barChart);
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1200, 400);
        root.setCenter(barChart);
        stage.setScene(scene);
        stage.show();
    }

    private BarChart<String, Number> showBarChart(NumberAxis yAxis, CategoryAxis xAxis, BarChart<String, Number> barChart) throws IOException, CsvValidationException {

        barChart.getData().clear();
        yAxis.setLabel("Rainfall (mm)");
        xAxis.setLabel("Month/Year");
        barChart.setTitle("Sydney Rainfall Visualiser");

        XYChart.Series seriesTotal = new XYChart.Series();
        XYChart.Series seriesMin = new XYChart.Series();
        XYChart.Series seriesMax = new XYChart.Series();

        seriesTotal.setName("Total");
        seriesMin.setName("Min");
        seriesMax.setName("Max");

        try (CSVReader dataReader = new CSVReader(new FileReader("resources/Sydney_analysed.csv"))) {
            String[] nextLine;

            while ((nextLine = dataReader.readNext()) != null) {

                // Name data parts (year, month, total, min, max)
                String year = String.valueOf(nextLine[0]);
                int month = Integer.parseInt(nextLine[1]);
                double total = Double.parseDouble(nextLine[2]);
                double min = Double.parseDouble(nextLine[3]);
                double max = Double.parseDouble(nextLine[4]);
                String monthAndYear = month + " / " + year;

                // Represent series (categories: total, min, max)
                seriesTotal.getData().add(new XYChart.Data(monthAndYear, total));
                seriesMin.getData().add(new XYChart.Data(monthAndYear, min));
                seriesMax.getData().add(new XYChart.Data(monthAndYear, max));

            }
        }
        barChart.getData().addAll(seriesTotal, seriesMin, seriesMax);
        return barChart;
    }

    public static void main(String[] args) {
        launch(args);
    }
}