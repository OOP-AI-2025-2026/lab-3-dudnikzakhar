package org.example.task2;

public class intStack {

    private final int CAPACITY = 20;

    private int[] items;
    private int top = -1;

    public intStack() {
        this.items = new int[CAPACITY];
    }

    public int size() {
        return top + 1;
    }

    public void push(int item) {
        if (top + 1 == items.length) {
            increaseCapacity();
        }
        top++;
        items[top] = item;
    }

    private void increaseCapacity() {
        int newCapacity = 2 * items.length;
        int[] newItems = new int[newCapacity];

        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }

        this.items = newItems;
    }

    public int pop() {
        if (isEmpty()) {
            return 0;
        }
        top--;
        return items[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void clear() {
        top = -1;
    }

    public int peek() {
        if (isEmpty()) {
            return 0;
        }
        return items[top];
    }

}
