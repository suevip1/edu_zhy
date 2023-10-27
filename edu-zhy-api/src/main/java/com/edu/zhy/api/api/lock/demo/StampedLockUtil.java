package com.edu.zhy.api.api.lock.demo;

//StampedLock 是Java中的一种乐观读锁、悲观写锁的实现，它提供了更高级别的功能和灵活性。

//StampedLock 使用一个长整型变量 stamp 来记录锁的状态信息。
//
//readLock() 方法用于获取读锁，并返回一个当前锁状态的标记 currentStamp。在获取读锁时，会检查是否有写锁或乐观读锁被持有。如果有，当前线程会通过调用 Thread.yield() 方法让出CPU资源，直到写锁或乐观读锁被释放。
//
//unlockRead() 方法用于释放读锁，根据传入的标记 stamp 检查是否与当前的锁状态匹配。如果匹配，则将 stamp 设置为0，表示该读锁已被释放。
//
//writeLock() 方法用于获取写锁，并返回一个当前锁状态的标记 currentStamp。在获取写锁时，会检查是否已经有任何锁被持有（包括读锁、乐观读锁和写锁）。如果有，当前线程会通过调用 Thread.yield() 方法让出CPU资源，直到所有的锁都被释放。
//
//unlockWrite() 方法用于释放写锁，根据传入的标记 stamp 检查是否与当前的锁状态匹配。如果匹配，则将 stamp 设置为0，表示该写锁已被释放。
//
//tryOptimisticRead() 方法尝试获取乐观读锁，并返回一个当前锁状态的标记 currentStamp。如果当前有写锁被持有，则无法获取乐观读锁，返回0。
//
//validate() 方法用于验证乐观读锁的有效性，根据传入的标记 stamp 检查是否与当前的锁状态匹配。如果匹配，表示乐观读锁仍然有效。
//
//需要注意的是，上述代码只是简化版的示例，并没有考虑到一些复杂的细节和边界情况。实际的 StampedLock 实现会更加复杂和高效，支持更多的功能和操作。在使用 StampedLock 时，需要根据具体场景选择适当的读写锁策略，并正确地进行加锁和解锁操作，以避免竞争条件和数据不一致的问题。

/**
 * *
 */
public class StampedLockUtil {
    private long stamp = 0L;

    public long readLock() {
        long currentStamp = stamp;
        // Check if there is a write lock or optimistic read lock held
        while (stamp < 0L) {
            Thread.yield();
        }
        return currentStamp;
    }

    public void unlockRead(long stamp) {
        if (this.stamp == stamp) {
            this.stamp = 0L;
        }
    }

    public long writeLock() {
        long currentStamp = stamp;
        // Check if there is any lock held (read lock, optimistic read lock, or write lock)
        while (stamp != 0L) {
            Thread.yield();
        }
        stamp = -currentStamp;
        return currentStamp;
    }

    public void unlockWrite(long stamp) {
        if (this.stamp == -stamp) {
            this.stamp = 0L;
        }
    }

    public long tryOptimisticRead() {
        long currentStamp = stamp;
        if (stamp < 0L) {
            // There is a write lock held, cannot obtain an optimistic read lock
            return 0L;
        }
        return currentStamp;
    }

    public boolean validate(long stamp) {
        return stamp == this.stamp;
    }
}
