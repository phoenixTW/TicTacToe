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

    public boolean input(String input) {
        String[] rowAndColumn = input.split("");
        int row = Integer.parseInt(rowAndColumn[0]);
        int column = Integer.parseInt(rowAndColumn[1]);

        if (board[row - 1][column - 1] == '-'){
            board[row - 1][column - 1] = 'X';
            return true;
        }

        return false;
    }
}
