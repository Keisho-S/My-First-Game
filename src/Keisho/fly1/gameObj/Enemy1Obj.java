package Keisho.fly1.gameObj;

import java.awt.*;

import Keisho.fly1.FlyFree;
import Keisho.fly1.gameItem.GameItem;

public class Enemy1Obj extends GameObj {

    int enemy1HP = 2; // enemy1 HP

    public Enemy1Obj() {
        super();
    }

    public Enemy1Obj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public Enemy1Obj(Image img, int x, int y, int width, int height, double speed, FlyFree frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public Rectangle getRec() {

        return super.getRec();
    }

    @Override
    public void paintSelf(Graphics gImage) {

        super.paintSelf(gImage);
        y += speed;

        // collision detection between enemy and hero
        if (this.getRec().intersects(this.frame.planeObj.getRec())) {
            FlyFree.state = 2;
        }

        // delete enemies that out of the frame
        if (y > 600) {
            this.x = -200;
            this.y = 200;
            GameItem.removeList.add(this);
        }

        // collision detection
        for (ShellObj shellObj : GameItem.shellObjList) {
            if (this.getRec().intersects(shellObj.getRec())) {

                ExplodeObj explodeObj = new ExplodeObj(x, y);
                GameItem.explodeObjList.add(explodeObj);
                GameItem.removeList.add(explodeObj);
                shellObj.setX(-100);
                shellObj.setY(100);
                GameItem.removeList.add(shellObj);
                enemy1HP--;

                if (enemy1HP <= 0) {
                    this.x = -200;
                    this.y = 200;
                    GameItem.removeList.add(this);
                    FlyFree.score++;
                }

            }
        }
    }

}
