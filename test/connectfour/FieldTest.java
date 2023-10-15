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
public class FieldTest {
    
    public FieldTest() {
    }
    
    @Test
    public void testComparison() {
        Field f1 = new Field();
        f1.setDisc('X');
        Field f2 = new Field();
        f2.setDisc('X');
        assertEquals(f1.getDisc(), f2.getDisc());
    }

    /**
     * Test of getDisc method, of class Field.
     */
    @Test
    public void testGetDisc() {
        System.out.println("getDisc");
        Field instance = new Field();
        char expResult = ' ';
        char result = instance.getDisc();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDisc method, of class Field.
     */
    @Test
    public void testSetDisc() {
        System.out.println("setDisc");
        char disc = 'X';
        Field instance = new Field();
        instance.setDisc(disc);
        assertEquals(disc, instance.getDisc());
    }
    
}
