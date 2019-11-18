package BattleShipLab;

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

    public boolean isGameOver() {
        Board b = getBoard();
        Coordinate [] [] test = b.getGrid();
        for (int i = 0; i < b.getSIZEOFBOARD(); ++i) {
            for (int j = 0; j < b.getSIZEOFBOARD(); ++j) {
                if (test[i][j].getStateOfCoordinate() == 1) {
                    continue;
                }
                if (test[i][j].getAssociation() != 0) {
                    return false;
                }
            }
        }
        return true;
    }


}