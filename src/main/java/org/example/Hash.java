package org.example;

import java.util.LinkedList;

class HashTable {
    private static final int SIZE = 10;
    private LinkedList<Integer>[] table;

    HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }
}