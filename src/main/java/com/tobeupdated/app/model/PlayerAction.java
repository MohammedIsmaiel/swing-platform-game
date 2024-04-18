package com.tobeupdated.app.model;

public enum PlayerAction {
    IDLE(0, 5),
    RUNNING(1, 6),
    JUMP(2, 3),
    FALLING(3, 1),
    GROUNDED(4, 2),
    HIT(5, 4),
    ATTACK(6, 3),
    ATTACK_JUMP_1(7, 3),
    ATTACK_JUMP_2(8, 3);

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
