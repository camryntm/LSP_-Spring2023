package org.howard.edu.lsp.assignment5;

import org.howard.edu.lsp.assignment5.IntegerSet.IntegerSetException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class IntegerSetTest {
    private IntegerSet my_set;

    @BeforeEach
    void setUp() {
        my_set = new IntegerSet();
    }

    @Test
    @DisplayName("Test case for clear")
    void testClear() {
        my_set.add(11);
        my_set.clear();
        assertEquals(0, my_set.length());
    }

    @Test
    @DisplayName("Test case for length")
    void testLength() {
        my_set.add(100);
        my_set.add(200);
        my_set.add(300);
        my_set.add(400);
        assertEquals(4, my_set.length());
    }

    @Test
    @DisplayName("Test case for equals")
    void testEquals() {
        IntegerSet that_set = new IntegerSet();
        my_set.add(11);
        that_set.add(11);
        assertTrue(my_set.equals(that_set));
    }

    @Test
    @DisplayName("Test case for contains")
    void testContains() {
        my_set.add(99);
        assertTrue(my_set.contains(99));
        assertFalse(my_set.contains(88));
    }

    @Test
    @DisplayName("Test case for largest")
    void testLargest() throws IntegerSet.IntegerSetException {
        my_set.add(40);
        my_set.add(80);
        my_set.add(120);
        my_set.add(160);
        my_set.add(200);
        assertEquals(200, my_set.largest());
    }

    @Test
    @DisplayName("Test case for largest exception")
    void testLargestException() {
        assertThrows(IntegerSet.IntegerSetException.class, () -> my_set.largest());
    }

    @Test
    @DisplayName("Test case for smallest")
    void testSmallest() throws IntegerSet.IntegerSetException {
        my_set.add(100);
        my_set.add(200);
        my_set.add(300);
        my_set.add(400);
        assertEquals(100, my_set.smallest());
    }

    @Test
    @DisplayName("Test case for smallest exception")
    void testSmallestException() {
        assertThrows(IntegerSet.IntegerSetException.class, () -> my_set.smallest());
    }

    @Test
    @DisplayName("Test case for add")
    void testAdd() {
        IntegerSet that_set = new IntegerSet();
        that_set.add(22);
        that_set.add(44);
        that_set.add(66);

        my_set.add(22);
        my_set.add(44);
        my_set.add(66);

        assertTrue(that_set.equals(my_set));

        // Add more add() test cases
        my_set.add(22); // Adding an already existing value should have no effect
        assertEquals(3, my_set.length());
    }

    @Test
    @DisplayName("Test case for remove")
    void testRemove() {
        my_set.add(500);
        my_set.add(1000);
        my_set.add(1500);
        my_set.remove(1500);

        assertFalse(my_set.contains(1500));
    }

    @Test
    @DisplayName("Test case for union")
    void testUnion() {
        IntegerSet that_set = new IntegerSet();
        my_set.add(1);
        my_set.add(2);
        my_set.add(3);
        my_set.add(4);

        that_set.add(3);
        that_set.add(4);
        that_set.add(5);
        that_set.add(6);

        my_set.union(that_set);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(expected, my_set.int_set);
    }

    @Test
    @DisplayName("Test case for intersect")
    void testIntersect() {
        IntegerSet that_set = new IntegerSet();
        my_set.add(50);
        my_set.add(100);
        my_set.add(150);
        my_set.add(200);

        that_set.add(100);
        that_set.add(200);
        that_set.add(300);
        that_set.add(400);

        my_set.intersect(that_set);
        List<Integer> expected = new ArrayList<>(Arrays.asList(100, 200));
        assertEquals(expected, my_set.int_set);
    }

    @Test
    @DisplayName("Test case for difference")
    void testDifference() {
        IntegerSet that_set = new IntegerSet();
        my_set.add(200);
        my_set.add(400);
        my_set.add(600);

        that_set.add(300);
        that_set.add(400);
        that_set.add(500);

        my_set.diff(that_set);
        List<Integer> expected = new ArrayList<>(Arrays.asList(200, 600));
        assertEquals(expected, my_set.int_set);
    }

    @Test
    @DisplayName("Test case for isEmpty")
    void testEmpty() {
        assertTrue(my_set.isEmpty());
        my_set.add(11);
        assertFalse(my_set.isEmpty());
    }

    @Test
    @DisplayName("Test case for toString")
    void testString() {
        my_set.add(11);
        my_set.add(22);
        my_set.add(33);
        my_set.add(44);
        my_set.add(55);
        assertEquals("11, 22, 33, 44, 55, ", my_set.toString());
    }
}
