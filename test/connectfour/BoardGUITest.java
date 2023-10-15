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
public class BoardGUITest {
    
    public BoardGUITest() {
    }

    /**
     * Test of refresh method, of class BoardGUI.
     */
    @Test
    public void testRefresh() {
        System.out.println("refresh");
        int x = 0;
        int y = 0;
        BoardGUI instance = new BoardGUI(2,2);
        instance.refresh(x, y);
    }

    /**
     * Test of reset method, of class BoardGUI.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        BoardGUI instance = new BoardGUI(3,3);
        instance.reset();
    }

    /**
     * Test of isWinner method, of class BoardGUI.
     */
    @Test
    public void testIsWinner() {
        System.out.println("isWinner");
        BoardGUI instance = new BoardGUI(4,4);
        boolean expResult = false;
        boolean result = instance.isWinner();
        assertEquals(expResult, result);
    }
    
}
