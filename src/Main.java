import States.Game;
import States.Menu;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;


public class Main {


    private static Game game = new Game(400, 600);
    private static Menu menu = new Menu(400, 600);
    private static final int fps = game.fps;

    public static void main(String args[]) {
        boolean inGame = true;
        JFrame frame = new JFrame("Title");

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

            }

            @Override
            public void keyReleased(KeyEvent e) {
                game.keyUp(e.getKeyCode());
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
