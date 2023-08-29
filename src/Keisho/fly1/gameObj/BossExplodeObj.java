package Keisho.fly1.gameObj;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class BossExplodeObj extends GameObj {

    static Image[] picBoss = new Image[79];

    int explodeCount = 0; // for limiting the explosion anime

    static {
        for (int i = 0; i < picBoss.length; i++) {
            picBoss[i] = new ImageIcon("src/Keisho/fly1/image/bossExplode/" + (i + 1) + ".gif").getImage();
        }
    }

    public BossExplodeObj(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics gImage) {

        if (explodeCount < 79) {
            img = picBoss[explodeCount];
            super.paintSelf(gImage);
            explodeCount++;
        }
    }

}
