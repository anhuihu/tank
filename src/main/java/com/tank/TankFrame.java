package com.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.ArrayList;
import java.util.List;


public class TankFrame extends Frame {

    Tank MyTank = new Tank(200, 200, Dir.DOWN,this);
    List<Bullet> bullets = new ArrayList<>();
//    Bullet bullet = new Bullet(300, 300, Dir.DOWN, tf););
    static final int GAME_WIDTH=800, GAME_HEIGHT = 600;
    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(100);

            }
        });
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffscreen = offScreenImage.getGraphics();
        Color c = gOffscreen.getColor();
        gOffscreen.setColor(Color.GREEN);
        gOffscreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffscreen.setColor(c);
        paint(gOffscreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        MyTank.paint(g);
//        bullet.paint(g)
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
        g.setColor(c);
        MyTank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
    }



    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
//                    x -= 10;
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
//                    y -= 10;
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
//                    x += 10;
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
//                    y += 10;
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    MyTank.fire();
                default:
                    break;
            }

            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bL && !bU && !bD && !bR) MyTank.setMoving(false);
            else {
                MyTank.setMoving(true);

                if (bL) MyTank.setDir(Dir.LEFT);
                if (bU) MyTank.setDir(Dir.UP);
                if (bR) MyTank.setDir(Dir.RIGHT);
                if (bD) MyTank.setDir(Dir.DOWN);
            }
        }
    }
}
