import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class MyBSTSetTest {
    @Test
    public void testAdd() {
        List<String> allElements = new ArrayList<>();
        Set<String> set = new MyBSTSet<>();
        allElements.add("apple");
        assertTrue(set.add("apple"));
        assertTrue(set.size() == 1);
        checkSetContainsAllElementsInList(allElements, set);
        allElements.add("banana");
        assertTrue(set.add("banana"));
        assertTrue(set.size() == 2);
        checkSetContainsAllElementsInList(allElements, set);
        allElements.add("mango");
        assertTrue(set.add("mango"));
        assertTrue(set.size() == 3);
        checkSetContainsAllElementsInList(allElements, set);
        allElements.add("grape");
        assertTrue(set.add("grape"));
        assertTrue(set.size() == 4);
        checkSetContainsAllElementsInList(allElements, set);
        boolean result = set.add("grape");
        assertFalse("add should have returned false for duplicate grape", result);
        assertTrue(set.size() == 4);
        checkSetContainsAllElementsInList(allElements, set);
    }

    private void checkSetContainsAllElementsInList(List<String> allElements, Set<String> set) {
        for (String s : allElements) {
            assertTrue(set.contains(s));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNull() {
        Set<String> set = new MyBSTSet<>();
        set.add(null);
    }

    @Test
    public void testRemove() {
        Set<String> set = new MyBSTSet<>();
        set.add("apple");
        set.add("orange");
        set.add("kiwifruit");
        assertTrue("orange was not found in the set", set.remove("orange"));
        assertFalse(set.contains("orange"));
        assertTrue(set.size() == 2);
        assertFalse(set.remove("Apple"));
        assertTrue(set.size() == 2);
        assertTrue(set.remove("apple"));
        assertFalse(set.contains("apple"));
        assertTrue(set.size() == 1);
        assertTrue(set.contains("kiwifruit"));
    }

    @Test
    public void testContains() {
        Set<String> set = new MyBSTSet<>();
        set.add("apple");
        set.add("orange");
        set.add("kiwifruit");
        assertTrue(set.contains("orange"));
        assertFalse(set.contains("grape"));
        assertFalse(set.contains("Orange"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContainsNull() {
        Set<String> set = new MyBSTSet<>();
        set.add("apple");
        set.add("orange");
        set.add("kiwifruit");
        set.contains(null);
    }
}
