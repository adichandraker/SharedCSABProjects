package BattleShipLab;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    private static Controller myInstance;
    private static View v;
    private static Board b;

    public Controller() {
    }

    public static void main(String[] args) {
        myInstance = new Controller();
        b = new Board();
        v = new View(myInstance);
        v.startTheGUI(args);


    }

    public Board getBoard() {
        return b;
    }


    public int checkThatGuess() {
        return 1;
    }

    public void handle(ActionEvent event) {
        v.getCatalog().setText(" " + checkThatGuess());
    }
}
