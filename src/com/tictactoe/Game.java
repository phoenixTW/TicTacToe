package com.tictactoe;

import java.util.Scanner;

public class Game {
    private final User user1;
    private final User user2;
    private Grid grid;

    public Game(Grid grid) {

        this.grid = grid;
        user1 = new User('X');
        user2 = new User('O');
    }

    public void start() {
        int counter = 1;
        while(true) {
            if(counter % 2 != 0) {
                if (game(grid, user1)) counter++;
            }
            else if (game(grid, user2)) counter++;
            else System.out.println("You insert wrong position");
        }
    }

    private boolean game(Grid grid, User user) {
        System.out.println(grid.getBoard());
        System.out.println("Enter the Grid number: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        return grid.input(input, user);
    }

}