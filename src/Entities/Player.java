package Entities;

import States.Game;

import java.awt.Graphics;

import static java.awt.Color.*;

public class Player {

    private final int x = 50;
    private int y;
    private final int g, w, h;


    public Player(int width, int height) {
        this.y = 250;
        this.g = 20;
        this.w = width;
        this.h = height;

    }

    public void jump() {

    }

    public void render(Graphics g) {
        g.setColor(red);
        g.fillRect(this.x, this.y, w, h);
    }

}
