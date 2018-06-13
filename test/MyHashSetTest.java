import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class MyHashSetTest {
    @Test
    public void testAdd() {
        Set<String> set = new MyHashSet<>();
        assertTrue(set.add("apple"));
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("apple"));
        assertTrue(set.add("banana"));
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("apple banana"));
        assertTrue(set.add("mango"));
        assertTrue(set.size() == 3);
        assertTrue(set.toString().equals("apple banana mango"));
        assertTrue(set.add("grape"));
        assertTrue(set.size() == 4);
        assertTrue(set.toString().equals("apple banana grape mango"));
        boolean result = set.add("grape");
        assertFalse("add should have returned false for duplicate grape", result);
        assertTrue(set.size() == 4);
        assertTrue(set.toString().equals("apple banana grape mango"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNull() {
        Set<String> set = new MyHashSet<>();
        set.add(null);
    }

    @Test
    public void testRemove() {
        Set<String> set = new MyHashSet<>();
        set.add("apple");
        set.add("orange");
        set.add("kiwifruit");
        assertTrue("orange was not found in the set", set.remove("orange"));
        assertTrue(set.toString().equals("apple kiwifruit"));
        assertTrue(set.size() == 2);
        assertFalse(set.remove("Apple"));
        assertTrue(set.size() == 2);
    }

    @Test
    public void testContains() {
        Set<String> set = new MyHashSet<>();
        set.add("apple");
        set.add("orange");
        set.add("kiwifruit");
        assertTrue(set.contains("orange"));
        assertFalse(set.contains("grape"));
        assertFalse(set.contains("Orange"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContainsNull() {
        Set<String> set = new MyHashSet<>();
        set.add("apple");
        set.add("orange");
        set.add("kiwifruit");
        set.contains(null);
    }
}
