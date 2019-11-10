package BattleShipLab;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    BorderPane borderPane;
    TextArea catalog;

    @Override
    public void start(Stage primaryStage) throws Exception {
        borderPane = new BorderPane();
        catalog = new TextArea();

        catalog.setPrefHeight(100);
        catalog.setPrefWidth(200);
        HBox leftSide = new HBox(catalog);
        leftSide.setPadding(new Insets(10, 10, 10, 10));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button b = new Button(" ");
                b.setId("pos" + i + j);
                b.setPrefHeight(40);
                b.setPrefWidth(40);

                b.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Color c = Color.RED;
                        System.out.println(b.getId());
                        b.setStyle("-fx-background-color: #a30f0f");
                    }
                });

                gridPane.add(b, i, j);
            }
        }


        borderPane.setLeft(leftSide);
        borderPane.setCenter(gridPane);

        primaryStage.setTitle("BattleShip");
        primaryStage.setScene(new Scene(borderPane, 640, 395));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
