package Entities;

import States.Game;

import java.awt.*;
import java.util.Random;

import static java.awt.Color.blue;

public class Tube {

    private static final int WIDTH = 75;
    private static final int SPEED = 5;
    private int xLeft, topHeight, yBottom;

    public Tube(Game f) {
        Random rand = new Random();
        this.xLeft = f.getWidth();
        int yGap = rand.nextInt(130) + 145;
        this.topHeight = rand.nextInt(225) + 75;
        this.yBottom = topHeight + yGap;
    }

    private void move() {
        this.xLeft -= SPEED;
    }

    public boolean offScreen() {
        return this.xLeft + WIDTH < -10;
    }

    public int getX() {
        return this.xLeft;
    }

    public int getTop() {
        return this.topHeight;
    }

    public int getBottom() {
        return this.yBottom;
    }

    public int getWidth() {
        return WIDTH;
    }

    public void render(Graphics g) {
        move();
        g.setColor(blue);
        g.fillRect(xLeft, 0, WIDTH, topHeight);
        g.fillRect(xLeft, yBottom, WIDTH, 600); // height doesn't matter - will go off screen
    }
}
