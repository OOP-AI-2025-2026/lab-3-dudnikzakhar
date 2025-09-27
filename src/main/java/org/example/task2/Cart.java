package org.example.task2;

import java.util.Arrays;

public class Cart {

    private Item[] items;
    private int itemCount;

    public Cart(int contents) {
        if (contents <= 0) {
            throw new IllegalArgumentException("Місткість кошика має бути додатнім числом.");

        }
        this.items = new Item[contents];
        this.itemCount = 0;

    }

    public void add(Item item) {
        if (item == null) {
            return;
        }
        if (isFull()) {
            resize();
        }

        this.items[this.itemCount] = item;
        this.itemCount++;
    }

    private int findItemIndexInArray(long itemId) {
        for (int i = 0; i < this.itemCount; i++) {
            if (this.items[i].getId() == itemId) {
                return i;
            }
        }
        return -1; // not found
    }

    public void removeItemById(long itemId) {
        int itemIndexToRemove = findItemIndexInArray(itemId);
        if (itemIndexToRemove == -1) {
            return;
        }

        shiftItems(itemIndexToRemove);
    }

    private void shiftItems(int fromIndex) {
        for (int i = fromIndex; i < this.itemCount - 1; i++) {
            this.items[i] = this.items[i + 1];
        }
        this.itemCount--;
        this.items[this.itemCount] = null;
    }

    public boolean isFull() {
        return this.itemCount == this.items.length;
    }

    public double calculateTotalPrice() {
        double sum = 0.0;
        for (int i = 0; i < this.itemCount; i++) {
            sum += this.items[i].getPrice();
        }
        return sum;
    }

    public Item[] getItems() {
        Item[] copy = new Item[this.itemCount];

        for (int i = 0; i < this.itemCount; i++) {
            copy[i] = this.items[i];
        }

        return copy;
    }

    private void resize() {
        int newCapacity = this.items.length * 2;

        Item[] newItems = new Item[newCapacity];

        System.arraycopy(this.items, 0, newItems, 0, this.items.length);

        this.items = newItems;
    }

    @Override
    public String toString() {
        return "Cart{"
                + "items=" + Arrays.toString(getItems())
                + ", itemCount=" + itemCount
                + ", capacity=" + items.length
                + '}';
    }
}
