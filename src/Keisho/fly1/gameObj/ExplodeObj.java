package Keisho.fly1.gameObj;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class ExplodeObj extends GameObj {

    static Image[] pic = new Image[17];

    int explodeCount = 0; // for limiting the explosion anime

    static {
        for (int i = 0; i < pic.length; i++) {
            pic[i] = new ImageIcon("Keisho/fly1/image/explode/" + (i + 1) + ".gif").getImage();
        }
    }

    public ExplodeObj(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics gImage) {

        if (explodeCount < 16) {
            img = pic[explodeCount];
            super.paintSelf(gImage);
            explodeCount++;
        }
    }

}
