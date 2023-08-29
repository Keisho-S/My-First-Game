package Keisho.fly1;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import Keisho.fly1.gameItem.*;
import Keisho.fly1.gameObj.*;

public class FlyFree extends JFrame {

    // default state
    public static int state = 0;

    // score
    public static int score = 0;

    Image offScreenImage = null;
    int width = 600;
    int height = 600;

    int count = 1;

    // record of enemy number
    int enemyCount = 0;

    // background
    BgObj bgObj = new BgObj(GameItem.bgImg, 0, -2000, 2);

    // plane
    public PlaneObj planeObj = new PlaneObj(GameItem.planeImg, 290, 550, 10, 10, 0, this);

    // boss
    public BossObj bossObj = null;

    public void launch() {

        this.setVisible(true);

        this.setSize(width, height);

        this.setLocationRelativeTo(null);

        this.setTitle("Keisho FlyFree");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // this.makeSound();

        GameItem.gameObjList.add(bgObj);
        GameItem.gameObjList.add(planeObj);
        // GameItem.gameObjList.add(bossObj);

        // click mouse to start game
        this.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                if (e.getButton() == 1 && state == 0) {

                    state = 1;

                }

            }

        });

        // pause
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 32) {
                    switch (state) {
                        case 1:
                            state = 2;
                            break;
                        case 2:
                            state = 1;
                            break;
                        default:

                    }
                }
            }
        });

        while (true) {
            if (state == 1) {
                createObj();
                repaint();

            }

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void paint(Graphics g) {

        if (offScreenImage == null) {
            offScreenImage = createImage(width, height);
        }
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0, 0, width, height);

        if (state == 0) {

            gImage.drawImage(GameItem.bgImg, 0, 0, null);
            gImage.drawImage(GameItem.boss1, 230, 40, null);
            gImage.drawImage(GameItem.enemyImg, 100, 100, null);
            gImage.drawImage(GameItem.enemy1Img, 450, 100, null);
            gImage.drawImage(GameItem.explodeS, 250, 400, null);
            GameItem.drawWorld(gImage, "Click to Start Game", Color.yellow, 30, 150, 300);

        }
        if (state == 1) {

            GameItem.gameObjList.addAll(GameItem.explodeObjList);

            for (int i = 0; i < GameItem.gameObjList.size(); i++) {
                GameItem.gameObjList.get(i).paintSelf(gImage);
            }

            GameItem.gameObjList.removeAll(GameItem.removeList);
            // System.out.println(GameItem.gameObjList.size());

        }
        if (state == 3) {

            gImage.drawImage(GameItem.explodeS, planeObj.getX() - 35, planeObj.getY() - 10, null);
            GameItem.drawWorld(gImage, "GAME OVER", Color.red, 50, 150, 300);

        }
        if (state == 4) {

            gImage.drawImage(GameItem.explodeBoss, bossObj.getX() - 55, bossObj.getY() - 10, null);
            GameItem.drawWorld(gImage, "YOU WIN", Color.green, 50, 190, 350);

        }

        GameItem.drawWorld(gImage, "* " + score, Color.PINK, 30, 30, 100);
        g.drawImage(offScreenImage, 0, 0, null);
        count++;

    }

    public void createObj() {
        // bullet
        if (count % 15 == 0) {
            GameItem.shellObjList
                    .add(new ShellObj(GameItem.shellImg, planeObj.getX() + 8, planeObj.getY() - 16, 14, 29, 5, this));
            GameItem.gameObjList.add(GameItem.shellObjList.get(GameItem.shellObjList.size() - 1));

        }

        // enemy
        if (count % 40 == 0) {
            GameItem.enemyObjList
                    .add(new EnemyObj(GameItem.enemyImg, (int) (Math.random() * 12) * 50, 0, 45, 50, 5, this));
            GameItem.gameObjList.add(GameItem.enemyObjList.get(GameItem.enemyObjList.size() - 1));
            enemyCount++;

        }
        if (count % 20 == 0) {
            // enemy1
            if (count % 100 == 0) {
                GameItem.enemy1ObjList
                        .add(new Enemy1Obj(GameItem.enemy1Img, (int) (Math.random() * 12) * 50, 0, 90, 132, 3, this));
                GameItem.gameObjList.add(GameItem.enemy1ObjList.get(GameItem.enemy1ObjList.size() - 1));
                enemyCount++;

            }
            if (GameItem.enemy1ObjList.size() > 0) {

                // x and y is the location of current generated enemy1, use this location to
                // create bullet1
                int x = (GameItem.enemy1ObjList.get(GameItem.enemy1ObjList.size() - 1)).getX();
                int y = (GameItem.enemy1ObjList.get(GameItem.enemy1ObjList.size() - 1)).getY();
                GameItem.enemy1BulletObjList
                        .add(new Enemy1BulletObj(GameItem.bullet1Img, x + 35, y + 40, 20, 20, 5, this));
                GameItem.gameObjList.add(GameItem.enemy1BulletObjList.get(GameItem.enemy1BulletObjList.size() - 1));
            }

        }

        // enemy bullet
        if (count % 13 == 0 && bossObj != null) {
            GameItem.bulletObjList
                    .add(new BulletObj(GameItem.bulletImg, bossObj.getX() + 50, bossObj.getY() + 200, 14, 29, 5,
                            this));
            GameItem.gameObjList.add(GameItem.bulletObjList.get(GameItem.bulletObjList.size() - 1));

        }

        if (enemyCount > 60 && bossObj == null) {
            bossObj = new BossObj(GameItem.boss1, 290, 25, 122, 221, 5, this);
            GameItem.gameObjList.add(bossObj);
        }

    }

    public static void main(String[] args) {

        FlyFree flyFree = new FlyFree();

        flyFree.launch();
    }

    public void makeSound() {
        File lol = new File("Keisho/fly1/flower.wav");

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(lol));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
