/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;

/**
 *
 * @author Shokhjakhon
 */
public class BoardTest {
    
    public BoardTest() {
    }

    /**
     * Test of isOver method, of class Board.
     */
    @Test
    public void testIsOver() {
        System.out.println("isOver");
        Board instance = new Board(1,1);
        boolean expResult = false;
        boolean result = instance.isOver();
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class Board.
     */
    @Test
    public void testGet_int_int() {
        System.out.println("get");
        int x = 0;
        int y = 0;
        Board instance = new Board(2,2);
        instance.get(x,y).setDisc('X');
        Field result = instance.get(x, y);
        assertEquals(instance.get(x,y), result);
    }

    /**
     * Test of getBoardWidth method, of class Board.
     */
    @Test
    public void testGetBoardWidth() {
        System.out.println("getBoardWidth");
        Board instance = new Board(3,2);
        int expResult = 2;
        int result = instance.getBoardWidth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBoardHeight method, of class Board.
     */
    @Test
    public void testGetBoardHeight() {
        System.out.println("getBoardHeight");
        Board instance = new Board(2,1);
        int expResult = 2;
        int result = instance.getBoardHeight();
        assertEquals(expResult, result);
    }
    
}
