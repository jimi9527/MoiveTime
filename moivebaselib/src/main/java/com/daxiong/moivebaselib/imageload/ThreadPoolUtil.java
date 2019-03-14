package com.daxiong.moivebaselib.imageload;

import android.support.annotation.NonNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/1/3
 */
public class ThreadPoolUtil {
    // 当前cpu核心数
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    // 当前核心进程数量
    private static final int CORE_POOL_SIZE = CPU_COUNT - 1;
    // 当前最大线程数
    private static final int MAX_POOL_SIZE = CPU_COUNT * 2 + 1;
    //过剩的空闲线程的存活时间
    private static final int KEEP_ALIVE_SECONDS = 30;
    private BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();

    // 线程工厂
    private static final ThreadFactory threadFactory = new ThreadFactory() {

        private final AtomicInteger atomicInteger = new AtomicInteger(1);

        @Override
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "ThreadPoolUtil:" + atomicInteger.getAndIncrement());
        }
    };

    private ThreadPoolExecutor mExectuor;
    public static ThreadPoolUtil threadPoolUtil;

    public static ThreadPoolUtil getInstance(){
        if(threadPoolUtil == null){
            synchronized (ThreadPoolUtil.class){
                if(threadPoolUtil == null){
                    threadPoolUtil = new ThreadPoolUtil();
                }
            }
        }
        return threadPoolUtil;
    }


    private void initThreadPool() {
        if (mExectuor == null || mExectuor.isShutdown() || mExectuor.isTerminated()) {
            synchronized (ThreadPoolUtil.class) {
                if (mExectuor == null || mExectuor.isShutdown() || mExectuor.isTerminated()) {
                    RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
                    mExectuor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_SECONDS, TimeUnit.MILLISECONDS
                            , workQueue, threadFactory, handler);
                }
            }
        }
    }

    public void excute(Runnable task){
        initThreadPool();
        mExectuor.execute(task);
    }

    public void remove(Runnable task){
        initThreadPool();
        mExectuor.remove(task);
    }

    public void shutDown(){
        initThreadPool();
        mExectuor.shutdownNow();
    }


}
