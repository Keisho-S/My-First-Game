package Keisho.fly1.gameObj;

import java.awt.*;

import Keisho.fly1.FlyFree;

public class GameObj {

    Image img;
    int x;
    int y;
    int width;
    int height;
    double speed;
    FlyFree frame;

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public FlyFree getFrame() {
        return frame;
    }

    public void setFrame(FlyFree frame) {
        this.frame = frame;
    }

    public GameObj() {

    }

    public GameObj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public GameObj(Image img, int x, int y, double speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public GameObj(Image img, int x, int y, int width, int height, double speed, FlyFree frame) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.frame = frame;
    }

    public void paintSelf(Graphics gImage) {
        gImage.drawImage(img, x, y, null);
    }

    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }

}
