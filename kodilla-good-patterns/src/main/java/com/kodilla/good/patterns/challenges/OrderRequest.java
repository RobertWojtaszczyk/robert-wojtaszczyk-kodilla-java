package com.kodilla.good.patterns.challenges;

public class OrderRequest {
    private User user;
    private Item item;
    private int quantity;

    public OrderRequest(final User user, final Item item, final int quantity) {
        this.user = user;
        this.item = item;
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
