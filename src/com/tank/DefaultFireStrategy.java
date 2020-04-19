package com.tank;

public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        // 修改计算子弹的位置
//        tf.bullets.add(new Bullet(this.x, this.y, this.dir, this.tf));
        int bX = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.y + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
//
        new Bullet(bX, bY, t.getDir(), t.getGroup(), t.getTf());
    }
}
