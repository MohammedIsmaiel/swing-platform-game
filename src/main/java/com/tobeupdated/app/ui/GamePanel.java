package com.tobeupdated.app.ui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.tobeupdated.app.input.KeyboardInput;
import com.tobeupdated.app.input.MouseInput;

public class GamePanel extends JPanel {
    private final Dimension panelDimension;
    private Game game;

    public GamePanel(Game game) {
        panelDimension = new Dimension(1280, 800);
        this.game = game;
        setMaximumSize(panelDimension);
        setMinimumSize(panelDimension);
        setPreferredSize(panelDimension);
        addKeyListener(new KeyboardInput(this));
        addMouseMotionListener(new MouseInput(this));
    }

    public Game getGame() {
        return game;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
    }

    public void update() {
        game.update();
    }

}
