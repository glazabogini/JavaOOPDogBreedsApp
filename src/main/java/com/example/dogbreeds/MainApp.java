package com.example.dogbreeds;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import javafx.scene.image.Image;

public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Dog Breeds Analysis");
        // Set the window icon
        primaryStage.getIcons().add(new Image(MainApp.class.getResourceAsStream("/icon.png")));
        // Fetch data from the Breeds table
        List<DogBreed> breeds = DataQuery.getDogBreeds();

        // Create and set main scene
        primaryStage.setScene(createMainScene(breeds));
        primaryStage.show();
    }

    private Scene createMainScene(List<DogBreed> breeds) {
        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);

        Button showBarChartButton = new Button("Show Bar Chart");
        showBarChartButton.setOnAction(e -> primaryStage.setScene(createBarChartScene(breeds)));
        mainLayout.getChildren().add(showBarChartButton);

        Button showPieChartButton = new Button("Show Pie Chart");
        showPieChartButton.setOnAction(e -> primaryStage.setScene(createPieChartScene(breeds)));
        mainLayout.getChildren().add(showPieChartButton);

        Button showTableViewButton = new Button("Show Table View");
        showTableViewButton.setOnAction(e -> primaryStage.setScene(createTableViewScene(breeds)));
        mainLayout.getChildren().add(showTableViewButton);

        Scene scene = new Scene(mainLayout, 500, 500);

        // Apply the stylesheet
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        return scene;
    }

    private Scene createBarChartScene(List<DogBreed> breeds) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Breed");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Number of Owners");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Dog Breed Popularity");

        for (DogBreed breed : breeds) {
            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data<>(breed.getBreedName(), breed.getNumberOfOwners()));
            barChart.getData().add(series);
        }

        VBox layout = new VBox(20);
        barChart.setLegendVisible(false);
        layout.getChildren().add(barChart);

        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(e -> primaryStage.setScene(createMainScene(breeds)));
        layout.getChildren().add(backButton);

        Scene scene = new Scene(layout, 800, 600);

        // Apply the stylesheet
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        return scene;
    }

    private Scene createPieChartScene(List<DogBreed> breeds) {
        // Structuring data using DP
        Map<String, Integer> originPopularity = new HashMap<>();
        for (DogBreed breed : breeds){
            String country = breed.getOrigin();
            originPopularity.put(country, originPopularity.getOrDefault(country, 0) + 1);
        }

        // Set up the pie chart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Map.Entry<String, Integer> entry : originPopularity.entrySet()) {
            pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }

        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Dog Breeds Origin");

        VBox layout = new VBox(20);
        layout.getChildren().add(pieChart);

        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(e -> primaryStage.setScene(createMainScene(breeds)));
        layout.getChildren().add(backButton);

        Scene scene = new Scene(layout, 800, 600);

        // Apply the stylesheet
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        return scene;
    }

    private Scene createTableViewScene(List<DogBreed> breeds) {
        TableView<DogBreed> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<DogBreed> data = FXCollections.observableArrayList(breeds);

        TableColumn<DogBreed, String> breedNameColumn = new TableColumn<>("Breed Name");
        breedNameColumn.setCellValueFactory(new PropertyValueFactory<>("breedName"));

        TableColumn<DogBreed, String> originColumn = new TableColumn<>("Origin");
        originColumn.setCellValueFactory(new PropertyValueFactory<>("origin"));

        TableColumn<DogBreed, String> sizeColumn = new TableColumn<>("Size");
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));

        TableColumn<DogBreed, Number> numberOfOwnersColumn = new TableColumn<>("Number of Owners");
        numberOfOwnersColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfOwners"));

        table.getColumns().add(breedNameColumn);
        table.getColumns().add(originColumn);
        table.getColumns().add(sizeColumn);
        table.getColumns().add(numberOfOwnersColumn);
        table.setItems(data);

        VBox layout = new VBox(20);
        layout.getChildren().add(table);

        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(e -> primaryStage.setScene(createMainScene(breeds)));
        layout.getChildren().add(backButton);

        Scene scene = new Scene(layout, 800, 600);

        // Apply the stylesheet
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
