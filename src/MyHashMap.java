import java.util.Arrays;

public class MyHashMap<K,V> implements Map<K,V> {
    private final int INITIAL_SIZE = 16;
    private final float GROWTH_FACTOR = 1.5f;
    private final float THRESHOLD_FACTOR = 0.75f;

    private MyLinkedList<Entry<K,V>>[] buckets;
    private int size;

    public MyHashMap(){
        buckets = new MyLinkedList[INITIAL_SIZE];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new MyLinkedList<Entry<K,V>>();
        }
        size = 0;
    }

    class Entry<K,V>{
        private K key;
        private V value;
        private Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            Entry<K,V> o = (Entry<K,V>)obj;
            return this.key.equals(o.getKey());
        }

        @Override
        public String toString() {
            return "("+key+", "+value+")";
        }
    }

    @Override
    public V put(K key, V value) {
        if(key==null || value==null)
            throw new IllegalArgumentException();
        MyLinkedList<Entry<K, V>> bucket = getBucket(key);
        Entry<K,V> entry = retrieve(key, bucket);
        if(entry==null) {
            bucket.add(new Entry(key, value));
            size++;
            return null;
        } else {
            V output = entry.getValue();
            entry.setValue(value);
            return output;
        }
    }

    private Entry<K,V> retrieve(K key, MyLinkedList<Entry<K,V>> bucket){
        MyLinkedList.Node node = bucket.head;
        while(node!=null){
            Entry<K,V> entry = (Entry<K,V>)node.val;
            if(entry.getKey().equals(key)){
                return entry;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public V get(K key) {
        if(key==null)
            throw new IllegalArgumentException();
        MyLinkedList<Entry<K, V>> bucket = getBucket(key);
        Entry<K,V> entry = retrieve(key, bucket);
        if(entry==null)
            return null;
        return entry.getValue();
    }

    @Override
    public boolean remove(K key) {
        MyLinkedList<Entry<K, V>> bucket = getBucket(key);
        if(!bucket.remove(new Entry<K,V>(key, null)))
            return false;
        size--;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new MyLinkedList<Entry<K,V>>();
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < buckets.length; i++) {
            MyLinkedList<Entry<K,V>> bucket = buckets[i];
            for (Entry<K,V> entry: bucket
                 ) {
                sb.append(entry + ", ");
            }
        }
        String output = sb.toString();
        if(output.lastIndexOf(',')>0)
            output = output.substring(0, output.lastIndexOf(','));
        return output + "]";
    }

    private MyLinkedList<Entry<K,V>> getBucket(K key){
        return buckets[getBucketNO(key)];
    }

    private int getBucketNO(K key){
        return Math.abs(key.hashCode() % buckets.length);
    }
}
