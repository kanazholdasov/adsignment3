import java.util.LinkedList;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    private int M = 11;
    private int size;
    private LinkedList<HashNode<K, V>>[] table;

    public MyHashTable() {
        this.table = new LinkedList[M];
        this.size = 0;
        for (int i = 0; i < M; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public MyHashTable(int M) {
        this.M = M;
        this.table = new LinkedList[M];
        this.size = 0;
        for (int i = 0; i < M; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value) {
        int index = hash(key);
        for (HashNode<K, V> node : table[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        table[index].add(new HashNode<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        for (HashNode<K, V> node : table[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        for (HashNode<K, V> node : table[index]) {
            if (node.key.equals(key)) {
                V value = node.value;
                table[index].remove(node);
                size--;
                return value;
            }
        }
        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            for (HashNode<K, V> node : table[i]) {
                if (node.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            for (HashNode<K, V> node : table[i]) {
                if (node.value.equals(value)) {
                    return node.key;
                }
            }
        }
        return null;
    }

    public void printBucketSizes() {
        for (int i = 0; i < M; i++) {
            System.out.println("Bucket " + i + ": " + table[i].size() + " elements");
        }
    }
}
