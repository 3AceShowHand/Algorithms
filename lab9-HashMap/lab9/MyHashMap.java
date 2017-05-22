package lab9;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Author:     Christopher
 * Written:    2017/5/23
 */
public class MyHashMap<Key extends Comparable<Key>, Value> implements Map61B<Key, Value> {

    // holds all keys
    private HashSet<Key> keys;

    public MyHashMap() {
        keys = new HashSet<>();
    }

    public MyHashMap(int initialSize) {
        keys = new HashSet<>();
    }

    public MyHashMap(int intialSize, double loadFactor) {
        keys = new HashSet<>();
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public Set<Key> keySet() {
        return keys;
    }

    @Override
    public Value remove(Key key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Value remove(Key key, Value value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void put(Key key, Value value) {

    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public boolean containsKey(Key key) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator<Key> iterator() {
        return new HashIter<>();
    }

    private class HashIter<Key> implements Iterator<Key> {
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
