package BattleShipLab;

import java.util.Random;

public class Board {
    private final int SIZEOFBOARD = 10;

    public int getSIZEOFBOARD() {
        return SIZEOFBOARD;
    }

    private final int WIDTHOFSHIP = 1;
    private static Coordinate[][] grid;
    private static Random generator = new Random();
    private static int assocNum = 1;

    public Board() {
        grid = new Coordinate[SIZEOFBOARD][SIZEOFBOARD];
        for (int i = 0; i < SIZEOFBOARD; i++) {
            for (int j = 0; j < SIZEOFBOARD; j++) {
                grid[i][j] = new Coordinate(i, j);
            }
        }
        setDefaultShips();
    }

    public void setTheShipPosition(int length, int assocNum) {

        int xCoorStart = generator.nextInt(9);
        int yCoorStart = generator.nextInt(9);
        int coordsToFix = 0; //to erase ships from the board, if needed
        if (generator.nextBoolean()) {
            if (!(xCoorStart + length > grid.length)) {
                for (int i = 0; i < length; i++) {
                    System.out.println(i + " " + yCoorStart);
                    grid[xCoorStart + i][yCoorStart].changeState(2);
                    grid[xCoorStart + i][yCoorStart].setAssociation(assocNum);
                }
            }
            else {
                for (int i = 0; i < length; i++) {
                    System.out.println(i + " " + yCoorStart);
                    grid[xCoorStart - i][yCoorStart].changeState(2);
                    grid[xCoorStart - i][yCoorStart].setAssociation(assocNum);
                }
            }
        } else {
            if (!(yCoorStart + length > grid.length)) {
                for (int i = 0; i < length; i++) {
                    System.out.println(xCoorStart + " " + i);
                    grid[xCoorStart][yCoorStart + i].changeState(2);
                    grid[xCoorStart][yCoorStart + i].setAssociation(assocNum);
                }
            }
            else {
                for (int i = 0; i < length; i++) {
                    System.out.println(xCoorStart + " " + i);
                    grid[xCoorStart][yCoorStart - i].changeState(2);
                    grid[xCoorStart][yCoorStart - i].setAssociation(assocNum);
                }
            }
        }

        /*if (horizOrNot == true) {
            if (!(xCoorStart + length > grid.length)) {
                for (int i = xCoorStart; i < xCoorStart + length; ++i) {
                    if (grid[i][yCoorStart].getStateOfCoordinate() != 2) {
                        grid[i][yCoorStart].changeState(2);
                        grid[i][yCoorStart].setAssociation(assocNum);
                        ++coordsToFix;
                    } else {
                        for (int j = xCoorStart; j < xCoorStart + coordsToFix; ++j) {
                            grid[j][yCoorStart].changeState(0);
                            grid[j][yCoorStart].setAssociation(0);
                        }
                        coordsToFix = 0;
                        setTheShipPosition(length);
                    }

                }
            } else {
                for (int i = xCoorStart; i > xCoorStart - length; --i) {
                    if (grid[i][yCoorStart].getStateOfCoordinate() != 2) {
                        grid[i][yCoorStart].changeState(2);
                        grid[i][yCoorStart].setAssociation(assocNum);
                        ++coordsToFix;
                    } else {
                        for (int j = xCoorStart; j < xCoorStart + coordsToFix; ++j) {
                            grid[j][yCoorStart].changeState(0);
                            grid[j][yCoorStart].setAssociation(0);
                        }
                        coordsToFix = 0;
                        setTheShipPosition(length);
                    }
                }
            }
        } else {
            if (!(yCoorStart + length > grid.length)) {
                for (int i = yCoorStart; i < yCoorStart + length; ++i) {
                    if (grid[xCoorStart][i].getStateOfCoordinate() != 2) {
                        grid[xCoorStart][i].changeState(2);
                        grid[xCoorStart][i].setAssociation(assocNum);
                        ++coordsToFix;
                    } else {
                        for (int j = yCoorStart; j < yCoorStart + coordsToFix; ++j) {
                            grid[xCoorStart][j].changeState(0);
                            grid[xCoorStart][i].setAssociation(0);
                        }
                        coordsToFix = 0;
                        setTheShipPosition(length);
                    }
                }
            } else {
                for (int i = yCoorStart; i > yCoorStart - length; --i) {
                    if (grid[xCoorStart][i].getStateOfCoordinate() != 2) {
                        grid[xCoorStart][i].changeState(2);
                        grid[xCoorStart][i].setAssociation(assocNum);
                        ++coordsToFix;
                    } else {
                        for (int j = yCoorStart; j < yCoorStart + coordsToFix; ++j) {
                            grid[xCoorStart][j].changeState(0);
                            grid[xCoorStart][i].setAssociation(0);
                        }
                        coordsToFix = 0;
                        setTheShipPosition(length);
                    }
                }
            }
        }*/
    }

    public void setDefaultShips() {
        setTheShipPosition(5, 1);
        setTheShipPosition(4, 2);
        setTheShipPosition(3, 3);
        setTheShipPosition(3, 4);
        setTheShipPosition(2, 5);
    }

    public Coordinate[][] getGrid() {
        return grid;
    }

}
