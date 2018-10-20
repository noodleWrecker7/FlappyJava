package Entities;

import States.Game;

import java.awt.Graphics;

import static java.awt.Color.*;

public class Player {

    private final int x = 50;
    private int y, ySpeed;
    private final int g, w, h, jumpSpeed;
    private static final int fps = Game.fps;


    public Player(int width, int height) {
        this.y = 250;
        this.g = 1;
        this.w = width;
        this.h = height;
        this.ySpeed = 0;
        this.jumpSpeed = -20;

    }

    public void jump() {
        this.ySpeed = jumpSpeed;
    }

    public void update(){
        this.y += this.ySpeed;
        this.ySpeed += g; // gravity
    }

    public void collision(){

    }

    public void render(Graphics g) {
        g.setColor(red);
        g.fillRect(this.x, this.y, this.w, this.h);
    }
}
