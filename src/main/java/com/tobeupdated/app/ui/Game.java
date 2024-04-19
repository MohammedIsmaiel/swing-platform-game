package com.tobeupdated.app.ui;

import java.awt.Graphics;

import javax.swing.Timer;

public class Game {
    public final static int TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 1.5f;
    public final static int TILES_WIDTH_NUMBER = 26;
    public final static int TILES_HEIGHT_NUMBER = 14;
    public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public final static int GAME_WIDTH = TILES_SIZE * TILES_WIDTH_NUMBER;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_HEIGHT_NUMBER;
    private GamePanel gamePanel;
    private Timer timer;
    private final int FPS = 60;
    private final long TARGET_TIME = 1000 / FPS;
    private int frameCount = 0;
    private long totalTime = 0;

    public Game() {
        gamePanel = new GamePanel();
        new GameWindow(gamePanel);
        gamePanel.requestFocus();

        timer = new Timer(0, e -> {
            long startFrameTime = System.currentTimeMillis();

            // Update game state
            gamePanel.update();
            // Render game state
            gamePanel.repaint();

            // Calculate frame time
            long frameTime = System.currentTimeMillis() - startFrameTime;

            // Throttle frame rate if necessary
            if (frameTime < TARGET_TIME) {
                try {
                    Thread.sleep(TARGET_TIME - frameTime);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            // Update frame count and total time
            frameCount++;
            totalTime += System.currentTimeMillis() - startFrameTime;

            // Print FPS every second
            if (totalTime >= 1000) {
                long fps = frameCount / (totalTime / 1000);
                System.out.println("FPS: " + fps);

                // Reset frame count and total time
                frameCount = 0;
                totalTime = 0;
            }
        });
    }

    public void start() {
        timer.setDelay((int) TARGET_TIME);
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    // public void update() {
    // player.update();
    // }

    public void render(Graphics g) {
    }
}
