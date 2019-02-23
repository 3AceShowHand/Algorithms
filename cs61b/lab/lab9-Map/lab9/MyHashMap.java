package lab9;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  @author Ling Jin
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    private static final int DEFAULT_SIZE = 16;
    private static final double MAX_LF = 0.75;

    private ArrayMap<K, V>[] buckets;
    private int size;

    private int loadFactor() {
        return size / buckets.length;
    }

    public MyHashMap() {
        buckets = new ArrayMap[DEFAULT_SIZE];
        this.clear();
    }

    public MyHashMap(int initialSize) {
        buckets = new ArrayMap[initialSize];
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        this.size = 0;
        for (int i = 0; i < this.buckets.length; i += 1) {
            this.buckets[i] = new ArrayMap<>();
        }
    }

    /* if the loadFactory > MAX_LF, make a new larger buckets,
     * rehash all elements then put to new bucket. */
    private void resize() {
        ArrayMap<K, V>[] oldBuckets = buckets;
        int oldCapacity = oldBuckets.length;

        buckets = new ArrayMap[oldCapacity * 2];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayMap<>();
        }

        for (ArrayMap<K, V> map: oldBuckets) {
            for (K key: map.keySet()) {
                int idx = hash(key);
                buckets[idx].put(key, map.get(key));
            }
        }
    }

    /** Computes the hash function of the given key. Consists of
     *  computing the hashcode, followed by modding by the number of buckets.
     *  To handle negative numbers properly, uses floorMod instead of %.
     */
    private int hash(K key) {
        if (key == null) {
            return 0;
        }

        int numBuckets = buckets.length;
        return Math.floorMod(key.hashCode(), numBuckets);
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        int bktIdx = hash(key);
        return buckets[bktIdx].get(key);
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        if (MAX_LF < loadFactor()) {
            resize();
        }
        int bktIdx = hash(key);
        if (!buckets[bktIdx].containsKey(key)) {
            size += 1;
        }
        buckets[bktIdx].put(key, value);

    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        Set<K> keys = new TreeSet<>();
        for (ArrayMap<K, V> map: buckets) {
            keys.addAll(map.keySet());
        }
        return keys;
    }

    /* Removes the mapping for the specified key from this map if exists.
     * Not required for this lab. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        if (key == null) {
            return null;
        }
        int idx = hash(key);
        if (buckets[idx].containsKey(key)) {
            size -= 1;
        }
        return buckets[idx].remove(key);
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for this lab. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        if (key == null || value == null) {
            return null;
        }
        int idx = hash(key);
        if (value.equals(get(key))) {
            size -= 1;
        }
        return buckets[idx].remove(key);
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }
}
