package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.interfaces.StackInterface;
import com.example.userimplementations.Stack;

import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for Stack implementation.
 */
public class StackTest {
    
    private StackInterface<Integer> stack;

    @Before
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void testPush() {
        stack.push(10);
        assertEquals("Stack length should be 1 after one push.", 1, stack.getLength());
        assertEquals("Top element should be 10.", (Integer)10, stack.peek());
    }

    @Test
    public void testPop() {
        stack.push(20);
        stack.push(30);
        Integer popped = stack.pop();
        assertEquals("Popped element should be 30.", (Integer)30, popped);
        assertEquals("Stack length should be 1 after one pop.", 1, stack.getLength());
        assertEquals("Top element should now be 20.", (Integer)20, stack.peek());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopEmptyStack() {
        stack.pop(); // Should throw NoSuchElementException
    }

    @Test
    public void testPeek() {
        stack.push(40);
        Integer top = stack.peek();
        assertEquals("Top element should be 40.", (Integer)40, top);
        assertEquals("Stack length should remain 1 after peek.", 1, stack.getLength());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekEmptyStack() {
        stack.peek(); // Should throw NoSuchElementException
    }

    @Test
    public void testPushMultiple() {
        stack.push(50);
        stack.push(60);
        stack.push(70);
        assertEquals("Stack length should be 3 after three pushes.", 3, stack.getLength());
        assertEquals("Top element should be 70.", (Integer)70, stack.peek());
    }

    @Test
    public void testPopAll() {
        stack.push(80);
        stack.push(90);
        stack.pop();
        stack.pop();
        assertTrue("Stack should be empty after popping all elements.", stack.isEmpty());
    }
}
