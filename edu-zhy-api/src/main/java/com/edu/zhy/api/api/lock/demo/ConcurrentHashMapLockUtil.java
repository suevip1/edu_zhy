package com.edu.zhy.api.api.lock.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 ** *
 * @param <K>
 * @param <V>
 */
//ConcurrentHashMap 在内部使用了分段锁（Segment Lock）的机制来实现线程安全。每个段（Segment）都是一个独立的哈希表，不同的段可以被多个线程同时访问，从而提高并发性能
//ConcurrentHashMap 类内部维护了一个段（Segment）数组，每个段都包含一个独立的哈希表和一个段级别的锁（ReentrantLock）。通过对键进行哈希计算，可以确定要操作的具体段。
//
//在 get() 和 put() 方法中，先根据键的哈希值计算出要访问的段，然后使用该段的锁进行加锁操作，以保证在进行读取或写入操作时的线程安全性。当访问完成后，会释放锁。
//
//这种分段锁的设计使得多个线程可以同时访问不同的段，从而提高并发性能。每个段内部的哈希表可以使用常规的非线程安全实现，因为线程之间对不同段的访问相互独立。
public class ConcurrentHashMapLockUtil<K,V> {

    private final int NUM_SEGMENTS = 16; // 分段数
    private final Segment[] segments; // 段数组

    public ConcurrentHashMapLockUtil() {
        segments = new Segment[NUM_SEGMENTS];
        for (int i = 0; i < NUM_SEGMENTS; i++) {
            segments[i] = new Segment();
        }
    }

    public V get(K key) {
        int hash = hash(key);
        return (V) segments[hash % NUM_SEGMENTS].get(key);
    }

    public void put(K key, V value) {
        int hash = hash(key);
        segments[hash % NUM_SEGMENTS].put(key, value);
    }

    // 其他方法省略...

    // 内部类表示段
    private static class Segment<K, V> {
        private final ReentrantLock lock = new ReentrantLock(); // 段级别的锁
        private final Map<K, V> map = new HashMap<>(); // 每个段对应的哈希表

        public V get(K key) {
            lock.lock();
            try {
                return map.get(key);
            } finally {
                lock.unlock();
            }
        }

        public void put(K key, V value) {
            lock.lock();
            try {
                map.put(key, value);
            } finally {
                lock.unlock();
            }
        }

        // 其他方法省略...
    }

    // 计算哈希值
    private int hash(K key) {
        return key.hashCode();
    }
}


