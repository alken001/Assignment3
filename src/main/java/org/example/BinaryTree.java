package org.example;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    public void countEvenOdd() {
        int[] count = {0, 0};
        countEvenOddRec(root, count);
        System.out.println("Even element: " + count[0]);
        System.out.println("Odd element: " + count[1]);
    }

    private void countEvenOddRec(Node root, int[] count) {
        if (root != null) {
            if (root.key % 2 == 0)
                count[0]++;
            else
                count[1]++; //
            countEvenOddRec(root.left, count);
            countEvenOddRec(root.right, count);
        }
    }

    public void findMaxMin() {
        int[] maxMin = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        findMaxMinRec(root, maxMin);
        System.out.println("Max element: " + maxMin[0]);
        System.out.println("Min element: " + maxMin[1]);
    }

    private void findMaxMinRec(Node root, int[] maxMin) {
        if (root != null) {
            if (root.key > maxMin[0])
                maxMin[0] = root.key;
            if (root.key < maxMin[1])
                maxMin[1] = root.key;
            findMaxMinRec(root.left, maxMin);
            findMaxMinRec(root.right, maxMin);
        }
    }

    public int length() {
        return length(root);
    }

    private int length(Node node) {
        if (node == null) {
            return 0;
        }

        int leftLength = length(node.left);
        int rightLength = length(node.right);

        return Math.max(leftLength, rightLength) + 1;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Method for removing a tree
    public void deleteTree() {
        root = null;
    }


    public void display() {
        printTree(root, 0);
    }

    private void printTree(Node node, int space) {
        if (node == null)
            return;

        space += 7;

        printTree(node.right, space);

        System.out.print("\n");
        for (int i = 5; i < space; i++)
            System.out.print(" ");
        System.out.print(node.key + "\n");

        printTree(node.left, space);
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(63);
        tree.insert(72);
        tree.insert(42);
        tree.insert(65);
        tree.insert(77);
        tree.insert(55);
        tree.insert(35);
        tree.insert(22);

        System.out.println("Tree:");


        tree.delete(42);

        System.out.println("\nTree after removing elements:");

        tree.display();

        tree.countEvenOdd();

        tree.findMaxMin();

        System.out.println("Length tree: "+ tree.length());

        System.out.println("Tree empty: " + tree.isEmpty());

        tree.deleteTree();
    }
}

