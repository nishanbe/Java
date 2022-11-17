module RainfallAnalyser {
    requires java.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.web;
    requires commons.csv;
    requires java.desktop;
    requires com.opencsv;

    opens alpha;
    opens beta;

}