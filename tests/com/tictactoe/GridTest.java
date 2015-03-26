package com.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kaustavc on 3/26/2015.
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
        boolean isSuccess = grid.input("11");
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
        boolean isSuccess = grid.input("11");
        isSuccess = grid.input("11");
        assertFalse(isSuccess);
    }
}
