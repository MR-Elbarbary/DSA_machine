package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.interfaces.QueueInterface;
import com.example.userimplementations.Queue;

import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for Queue implementation.
 */
public class QueueTest {
    
    private QueueInterface<Integer> queue;

    @Before
    public void setUp() {
        queue = new Queue<>();
    }

    @Test
    public void testEnqueue() {
        queue.enqueue(10);
        assertEquals("Queue length should be 1 after one enqueue.", 1, queue.getLength());
        assertEquals("Front element should be 10.", (Integer)10, queue.peek());
    }

    @Test
    public void testDeque() {
        queue.enqueue(20);
        queue.enqueue(30);
        Integer dequeued = queue.deque();
        assertEquals("Dequeued element should be 20.", (Integer)20, dequeued);
        assertEquals("Queue length should be 1 after one deque.", 1, queue.getLength());
        assertEquals("Front element should now be 30.", (Integer)30, queue.peek());
    }

    @Test(expected = NoSuchElementException.class)
    public void testDequeEmptyQueue() {
        queue.deque(); // Should throw NoSuchElementException
    }

    @Test
    public void testPeek() {
        queue.enqueue(40);
        Integer front = queue.peek();
        assertEquals("Front element should be 40.", (Integer)40, front);
        assertEquals("Queue length should remain 1 after peek.", 1, queue.getLength());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekEmptyQueue() {
        queue.peek(); // Should throw NoSuchElementException
    }

    @Test
    public void testEnqueueMultiple() {
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        assertEquals("Queue length should be 3 after three enqueues.", 3, queue.getLength());
        assertEquals("Front element should be 50.", (Integer)50, queue.peek());
    }

    @Test
    public void testDequeAll() {
        queue.enqueue(80);
        queue.enqueue(90);
        queue.deque();
        queue.deque();
        assertTrue("Queue should be empty after dequeuing all elements.", queue.isEmpty());
    }
}
