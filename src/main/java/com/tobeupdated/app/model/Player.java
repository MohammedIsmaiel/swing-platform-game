package com.tobeupdated.app.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.tobeupdated.app.service.Renderable;
import com.tobeupdated.app.service.Updatable;
import com.tobeupdated.app.util.LoadSave;

/**
 * Player
 */
public class Player extends Entity implements Renderable, Updatable {

    private BufferedImage[][] animation;
    private PlayerAction playerAction;

    private boolean isPlayerMoving, up, down, right, left, attacking;

    private int animationPulse, animationSpeed = 8, animationIndex, playerSpeed = 10;

    public Player(int x, int y) {
        super(x, y);
        playerAction = PlayerAction.IDLE;
        isPlayerMoving = false;
        loadAnimations();
    }

    @Override
    public void update() {
        movePlayer();
        updatePlayerAction();
        runAnimation();
    }

    @Override
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

        var playerSprite = LoadSave.loadSprite(LoadSave.PLAYER_SPIRIT);
        animation = new BufferedImage[9][6];
        for (int i = 0; i < animation.length; i++) {
            for (int j = 0; j < animation[i].length; j++) {
                animation[i][j] = playerSprite.getSubimage(j * 64, i * 40, 64, 40);
            }
        }
    }

    private void movePlayer() {
        boolean isPlayerMoving = false; // Initialize the movement flag
        // Check each direction and move accordingly
        if (up && !down) {
            y -= playerSpeed;
            isPlayerMoving = true;
        } else if (down && !up) {
            y += playerSpeed;
            isPlayerMoving = true;
        }
        if (right && !left) {
            x += playerSpeed;
            isPlayerMoving = true;
        } else if (left && !right) {
            x -= playerSpeed;
            isPlayerMoving = true;
        }
        // Set the overall movement flag
        this.isPlayerMoving = isPlayerMoving;
    }

    private void updatePlayerAction() {
        PlayerAction initAnimation = playerAction;
        if (isPlayerMoving) {
            playerAction = PlayerAction.RUNNING;
        } else
            playerAction = PlayerAction.IDLE;
        if (attacking) {
            playerAction = playerAction.ATTACK;
        }
        if (initAnimation != playerAction) {
            resetAnimation();
        }
    }

    void resetAnimation() {
        animationIndex = 0;
        animationPulse = 0;
    }

    private void runAnimation() {
        animationPulse++;
        if (animationPulse >= animationSpeed) {
            animationPulse = 0;
            animationIndex++;
            if (animationIndex >= playerAction.getAnimationLength()) {
                animationIndex = 0;
                attacking = false;
            }
        }
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }
}