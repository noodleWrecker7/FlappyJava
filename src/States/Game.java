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

    public Game() {

    }

    public void paint(Graphics g) {

        g.setColor(green);
        g.fillRect(0, 0, this.getWidth(), 200);
        g.fillRect(0, 400, this.getWidth(), 200);
        player.render(g);

    }

    public void update(Graphics g) {
        paint(g);
    }

    public void keyDown(int e) {

    }
    public void keyUp(int e) {
        if(e == 32) {

        }
    }

    public static void main(String args[]) {

    }

}
