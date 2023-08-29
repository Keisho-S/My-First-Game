package Keisho.fly1.gameObj;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Keisho.fly1.FlyFree;

public class PlaneObj extends GameObj {

    public PlaneObj() {
        super();
    }

    public PlaneObj(Image img, int x, int y, int width, int height, double speed, FlyFree frame) {
        super(img, x, y, width, height, speed, frame);
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {

                PlaneObj.super.x = e.getX() - 11;
                PlaneObj.super.y = e.getY() - 16;
            }

        });

    }

    @Override
    public Rectangle getRec() {

        return super.getRec();
    }

    @Override
    public void paintSelf(Graphics gImage) {

        super.paintSelf(gImage);

        // enemy boss collision detection
        if (this.frame.bossObj != null && this.getRec().intersects(this.frame.bossObj.getRec())) {
            FlyFree.state = 3;
        }
    }
}
