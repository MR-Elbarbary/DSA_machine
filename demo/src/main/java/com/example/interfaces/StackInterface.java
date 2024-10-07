package com.example.interfaces;

public interface StackInterface<T> {
    boolean isEmpty();
    int getLength();
    void push(T item);
    T pop();
    T peek();
}
