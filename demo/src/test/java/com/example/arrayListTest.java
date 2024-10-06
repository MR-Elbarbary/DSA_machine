package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Before;

import com.example.interfaces.ArrayListInterface;
import com.example.userimplementations.arrayList;

public class arrayListTest 
{
    private ArrayListInterface<Integer> userArrayList;
    @Before
    public void setUp() {
        userArrayList = new arrayList<>();
    }

     @Test
    public void testInitialLength() {
        assertEquals("Initial length should be 0.", 0, userArrayList.getLength());
    }

    @Test
    public void testAppend() {
        userArrayList.append(10);
        assertEquals("Length should be 1 after one append.", 1, userArrayList.getLength());
        assertEquals("First element should be 10.", (Object)10, userArrayList.get(0));
    }

    @Test
    public void testPrepend() {
        userArrayList.prepend(20);
        assertEquals("Length should be 1 after one prepend.", 1, userArrayList.getLength());
        assertEquals("First element should be 20.", (Object)20, userArrayList.get(0));
    }

    @Test
    public void testInsertAt() {
        userArrayList.append(1);
        userArrayList.append(3);
        userArrayList.insertAt(2, 1);
        assertEquals("Length should be 3 after insertAt.", 3, userArrayList.getLength());
        assertEquals("Element at index 1 should be 2.", (Object)2, userArrayList.get(1));
    }

    @Test
    public void testRemoveExistingItem() {
        userArrayList.append(5);
        userArrayList.append(10);
        Integer removed = userArrayList.remove(5);
        assertEquals("Removed item should be 5.", (Object)5, removed);
        assertEquals("Length should be 1 after removal.", (Object)1, userArrayList.getLength());
        assertEquals("Remaining element should be 10.", (Object)10, userArrayList.get(0));
    }

    @Test
    public void testRemoveNonExistingItem() {
        userArrayList.append(15);
        Integer removed = userArrayList.remove(20);
        assertNull("Removing non-existing item should return null.", removed);
        assertEquals("Length should remain 1.", 1, userArrayList.getLength());
    }

    @Test
    public void testGetValidIndex() {
        userArrayList.append(100);
        userArrayList.append(200);
        assertEquals("Element at index 0 should be 100." ,(Object)100, userArrayList.get(0));
        assertEquals("Element at index 1 should be 200.", (Object)200, userArrayList.get(1));
    }

    @Test
    public void testGetInvalidIndex() {
        userArrayList.append(50);
        assertNull("Getting negative index should return null.", userArrayList.get(-1));
        assertNull("Getting out-of-bounds index should return null.", userArrayList.get(1));
    }

    @Test
    public void testRemoveAtValidIndex() {
        userArrayList.append(7);
        userArrayList.append(14);
        Integer removed = userArrayList.removeAt(0);
        assertEquals("Removed item should be 7.", (Object)7, removed);
        assertEquals("Length should be 1 after removal.", (Object)1, userArrayList.getLength());
        assertEquals("Remaining element should be 14.", (Object)14, userArrayList.get(0));
    }

    @Test
    public void testRemoveAtInvalidIndex() {
        userArrayList.append(21);
        Integer removed = userArrayList.removeAt(2);
        assertNull("Removing at invalid index should return null." ,removed);
        assertEquals("Length should remain 1.", 1, userArrayList.getLength());
    }
}
