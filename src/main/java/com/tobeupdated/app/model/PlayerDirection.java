package com.tobeupdated.app.model;

public enum PlayerDirection {
    UP(false),
    DOWN(false),
    LEFT(false),
    RIGHT(false);

    private boolean isMoving;

    PlayerDirection(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }
}
