package com.tobeupdated.app.model;

public enum PlayerAction {
    IDLE(0, 5),
    RUNNING(1, 6),
    HIT(2, 4),
    JUMP(3, 3),
    ATTACK(4, 3),
    ATTACK_JUMP_1(5, 3),
    ATTACK_JUMP_2(6, 3),
    GROUNDED(7, 2),
    FALLING(8, 1);

    private final int id;
    private final int animationLength;

    PlayerAction(int id, int animationLength) {
        this.id = id;
        this.animationLength = animationLength;
    }

    public int getId() {
        return id;
    }

    public int getAnimationLength() {
        return animationLength;
    }
}
