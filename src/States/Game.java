package States;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

import static java.awt.Color.*;

public class Game extends Canvas {

    private int x, y;
    private int w, h;

    public Game() {
        this.x = 0;
        this.y = 0;
        this.w = 50;
        this.h = 50;


    }

    public void paint(Graphics g) {
        w++;
        h++;
        g.setColor(red);
        g.fillRect(x, y, w, h);

    }

    public void keyDown(char e) {

    }
    public void keyUp(char e) {

    }

    public static void main(String args[]) {

    }

}
