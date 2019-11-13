package com.rk.algos.map;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayDeque;

// todo: Using LinkedHashMap
public class LRUCache<K, V> {
    private int capacity;
    private ArrayDeque<K> pqueue;
    private Map<K, V> pmap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        pqueue = new ArrayDeque<>();
        pmap = new HashMap<>(this.capacity);
    }

    public V get(K key) {
        V value = pmap.get(key);
        if (value != null) {
            pqueue.remove(key);
            pqueue.add(key); // add at tail
        }
        return value;
    }

    public void put(K key, V value) {
        if (pmap.containsKey(key)) {
            pqueue.remove(key);
        } else {
            if (pqueue.size() == capacity) {
                K oldest = pqueue.poll(); // remove from head
                pmap.remove(oldest);
            }
        }
        pmap.put(key, value);
        pqueue.add(key);
    }

    public void evict(K key) {
        if (pmap.containsKey(key)) {
            pqueue.remove(key);
            pmap.remove(key);
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("Getting 1: " + cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println("Getting 2: " + cache.get(2)); // returns null (not found)
        cache.put(4, 4); // evicts key 1
        System.out.println("Getting 1: " + cache.get(1)); // returns null (not found)
        System.out.println("Getting 3: " + cache.get(3)); // returns 3
        System.out.println("Getting 4: " + cache.get(4)); // returns 4
        cache.evict(2);
        cache.put(2, 2); // evicts key 3
        cache.evict(4);
        System.out.println("Getting 4: " + cache.get(4)); // returns null
        System.out.println("Getting 3: " + cache.get(3)); // returns null
        System.out.println("Getting 2: " + cache.get(2)); // returns 2
    }
}
