package com.tictactoe;

import java.util.NoSuchElementException;
public class TicTacToe {

    public static void main(String[] args) {
        try{
            new Game(new TicBoard(3, 3)).start();
        }catch (NoSuchElementException e) {
            System.out.println("Game stopped");
        }
    }
}
