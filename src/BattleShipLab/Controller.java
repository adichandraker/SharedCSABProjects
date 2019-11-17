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
        b.getGrid()[0][0] = new Coordinate(0,0,1);
        b.getGrid()[1][0] = new Coordinate(1,0,1);
        b.getGrid()[2][0] = new Coordinate(1,0,1);
        b.getGrid()[2][1] = new Coordinate(1,0,1);
        v = new View(myInstance);
        v.startTheGUI(args);


    }

    public Board getBoard() {
        return b;
    }

    public Coordinate getCoordinate(int xCoor, int yCoor){
        return b.getGrid()[xCoor][yCoor];
    }


    public int checkThatGuess(int xCoor, int yCoor) {

        if (b.getGrid()[xCoor][yCoor] == null) {
            b.getGrid()[xCoor][yCoor] = new Coordinate(xCoor, yCoor);
        }

        Coordinate checkCoordinate = b.getGrid()[xCoor][yCoor];
        int checkState = checkCoordinate.getStateOfCoordinate();

        if (checkState == 2) {
            checkCoordinate.changeState(1);
            return 1;
        } else {
            return checkState;
        }
    }

    public boolean areAllAssociatedShipsSunk(int asoc) {
        for (int i = 0; i < b.getSIZEOFBOARD(); i++) {
            for (int j = 0; j < b.getSIZEOFBOARD(); j++) {
                Coordinate checkCoordinate = b.getGrid()[i][j];
                if (checkCoordinate.getAssociation() == asoc){
                    if(checkCoordinate.getStateOfCoordinate() != 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}
