package com.tictactoe;

/**
 * Created by kaustavc on 3/26/2015.
 */

public class Strategies {
    public boolean isRowFilled(char symbol, TicBoard ticBoard) {

        int count = 0;
        for (int outerCounter = 0; outerCounter < 3; outerCounter++) {
            for (int innerCounter = 0; innerCounter < 3; innerCounter++) {
                if (ticBoard.isSymbol(symbol, outerCounter, innerCounter)) count++;
            }

            if (count == 3) return true;

            count = 0;
        }

        return false;
    }

    public boolean isColumnsFilled(char symbol, TicBoard ticBoard) {
        int count = 0;
        for (int outerCounter = 0; outerCounter < 3; outerCounter++) {
            for (int innerCounter = 0; innerCounter < 3; innerCounter++) {
                if (ticBoard.isSymbol(symbol, innerCounter, outerCounter)) count++;
            }

            if (count == 3) return true;

            count = 0;
        }

        return false;
    }

    public boolean isDiagonalFilled(char symbol, TicBoard ticBoard) {
        int countForRightToLeft = rightToLeft(symbol, ticBoard);
        int countForLeftToRight = leftToRight(symbol, ticBoard);
        return countForLeftToRight == 3 || countForRightToLeft == 3;
    }

    private int leftToRight(char symbol, TicBoard ticBoard) {
        int count = 0;
        for (int counter = 0; counter < 3; counter++) {
            if(ticBoard.isSymbol(symbol, counter, counter))
                count++;
        }
        return count;
    }

    private int rightToLeft(char symbol, TicBoard ticBoard) {
        int count = 0;
        int row = -1;

        for (int counter = 2; counter >= 0; counter--) {
            if(ticBoard.isSymbol(symbol, ++row, counter)) {
                count++;
            }
        }
        return count;
    }

}
