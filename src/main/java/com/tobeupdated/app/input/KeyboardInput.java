package com.tobeupdated.app.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.tobeupdated.app.ui.GamePanel;

public class KeyboardInput implements KeyListener {

    public GamePanel gamePanel;

    public KeyboardInput(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                gamePanel.getPlayer().setUp(true);
            case KeyEvent.VK_S:
                gamePanel.getPlayer().setDown(true);
            case KeyEvent.VK_A:
                gamePanel.getPlayer().setLeft(true);
            case KeyEvent.VK_D:
                gamePanel.getPlayer().setRight(true);
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("space");
                break;
            default:
                // Handle other key presses if needed
                System.out.println("not valid");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                gamePanel.getPlayer().setUp(false);
            case KeyEvent.VK_S:
                gamePanel.getPlayer().setDown(false);
            case KeyEvent.VK_A:
                gamePanel.getPlayer().setLeft(false);
            case KeyEvent.VK_D:
                gamePanel.getPlayer().setRight(false);
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("space");
                break;
            default:
                // Handle other key presses if needed
                System.out.println("not valid");
                break;
        }
    }

}
