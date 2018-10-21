import States.Game;
import States.Menu;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;


class Main {


    private static final Game game = new Game(400, 600);
    private static final Menu menu = new Menu(400, 600);
    private static final int fps = Game.fps;

    public static void main(String args[]) {
        JFrame frame = new JFrame("Title");

        frame.add(game);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        game.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // irrelevant
            }

            @Override
            public void keyPressed(KeyEvent e) {
                game.keyDown(e.getKeyCode());
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
                game.createBufferStrategy(2);
                game.repaint();
                if (game.collideTube()) {
                    frame.remove(game);
                    frame.add(menu);
                    menu.setScore(game.getScore());
                    menu.repaint();
                    timer.cancel();
                }
            }
        }, 1000, 1000 / fps);
    }
}
