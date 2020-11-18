package utils;

import java.util.*;

/**
 * A strand of the HashMap data structure where the value is a Collection of items and both key and value types are received from the type parameters.
 * The first parameter refer to the type of the MultiMap keys.
 * The second parameter refer to the type of the Collection items.
 */
public class MultiMap<K, V> {

  private Map<K, Collection<V>> map = new HashMap<>();

  /**
   * Adds the given value with the given key in the MultiMap
   * @param key the key where the value is going to be pushed
   * @param value the value to be pushed
   */
  public void put(K key, V value) {
    if (map.get(key) == null) {
      map.put(key, new ArrayList<V>());
    }

    map.get(key).add(value);
  }

  /**
   * Returns the Collection stored in the given key
   * @param key the key from the Collection to be returned
   * @return the Collection stored in the given key
   */
  public Collection<V> get(K key) {
    return map.get(key);
  }

  /**
   * Returns a Set with the unique keys of the MultiMap
   * @return a Set with the unique keys of the MultiMap
   */
  public Set<K> getKeySet() {
    return map.keySet();
  }

  /**
   *
   * @return a Collection with all values from all keys of the MultiMap
   */
  public Collection<Collection<V>> values() {
    return map.values();
  }

  /**
   * Checks if the given key exists in the MultiMap
   * @param key the key to be verified
   * @return true if the given key exists and false if it does not
   */
  public boolean containsKey(Object key) {
    return map.containsKey(key);
  }

  /**
   * Removes the specified key from the MultiMap
   * @param key the key to be removed
   * @return the value to which this map previously associated the key, or null if the map contained no mapping for the key.
   */
  public Collection<V> remove(Object key) {
    return map.remove(key);
  }

  /**
   * Checks if this map contains no key-value mappings.
   * @return true if it contains and false if it does not
   */
  public boolean isEmpty() {
    return map.isEmpty();
  }

  /**
   * Removes all of the mappings from this map (optional operation). The map will be empty after this call returns.
   * @return the number of elements in this collection
   */
  public int size() {
    int size = 0;

    for (Collection<V> wordsList : map.values()) {
      size += wordsList.size();
    }

    return size;
  }

  /**
   * Removes all of the mappings from this map (optional operation). The map will be empty after this call returns.
   */
  public void clear() {
    map.clear();
  }
}
