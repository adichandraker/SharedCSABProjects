package BattleShipLab;

import java.util.Scanner;

public class Board {

    Coordinate [] [] grid;

    public Coordinate generateCoordinatePos (int xCor, int yCor) {
        Coordinate newCoordinate = new Coordinate(xCor, yCor);
        return newCoordinate;
    }

    public Board() {
        grid = new Coordinate [10] [10];
    }

    public void guess() {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the x-coordinate of the point you wish to guess?  (Enter a number, 0 through 9.)");
        int xGuess = input.nextInt();
        System.out.println("Okay, and the y-coordinate?");
        int yGuess = input.nextInt();
        if ((xGuess < 0) || (xGuess > 9) || (yGuess < 0) || (yGuess > 9)) {
            System.out.println("Sorry, those coordinates do not exist.  Try again!");
            guess();
        } else {
            checkCoordinate(xGuess, yGuess);
        }
    }

    public void checkCoordinate (int xCor, int yCor) {
        if (grid[xCor][yCor] == null) {
            Coordinate c = generateCoordinatePos(xCor, yCor);
            grid[xCor][yCor] = c;
        }
    }

}
