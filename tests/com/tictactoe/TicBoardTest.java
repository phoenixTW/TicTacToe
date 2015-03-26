package com.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kaustavc on 3/26/2015.
 * Testing for the board.
 */
public class TicBoardTest {
    TicBoard ticBoard;

    @Before
    public void setUp() throws Exception {

        ticBoard = new TicBoard(3, 3);
    }

    @Test
    public void testThreeByThreeGridShouldBeCreated() {
        assertEquals(9, ticBoard.total());
    }

    @Test
    public void testFourByFourGridShouldBeCreated() {
        ticBoard = new TicBoard(4, 4);
        assertNotEquals(9, ticBoard.total());
    }

    @Test
    public void testGetBoardShouldGive3by3Grid(){
        StringBuilder expected = new StringBuilder();
        expected.append("---");
        expected.append(System.lineSeparator());
        expected.append("---");
        expected.append(System.lineSeparator());
        expected.append("---");
        expected.append(System.lineSeparator());

        assertEquals(expected.toString(), ticBoard.getBoard());
    }

    @Test
    public void testInputShouldReplace_withXSymbol() {
        boolean isSuccess = ticBoard.input("11", new User('X', "User"));
        assertTrue(isSuccess);

        StringBuilder expected = new StringBuilder();
        expected.append("X--");
        expected.append(System.lineSeparator());
        expected.append("---");
        expected.append(System.lineSeparator());
        expected.append("---");
        expected.append(System.lineSeparator());

        assertEquals(expected.toString(), ticBoard.getBoard());
    }

    @Test
    public void testInputShouldReplace_withXSymbolReturnsFalls() {
        boolean isSuccess = ticBoard.input("11", new User('X', "User"));
        isSuccess = ticBoard.input("11", new User('X', "User"));
        assertFalse(isSuccess);
    }

    @Test
    public void testInputShouldReplaceTheSymbolsAccordingToTheUser() {
        User u1 = new User('X', "User");
        User u2 = new User('O', "User");
        assertTrue(ticBoard.input("11", u1));
        assertTrue(ticBoard.input("12", u2));

        StringBuilder expected = new StringBuilder();
        expected.append("XO-");
        expected.append(System.lineSeparator());
        expected.append("---");
        expected.append(System.lineSeparator());
        expected.append("---");
        expected.append(System.lineSeparator());

        assertEquals(expected.toString(), ticBoard.getBoard());
    }

    @Test
    public void testUserShouldWinWhenRowGridContainsSameSymbol() {
        User u1 = new User('X', "User");
        assertTrue(ticBoard.input("11", u1));
        assertTrue(ticBoard.input("12", u1));
        assertTrue(ticBoard.input("13", u1));

        assertTrue(ticBoard.isRowFilled('X'));

    }

    @Test
    public void testUserShouldNotWinWhenRowGridContainsDifferentSymbol() {
        User u1 = new User('X', "User");
        User u2 = new User('O', "User");
        assertTrue(ticBoard.input("11", u1));
        assertTrue(ticBoard.input("12", u2));
        assertTrue(ticBoard.input("13", u1));

        assertFalse(ticBoard.isRowFilled('X'));

    }

    @Test
    public void testUserShouldWinWhenColumnsGridContainsSameSymbol() {
        User u1 = new User('X', "User");
        assertTrue(ticBoard.input("11", u1));
        assertTrue(ticBoard.input("21", u1));
        assertTrue(ticBoard.input("31", u1));

        assertTrue(ticBoard.isColumnsFilled('X'));

    }
    @Test
    public void testUserShouldNotWinWhenColumnsGridContainsDifferentSymbol() {
        User u1 = new User('X', "User");
        User u2 = new User('O', "User");
        assertTrue(ticBoard.input("11", u1));
        assertTrue(ticBoard.input("21", u2));
        assertTrue(ticBoard.input("31", u1));

        assertFalse(ticBoard.isColumnsFilled('X'));

    }

    @Test
    public void testCrossStratergyShouldGiveTrueWhenTheGridAreFilledInCross() {
        User u1 = new User('X', "User");
        assertTrue(ticBoard.input("11", u1));
        assertTrue(ticBoard.input("22", u1));
        assertTrue(ticBoard.input("33", u1));

        assertTrue(ticBoard.isDiagonalFilled('X'));

    }

    @Test
    public void testCrossStratergyShouldGiveFalseWhenTheGridAreFilledInCross() {
        User u1 = new User('X', "User");
        User u2 = new User('O', "User");
        assertTrue(ticBoard.input("11", u1));
        assertTrue(ticBoard.input("22", u2));
        assertTrue(ticBoard.input("33", u1));

        assertFalse(ticBoard.isDiagonalFilled('X'));

    }

    @Test
    public void testCrossStratergyShouldGiveTrueWhenTheGridAreFilledFromRigntToLeft() {
        User u1 = new User('X', "User");
        assertTrue(ticBoard.input("13", u1));
        assertTrue(ticBoard.input("22", u1));
        assertTrue(ticBoard.input("31", u1));

        assertTrue(ticBoard.isDiagonalFilled('X'));

    }
}
