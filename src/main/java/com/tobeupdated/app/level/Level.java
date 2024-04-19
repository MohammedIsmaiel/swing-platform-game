package com.tobeupdated.app.level;

public class Level {
    private LevelData levelData;

    public Level(LevelData levelData) {
        this.levelData = levelData;
    }

    public int[][] getLevelData() {
        return levelData.getData();
    }
}
