package com.example.interfaces;

public interface LinkedListInterface<T> {
    void prepend(T item);
    void insertAt(T item, int idx);
    void append(T item);
    int getLength();
    T remove(T item); 
    T get(int idx);
    T removeAt(int idx);
}