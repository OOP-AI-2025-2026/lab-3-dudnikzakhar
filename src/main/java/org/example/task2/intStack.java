package org.example.task2;

public class intStack {

    private final int CAPACITY = 20;

    private int[] elements;

    private int size;

    public void increaseCapacity() {
        int newCapacity = 2 * elements.length;
        int[] newElements = new int[newCapacity];

        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }

        this.elements = newElements;
    }

    public intStack() {
        this.elements = new int[CAPACITY];
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public void push(int item) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size] = item;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            return 0;
        }
        size--;
        return elements[size];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void clear() {
        this.size = 0;
    }

    public int peek() {
        if (isEmpty()) {
            return 0;
        }
        return elements[size - 1];
    }

}
