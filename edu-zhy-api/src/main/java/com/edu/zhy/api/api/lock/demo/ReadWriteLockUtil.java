package com.edu.zhy.api.api.lock.demo;

//ReadWriteLock 是Java中的读写锁接口，它允许多个线程同时读取共享资源，但只有一个线程可以进行写操作

//ReadWriteLock 使用三个变量来跟踪读锁和写锁的状态：writers 表示当前持有写锁的线程数，readers 表示当前持有读锁的线程数，writeRequests 表示正在等待获取写锁的请求数。
//
//在 lockRead() 方法中，当有线程持有写锁或存在写锁请求时，读取操作线程进入等待状态（通过调用 wait() 方法）。当没有写锁和写锁请求时，读取操作线程获得读锁，readers 计数加一。
//
//在 unlockRead() 方法中，读取操作线程释放读锁，readers 计数减一，并通过调用 notifyAll() 方法唤醒其他等待的线程。
//
//在 lockWrite() 方法中，当有线程持有读锁或写锁时，写操作线程进入等待状态。如果有写锁请求，则先增加 writeRequests 计数，然后继续等待直到没有读锁和写锁时才获得写锁。当获得写锁后，将 writeRequests 计数减一，并将 writers 计数加一。
//
//在 unlockWrite() 方法中，写操作线程释放写锁，writers 计数减一，并通过调用 notifyAll() 方法唤醒其他等待的线程。
//
//需要注意的是，上述代码只是简化版的示例，并没有考虑到一些复杂的细节和边界情况。实际的 ReadWriteLock 实现要更加复杂和高效，通常会有更精细的算法来控制读写锁的获取和释放顺序，以提高性能和公平性。在使用 ReadWriteLock 时，需要根据具体场景正确地选择读锁和写锁的获取方式，避免产生死锁或数据不一致的情况。

/**
 * *
 */
public class ReadWriteLockUtil {
    private int writers = 0;
    private int readers = 0;
    private int writeRequests = 0;

    public synchronized void lockRead() throws InterruptedException {
        while (writers > 0 || writeRequests > 0) {
            wait();
        }
        readers++;
    }

    public synchronized void unlockRead() {
        readers--;
        notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException {
        writeRequests++;
        while (readers > 0 || writers > 0) {
            wait();
        }
        writeRequests--;
        writers++;
    }

    public synchronized void unlockWrite() {
        writers--;
        notifyAll();
    }
}