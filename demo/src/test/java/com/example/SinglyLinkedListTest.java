// File: SinglyLinkedListTest.java
package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.example.interfaces.LinkedListInterface;
import com.example.userimplementations.SinglyLinkedList;

/**
 * Unit tests for SinglyLinkedList implementation.
 */
public class SinglyLinkedListTest {
    
    private LinkedListInterface<Integer> list;

    @Before
    public void setUp() {
        list = new SinglyLinkedList<>();
    }

    @Test
    public void testInitialLength() {
        assertEquals("Initial length should be 0.", 0, list.getLength());
    }

    @Test
    public void testAppend() {
        list.append(10);
        assertEquals("Length should be 1 after one append.", 1, list.getLength());
        assertEquals("First element should be 10.", (Integer)10, list.get(0));
    }

    @Test
    public void testPrepend() {
        list.prepend(20);
        assertEquals("Length should be 1 after one prepend.", 1, list.getLength());
        assertEquals("First element should be 20.", (Integer)20, list.get(0));
    }

    @Test
    public void testInsertAt() {
        list.append(1);
        list.append(3);
        list.insertAt(2, 1);
        assertEquals("Length should be 3 after insertAt.", 3, list.getLength());
        assertEquals("Element at index 1 should be 2.", (Integer)2, list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertAtInvalidIndex() {
        list.insertAt(5, 3); // Should throw IndexOutOfBoundsException
    }

    @Test
    public void testRemoveExistingItem() {
        list.append(5);
        list.append(10);
        Integer removed = list.remove(5);
        assertEquals("Removed item should be 5.", (Integer)5, removed);
        assertEquals("Length should be 1 after removal.", 1, list.getLength());
        assertEquals("Remaining element should be 10.", (Integer)10, list.get(0));
    }

    @Test
    public void testRemoveNonExistingItem() {
        list.append(15);
        Integer removed = list.remove(20);
        assertNull("Removing non-existing item should return null.", removed);
        assertEquals("Length should remain 1.", 1, list.getLength());
    }

    @Test
    public void testGetValidIndex() {
        list.append(100);
        list.append(200);
        assertEquals("Element at index 0 should be 100.", (Integer)100, list.get(0));
        assertEquals("Element at index 1 should be 200.", (Integer)200, list.get(1));
    }

    @Test
    public void testGetInvalidIndex() {
        list.append(50);
        assertNull("Getting negative index should return null.", list.get(-1));
        assertNull("Getting out-of-bounds index should return null.", list.get(2));
    }

    @Test
    public void testRemoveAtValidIndex() {
        list.append(7);
        list.append(14);
        Integer removed = list.removeAt(0);
        assertEquals("Removed item should be 7.", (Integer)7, removed);
        assertEquals("Length should be 1 after removal.", 1, list.getLength());
        assertEquals("Remaining element should be 14.", (Integer)14, list.get(0));
    }

    @Test
    public void testRemoveAtInvalidIndex() {
        list.append(21);
        Integer removed = list.removeAt(2);
        assertNull("Removing at invalid index should return null.", removed);
        assertEquals("Length should remain 1.", 1, list.getLength());
    }
}
