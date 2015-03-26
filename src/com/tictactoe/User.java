package com.tictactoe;

/**
 * Created by kaustavc on 3/26/2015.
 */
public class User {
    private final char symbol;
    private final String name;

    public User(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}
