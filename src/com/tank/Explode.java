package com.tank;

import java.awt.*;
import java.util.Random;

public class Explode {

    private int x, y;
    private Dir dir = Dir.DOWN;
    private TankFrame tf = null;
    private int step = 0;

    public static int WIDTH = ResourceMgr.exploads[0].getWidth();
    public static int HEIGHT = ResourceMgr.exploads[0].getHeight();


    public Explode(int x, int y, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.exploads[step++], x, y, null);
        if (step >= ResourceMgr.exploads.length) step = 0;

    }


}


