package com.edu.zhy.api.api.lock.demo;



//ReentrantLock 是Java中的一个可重入锁实现，它提供了显示的加锁和解锁操作

//ReentrantLock 类使用一个布尔变量 isLocked 表示锁的状态，lockedBy 变量记录当前持有锁的线程，lockCount 记录同一个线程重入锁的次数。
//
//在 lock() 方法中，首先获取当前线程，并检查锁的状态。如果锁已被其他线程占用并且不是当前线程自己持有，则当前线程进入等待状态（通过调用 wait() 方法）。当锁可用时，将 isLocked 设置为 true，lockedBy 设置为当前线程，lockCount 加一。
//
//在 unlock() 方法中，先检查当前线程是否是持有锁的线程，如果是，则将 lockCount 减一。当 lockCount 变为零时，表示当前线程已经完全释放了锁，将 isLocked 设置为 false，lockedBy 设置为 null，并通过调用 notifyAll() 唤醒其他等待的线程。
//
//需要注意的是，上述代码只是简化版的示例，并没有考虑到一些复杂的细节和边界情况。实际的 ReentrantLock 实现要更加复杂和高效，支持公平性设置、条件变量等功能。在使用 ReentrantLock 时，需要确保正确地进行加锁和解锁操作，避免产生死锁或未解锁的情况。

public class ReentrantLockUtil {
    private boolean isLocked = false;
    private Thread lockedBy = null;
    private int lockCount = 0;

    public synchronized void lock() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        while (isLocked && lockedBy != currentThread) {
            wait();
        }
        isLocked = true;
        lockedBy = currentThread;
        lockCount++;
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == lockedBy) {
            lockCount--;
            if (lockCount == 0) {
                isLocked = false;
                lockedBy = null;
                notifyAll();
            }
        }
    }
}
