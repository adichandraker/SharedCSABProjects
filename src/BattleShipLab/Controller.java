package BattleShipLab;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    private static View v;
    private static Board b;

    public static void main(String[] args) {
        b = new Board();
        v = new View();
        v.startTheGUI(args);


    }

    public Board getBoard() {
        return b;
    }


    public int checkThatGuess() {
        return 1;
    }
}
