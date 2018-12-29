package com.ckd.thread;

/**
 * @author diaochengkun
 * @create 2018-12-20
 **/
public class ThreadSort {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread3");
            }
        });

        t1.start();

        t2.start();

        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
