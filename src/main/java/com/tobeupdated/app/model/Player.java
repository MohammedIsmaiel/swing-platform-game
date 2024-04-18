package com.tobeupdated.app.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * Player
 */
public class Player extends Entity {

    private BufferedImage[][] animation;
    private PlayerAction playerAction;

    private boolean isPlayerMoving, up, down, right, left;

    private int animationPulse, animationSpeed = 8, animationIndex, playerSpeed = 10;

    public Player(int x, int y) {
        super(x, y);
        playerAction = PlayerAction.IDLE;
        isPlayerMoving = false;
        loadAnimations();
    }

    public void update() {
        movePlayer();
        updatePlayerAction();
        runAnimation();

    }

    public void render(Graphics g) {
        g.drawImage(animation[playerAction.getId()][animationIndex], x, y, 128, 80, null);
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setPlayerMoving(boolean isPlayerMoving) {
        this.isPlayerMoving = isPlayerMoving;
    }

    private void loadAnimations() {
        InputStream inputStream = getClass().getResourceAsStream("/player_sprites.png");
        try {
            var playerSprite = ImageIO.read(inputStream);
            animation = new BufferedImage[9][6];
            for (int i = 0; i < animation.length; i++) {
                for (int j = 0; j < animation[i].length; j++) {
                    animation[i][j] = playerSprite.getSubimage(j * 64, i * 40, 64, 40);
                }
            }
        } catch (IOException e) {
            System.out.println("can't load player image");
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void movePlayer() {
        boolean isPlayerMoving = false; // Initialize the movement flag

        // Check each direction and move accordingly
        if (up) {
            y -= playerSpeed;
            isPlayerMoving = true;
        } else if (down) {
            y += playerSpeed;
            isPlayerMoving = true;
        } else if (right) {
            x += playerSpeed;
            isPlayerMoving = true;
        } else if (left) {
            x -= playerSpeed;
            isPlayerMoving = true;
        }

        // Set the overall movement flag
        this.isPlayerMoving = isPlayerMoving;
    }

    private void updatePlayerAction() {
        if (isPlayerMoving) {
            playerAction = PlayerAction.RUNNING;
        } else
            playerAction = PlayerAction.IDLE;
    }

    private void runAnimation() {
        animationPulse++;
        if (animationPulse >= animationSpeed) {
            animationPulse = 0;
            animationIndex++;
            if (animationIndex >= playerAction.getAnimationLength()) {
                animationIndex = 0;
            }
        }
    }
}