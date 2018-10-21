package Entities;

import States.Game;

import java.awt.Graphics;

import static java.awt.Color.*;

public class Player {

    private static final int X = 75;
    private int y;
    private final int W, H;
    private static final int JUMP_SPEED = -5;
    private static final float GRAVITY = 0.15f;
    private float ySpeed;


    public Player(int width, int height) {
        this.y = 250;
        this.W = width;
        this.H = height;
        this.ySpeed = 0;
    }

    public void jump() {
        this.ySpeed = JUMP_SPEED;
    }

    public void update(Game f) {
        this.y += this.ySpeed;
        this.ySpeed += GRAVITY; // gravity
        collision(f);
    }

    private void collision(Game f) {
        if (this.y + this.H > f.getHeight()) {
            this.ySpeed = 0;
            this.y = f.getHeight() - this.H;
        }
        if (this.y < 0) {
            this.ySpeed = 0;
            this.y = 0;
        }
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.W;
    }

    public int getX() {
        return this.X;
    }

    public int getHeight() {
        return this.H;
    }

    public void render(Graphics g) {
        g.setColor(red);
        g.fillRect(this.X, this.y, this.W, this.H);
    }
}