package lab8;

import java.util.Iterator;
import java.util.Set;

/**
 * Author:     Christopher
 * Written:    2017/4/5
 */
public class BSTMap<Key, Value> implements Map61B<Key, Value> {

    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(Key key) {
        return false;
    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public void put(Key key, Value value) {

    }

    @Override
    public Value remove(Key key, Value value) {
        return null;
    }

    @Override
    public Value remove(Key key) {
        return null;
    }

    @Override
    public Set<Key> keySet() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<Key> iterator() {
        return new MapIterator();
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
