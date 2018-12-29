package com.ckd.thread;

/**
 * 线程实现方式：
 * 继承线程类
 * @author diaochengkun
 * @create 2018-12-20
 **/
public class ThreadExam extends Thread {

    public static void main(String[] args) {
        ThreadExam thread  = new ThreadExam();
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("线程开始执行");
    }
}
