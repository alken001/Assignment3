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

    void insert(int key) {
        int index = hash(key);
        table[index].add(key);
    }

    void delete(int key) {
        int index = hash(key);
        table[index].remove(Integer.valueOf(key));
    }

    void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Integer item : table[i]) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    int sum() {
        int sum = 0;
        for (int i = 0; i < SIZE; i++) {
            for (Integer item : table[i]) {
                sum += item;
            }
        }
        return sum;
    }

    int max() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < SIZE; i++) {
            for (Integer item : table[i]) {
                if (item > max) {
                    max = item;
                }
            }
        }
        return max;
    }

    int min() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < SIZE; i++) {
            for (Integer item : table[i]) {
                if (item < min) {
                    min = item;
                }
            }
        }
        return min;
    }
    void printOddEven() {
        System.out.print("Odd elements: ");
        for (int i = 0; i < SIZE; i++) {
            for (Integer item : table[i]) {
                if (item % 2 != 0) {
                    System.out.print(item + " ");
                }
            }
        }
        System.out.println();
        System.out.print("Even elements: ");
        for (int i = 0; i < SIZE; i++) {
            for (Integer item : table[i]) {
                if (item % 2 == 0) {
                    System.out.print(item + " ");
                }
            }
        }
        System.out.println();
    }
}

public class Hash {
    public static void main(String[] args) {
        HashTable hashtable = new HashTable();

        hashtable.insert(10);
        hashtable.insert(20);
        hashtable.insert(25);
        hashtable.insert(35);
        hashtable.insert(44);
        hashtable.insert(39);
        hashtable.insert(99);

        System.out.println("Hash table:");
        hashtable.display();

        System.out.println("Sum: " + hashtable.sum());
        System.out.println("Max: " + hashtable.max());
        System.out.println("Min: " + hashtable.min());

        System.out.println("Odd and even:");
        hashtable.printOddEven();

        hashtable.delete(20);
        hashtable.display();
    }
}
