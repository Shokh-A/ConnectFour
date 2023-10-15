/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.awt.Point;
/**
 *
 * @author Shokhjakhon
 */
public class Board {
    
    private Field[][] board;
    private final int h;
    private final int w;
    
    public Board(int h, int w) {
        this.h = h;
        this.w = w;
        board = new Field[this.h][this.w];
        for (int i = 0; i < this.h; i++) {
            for (int j = 0; j < this.w; j++) {
                board[i][j] = new Field();
            }
        }
    }
    
    /**
     * This method checks if there are free slots where we still can put X or O.
     * @return Boolean this method returns True or False
     */
    public boolean isOver() {
        for (int i = 0; i < this.h; i++) {
            for (int j = 0; j < this.w; j++) {
                if (board[i][j].getDisc() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * This method finds the needed Field class
     * @param x this parameter shows the row in which a Field is located
     * @param y this parameter shows the column in which a Field is located
     * @return Field this method returns Field class
     */
    public Field get(int x, int y) {
        return board[x][y];
    }
    
    public Field get(Point point) {
        int x = (int)point.getX();
        int y = (int)point.getY();
        return get(x, y);
    }
    
    public int getBoardWidth() {
        return w;
    }
    
    public int getBoardHeight() {
        return h;
    }
}
