package com.tobeupdated.app.ui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.tobeupdated.app.input.KeyboardInput;
import com.tobeupdated.app.input.MouseInput;
import com.tobeupdated.app.model.Player;

public class GamePanel extends JPanel {
    private final Dimension panelDimension;
    private Player player;

    public GamePanel() {
        panelDimension = new Dimension(1280, 800);
        player = new Player(100, 100);
        setMaximumSize(panelDimension);
        setMinimumSize(panelDimension);
        setPreferredSize(panelDimension);
        addKeyListener(new KeyboardInput(this));
        addMouseMotionListener(new MouseInput(this));
        addMouseListener(new MouseInput(this));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.render(g);
    }

    public Player getPlayer() {
        return player;
    }

    public void update() {
        player.update();
    }

}
