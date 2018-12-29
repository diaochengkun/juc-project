package com.ckd.thread;

/**
 * wait  sleep  的区别
 * 1.wait是Object类提供的方法  sleep是Thread提供的方法
 * 2.执行wait() 可以让当前线程让出CPU,将当前线程挂起,此时会释放锁。
 *   执行sleep() 同样可以将当前线程让出CPU,进入休眠,但是不会释放锁,一旦休眠结束，会进入Runnable状态,开始抢占锁
  3.
 * @author diaochengkun
 * @create 2018-12-20
 **/
public class WaitAndSleepDiff {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Thread1(1),"thread1....");
        Thread t3 = new Thread(new Thread1(3),"thread3....");
        Thread t4 = new Thread(new Thread1(4),"thread4....");
        Thread t2 = new Thread(new Thread2(2),"thread2....");
        t1.start();
        t1.join();
        t2.start();
        t2.wait();
        t3.start();
        t3.wait();
        t4.start();
        t4.wait();

        synchronized (t1){
            while (t1.isAlive()){
                t1.wait();
            }
        }
    }
    private static class Thread1 implements Runnable{
        private int id;
        public Thread1(int id){
            this.id = id;
        }
        @Override
        public void run() {
            synchronized (WaitAndSleepDiff.class){
                System.out.println("enter thread1.. id="+id);
                try {
                    WaitAndSleepDiff.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 is over..id="+id);
            }
        }
    }

    private static class Thread2 implements Runnable{

        private int id;
        public Thread2(int id){
            this.id = id;
        }
        @Override
        public void run() {
            synchronized (WaitAndSleepDiff.class){
                System.out.println("enter thread2..id="+id);
                WaitAndSleepDiff.class.notifyAll();
                System.out.println("thread2 is over..id="+id);
            }
        }
    }
}
