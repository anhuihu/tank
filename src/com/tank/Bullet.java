package com.tank;



import java.awt.*;



public class Bullet {
    // bullet speed
    private static final int SPEED = 5;
    // bullet size
    private static final int WIDTH= 30,HEIGHT = 30;

    // bullet location
    private int x, y;
    // bullet direction
    private Dir dir;
    // 为了解决bullet的list无限增加的问题，给子弹类添加一个live属性，用于判断是否需要将其从list remove
    private boolean live = true;
    // bullet 构造方法 structure
    TankFrame tf = null;
    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;

    }

    public void paint(Graphics g) {
        // bullet 绘制前判断bullet的live属性
        if (!live) {
            tf.bullets.remove(this);
        }

        Color c = g.getColor();

        // bullet color
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);

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
        // 判断子弹的位置是否移出了定义的游戏窗口，如果移除窗口，将其设置为false
        if (x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT) live = false;

    }
}
