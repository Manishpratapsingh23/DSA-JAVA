import java.util.ArrayList;

public class Map<K, V> {
    private ArrayList<MapNode<K, V>> bucket;
    private int size;
    private int numBuckets;

    public Map() {
        bucket = new ArrayList<>();
        numBuckets = 5;
        size = 0;
        for (int i = 0; i < numBuckets; i++) {
            bucket.add(null);
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % numBuckets;
    }

    public int size() {
        return size;
    }

    public V getValue(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V removeKey(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        MapNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    bucket.set(bucketIndex, head.next);
                } else {
                    prev.next = head.next;
                }
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    private void rehash() {
        System.out.println("Rehashing --> Buckets: " + numBuckets + " Size: " + size);
        ArrayList<MapNode<K, V>> temp = bucket;
        
        numBuckets *= 2; // Increase bucket size first
        bucket = new ArrayList<>();

        for (int i = 0; i < numBuckets; i++) {
            bucket.add(null);
        }

        size = 0; // Reset size before reinserting elements

        for (MapNode<K, V> headNode : temp) {
            while (headNode != null) {
                insert(headNode.key, headNode.value);
                headNode = headNode.next;
            }
        }
    }

    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        head = bucket.get(bucketIndex);
        MapNode<K, V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        bucket.set(bucketIndex, newNode);
        size++;

        double loadFactor = (1.0 * size) / numBuckets;
        if (loadFactor > 0.7) {
            rehash();
        }
    }

    public double loadFactor() {
        return (1.0 * size) / numBuckets;
    }
}
