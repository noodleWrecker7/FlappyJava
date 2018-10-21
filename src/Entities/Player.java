package Entities;

import States.Game;

import java.awt.Graphics;

import static java.awt.Color.*;

public class Player {

    private final int x = 75;
    private int y;
    private final int w, h, jumpSpeed;
    private final float g;
    private float ySpeed;


    public Player(int width, int height) {
        this.y = 250;
        this.g = 0.15f;
        this.w = width;
        this.h = height;
        this.ySpeed = 0;
        this.jumpSpeed = -5;

    }

    public void jump() {
        this.ySpeed = jumpSpeed;
    }

    public void update(Game f) {
        this.y += this.ySpeed;
        this.ySpeed += g; // gravity
        collision(f);
    }

    private void collision(Game f) {
        if (this.y + this.h > f.getHeight()) {
            this.ySpeed = 0;
            this.y = f.getHeight() - this.h;
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
        return this.w;
    }

    public int getX() {
        return this.x;
    }

    public int getHeight() {
        return this.h;
    }

    public void render(Graphics g) {
        g.setColor(red);
        g.fillRect(this.x, this.y, this.w, this.h);
    }
}
