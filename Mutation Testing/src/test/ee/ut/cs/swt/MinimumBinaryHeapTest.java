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

    @Before
    public void setUp() {
        heap = new MinimumBinaryHeap();
    }

    @Test
    public void minHeapifyTest() {
        heap.minHeapify(Arrays.asList(5, 17, 15, 9, 19, 11, 16, 8, 12, 10, 2, 7, 3, 14, 13, 20, 6, 1, 4, 18));
        assertEquals(Arrays.asList(1, 2, 3, 4, 8, 7, 13, 9, 5, 18, 10, 15, 11, 16, 14, 20, 17, 12, 6, 19),
                     heap.getArray());
    }

    @Test
    public void addTest() {
        heap.add(10);
        assertEquals(Collections.singletonList(10), heap.getArray());

        heap.add(5);
        assertEquals(Arrays.asList(5, 10), heap.getArray());

        heap.add(4);
        assertEquals(Arrays.asList(4, 10, 5), heap.getArray());

        heap.add(8);
        assertEquals(Arrays.asList(4, 8, 5, 10), heap.getArray());

        heap.add(12);
        assertEquals(Arrays.asList(4, 8, 5, 10, 12), heap.getArray());
    }

    @Test
    public void removeWithEmptyTest() {
        boolean b = heap.remove(9);
        assertFalse(b);
        assertTrue(heap.isEmpty());
    }


    @Test
    public void removeNonexistentTest() {
        heap.getArray().addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        List<Integer> startState = new ArrayList<>(heap.getArray());

        boolean b = heap.remove(9);

        assertFalse(b);
        assertEquals(startState, heap.getArray());
    }

    @Test
    public void removeTest() {
        heap.getArray().addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        boolean b = heap.remove(4);
        assertTrue(b);
        assertEquals(Arrays.asList(1, 2, 3, 8, 5, 6, 7), heap.getArray());

        b = heap.remove(8);
        assertTrue(b);
        assertEquals(Arrays.asList(1, 2, 3, 7, 5, 6), heap.getArray());

        b = heap.remove(1);
        assertTrue(b);
        assertEquals(Arrays.asList(2, 5, 3, 7, 6), heap.getArray());

        b = heap.remove(3);
        assertTrue(b);
        assertEquals(Arrays.asList(2, 5, 6, 7), heap.getArray());

        b = heap.remove(5);
        assertTrue(b);
        assertEquals(Arrays.asList(2, 7, 6), heap.getArray());

        b = heap.remove(2);
        assertTrue(b);
        assertEquals(Arrays.asList(6, 7), heap.getArray());

        b = heap.remove(6);
        assertTrue(b);
        assertEquals(Collections.singletonList(7), heap.getArray());

        b = heap.remove(7);
        assertTrue(b);
        assertEquals(Collections.emptyList(), heap.getArray());
    }

    @Test
    public void extractMinTest() {
        heap.getArray().addAll(Arrays.asList(1, 2, 3, 4, 8, 7, 13, 9, 5, 18, 10, 15, 11, 16, 14, 20, 17, 12, 6, 19));

        int a = heap.extractMin();
        assertEquals(1, a);
        assertEquals(Arrays.asList(2, 4, 3, 5, 8, 7, 13, 9, 6, 18, 10, 15, 11, 16, 14, 20, 17, 12, 19),
                     heap.getArray());

        a = heap.extractMin();
        assertEquals(2, a);
        assertEquals(Arrays.asList(3, 4, 7, 5, 8, 11, 13, 9, 6, 18, 10, 15, 19, 16, 14, 20, 17, 12), heap.getArray());

        a = heap.extractMin();
        assertEquals(3, a);
        assertEquals(Arrays.asList(4, 5, 7, 6, 8, 11, 13, 9, 12, 18, 10, 15, 19, 16, 14, 20, 17), heap.getArray());

        a = heap.extractMin();
        assertEquals(4, a);
        assertEquals(Arrays.asList(5, 6, 7, 9, 8, 11, 13, 17, 12, 18, 10, 15, 19, 16, 14, 20), heap.getArray());

        a = heap.extractMin();
        assertEquals(5, a);
        assertEquals(Arrays.asList(6, 8, 7, 9, 10, 11, 13, 17, 12, 18, 20, 15, 19, 16, 14), heap.getArray());

        a = heap.extractMin();
        assertEquals(6, a);
        assertEquals(Arrays.asList(7, 8, 11, 9, 10, 14, 13, 17, 12, 18, 20, 15, 19, 16), heap.getArray());

        a = heap.extractMin();
        assertEquals(7, a);
        assertEquals(Arrays.asList(8, 9, 11, 12, 10, 14, 13, 17, 16, 18, 20, 15, 19), heap.getArray());

        a = heap.extractMin();
        assertEquals(8, a);
        assertEquals(Arrays.asList(9, 10, 11, 12, 18, 14, 13, 17, 16, 19, 20, 15), heap.getArray());

        a = heap.extractMin();
        assertEquals(9, a);
        assertEquals(Arrays.asList(10, 12, 11, 15, 18, 14, 13, 17, 16, 19, 20), heap.getArray());

        a = heap.extractMin();
        assertEquals(10, a);
        assertEquals(Arrays.asList(11, 12, 13, 15, 18, 14, 20, 17, 16, 19), heap.getArray());

        a = heap.extractMin();
        assertEquals(11, a);
        assertEquals(Arrays.asList(12, 15, 13, 16, 18, 14, 20, 17, 19), heap.getArray());

        a = heap.extractMin();
        assertEquals(12, a);
        assertEquals(Arrays.asList(13, 15, 14, 16, 18, 19, 20, 17), heap.getArray());

        a = heap.extractMin();
        assertEquals(13, a);
        assertEquals(Arrays.asList(14, 15, 17, 16, 18, 19, 20), heap.getArray());

        a = heap.extractMin();
        assertEquals(14, a);
        assertEquals(Arrays.asList(15, 16, 17, 20, 18, 19), heap.getArray());

        a = heap.extractMin();
        assertEquals(15, a);
        assertEquals(Arrays.asList(16, 18, 17, 20, 19), heap.getArray());

        a = heap.extractMin();
        assertEquals(16, a);
        assertEquals(Arrays.asList(17, 18, 19, 20), heap.getArray());

        a = heap.extractMin();
        assertEquals(17, a);
        assertEquals(Arrays.asList(18, 20, 19), heap.getArray());

        a = heap.extractMin();
        assertEquals(18, a);
        assertEquals(Arrays.asList(19, 20), heap.getArray());

        a = heap.extractMin();
        assertEquals(19, a);
        assertEquals(Collections.singletonList(20), heap.getArray());

        a = heap.extractMin();
        assertEquals(20, a);
        assertEquals(Collections.emptyList(), heap.getArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void extractMinWithEmptyTest() {
        heap = new MinimumBinaryHeap();
        assertTrue(heap.isEmpty());
        heap.extractMin();
    }
}

