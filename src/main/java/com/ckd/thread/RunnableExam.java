package com.ckd.thread;

/**
 * 线程实现方式：：
 * 实现Runnable接口
 * @author diaochengkun
 * @create 2018-12-20
 **/
public class RunnableExam implements Runnable{

    @Override
    public void run() {
        System.out.println("通过Runnable实现线程");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableExam());
        thread.start();
    }
}
