package States;

import Entities.Player;
import Entities.Tube;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import static java.awt.Color.*;

public class Game extends Canvas {

    public static final int FPS = 45;
    private int score = 0;
    private final Player PLAYER = new Player(50, 50);
    private final Rect TOP, BOTTOM, MID;
    private Tube tube = null;

    public Game(int width, int height) {

        this.setSize(width, height); // this is so the definition below can get the dimensions of itself
        TOP = new Rect(0, this.getWidth(), 100, green);
        BOTTOM = new Rect(500, this.getWidth(), 100, green);
        MID = new Rect(100, this.getWidth(), 400, gray);
    }

    public void paint(Graphics g) {
        PLAYER.update(this);

        TOP.render(g);
        BOTTOM.render(g);
        MID.render(g);

        manageTubes(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString(Integer.toString(score), 25, 25);
        PLAYER.render(g);
    }

    private void manageTubes(Graphics g) {

        if (tube != null) {
            tube.render(g);
            if (tube.offScreen()) {
                tube = new Tube(this);
                score++;
            }
        } else {
            tube = new Tube(this);
        }
    }

    public boolean collideTube() {
        boolean b = false;

        if (PLAYER.getX() < tube.getX() + tube.getWidth() && PLAYER.getX() + PLAYER.getWidth() > tube.getX()) {
            if (PLAYER.getY() < tube.getTop() || PLAYER.getY() + PLAYER.getHeight() > tube.getBottom()) {
                b = true;
            }
        }
        return b;
    }

    public int getScore() {
        return score;
    }

    public void update(Graphics g) {
        Graphics offgc;
        Image offscreen;
        Dimension d = size();

        offscreen = createImage(d.width, d.height);
        offgc = offscreen.getGraphics();

        paint(offgc);

        g.drawImage(offscreen, 0, 0, this);
    }

    public void keyDown(int e) {
        if (e == 32) {
            PLAYER.jump();
        }
    }
}

class Rect {

    private final int X, Y, W, H;
    private final Color COLOUR;

    Rect(int y, int w, int h, Color c) {
        this.X = 0;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.COLOUR = c;
    }

    void render(Graphics g) {
        g.setColor(COLOUR);
        g.fillRect(this.X, this.Y, this.W, this.H);
    }
}