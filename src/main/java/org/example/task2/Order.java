package org.example.task2;

public class Order {

    private long id;
    private String customer;

    public Order(long id, String customer) {
        this.id = id;
        this.customer = customer;
    }

    public String formOrderBill(Cart cart) {
        StringBuilder builder = new StringBuilder();
        builder.append("Order number ").append(this.id)
                .append(" for customer ").append(this.customer);
        builder.append("\n------------------\n");

        Item[] currentItemsInCart = cart.getItems();

        if (currentItemsInCart.length == 0) {
            builder.append("Cart is empty.\n");
        } else {
            for (Item item : currentItemsInCart) {
                builder.append("Item id: ").append(item.getId())
                        .append(", name: ").append(item.getName())
                        .append(", price: ").append(item.getPrice())
                        .append("\n");
            }
        }

        builder.append("------------------\n");
        builder.append("Total sum: ")
                .append(cart.calculateTotalPrice());

        return builder.toString();
    }
}
