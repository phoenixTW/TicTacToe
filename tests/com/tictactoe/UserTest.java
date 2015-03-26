package com.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testGetSymbolShouldReturnTheSymbolOfTheUser() {
        User u1 = new User('X');
        char u1Expected = 'X';
        assertEquals(u1Expected, u1.getSymbol());
    }

}