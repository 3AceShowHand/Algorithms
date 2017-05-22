package lab9;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

/**
 * Author:     Christopher
 * Written:    2017/5/23
 */
public class MyHashMap<Key extends Comparable<Key>, Value> implements Map61B<Key, Value> {

    public MyHashMap() {

    }

    public MyHashMap(int initialSize) {

    }

    public MyHashMap(int intialSize, double loadFactor) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<Key> keySet() {
        return null;
    }

    @Override
    public Value remove(Key key) {
        return null;
    }

    @Override
    public Value remove(Key key, Value value) {
        return null;
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
