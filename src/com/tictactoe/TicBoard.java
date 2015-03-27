package com.tictactoe;

/**
 * Created by kaustavc on 3/26/2015.
 */
public class TicBoard {
    private char[][] board;
    private int numberOfRows;
    private int numberOfColumns;

    public TicBoard(int numberOfRows, int numberOfColumns) {
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
    public boolean isSymbol(char symbol, int outerCounter, int innerCounter) {
        return board[outerCounter][innerCounter] == symbol;
    }

    public boolean isNoGridLeft() {
        int count = 0;
        for (int outerCounter = 0; outerCounter < numberOfRows; outerCounter++) {
            for (int innerCounter = 0; innerCounter < numberOfColumns; innerCounter++) {
                if(board[outerCounter][innerCounter] != '-') count++;
            }
        }

        return count == numberOfRows * numberOfColumns;
    }
}
