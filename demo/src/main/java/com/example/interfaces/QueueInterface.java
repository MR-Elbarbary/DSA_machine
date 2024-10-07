package com.example.interfaces;

public interface QueueInterface<T> {
    boolean isEmpty();
    int getLength();
    void enqueue(T item);
    T deque();
    T peek();
}
