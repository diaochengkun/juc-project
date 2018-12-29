package com.ckd.threadpool;

import java.util.concurrent.*;

/**
 * @author diaochengkun
 * @create 2018-12-21
 **/
public class ThreadPoolExecutorExam {

    //线程核心数量
    private static int coreSize = 10;

    //线程最大数量
    private static int maxSize = 20;

    //线程数大于coreSize时,空闲线程数空闲时间
    private static int keepAliveTime = 10;

    private static TimeUnit aliveTimeUnit = TimeUnit.SECONDS;

    //线程缓存队列
    private static BlockingDeque<Runnable> workQueue = null;

    private static ThreadPoolExecutor threadPoolExecutor = null;

    //线程工厂
    private static ThreadFactory threadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"threadName");
        }
    };

    static {
        workQueue = new LinkedBlockingDeque<>(5);
        threadPoolExecutor = new ThreadPoolExecutor(coreSize,maxSize,keepAliveTime,aliveTimeUnit,workQueue,threadFactory);
    }

    public static void main(String[] args) {
        try {
            for(int i=0;i<200;i++){
                System.out.println("===========第"+i+"次");
                threadPoolExecutor.execute(()->{System.out.println("当前线程:"+Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                System.out.println("线程池中正在执行的线程数量:"+threadPoolExecutor.getPoolSize());
                System.out.println("线程池中缓存任务队列数:"+threadPoolExecutor.getQueue().size());
            }
        }finally {
            threadPoolExecutor.shutdown();
        }
    }
}
