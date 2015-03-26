package com.tictactoe;

/**
 * Created by kaustavc on 3/26/2015.
 */
public class Grid {
    private char[][] board;
    private int numberOfRows;
    private int numberOfColumns;

    public Grid(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        board = new char[numberOfRows][numberOfColumns];
        init();
    }

    private void init() {
        for (int outerCounter = 0; outerCounter < numberOfRows; outerCounter++) {
            for (int innerCounter = 0; innerCounter < numberOfColumns; innerCounter++) {
                board[outerCounter][innerCounter] = '-';
            }
        }
    }

    public int total() {
        return numberOfRows * numberOfColumns;
    }

    public String getBoard() {
        StringBuilder showBoard = new StringBuilder();
        for (int outerCounter = 0; outerCounter < numberOfRows; outerCounter++) {
            for (int innerCounter = 0; innerCounter < numberOfColumns; innerCounter++) {
                showBoard.append(board[outerCounter][innerCounter]);
            }

            showBoard.append(System.lineSeparator());
        }

        return showBoard.toString();
    }

    public boolean input(String input, User user) {
        String[] rowAndColumn = input.split("");

        if (rowAndColumn.length < 2 || rowAndColumn.length > 2 || rowAndColumn.length < 0)
            return false;

        int row = Integer.parseInt(rowAndColumn[0]);
        int column = Integer.parseInt(rowAndColumn[1]);

        if (board[row - 1][column - 1] == '-'){
            board[row - 1][column - 1] = user.getSymbol();
            return true;
        }

        return false;
    }

    public boolean isRowFilled(char symbol) {
        int count = 0;
        for (int outerCounter = 0; outerCounter < numberOfRows; outerCounter++) {
            for (int innerCounter = 0; innerCounter < numberOfColumns; innerCounter++) {
                if (board[outerCounter][innerCounter] == symbol) count++;
            }

            if (count == numberOfColumns) return true;

            count = 0;
        }

        return false;
    }

    public boolean isColumnsFilled(char symbol) {
        int count = 0;
        for (int outerCounter = 0; outerCounter < numberOfColumns; outerCounter++) {
            for (int innerCounter = 0; innerCounter < numberOfRows; innerCounter++) {
                if (board[innerCounter][outerCounter] == symbol) count++;
            }

            if (count == numberOfRows) return true;

            count = 0;
        }

        return false;
    }

    public boolean isDiogonalFilled(char symbol) {
        int count = 0;
        for (int counter = 0; counter < numberOfColumns; counter++) {
            if(board[counter][counter] == symbol)
                count++;
        }

        return count == 3;
    }

    public boolean isNoGridLeft() {
        int count = 0;
        for (int outerCounter = 0; outerCounter < numberOfRows; outerCounter++) {
            for (int innerCounter = 0; innerCounter < numberOfColumns; innerCounter++) {
                if(board[outerCounter][innerCounter] != '-') count++;
            }
        }

        return count == total();
    }
}
