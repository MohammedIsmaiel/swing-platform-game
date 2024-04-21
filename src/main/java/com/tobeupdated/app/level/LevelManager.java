package com.tobeupdated.app.level;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.tobeupdated.app.service.Renderable;
import com.tobeupdated.app.service.Updatable;
import com.tobeupdated.app.ui.Game;
import com.tobeupdated.app.util.LoadSave;

public class LevelManager implements Renderable, Updatable {
    BufferedImage[] levelSprite;
    private Level level;

    public LevelManager() {
        loadLevel();
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void render(Graphics g) {
        for (int i = 0; i < level.getLevelData().length; i++) {
            for (int j = 0; j < level.getLevelData()[i].length; j++) {
                g.drawImage(levelSprite[level.getLevelData()[i][j]], j * Game.TILES_SIZE,
                        i * Game.TILES_SIZE, Game.TILES_SIZE, Game.TILES_SIZE, null);
            }
        }
    }

    private void loadLevel() {
        level = new Level(LevelData.ONE);
        BufferedImage image = LoadSave.loadSprite(LoadSave.LEVEL_SPIRIT);
        levelSprite = new BufferedImage[48];

        int rows = image.getHeight() / Game.TILES_SIZE; // Calculate the number of rows in the tileset image
        int cols = image.getWidth() / Game.TILES_SIZE; // Calculate the number of columns in the tileset image

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j;
                int x = j * Game.TILES_SIZE; // Calculate the x coordinate of the subimage
                int y = i * Game.TILES_SIZE; // Calculate the y coordinate of the subimage
                levelSprite[index] = image.getSubimage(x, y, Game.TILES_SIZE, Game.TILES_SIZE);
            }
        }
    }

}
