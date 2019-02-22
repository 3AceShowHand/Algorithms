package lab9;

import java.util.*;


/**
 * Implementation of interface Map61B with BST as core data structure.
 * get, put, size should be implemented.
 * remove, keySet, iterator are optional, by default should throw an UnsupportedOperationException.
 *
 * @author Ling Jin
 */

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;   /* Root node of the tree. */
    private int size;    /* The number of key-value pairs in the tree */
    // private Set<K> keys; /* use to store all keys*/

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns the value mapped to by KEY in the subtree rooted in P.
     *  or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        if (key == null) {
            throw new IllegalArgumentException("key can not be null");
        }
        if (p == null) {
            return null;
        }
        int cmp = key.compareTo(p.key);
        if (cmp == 0) return p.value;
        else if (cmp < 0) return getHelper(key, p.left);
        else return getHelper(key, p.right);
    }

    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return getHelper(key, this.root);
    }

    /** Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
      * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        if (p == null) {
            size += 1;
            return new Node(key, value);
        }
        int cmp = key.compareTo(p.key);
        if (cmp < 0) {
            p.left = putHelper(key, value, p.left);
        } else if (cmp > 0) {
            p.right = putHelper(key, value, p.right);
        } else {
            p.value = value;
        }
        return p;
    }

    /** Inserts the key KEY
     *  If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("key can not be null");
        }
        if (value == null) {
            throw new IllegalArgumentException("value can not be null");
        }
        root = putHelper(key, value, root);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return this.size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */

    private void getKeySet(Set<K> keySet, Node p) {
        if (p == null) {
            return;
        } else {
            keySet.add(p.key);
            getKeySet(keySet, p.left);
            getKeySet(keySet, p.right);
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new TreeSet<>();
        getKeySet(keys, this.root);
        return keys;
    }

    /**Return Node with smallest value,
     * from p and its child.
     * null if not find.
     */
    private Node getMin(Node p) {
        Node ret = p;
        while (ret != null) {
            if (ret.left != null) {
                ret = ret.left;
            } else {
                break;
            }
        }
        return ret;
    }

    /* delete min node root at p
    * */
    private Node deleteMin(Node p) {
        if (p.left == null) {
            size -= 1;
            return p.right;
        }
        p.left = deleteMin(p.left);
        return p;
    }
    /** Removes KEY from the tree if present
     *  returns VALUE removed,
     *  null on failed removal.
     */

    private Node search(K key) {
        Node ret = root;
        while (ret != null) {
            int cmp = key.compareTo(ret.key);
            if (cmp < 0) {
                ret = ret.left;
            } else if (cmp > 0) {
                ret = ret.right;
            } else {
                break;
            }
        }
        return ret;
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key can not be null");
        }
        // search for key, if not exist, just return null
        if (root == null) {
            return null;
        }
        // if key exists, then set its parent's corresponding child to null.
        Node parent = root;
        Node target = parent;
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) {
            target = parent.left;
        } else if (cmp > 0) {
            target = parent.right;
        }
        while (target != null) {
            cmp = key.compareTo(target.key);
            if (cmp < 0) {
                parent = target;
                target = target.left;
            } else if (cmp > 0) {
                parent = target;
                target = target.right;
            } else {
                break;
            }
        }
        if (target == null) {
            return null;
        }
        // already find parent and node with key.
        // if child is a leaf, just set as null
        Node child = null;
        V ret = target.value;
        if (target.left != null && target.right != null) {
            Node min = getMin(target.right);
            target.key = min.key;
            target.value = min.value;
            target.right = deleteMin(target.right);
            return ret;
        } else if (target.left == null) {
            child = target.right;
        } else if (target.right == null) {
            child = target.left;
        }
        cmp = key.compareTo(parent.key);
        if (cmp < 0) {
            parent.left = child;
        } else if (cmp > 0) {
            parent.right = child;
        } else {
            root = child;
        }
        size -= 1;
        return ret;
    }

    /** Removes the key-value entry for the specified key only if it is
     *  currently mapped to the specified value.  Returns the VALUE removed,
     *  null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        V stored = this.get(key);
        if (stored.equals(value)) {
            return remove(key);
        }
        return null;
    }
    @Override
    public Iterator<K> iterator() {
        // throw new UnsupportedOperationException();
        return new BSTIter();
    }

    private class BSTIter implements Iterator<K> {
        private Queue<K> keys;

        private void init(Queue<K> q, Node p) {
            if (p == null) {
                return;
            }
            init(q, p.left);
            q.add(p.key);
            init(q, p.right);
        }

        private BSTIter() {
            keys = new LinkedList<>();
            init(keys, root);
        }

        @Override
        public boolean hasNext() {
            return !keys.isEmpty();
        }

        @Override
        public K next() {
            return keys.remove();
        }
    }

    public static void main(String[] args) {
        BSTMap<Integer, Integer> map = new BSTMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
        Iterator iter = map.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}