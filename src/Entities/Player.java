package Entities;

import States.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.Color.*;

public class Player {

    private static final int X = 75;
    private int y;
    private final int W, H;
    private static final int JUMP_SPEED = -5;
    private static final float GRAVITY = 0.14f;
    private float ySpeed;
    private BufferedImage img = null;

    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = env.getDefaultScreenDevice();
    GraphicsConfiguration config = device.getDefaultConfiguration();
    Graphics2D g2;

    public Player(int width, int height) {
        this.y = 250;
        this.W = width;
        this.H = height;
        this.ySpeed = 0;


        // img = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
        img = config.createCompatibleImage(50, 50 , Transparency.TRANSLUCENT);
        g2 = img.createGraphics();


        /*try {
            img = ImageIO.read(new File("C:/Users/hodgk/IdeaProjects/FlappyJava/out/production/FlappyJava/Assets/Bird.png"));
        } catch(IOException e) {
            System.out.println("Error reading");
        }*/

        try {
            ImageIO.write(img, "jpg",new File("file.jpg"));
            //g2.dispose();
        } catch (Exception e) {
            System.out.println("Error saving");
        }
    }

    public void jump() {
        this.ySpeed = JUMP_SPEED;
    }

    public void update(Game f) {
        this.y += this.ySpeed;
        this.ySpeed += GRAVITY; // gravity
        collision(f);
    }

    private void collision(Game f) {
        if (this.y + this.H > f.getHeight()) {
            this.ySpeed = 0;
            this.y = f.getHeight() - this.H;
        }
        if (this.y < 0) {
            this.ySpeed = 0;
            this.y = 0;
        }
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.W;
    }

    public int getX() {
        return X;
    }

    public int getHeight() {
        return this.H;
    }

    private void cacheImg(){
        try {
            img = ImageIO.read(new File("C:/Users/hodgk/IdeaProjects/FlappyJava/out/production/FlappyJava/Assets/Bird.png"));
        } catch(IOException e) {
            System.out.println("Error reading");
        }

    }


    public void render(Graphics g) {
        //g.setColor(red);
        //g.fillRect(X, this.y, this.W, this.H);
        /*g2.setColor(red);
        g2.fillRect(0, 0, 50, 50);*/
        cacheImg();
        g.drawImage(this.img, X, this.y, null);

    }
}