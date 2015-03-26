package com.tictactoe;

public class TicTacToe {

    public static void main(String[] args) {
        new Game(new Grid(3, 3)).start();
    }
}
