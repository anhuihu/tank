package com.tank;


import org.w3c.dom.css.Rect;

import java.awt.*;


public class Bullet {
    // bullet speed
    private static final int SPEED = 5;
    // bullet size
    public static int WIDTH = ResourceMgr.bulletU.getWidth();
    public static int HEIGHT = ResourceMgr.bulletU.getHeight();
    Rectangle rect = new Rectangle();

    // bullet location
    private int x, y;
    // bullet direction
    private Dir dir;
    private Group group = Group.BAD;
    // 为了解决bullet的list无限增加的问题，给子弹类添加一个live属性，用于判断是否需要将其从list remove
    private boolean living = true;
    // bullet 构造方法 structure
    TankFrame tf = null;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        tf.bullets.add(this);

    }

    public void paint(Graphics g) {
        // bullet 绘制前判断bullet的live属性
        if (!living) {
            tf.bullets.remove(this);
        }

        Color c = g.getColor();

        // bullet color
//        g.setColor(Color.RED);
//        g.fillOval(x, y, WIDTH, HEIGHT);
//        g.setColor(c);
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;

        }
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
        // update rect
        rect.x = this.x;
        rect.y = this.y;
        // 判断子弹的位置是否移出了定义的游戏窗口，如果移除窗口，将其设置为false
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;


    }

    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) return;
        // 用一个rect来记录子弹的  每移动一次都要做碰撞检测，所有子弹和所有tank的遍历
        // tank数量为n，子弹数量为m，每次都要进行n*m的碰撞检测，每次都要产生两个 Rectangle
        // 每次重画都要产生2m*n的新对象，为了消除这个问题，在tank和子弹中记录一个rect，每次移动，更新这个值
        // 检测时候直接拿来
//        Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
//        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), tank.WIDTH, tank.HEIGHT);
        if (rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
//            ResourceMgr.explodes.add(new Explode(x, y, tf));
            tf.explodes.add(new Explode(eX, eY, tf));
        }

    }

    private void die() {
        this.living = false;
    }

    ;
}
