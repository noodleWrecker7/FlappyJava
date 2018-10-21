import States.Game;
import States.Menu;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;


public class Main {


    private static Game Game = new Game(400, 600);
    private static Menu menu = new Menu(400, 600);
    private static final int fps = Game.fps;

    public static void main(String args[]) {
        boolean inGame = true;
        JFrame frame = new JFrame("Title");

        frame.add(Game);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        Game.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // not needed
            }

            @Override
            public void keyPressed(KeyEvent e) {
                Game.keyDown(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Game.keyUp(e.getKeyCode());
            }
        });

        Timer timer = new Timer();
        // renders screen every frame
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                Game.repaint();
                if (Game.collideTube()) {
                    frame.remove(Game);
                    frame.add(menu);
                    menu.setScore(Game.getScore());
                    menu.repaint();
                    timer.cancel();
                }
            }
        }, 1000, 1000 / fps);
    }
}
