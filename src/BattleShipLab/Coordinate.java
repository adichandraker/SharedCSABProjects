package BattleShipLab;

public class Coordinate {

    private int xCoordinate;
    private int yCoordinate;
    private int stateOfCoordinate;

    private Coordinate(int xCor, int yCor) {
        xCoordinate = xCor;
        yCoordinate = yCor;
        stateOfCoordinate = 0;
    }

    public static Coordinate getACoordinate(int xCor, int yCor) {
        return new Coordinate(xCor, yCor);
    }

    public void changeState(int newState) {
        stateOfCoordinate = newState;
    }

    public int getStateOfCoordinate() {
        return stateOfCoordinate;
    }

}
