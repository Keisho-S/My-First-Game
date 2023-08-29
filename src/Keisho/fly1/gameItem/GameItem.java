package Keisho.fly1.gameItem;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Keisho.fly1.gameObj.*;

public class GameItem {

    public static Image bgImg = new ImageIcon("Keisho/fly1/image/universe.jpg").getImage();
    public static Image boss1 = new ImageIcon("Keisho/fly1/image/boss1.png").getImage();
    public static Image explodeS = new ImageIcon("Keisho/fly1/image/explosion.png").getImage();
    public static Image explodeBoss = new ImageIcon("Keisho/fly1/image/bo.png").getImage();
    public static Image planeImg = new ImageIcon("Keisho/fly1/image/plane1.png").getImage();
    public static Image shellImg = new ImageIcon("Keisho/fly1/image/bullet.png").getImage();
    public static Image bulletImg = new ImageIcon("Keisho/fly1/image/bulletE.png").getImage();
    public static Image bullet1Img = new ImageIcon("Keisho/fly1/image/bullet1.png").getImage();
    public static Image enemyImg = new ImageIcon("Keisho/fly1/image/enemy.png").getImage();
    public static Image enemy1Img = new ImageIcon("Keisho/fly1/image/enemy1.png").getImage();

    // all list of game object
    public static List<GameObj> gameObjList = new ArrayList<>();

    // my bullets list
    public static List<ShellObj> shellObjList = new ArrayList<>();

    // enemy bullets list
    public static List<BulletObj> bulletObjList = new ArrayList<>();

    // enemy1 bullets list
    public static List<Enemy1BulletObj> enemy1BulletObjList = new ArrayList<>();

    // enemy list
    public static List<EnemyObj> enemyObjList = new ArrayList<>();

    // enemy1 list
    public static List<Enemy1Obj> enemy1ObjList = new ArrayList<>();

    // explode list
    public static List<ExplodeObj> explodeObjList = new ArrayList<>();

    // delete list
    public static List<GameObj> removeList = new ArrayList<>();

    // font tool
    public static void drawWorld(Graphics gImage, String str, Color color, int size, int x, int y) {
        gImage.setColor(color);
        gImage.setFont(new Font("sans-serif", Font.BOLD, size));
        gImage.drawString(str, x, y);
    }

}
