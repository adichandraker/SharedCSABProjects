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

    public static Coordinate getACoordinate(Coordinate[][] gridCopy, int xCor, int yCor) {
        if (gridCopy[xCor][yCor] == null) {
            return new Coordinate(xCor, yCor);
        }
        return gridCopy[xCor][yCor];

    }

    public void changeState(int newState) {
        stateOfCoordinate = newState;
    }

    public int getStateOfCoordinate() {
        return stateOfCoordinate;
    }

}
