package States;

import Entities.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

import static java.awt.Color.*;

public class Game extends Canvas {

    public static final int fps = 25;
    private int x, y;
    private int w, h;
    Player player = new Player(50, 50);
    Rect top, bottom, mid;

    public Game(int width, int height) {
        this.setSize(width, height); // this is so the definition below can get the dimensions of itself
        top = new Rect(0, 0, this.getWidth(), 200, green);
        bottom = new Rect(0, 400, this.getWidth(), 200, green);
        mid = new Rect(0, 200, this.getWidth(), 200, gray);
    }

    public void paint(Graphics g) {
        player.update();

        top.render(g);
        bottom.render(g);
        mid.render(g);

        player.render(g);

    }

    public void update(Graphics g) {
        paint(g);
    }

    public void keyDown(int e) {

    }
    public void keyUp(int e) {
        if(e == 32) {
            player.jump();
        }
    }
}

class Rect {

    int x, y, w, h;
    Color colour;

    Rect(int x, int y, int w, int h, Color c){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.colour = c;
    }

    void render(Graphics g) {
        g.setColor(colour);
        g.fillRect(this.x, this.y, this.w, this.h);
    }
}