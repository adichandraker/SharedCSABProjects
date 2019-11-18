package BattleShipLab;

public class Coordinate {

    private int xCoordinate;
    private int yCoordinate;
    private int stateOfCoordinate;
    private int association;

    public Coordinate(int xCor, int yCor) {
        xCoordinate = xCor;
        yCoordinate = yCor;
        stateOfCoordinate = 0;
        association = 0;
    }

    public Coordinate(int xCor, int yCor, int ws) {
        xCoordinate = xCor;
        yCoordinate = yCor;
        stateOfCoordinate = 2;
        association = ws;
    }

    public void changeState(int newState) {
        stateOfCoordinate = newState;
    }

    public int getStateOfCoordinate() {
        return stateOfCoordinate;
    }

    public int getAssociation() {
        return association;
    }

    public void setAssociation(int association) {
        this.association = association;
    }


}
