import org.junit.Test;

import static junit.framework.TestCase.*;

public class MapTest {

    private static final boolean USE_HASH = true;

    @Test
    public void testPut() {
        Map<String, Double> map = USE_HASH ? new MyHashMap<>() : new MyBSTMap<>();
        assertNull(map.put("apple", 2.5));
        assertTrue(map.size() == 1);
        assertEquals("[(apple, 2.5)]", map.toString());
        assertNull(map.put("banana", 2.0));
        assertTrue(map.size() == 2);
        assertEquals("[(apple, 2.5), (banana, 2.0)]", map.toString());
        assertNull(map.put("mango", 5.00));
        assertTrue(map.size() == 3);
        assertEquals("[(mango, 5.0), (apple, 2.5), (banana, 2.0)]", map.toString());
        assertNull(map.put("grape", 5.50));
        assertTrue(map.size() == 4);
        assertEquals("[(mango, 5.0), (apple, 2.5), (banana, 2.0), (grape, 5.5)]", map.toString());
        Double previous = map.put("grape", 3.5);
        assertEquals("put should have returned previous value of 5.50 for grape", previous, 5.50);
        assertTrue(map.size() == 4);
        assertEquals("[(mango, 5.0), (apple, 2.5), (banana, 2.0), (grape, 3.5)]", map.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutNullKey() {
        Map<String, Double> map = USE_HASH ? new MyHashMap<>() : new MyBSTMap<>();
        map.put(null, 1.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutNullValue() {
        Map<String, Double> map = USE_HASH ? new MyHashMap<>() : new MyBSTMap<>();
        map.put("apple", null);
    }

    @Test
    public void testRemove() {
        Map<String, Double> map = USE_HASH ? new MyHashMap<>() : new MyBSTMap<>();
        assertNull(map.put("apple", 2.50));
        assertNull(map.put("orange", 4.00));
        assertNull(map.put("kiwifruit", 6.00));
        assertTrue("orange was not found in the map", map.remove("orange"));
        assertEquals("[(apple, 2.5), (kiwifruit, 6.0)]", map.toString());
        assertTrue(map.size() == 2);
        assertFalse(map.remove("Apple"));
        assertTrue(map.size() == 2);
    }

    @Test
    public void testGet() {
        Map<String, Double> map = USE_HASH ? new MyHashMap<>() : new MyBSTMap<>();
        assertNull(map.put("apple", 2.50));
        assertNull(map.put("orange", 4.00));
        assertNull(map.put("kiwifruit", 6.00));
        assertEquals(2.50, map.get("apple"));
        assertEquals(4.00, map.get("orange"));
        assertEquals(6.00, map.get("kiwifruit"));
        assertEquals(null, map.get("grape"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNull() {
        Map<String, Double> map = USE_HASH ? new MyHashMap<>() : new MyBSTMap<>();
        assertNull(map.put("apple", 2.50));
        assertNull(map.put("orange", 4.00));
        assertNull(map.put("kiwifruit", 6.00));
        map.get(null);
    }

    @Test
    public void testClear() {
        Map<String, Double> map = USE_HASH ? new MyHashMap<>() : new MyBSTMap<>();
        assertNull(map.put("apple", 2.50));
        assertNull(map.put("orange", 4.00));
        assertNull(map.put("kiwifruit", 6.00));
        map.clear();
        assertEquals("[]", map.toString());
        assertEquals(0, map.size());
        assertEquals(null, map.get("orange"));
    }
}
