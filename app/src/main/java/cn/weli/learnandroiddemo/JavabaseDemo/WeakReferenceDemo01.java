package cn.weli.learnandroiddemo.JavabaseDemo;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo01 {

    public static void main(String[] args) {

        Apple apple = new Apple("红富士");

        WeakReference<Apple> appleWeakReference = new WeakReference<>(apple);
        Apple apple1 = appleWeakReference.get();
        System.out.println("Apple:" +apple1);
        System.gc();
        try {
            //休眠一下，在运行的时候加上虚拟机参数-XX:+PrintGCDetails，输出gc信息，确定gc发生了。
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //如果为空，代表被回收了
        if (apple1 == null) {
            System.out.println("clear Apple。");
        }

    }

}
