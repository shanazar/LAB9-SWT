package ee.ut.cs.swt;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class MinimumBinaryHeapTest {

    private MinimumBinaryHeap heap;
    private List<Integer> result;

    @Before
    public void setUp() {
        heap = new MinimumBinaryHeap();
        result = new ArrayList<>();
        result.add(10);
        result.add(5);
        result.add(4);
        result.add(8);
        result.add(12);
    }

    @Test
    public void minHeapifyTest() {
        heap.minHeapify(result);
        assertEquals(4, heap.getArray().get(0), 0);
        assertEquals(5, heap.getArray().get(1), 0);
        assertEquals(10, heap.getArray().get(2), 0);

    }

    @Test
    public void swapTest() {
        heap.add(5);
        heap.add(8);
        heap.add(13);
        heap.swap(1, 2);
        assertEquals(5, heap.getArray().get(0), 0);
        assertEquals(13, heap.getArray().get(1), 0);
        assertEquals(8, heap.getArray().get(2), 0);
    }

    @Test
    public void addTest() {
        heap.add(10);
        heap.add(5);
        heap.add(4);
        heap.add(8);
        heap.add(12);
        assertEquals(4, heap.getArray().get(0), 0);
        assertEquals(5, heap.getArray().get(1), 0);
        assertEquals(10, heap.getArray().get(2), 0);
    }

    @Test
    public void removeTest() {
        heap.add(7);
        heap.add(9);
        heap.add(5);
        heap.add(3);
        heap.add(2);
        List<Integer> result = Arrays.asList(3, 5, 9);
        System.out.println(heap.getArray());
        boolean b1 = heap.remove(2);
        boolean b2 = heap.remove(7);
        boolean b3 = heap.remove(8);
        assertTrue(b1);
        assertTrue(b2);
        assertFalse(b3);
        assertEquals(result, heap.getArray());
    }

    @Test
    public void isEmptyTest() {
        heap.add(1);

        boolean b1 = heap.remove(1);
        assertTrue(b1);
        assertTrue(heap.isEmpty());

        b1 = heap.remove(1);
        assertFalse(b1);
        assertTrue(heap.isEmpty());
    }

    @Test
    public void extractMinTest() {
        heap.minHeapify(Arrays.asList(5, 17, 15, 9, 19, 11, 16, 8, 12, 10, 2, 7, 3, 14, 13, 20, 6, 1, 4, 18));

        int a = heap.exractMin();
        assertEquals(1, a);
        assertEquals(Arrays.asList(2, 4, 3, 6, 10, 7, 5, 13, 8, 18, 17, 11, 16, 14, 15, 20, 19, 9, 12),
                     heap.getArray());

        a = heap.exractMin();
        assertEquals(2, a);
        assertEquals(Arrays.asList(3, 4, 5, 6, 10, 7, 12, 13, 8, 18, 17, 11, 16, 14, 15, 20, 19, 9), heap.getArray());

        a = heap.exractMin();
        assertEquals(3, a);
        assertEquals(Arrays.asList(4, 6, 5, 8, 10, 7, 12, 13, 9, 18, 17, 11, 16, 14, 15, 20, 19), heap.getArray());

        a = heap.exractMin();
        assertEquals(4, a);
        assertEquals(Arrays.asList(5, 6, 7, 8, 10, 11, 12, 13, 9, 18, 17, 19, 16, 14, 15, 20), heap.getArray());

        a = heap.exractMin();
        assertEquals(5, a);
        assertEquals(Arrays.asList(6, 8, 7, 9, 10, 11, 12, 13, 20, 18, 17, 19, 16, 14, 15), heap.getArray());

        a = heap.exractMin();
        assertEquals(6, a);
        assertEquals(Arrays.asList(7, 8, 11, 9, 10, 15, 12, 13, 20, 18, 17, 19, 16, 14), heap.getArray());

        a = heap.exractMin();
        assertEquals(7, a);
        assertEquals(Arrays.asList(8, 9, 11, 13, 10, 15, 12, 14, 20, 18, 17, 19, 16), heap.getArray());

        a = heap.exractMin();
        assertEquals(8, a);
        assertEquals(Arrays.asList(9, 10, 11, 13, 16, 15, 12, 14, 20, 18, 17, 19), heap.getArray());

        a = heap.exractMin();
        assertEquals(9, a);
        assertEquals(Arrays.asList(10, 13, 11, 14, 16, 15, 12, 19, 20, 18, 17), heap.getArray());

        a = heap.exractMin();
        assertEquals(10, a);
        assertEquals(Arrays.asList(11, 13, 12, 14, 16, 15, 17, 19, 20, 18), heap.getArray());

        a = heap.exractMin();
        assertEquals(11, a);
        assertEquals(Arrays.asList(12, 13, 15, 14, 16, 18, 17, 19, 20), heap.getArray());

        a = heap.exractMin();
        assertEquals(12, a);
        assertEquals(Arrays.asList(13, 14, 15, 19, 16, 18, 17, 20), heap.getArray());

        a = heap.exractMin();
        assertEquals(13, a);
        assertEquals(Arrays.asList(14, 16, 15, 19, 20, 18, 17), heap.getArray());

        a = heap.exractMin();
        assertEquals(14, a);
        assertEquals(Arrays.asList(15, 16, 17, 19, 20, 18), heap.getArray());

        a = heap.exractMin();
        assertEquals(15, a);
        assertEquals(Arrays.asList(16, 18, 17, 19, 20), heap.getArray());

        a = heap.exractMin();
        assertEquals(16, a);
        assertEquals(Arrays.asList(17, 18, 20, 19), heap.getArray());

        a = heap.exractMin();
        assertEquals(17, a);
        assertEquals(Arrays.asList(18, 19, 20), heap.getArray());

        a = heap.exractMin();
        assertEquals(18, a);
        assertEquals(Arrays.asList(19, 20), heap.getArray());

        a = heap.exractMin();
        assertEquals(19, a);
        assertEquals(Collections.singletonList(20), heap.getArray());

        a = heap.exractMin();
        assertEquals(20, a);
        assertEquals(Collections.emptyList(), heap.getArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void extractMinWithEmpty() {
        heap = new MinimumBinaryHeap();
        heap.exractMin();
    }
}

