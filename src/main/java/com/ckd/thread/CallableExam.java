package com.ckd.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 实现线程的方式：
 * 通过Callable接口
 * @author diaochengkun
 * @create 2018-12-20
 **/
public class CallableExam implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "实现callable接口方式";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask(new CallableExam());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
