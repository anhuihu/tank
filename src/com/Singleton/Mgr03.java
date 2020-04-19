package com.Singleton;


/*
静态内部类
JVM保证单例
加载外部类时候不会加载内部类，实现懒加载
*/
public class Mgr03 {
    private Mgr03() {

    }
    private static class Mgr03Holder{
        private final static Mgr03 INSTANCE = new Mgr03();
    }

    public static Mgr03 getInstance() {
        return Mgr03Holder.INSTANCE;
    }
}
