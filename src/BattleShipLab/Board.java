package BattleShipLab;

import java.util.Random;

public class Board {

    private final int SIZEOFBOARD = 10;
    private final int WIDTHOFSHIP = 1;

    private static Coordinate[][] grid;
    private static Random generator = new Random();


    public Board() {
        grid = new Coordinate[SIZEOFBOARD][SIZEOFBOARD];
    }



    public void setTheShipPosition(int length) {

        boolean direction = generator.nextBoolean();

        int startCoord = generator.nextInt(99);
        int xCoord = startCoord / 10;
        int yCoord = startCoord % 10;


        // Check if go off board
        if (xCoord + length > SIZEOFBOARD) {
            direction = false; // will go up down
        }
        if (yCoord + length > SIZEOFBOARD) {
            direction  = true; // will go left to right
        }

        for(int i = 0; i<WIDTHOFSHIP + 2; i++){
            for (int j = 0; i< length + 2; j++){
                if(grid[i][j].getStateOfCoordinate() < 0 || grid[i][j].getStateOfCoordinate() == 2)
                    setTheShipPosition(length);
            }
        }

    }

    public void setDefaultShips() {
        setTheShipPosition(5);
        setTheShipPosition(4);
        setTheShipPosition(3);
        setTheShipPosition(3);
        setTheShipPosition(2);

    }

    public Coordinate[][] getGrid() {
        return grid;
    }
}
