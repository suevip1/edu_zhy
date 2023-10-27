package com.edu.zhy.api.api.lock.demo;

import java.util.Map;
import java.util.concurrent.locks.LockSupport;

//LockSupport 是Java中一种基于线程阻塞和唤醒的工具类，用于实现锁的功能。它提供了 park() 和 unpark(Thread thread) 方法来阻塞和唤醒线程。
//CustomLock 使用 locked 和 owner 两个变量来记录锁的状态和拥有者线程。
//
//lock() 方法用于获取锁。当锁未被占用时，通过 synchronized 块设置 locked 为 true，将当前线程设为 owner，然后返回。如果锁已被占用，则调用 LockSupport.park() 方法将当前线程阻塞。
//
//unlock() 方法用于释放锁。首先检查当前线程是否为锁的拥有者，如果不是则抛出异常。然后将 locked 设置为 false，将 owner 设置为 null，并选择下一个需要唤醒的线程进行唤醒操作。
//
//getNextBlockedThread() 方法用于选择下一个需要唤醒的线程。这里给出了一个简化的实现，通过调用 Thread.getAllStackTraces() 获取所有线程，并选择第一个处于等待或阻塞状态的线程进行唤醒。在实际场景中，你可能需要根据具体需求设计更复杂的逻辑来选择下一个线程。
//
//需要注意的是，上述代码只是简化版的示例，并没有考虑到一些复杂的细节和边界情况。实际的锁实现会更加复杂和高效，支持更多的功能和操作。在使用 LockSupport 实现锁时，需要根据具体场景选择适当的阻塞和唤醒策略，并确保正确地进行加锁和解锁操作，以避免死锁和数据不一致的问题。

/**
 * *
 */
public class LockSupportUtil {
    private volatile boolean locked = false;
    private Thread owner = null;

    public void lock() {
        while (true) {
            if (!locked) {
                synchronized (this) {
                    if (!locked) {
                        locked = true;
                        owner = Thread.currentThread();
                        return;
                    }
                }
            }
            LockSupport.park();
        }
    }

    public void unlock() {
        if (Thread.currentThread() != owner) {
            throw new IllegalMonitorStateException("Only the owner thread can unlock the lock");
        }

        locked = false;
        owner = null;
        LockSupport.unpark(getNextBlockedThread());
    }

    private Thread getNextBlockedThread() {
        // Implement your own logic to select the next blocked thread to unpark
        // This is a simplified example, you may need to consider fairness and other factors
        // for selecting the next thread in a real-world implementation.
        // Here, we simply use Thread.getAllStackTraces() to get all threads and choose the first one.
        Map<Thread, StackTraceElement[]> threadMap = Thread.getAllStackTraces();
        for (Thread thread : threadMap.keySet()) {
            if (thread.getState() == Thread.State.WAITING ||
                    thread.getState() == Thread.State.TIMED_WAITING ||
                    thread.getState() == Thread.State.BLOCKED) {
                return thread;
            }
        }

        return null;
    }
}
