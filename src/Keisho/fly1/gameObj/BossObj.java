package Keisho.fly1.gameObj;

import java.awt.*;

import Keisho.fly1.FlyFree;
import Keisho.fly1.gameItem.GameItem;

public class BossObj extends GameObj {

    int bossHP = 50;

    public BossObj() {
        super();
    }

    public BossObj(Image img, int x, int y, int width, int height, double speed, FlyFree frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public Rectangle getRec() {

        return super.getRec();
    }

    @Override
    public void paintSelf(Graphics gImage) {

        super.paintSelf(gImage);

        if (x > 550 || x < -50) {
            speed = -speed;
        }
        x += speed;
        for (ShellObj shellObj : GameItem.shellObjList) {
            if (this.getRec().intersects(shellObj.getRec())) {
                ExplodeObj explodeObj = new ExplodeObj(x, y + 100);
                GameItem.explodeObjList.add(explodeObj);
                GameItem.removeList.add(explodeObj);
                shellObj.setX(-100);
                shellObj.setY(100);
                GameItem.removeList.add(shellObj);
                bossHP--;
            }
            if (bossHP <= 0) {

                FlyFree.state = 4;
            }
        }

        // BOSS HP bar back ground
        gImage.setColor(Color.white);
        gImage.fillRect(20, 40, 500, 10);

        //
        gImage.setColor(Color.red);
        gImage.fillRect(20, 40, bossHP * 100 / 10, 10);
    }

}
