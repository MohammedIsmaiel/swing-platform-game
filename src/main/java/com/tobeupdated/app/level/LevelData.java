package com.tobeupdated.app.level;

public enum LevelData {
    ONE(new int[][] {
            { 0, 1, 1, 1, 3 },
            { 12, 1, 1, 1, 12 },
            { 12, 1, 2, 1, 12 },
            { 12, 1, 1, 1, 12 },
            { 48, 49, 49, 49, 51 }
    }),
    TWO(new int[][] {
            { 12, 12, 12, 12, 12 },
            { 12, 2, 2, 2, 12 },
            { 12, 2, 1, 2, 12 },
            { 12, 2, 2, 2, 12 },
            { 12, 12, 12, 12, 12 }
    });

    private final int[][] data;

    LevelData(int[][] data) {
        this.data = data;
    }

    public int[][] getData() {
        return data;
    }
}
