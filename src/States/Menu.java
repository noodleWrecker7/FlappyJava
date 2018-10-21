package States;

import java.awt.*;

import static java.awt.Color.black;

public class Menu extends Canvas {

    private int s;

    public Menu(int width, int height) {
        this.setSize(width, height);

    }

    public void setScore(int s) {
        this.s = s;
    }

    public void paint(Graphics g) {
        g.setColor(black);
        g.drawString("GAME OVER", 150, 250);
        g.drawString("YOU SCORED: " + s, 150, 300);
    }
}