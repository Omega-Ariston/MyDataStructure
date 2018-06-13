import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ListTest {
    boolean testArrayList = false;

    @Test
    public void testAdd() {
        List<Integer> list = testArrayList ? new MyArrayList<>() : new MyLinkedList<>();
        assertEquals(0, list.size());
        list.add(10);
        assertEquals(1, list.size());
        list.add(12);
        assertEquals(2, list.size());
        list.add(5);
        assertEquals(3, list.size());
    }

    @Test
    public void testGet() {
        List<Integer> list = testArrayList ? new MyArrayList<>() : new MyLinkedList<>();
        assertEquals(0, list.size());
        list.add(10);
        assertEquals(1, list.size());
        list.add(12);
        assertEquals(2, list.size());
        list.add(5);
        assertEquals(3, list.size());

        assertEquals(new Integer(10), list.get(0));
        assertEquals(new Integer(12), list.get(1));
        assertEquals(new Integer(5), list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        List<Integer> list = testArrayList ? new MyArrayList<>() : new MyLinkedList<>();
        list.add(1);
        list.add(4);
        list.add(9);
        Integer val = list.get(3);
    }

    @Test
    public void testRemove() {
        List<Integer> list = testArrayList ? new MyArrayList<>() : new MyLinkedList<>();
        list.add(10);
        list.add(12);
        list.add(5);
        Integer value = list.remove(1);
        assertEquals(new Integer(12), value);
        assertEquals(2, list.size());
        assertEquals(new Integer(10), list.get(0));
        assertEquals(new Integer(5), list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBounds() {
        List<Integer> list = testArrayList ? new MyArrayList<>() : new MyLinkedList<>();
        list.add(10);
        list.add(12);
        list.remove(2);
    }

    @Test
    public void testReverse() {
        List<Integer> list = testArrayList ? new MyArrayList<>() : new MyLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(5, list.size());
        List<Integer> reversed = testArrayList ? new MyArrayList<>() : new MyLinkedList<>();
        reversed.add(4);
        reversed.add(3);
        reversed.add(2);
        reversed.add(1);
        reversed.add(0);
        assertEquals(5, reversed.size());

        list.reverse();
        assertEquals(5, list.size());

        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i) != null);
            assertTrue(reversed.get(i) != null);
            assertEquals(list.get(i), reversed.get(i));
        }

        List<Integer> list2 = testArrayList ? new MyArrayList<>() : new MyLinkedList<>();
        list2.add(0);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        assertEquals(6, list2.size());
        List<Integer> reversed2 = testArrayList ? new MyArrayList<>() : new MyLinkedList<>();
        reversed2.add(5);
        reversed2.add(4);
        reversed2.add(3);
        reversed2.add(2);
        reversed2.add(1);
        reversed2.add(0);
        assertEquals(6, reversed2.size());

        list2.reverse();
        assertEquals(6, list2.size());

        for (int i = 0; i < list2.size(); i++) {
            assertTrue(list2.get(i) != null);
            assertTrue(reversed2.get(i) != null);
            assertEquals(list2.get(i), reversed2.get(i));
        }
    }

}
