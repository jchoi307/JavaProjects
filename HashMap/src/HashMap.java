import java.util.*;

/**
 * Your implementation of a HashMap, using external chaining as your collision
 * policy.  Read the PDF for more instructions on external chaining.
 *
 * @author Joon Gyu Choi
 * @version 1.0
 */
public class HashMap<K, V> implements HashMapInterface<K, V> {

    // Do not make any new instance variables.
    private MapEntry<K, V>[] table;
    private int size;

    /**
     * Create a hash map with no entries.
     */
    public HashMap() {
        // Initialize your hashtable here.
        table = new MapEntry[STARTING_SIZE];
        //for (int i = 0; i < STARTING_SIZE; i++) {
        //    table[i] = null;
        //}
        size = 0;
    }

    @Override
    public V add(K key, V value) {
        if(key == null || value == null) {
            throw new IllegalArgumentException("Key or Value is Null");
        }
        //System.out.println(size);
        //System.out.println((double)size / (double)table.length);
        if(((double)(size + 1) / (double)table.length) >= MAX_LOAD_FACTOR) {
            resize();
        }
        MapEntry<K, V> newEntry = new MapEntry<>(key, value);
        int hash = Math.abs(key.hashCode());
        int index = hash % table.length;
        //if(entry != null) {
        //    if (entry.getKey() == key || entry.getKey().equals(key)) {
        //        V oldValue = entry.getValue();
        //        entry.setValue(value);
        //        return oldValue;
        //    } else {
        //        while (entry.getNext() != null) {
        //            entry = entry.getNext();
        //        }
        //        entry.setNext(newEntry);
        //        size++;
        //    }
        //} else {
        //    table[index] = newEntry;
        //    size++;
        //}
        if (table[index] == null) {
            table[index] = newEntry;
            size++;
            return null;
        } else {
            MapEntry<K, V> entry = table[index];
            while (entry != null) {
                if (entry.getKey() == key || entry.getKey().equals(key)) {
                    V oldValue = entry.getValue();
                    entry.setValue(value);
                    return oldValue;
                } else {
                    entry = entry.getNext();
                }
            }
        }
        table[index] = newEntry;
        size++;
        return null;
    }

    /**
     * Resize the backing array
     */
    private void resize() {
        int tableSize = table.length * 2 + 1;
        MapEntry<K, V>[] oldTable = table;
        MapEntry<K, V>[] newTable  = new MapEntry[tableSize];
        for (int i = 0; i < oldTable.length; i++) {
            newTable[i] = oldTable[i];
        }
        table = newTable;
    }

    @Override
    public V remove(K key) {
        if(key == null){
            throw new IllegalArgumentException("Key is null");
        }
        int hash = Math.abs(key.hashCode());
        int index = hash % table.length;
        if(table[index] == null) {
            throw new NoSuchElementException("Nothing exist");
        }
        MapEntry<K, V> entry = table[index];
        if (entry.getNext() != null) { //while(?)
            if(entry.getKey() == key || entry.getKey().equals(key)) {
                V prev = entry.getValue();
                table[index] = entry.getNext();
                size --;
                return prev;
            }
        }
        return null;
    }

    @Override
    public V get(K key) {
        if(key == null){
            throw new IllegalArgumentException("Key is null");
        }
        int hash = Math.abs(key.hashCode());
        int index = hash % table.length;
        if(table[index] == null) {
            throw new NoSuchElementException("Nothing exist");
        }
        MapEntry<K, V> entry = table[index];
        if(entry.getKey() == key || entry.getKey().equals(key)) {
            return entry.getValue();
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        if(key == null){
            throw new IllegalArgumentException("Key is null");
        }
        int hash = Math.abs(key.hashCode());
        int index = hash % table.length;
        MapEntry<K, V> entry = table[index];
        if (entry == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void clear() {
        //for (int i = 0; i < table.length; i++) {
        //    table[i] = null;
        //}
        table = new MapEntry[STARTING_SIZE];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<K> keySet() {
        HashSet<K> set = new HashSet<>(size);
        for (int i = 0; i < table.length; i++) {
            MapEntry<K, V> entry = table[i];
            if (entry != null) {
                set.add(entry.getKey());
            }
        }
        return set;
    }

    @Override
    public List<V> values() {
        ArrayList<V> array = new ArrayList<>(size);
        for (int i = 0; i < table.length; i++) {
            MapEntry<K, V> entry = table[i];
            if (entry != null) {
                array.add(entry.getValue());
            }
        }
        return array;
    }

    /**
     * DO NOT USE THIS METHOD IN YOUR CODE.  IT IS FOR TESTING ONLY
     * @return the backing array of the data structure, not a copy.
     */
    public MapEntry<K, V>[] toArray() {
        return table;
    }

}