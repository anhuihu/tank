package com.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    Tank MyTank = new Tank(200, 200, Dir.DOWN);


    public TankFrame() {
        setSize(800, 600);
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

    @Override
    public void paint(Graphics g) {
        MyTank.paint(g);
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
//                    x -= 10;
                bL = true;
                break;
            case KeyEvent.VK_UP:
//                    y -= 10;
                bU = true;
                break;
            case KeyEvent.VK_RIGHT:
//                    x += 10;
                bR = true;
                break;
            case KeyEvent.VK_DOWN:
//                    y += 10;
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
            default:
                break;
        }

        setMainTankDir();
    }

    private void setMainTankDir() {
        if (bL) MyTank.setDir(Dir.LEFT);
        if (bU) MyTank.setDir(Dir.UP);
        if (bR) MyTank.setDir(Dir.RIGHT);
        if (bD) MyTank.setDir(Dir.DOWN);
    }
}
}
