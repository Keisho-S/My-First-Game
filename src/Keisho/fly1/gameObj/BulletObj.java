package Keisho.fly1.gameObj;

import java.awt.*;

import Keisho.fly1.FlyFree;
import Keisho.fly1.gameItem.GameItem;

public class BulletObj extends GameObj {

    public BulletObj(Image img, int x, int y, int width, int height, double speed, FlyFree frame) {
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

        // collision detection
        if (this.getRec().intersects(this.frame.planeObj.getRec())) {
            FlyFree.state = 3;
        }

        // delete enemy bullets that out of the frame
        if (y > 600) {
            this.x = -300;
            this.y = 300;
            GameItem.removeList.add(this);
        }
    }

}
