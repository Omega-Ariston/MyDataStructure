public interface Map<K, V> {
    /**
     * Put the given key-value pair into this map.
     * If there was already a value in this map for the given key,
     * update with the new value.
     * @param key the key against which to put the value, must not be null
     * @param value the value to put in this map, must not be null
     * @return the value that was previously stored, or null if there was no previously existing value
     */
    V put(K key, V value);

    /**
     * @param key a key for which to search in this map
     * @return the value associated with the given key, or null if there is the key is not found in the map
     */
    V get(K key);

    /**
     * Remove the given key and its corresponding value from this map.
     * @param key a key to remove from this map
     * @return true if the key was found (and removed); otherwise false
     */
    boolean remove(K key);

    /**
     * Remove all keys and values from this map.
     */
    void clear();

    /**
     * @return the number of key-value pairs in this map
     */
    int size();

    String toString();
}
