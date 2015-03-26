package com.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kaustavc on 3/26/2015.
 * Testing for the board.
 */
public class GridTest {
    Grid grid;

    @Before
    public void setUp() throws Exception {

        grid = new Grid(3, 3);
    }

    @Test
    public void testThreeByThreeGridShouldBeCreated() {
        assertEquals(9, grid.total());
    }

    @Test
    public void testFourByFourGridShouldBeCreated() {
        grid = new Grid(4, 4);
        assertNotEquals(9, grid.total());
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

        assertEquals(expected.toString(), grid.getBoard());
    }

    @Test
    public void testInputShouldReplace_withXSymbol() {
        boolean isSuccess = grid.input("11", new User('X', "User"));
        assertTrue(isSuccess);

        StringBuilder expected = new StringBuilder();
        expected.append("X--");
        expected.append(System.lineSeparator());
        expected.append("---");
        expected.append(System.lineSeparator());
        expected.append("---");
        expected.append(System.lineSeparator());

        assertEquals(expected.toString(), grid.getBoard());
    }

    @Test
    public void testInputShouldReplace_withXSymbolReturnsFalls() {
        boolean isSuccess = grid.input("11", new User('X', "User"));
        isSuccess = grid.input("11", new User('X', "User"));
        assertFalse(isSuccess);
    }

    @Test
    public void testInputShouldReplaceTheSymbolsAccordingToTheUser() {
        User u1 = new User('X', "User");
        User u2 = new User('O', "User");
        assertTrue(grid.input("11", u1));
        assertTrue(grid.input("12", u2));

        StringBuilder expected = new StringBuilder();
        expected.append("XO-");
        expected.append(System.lineSeparator());
        expected.append("---");
        expected.append(System.lineSeparator());
        expected.append("---");
        expected.append(System.lineSeparator());

        assertEquals(expected.toString(), grid.getBoard());
    }

    @Test
    public void testUserShouldWinWhenRowGridContainsSameSymbol() {
        User u1 = new User('X', "User");
        assertTrue(grid.input("11", u1));
        assertTrue(grid.input("12", u1));
        assertTrue(grid.input("13", u1));

        assertTrue(grid.isRowFilled('X'));

    }

    @Test
    public void testUserShouldNotWinWhenRowGridContainsDifferentSymbol() {
        User u1 = new User('X', "User");
        User u2 = new User('O', "User");
        assertTrue(grid.input("11", u1));
        assertTrue(grid.input("12", u2));
        assertTrue(grid.input("13", u1));

        assertFalse(grid.isRowFilled('X'));

    }

    @Test
    public void testUserShouldWinWhenColumnsGridContainsSameSymbol() {
        User u1 = new User('X', "User");
        assertTrue(grid.input("11", u1));
        assertTrue(grid.input("21", u1));
        assertTrue(grid.input("31", u1));

        assertTrue(grid.isColumnsFilled('X'));

    }
    @Test
    public void testUserShouldNotWinWhenColumnsGridContainsDifferentSymbol() {
        User u1 = new User('X', "User");
        User u2 = new User('O', "User");
        assertTrue(grid.input("11", u1));
        assertTrue(grid.input("21", u2));
        assertTrue(grid.input("31", u1));

        assertFalse(grid.isColumnsFilled('X'));

    }

    @Test
    public void testCrossStratergyShouldGiveTrueWhenTheGridAreFilledInCross() {
        User u1 = new User('X', "User");
        assertTrue(grid.input("11", u1));
        assertTrue(grid.input("22", u1));
        assertTrue(grid.input("33", u1));

        assertTrue(grid.isDiogonalFilled('X'));

    }

    @Test
    public void testCrossStratergyShouldGiveFalseWhenTheGridAreFilledInCross() {
        User u1 = new User('X', "User");
        User u2 = new User('O', "User");
        assertTrue(grid.input("11", u1));
        assertTrue(grid.input("22", u2));
        assertTrue(grid.input("33", u1));

        assertFalse(grid.isDiogonalFilled('X'));

    }
}
