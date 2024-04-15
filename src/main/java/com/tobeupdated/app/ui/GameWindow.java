package com.tobeupdated.app.ui;

import javax.swing.JFrame;

public class GameWindow {
    public GameWindow(GamePanel panel) {
        JFrame frame = new JFrame("Simple Java game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
