package BinarySearchTree;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Set;

/**
 * Author:     Christopher
 * Written:    2017/4/5
 */

public class BSTMap<Key extends Comparable<Key> , Value> implements Map61B<Key, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int count;

        Node(Key key, Value val, int count) {
            this.key = key;
            this.val = val;
            this.count = count;
        }
    }

    @Override
    public void clear() {
        this.root = null;
    }

    @Override
    public boolean containsKey(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument key is null");
        }
        return get(key) != null;
    }

    @Override
    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.val;
            }
        }
        return null;
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("argument Key is null");
        } else {
            if (value == null) {
                remove(key);
                return;
            }
            root = put(root, key, value);
        }
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }


    @Override
    public int size() {
        return size(root);
    }

    private int size(Node n) {
        if (n == null) {
            return 0;
        }
        return n.count;
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node n) {
        if (n != null) {
            printInOrder(n.left);
            StdOut.println(n.key);
            printInOrder(n.right);
        }
    }

    @Override
    public Value remove(Key key, Value value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Value remove(Key key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Key> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Key> iterator() {
        throw new UnsupportedOperationException();
    }

    private class MapIterator implements Iterator<Key> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Key next() {
            return null;
        }
    }
}
