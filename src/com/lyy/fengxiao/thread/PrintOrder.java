package com.lyy.fengxiao.thread;

public class PrintOrder {

    /**
     * 顺序打印：1114。
     * 我们提供了一个类：
     * public class Foo {
     *   public void one() { print("one"); }
     *   public void two() { print("two"); }
     *   public void three() { print("three"); }
     * }
     * 三个不同的线程将会共用一个 Foo 实例。
     * 线程 A 将会调用 one() 方法
     * 线程 B 将会调用 two() 方法
     * 线程 C 将会调用 three() 方法
     * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
     */
    private volatile int flag=1;

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag=2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (flag!=2){

        }

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag=3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (flag!=3){

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
