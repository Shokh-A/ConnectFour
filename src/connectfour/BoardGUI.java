/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Shokhjakhon
 */
public class BoardGUI {
    
    private JButton[][] buttons;
    private Board board;
    private JPanel boardPanel;
    private JLabel timeLabel;
    private ArrayList<Point> points;
    
    private long startTime;
    private Timer timer;
    
    private char curPlayer = 'O';
    
    public BoardGUI(int h, int w) {
        board = new Board(h, w);
        boardPanel = new JPanel();
        points = new ArrayList<>();
        boardPanel.setLayout(new GridLayout(board.getBoardHeight(), board.getBoardWidth()));
        buttons = new JButton[board.getBoardHeight()][board.getBoardWidth()];
        for (int i = 0; i < board.getBoardHeight(); ++i) {
            for (int j = 0; j < board.getBoardWidth(); ++j) {
                JButton button = new JButton();
                button.addActionListener(new ButtonListener(i, j));
                button.setPreferredSize(new Dimension(50, 50));
                buttons[i][j] = button;
                boardPanel.add(button);
                points.add(new Point(i, j));
            }
        }
        
        timeLabel = new JLabel(" ");
        timeLabel.setHorizontalAlignment(JLabel.RIGHT);
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLabel.setText(elapsedTime() + " ms");
            }
        });
        startTime = System.currentTimeMillis();
        timer.start();
    }
    
    /**
     * This method computes the time spent to finish the game
     * @return this method returns time within the game ended
     */
    public long elapsedTime() {
        return System.currentTimeMillis() - startTime;
    }
    
    /**
     * This method applies change in the Field to button
     * @param x indicates the row in which Field is located
     * @param y indicates the column in which Field is located
     */
    public void refresh(int x, int y) {
        JButton button = buttons[x][y];
        Field field = board.get(x, y);
        if (field.getDisc() != ' ') {
            button.setText(String.valueOf(field.getDisc()));
        }
    }
    
    public JPanel getBoardPanel() {
        return boardPanel;
    }

    class ButtonListener implements ActionListener {

        private int x, y;

        public ButtonListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * This method applies the change made by player to a Field and then to a button
         * @param e event causing a change
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int row = board.getBoardHeight()-1; row >= 0; row--){
		if(board.get(row, y).getDisc() == ' '){
                    board.get(row, y).setDisc(curPlayer);
                    refresh(row,y);
                    break;
		}
            }
            /*
            if (board.get(x, y).getDisc() == ' ') {
                board.get(x, y).setDisc(curPlayer);
                refresh(x, y);
            }
            */
            //refresh(x, y);
            if (isWinner()) {
                timer.stop();
                JOptionPane.showMessageDialog(boardPanel, "The player \"" + curPlayer + "\" won in " + elapsedTime() + " ms.", "Game over!",
                        JOptionPane.PLAIN_MESSAGE);
                reset();
            } else if (board.isOver()) {
                timer.stop();
                JOptionPane.showMessageDialog(boardPanel, "Friendship wins! (Time passed: " + elapsedTime() + " ms.)", "Game over!",
                        JOptionPane.PLAIN_MESSAGE);
                reset();
            }
            if (curPlayer == 'O') curPlayer = 'X';
            else curPlayer = 'O';
        }
    }
    
    /**
     * This method resets all game settings: board and time
     */
    public void reset() {
        board = new Board(board.getBoardHeight(), board.getBoardWidth());
        points = new ArrayList<>();
        for (int i = 0; i < board.getBoardHeight(); ++i) {
            for (int j = 0; j < board.getBoardWidth(); ++j) {
                buttons[i][j].setText("");
                points.add(new Point(i, j));
            }
        }
        
        startTime = System.currentTimeMillis();
        timer.start();
    }
    
    /**
     * This method checks the Board to find the winner of the game. Winner can be decided in 4 cases.
     * @return Boolean it returns True if either player won and False if there are no winners
     */
    public boolean isWinner(){
	//check for 4 across
	for(int row = 0; row < board.getBoardHeight(); row++){
            for (int col = 0; col < board.getBoardWidth() - 3; col++){
		if (board.get(row, col).getDisc() == curPlayer && 
                    board.get(row, col+1).getDisc() == curPlayer &&
                    board.get(row, col+2).getDisc() == curPlayer &&
                    board.get(row, col+3).getDisc() == curPlayer){
                    return true;
		}
            }			
	}
	//check for 4 up and down
	for(int row = 0; row < board.getBoardHeight() - 3; row++){
            for(int col = 0; col < board.getBoardWidth(); col++){
            	if (board.get(row, col).getDisc() == curPlayer && 
                    board.get(row+1, col).getDisc() == curPlayer &&
                    board.get(row+2, col).getDisc() == curPlayer &&
                    board.get(row+3, col).getDisc() == curPlayer){
                    return true;
            	}
            }
	}
	//check upward diagonal
	for(int row = 3; row < board.getBoardHeight(); row++){
            for(int col = 0; col < board.getBoardWidth() - 3; col++){
                if (board.get(row, col).getDisc() == curPlayer && 
                    board.get(row-1, col+1).getDisc() == curPlayer &&
                    board.get(row-2, col+2).getDisc() == curPlayer &&
                    board.get(row-3, col+3).getDisc() == curPlayer){
                    return true;
            	}
            }
	}
	//check downward diagonal
	for(int row = 0; row < board.getBoardHeight() - 3; row++){
            for(int col = 0; col < board.getBoardWidth() - 3; col++){
                if (board.get(row, col).getDisc() == curPlayer && 
                    board.get(row+1, col+1).getDisc() == curPlayer &&
                    board.get(row+2, col+2).getDisc() == curPlayer &&
                    board.get(row+3, col+3).getDisc() == curPlayer){
                    return true;
            	}
            }
	}
	return false;
    }

    public JLabel getTimeLabel() {
        return timeLabel;
    }
}
