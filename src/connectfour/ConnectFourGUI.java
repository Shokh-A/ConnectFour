/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Shokhjakhon
 */
public class ConnectFourGUI {
    
    private JFrame frame;
    private BoardGUI boardGUI;

    private final int INITIAL_BOARD_WIDTH = 8;
    private final int INITIAL_BOARD_HEIGHT = 5;

    public ConnectFourGUI() {
        frame = new JFrame("Connect Four");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardGUI = new BoardGUI(INITIAL_BOARD_HEIGHT, INITIAL_BOARD_WIDTH);
        frame.getContentPane().add(boardGUI.getBoardPanel(), BorderLayout.CENTER);
        frame.getContentPane().add(boardGUI.getTimeLabel(), BorderLayout.SOUTH);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        JMenu newMenu = new JMenu("New");
        gameMenu.add(newMenu);
        int[] boardWidths = new int[]{8,10,12};
        int[] boardHeights = new int[]{5,6,7};
        for (int i = 0; i < 3; i++) {
            int w = boardWidths[i];
            int h = boardHeights[i];
            JMenuItem sizeMenuItem = new JMenuItem(w + "x" + h);
            newMenu.add(sizeMenuItem);
            sizeMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().remove(boardGUI.getBoardPanel());
                    frame.getContentPane().remove(boardGUI.getTimeLabel());
                    boardGUI = new BoardGUI(h, w);
                    frame.getContentPane().add(boardGUI.getBoardPanel(),
                            BorderLayout.CENTER);
                    frame.getContentPane().add(boardGUI.getTimeLabel(), BorderLayout.SOUTH);
                    frame.pack();
                }
            });
        }
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        gameMenu.add(resetMenuItem);
        resetMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boardGUI.reset();
            }
        });
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        gameMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}
