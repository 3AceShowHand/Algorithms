package BinarySearchTree;

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

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(Key key) {

    }

    @Override
    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;
        return x;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    @Override
    public int size() {
        return 0;
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
