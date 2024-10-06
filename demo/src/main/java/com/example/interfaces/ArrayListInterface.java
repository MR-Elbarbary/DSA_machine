package com.example.interfaces;

public interface ArrayListInterface<T> {
    int getLength();
    void prepend(T item);
    void insertAt(T item, int idx);
    void append(T item);
    T remove(T item);
    T get(int idx);
    T removeAt(int idx);
}