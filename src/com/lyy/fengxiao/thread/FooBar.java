package com.lyy.fengxiao.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    /**
     * 交替打印FooBar：1115。
     * 我们提供一个类：
     * class FooBar {
     *   public void foo() {
     *     for (int i = 0; i < n; i++) {
     *       print("foo");
     *     }
     *   }
     *   public void bar() {
     *     for (int i = 0; i < n; i++) {
     *       print("bar");
     *     }
     *   }
     * }
     * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
     * 请设计修改程序，以确保 "foobar" 被输出 n 次。
     * 示例 1:
     * 输入: n = 1
     * 输出: "foobar"
     * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
     */
    private int n;

    public FooBar(int n) {
        this.n = n;
    }


    private final Lock lock=new ReentrantLock();
    private final Condition condition1=lock.newCondition();
    private final Condition condition2=lock.newCondition();
    private boolean flag=true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!flag){
                    condition1.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
            }finally {
                flag=false;
                condition2.signalAll();
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag){
                    condition2.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
            }finally {
                flag=true;
                condition1.signalAll();
                lock.unlock();
            }
        }
    }

//    private volatile boolean flag=true;
//    private final Object lock=new Object();
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            synchronized (lock){
//                while (!flag){
//                    lock.wait();
//                }
//                // printFoo.run() outputs "foo". Do not change or remove this line.
//                printFoo.run();
//                flag=false;
//                lock.notifyAll();
//            }
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//
//            synchronized (lock){
//                while (flag){
//                    lock.wait();
//                }
//                // printBar.run() outputs "bar". Do not change or remove this line.
//                printBar.run();
//                flag=true;
//                lock.notifyAll();
//            }
//        }
//    }
}
