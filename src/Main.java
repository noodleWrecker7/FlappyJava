import States.Game;
import States.Menu;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;


public class Main {


    public static Game game = new Game();
    public static Menu menu = new Menu();
    public static final int fps = 25;

    public static void main(String args[]) {
        boolean inGame = true;
        JFrame frame = new JFrame("Title");

        game.setSize(400, 600);
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        game.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // not needed
            }

            @Override
            public void keyPressed(KeyEvent e) {
                game.keyDown(e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                game.keyUp(e.getKeyChar());
            }
        });

        Timer timer = new Timer();
        // renders screen every frame
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (inGame) {
                    game.repaint();
                }
            }
        }, 1000, 1000/fps);


    }
}
