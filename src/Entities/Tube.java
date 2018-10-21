package Entities;

import States.Game;

import java.util.Random;
import java.awt.Graphics;

import static java.awt.Color.*;

public class Tube {

    private static final int WIDTH = 75;
    private static final int SPEED = 5;
    private int xLeft, topHeight, yBottom, yGap;

    public Tube(Game f) {
        Random rand = new Random();
        this.xLeft = f.getWidth();
        this.yGap = rand.nextInt(150) + 150;
        this.topHeight = rand.nextInt(100);
        this.yBottom = topHeight + yGap;
    }

    private void move() {
        this.xLeft -= SPEED;
    }

    public boolean offScreen() {
        return this.xLeft + WIDTH < -10;
    }

    public void render(Graphics g) {
        move();
        g.setColor(blue);
        g.fillRect(xLeft, 0, WIDTH, this.topHeight);
        g.fillRect(xLeft, yBottom, WIDTH, 600); // height doesn't matter - will go off screen
    }
}
