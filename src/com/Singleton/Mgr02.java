package com.Singleton;

public class Mgr02 {
    public static volatile  Mgr02 INSTANCE;


    private Mgr02() {
    }

    public  static  Mgr02 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr02.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Mgr02();
                }
            }
        }
        return INSTANCE;
    }

}
