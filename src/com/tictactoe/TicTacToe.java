package com.tictactoe;

public class TicTacToe {

    public static void main(String[] args) {
        Grid grid = new Grid(3, 3);
        System.out.println(grid.getBoard());
    }
}
