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

public class View extends Application {

    private static Controller c;
    private BorderPane borderPane;
    private TextArea catalog;
    private GridPane gridPane;

    public View(Controller c) {
        this.c = c;
    }
    public View() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        borderPane = new BorderPane();
        catalog = new TextArea();
        catalog.setEditable(false);
        catalog.setText("Welcome to Battleship");

        catalog.setPrefHeight(100);
        catalog.setPrefWidth(200);
        catalog.setPadding(new Insets(10, 10, 10, 10));

        gridPane = new GridPane();
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
                        String splitThis = b.getId();
                        String [] numbers = splitThis.split("");
                        int xCoor = Integer.parseInt(numbers[3]);
                        int yCoor = Integer.parseInt(numbers[4]);

                        if(c.checkThatGuess(xCoor, yCoor) == 0 ) {
                            catalog.setText("miss");
                            b.setStyle("-fx-background-color: #a30f0f");
                        }
                        else if(c.checkThatGuess(xCoor, yCoor) == 1){
                            catalog.setText("hit");
                            b.setStyle("-fx-background-color: #0fa616");
                        }else {
                            catalog.setText("weird");
                        }
                    }
                });

                gridPane.add(b, i, j);
            }
        }


        borderPane.setLeft(catalog);
        borderPane.setCenter(gridPane);

        primaryStage.setTitle("BattleShip");
        primaryStage.setScene(new Scene(borderPane, 640, 395));
        primaryStage.show();
    }

    public static void startTheGUI(String[] args) {
        launch(args);
    }

}
