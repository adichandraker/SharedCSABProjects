public class Coordinate {

    private int xCoordinate;
    private int yCoordinate;
    private int stateOfCoordinate;

    public Coordinate (int xCor, int yCor) {
        xCoordinate = xCor;
        yCoordinate = yCor;
        stateOfCoordinate = 0;
    }

    public void changeState(int newState) {
        stateOfCoordinate = newState;
    }

}
