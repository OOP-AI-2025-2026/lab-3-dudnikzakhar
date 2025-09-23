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
            System.out.println("Немає місця для " + item.getName());
            return;
        }
        this.items[this.itemCount] = item;
        this.itemCount++;
    }

    public void removeItemById(long itemId) {
        int foundIndex = findItemIndexById(itemId);

        if (foundIndex == -1) {
            return;
        }

        shiftItemsLeft(foundIndex);
        this.itemCount--;
        this.items[this.itemCount] = null;
    }

    private int findItemIndexById(long itemId) {
        for (int i = 0; i < this.itemCount; i++) {
            if (this.items[i].getId() == itemId) {
                return i;
            }
        }
        return -1; // not found
    }

    private void shiftItemsLeft(int fromIndex) {
        for (int i = fromIndex; i < this.itemCount - 1; i++) {
            this.items[i] = this.items[i + 1];
        }
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

    @Override
    public String toString() {
        return "Cart{"
                + "items=" + Arrays.toString(getItems())
                + ", itemCount=" + itemCount
                + ", capacity=" + items.length
                + '}';
    }
}
