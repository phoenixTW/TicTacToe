package com.tictactoe;

import java.util.Scanner;

public class Game {
    private final User user1;
    private final User user2;
    private TicBoard ticBoard;

    public Game(TicBoard ticBoard) {
        this.ticBoard = ticBoard;
        user1 = new User('X', "User 1");
        user2 = new User('O', "User 2");
    }

    public void start() {
        int counter = 1;
        int prev = counter;

        while(true) {
            if(counter % 2 != 0) {
                counter += checkGameStrategy(user1);
            }
            else {
                counter += checkGameStrategy(user2);
            }

            if(counter == prev) System.out.println("You insert wrong position");
            else prev = counter;

            if(ticBoard.isNoGridLeft()){//naming
                System.out.println("Game Tied");
                System.exit(0);
            }
        }
    }

    private int checkGameStrategy(User user) {
        int counter = 0;
        if (game(ticBoard, user)){
            counter++;
            checkStrategy(user);
        }
        return counter;
    }

    private void checkStrategy(User user) {
        Strategies strategies = new Strategies();
        if(strategies.isRowFilled(user.getSymbol(), ticBoard)
                || strategies.isColumnsFilled(user.getSymbol(), ticBoard)
                || strategies.isDiagonalFilled(user.getSymbol(), ticBoard)){

            System.out.println(ticBoard.getBoard());
            System.out.println(user.getName() + " won the game");
            System.exit(0);
        }

    }

    private boolean game(TicBoard ticBoard, User user) {
        System.out.println(ticBoard.getBoard());
        System.out.println("Enter the Grid number: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        return ticBoard.input(input, user);
    }
}