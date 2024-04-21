package com.tobeupdated.app.ui;

import javax.swing.JFrame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameWindow {
    public GameWindow(GamePanel panel) {
        JFrame frame = new JFrame("Simple Java game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setResizable(true);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                panel.getPlayer().setUp(false);
                panel.getPlayer().setDown(false);
                panel.getPlayer().setRight(false);
                panel.getPlayer().setLeft(false);
            }
        });
    }
}
