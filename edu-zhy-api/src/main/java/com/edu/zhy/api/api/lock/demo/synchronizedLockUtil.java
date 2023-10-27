package com.edu.zhy.api.api.lock.demo;

//synchronized 是Java中的关键字，用于实现线程安全的同步代码块或方法。它基于对象监视器（Object Monitor）来提供互斥访问和可见性保证。

//CustomLock 类使用一个布尔型变量 locked 来表示锁的状态。
//
//lock() 方法通过使用 synchronized 关键字将其声明为同步方法，实现了获取锁的功能。当锁已被其他线程占用时，当前线程会调用 wait() 方法进入等待状态，直到其他线程释放锁并调用 notify() 方法唤醒等待的线程。一旦获得锁，将 locked 设置为 true。
//
//unlock() 方法也通过使用 synchronized 关键字将其声明为同步方法，实现了释放锁的功能。它将 locked 设置为 false，然后调用 notify() 方法唤醒一个等待的线程来获取锁。
//
//需要注意的是，上述代码是简化版的示例，并没有考虑到一些复杂的细节和边界情况。实际使用 synchronized 时，需要注意以下几点：
//
//synchronized 关键字可以用于同步代码块和方法。在同步代码块中，通过指定一个对象监视器来实现锁的控制。
//对象监视器可以是任意对象，但是对于同步方法来说，默认使用当前对象（this）作为监视器。
//wait() 方法会释放获得的锁，并将线程置于等待状态，直到被唤醒或超时。
//notify() 方法会随机选择一个等待的线程进行唤醒，而 notifyAll() 方法会唤醒所有等待的线程。
//在使用 synchronized 时，需要确保正确地加锁和解锁，以避免死锁和数据不一致的问题。此外，也可以考虑使用更高级别的并发工具类，如 Lock、ReentrantLock 或 ReadWriteLock，以满足更复杂的线程同步需求。

public class synchronizedLockUtil {
    private boolean locked = false;

    public synchronized void lock() throws InterruptedException {
        while (locked) {
            wait();
        }
        locked = true;
    }

    public synchronized void unlock() {
        locked = false;
        notify();
    }
}
