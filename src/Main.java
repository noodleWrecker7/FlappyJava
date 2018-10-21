import States.Game;
import States.Menu;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;


class Main {

    private static final Game GAME = new Game(400, 600);
    private static final Menu MENU = new Menu(400, 600);
    private static final int FPS = Game.FPS;

    public static void main(String args[]) {
        JFrame frame = new JFrame("Title");

        frame.add(GAME);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        GAME.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // irrelevant
            }

            @Override
            public void keyPressed(KeyEvent e) {
                GAME.keyDown(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // irrelevant
            }
        });

        Timer timer = new Timer();
        // renders screen every frame
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                GAME.createBufferStrategy(2);
                GAME.repaint();
                if (GAME.collideTube()) {
                    frame.remove(GAME);
                    frame.add(MENU);
                    MENU.setScore(GAME.getScore());
                    MENU.repaint();
                    timer.cancel();
                }
            }
        }, 1000, 1000 / FPS);
    }
}