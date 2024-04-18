package com.tobeupdated.app.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {
    public static final String PLAYER_SPIRIT = "/player_sprites.png";

    public static BufferedImage loadAnimations(String spiritPath) {
        InputStream inputStream = LoadSave.class.getResourceAsStream(spiritPath);
        BufferedImage spirit = null;
        try {
            spirit = ImageIO.read(inputStream);
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
        return spirit;
    }
}
