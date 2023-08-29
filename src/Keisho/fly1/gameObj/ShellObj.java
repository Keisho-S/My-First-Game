package Keisho.fly1.gameObj;

import java.awt.*;

import Keisho.fly1.FlyFree;
import Keisho.fly1.gameItem.GameItem;

public class ShellObj extends GameObj {

    public ShellObj() {
        super();
    }

    public ShellObj(Image img, int x, int y, int width, int height, double speed, FlyFree frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public Image getImg() {

        return super.getImg();
    }

    @Override
    public Rectangle getRec() {

        return super.getRec();
    }

    @Override
    public void paintSelf(Graphics gImage) {

        super.paintSelf(gImage);
        y -= speed;

        // delete the bullets that out of the frame
        if (y < 0) {
            this.x = -100;
            this.y = 100;
            GameItem.removeList.add(this);
        }
    }

}
