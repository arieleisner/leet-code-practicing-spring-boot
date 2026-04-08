package com.ariel.eisner.practice.domain.service;

import com.ariel.eisner.practice.domain.port.in.LastRecentlyUsedCacheUseCase;

import java.util.HashMap;

public class LastRecentlyUsedCacheOwnService implements LastRecentlyUsedCacheUseCase {

    private final int capacity;
    private final HashMap<String, Node> cache;
    private final Node head;
    private final Node tail;

    /*
        We will have 2 structures:
        1) A doubled linked list with this format:
            [HEAD] <---> [NODES] <---> [TAIL]
        2) A map containing all NODES
            NODES are inside of a hash map for O(1) retrieval and deletion in any case
        Each node contains the key and value we insert, as long as the reference to the previous and next nodes.
     */
    class Node {
        String key;
        String value;
        Node prev;
        Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }


    public LastRecentlyUsedCacheOwnService(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.head = new Node("", "");
        this.tail = new Node("", "");
        head.next = tail;
        tail.prev = head;
    }

    /*
     * If key exists
     *      update value + move to front
     * else
     *      if cache is full
     *          remove back
     *      insert value in front
     * return value
     */
    @Override
    public String put(String key, String value) {
        if (cache.containsKey(key)) {
            Node current = cache.get(key);
            current.value = value;
            moveToFront(current);
            cache.put(key, current);
        } else {
            if (cache.size() == capacity) {
                removeBack();
            }

            Node current = new Node(key, value);
            putFirst(current);
            cache.put(key, current);
        }
        return value;
    }

    private void removeBack() {
        // HEAD ---- newBack <-> back <-> TAIL
        // HEAD ---- newBack <-> TAIL
        Node back = tail.prev;
        Node newBack = tail.prev.prev;
        newBack.next = back.next;
        tail.prev = back.prev;

        cache.remove(back.key);
    }

    private void moveToFront(Node current) {
        removeFromCurrentPlace(current);
        putFirst(current);
    }

    private void removeFromCurrentPlace(Node current) {
        // HEAD <-> ... <-> current.prev <-> current <-> current.next <-> ... <-> TAIL
        // HEAD <-> ... <-> current.prev <-> current.next <-> ... <-> TAIL
        current.next.prev = current.prev;
        current.prev.next = current.next;
    }

    private void putFirst(Node current) {
        // HEAD <-> oldFirst <-> ... <-> current <-> ... <-> TAIL
        // HEAD <-> current <-> oldFirst <-> ... <-> TAIL
        current.next = head.next;
        current.prev = head;
        head.next.prev = current;
        head.next = current;
    }

    /*
     * If key exists
     *      move to front
     *      return value
     * else
     *      return null/empty
     */
    @Override
    public String get(String key) {
        if (cache.containsKey(key)) {
            Node current = cache.get(key);
            moveToFront(current);
            return current.value;
        }
        return null;
    }
}
