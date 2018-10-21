package States;

import Entities.Player;
import Entities.Tube;

import java.awt.*;

import static java.awt.Color.*;

public class Game extends Canvas {

    public static final int fps = 15;
    private int score = 0;
    private Player player = new Player(50, 50);
    private Rect top, bottom, mid;
    private Tube tube = null;

    public Game(int width, int height) {
        this.setSize(width, height); // this is so the definition below can get the dimensions of itself
        top = new Rect(0, 0, this.getWidth(), 100, green);
        bottom = new Rect(0, 500, this.getWidth(), 100, green);
        mid = new Rect(0, 100, this.getWidth(), 400, gray);

    }

    public void paint(Graphics g) {
        player.update(this);

        top.render(g);
        bottom.render(g);
        mid.render(g);

        manageTubes(g);

        player.render(g);
        g.drawString(Integer.toString(score), 25, 25);

    }

    private void manageTubes(Graphics g) {
        if (tube != null) {
            tube.render(g);
            if (tube.offScreen()) {
                tube = new Tube(this);
                score ++;
            }
        } else {
            tube = new Tube(this);
        }
    }

    public boolean collideTube() {
        boolean b = false;
        if (player.getX() < tube.getX() + tube.getWidth() && player.getX() + player.getWidth() > tube.getX()) {
            if (player.getY() < tube.getTop() || player.getY() + player.getHeight() > tube.getBottom()) {
                b = true;
            }
        }
        return b;
    }

    public int getScore() {
        return score;
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void keyUp(int e) {
        if (e == 32) {
            player.jump();
        }
    }

}

class Rect {

    private int x, y, w, h;
    private Color colour;

    Rect(int x, int y, int w, int h, Color c) {
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