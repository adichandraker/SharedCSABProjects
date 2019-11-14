package BattleShipLab;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class Controller{

    private static Controller myInstance = new Controller();
    private static View v = new View(myInstance);
    private static Board b;

    public static void main(String[] args) {
        v.startTheGUI(args);
        b.setDefaultShips();

    }


}
