package com.tank;


import java.util.Properties;

public class Mian {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();


        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        // 初始化敌方tank
        for (int i = 0; i < initTankCount; i++) {

            tf.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN,Group.BAD, tf));

        }
        while (true) {
            Thread.sleep(50);
            tf.repaint();




        }
    }

}
