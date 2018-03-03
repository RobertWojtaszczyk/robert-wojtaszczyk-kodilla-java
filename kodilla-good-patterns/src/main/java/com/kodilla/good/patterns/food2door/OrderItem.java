package com.kodilla.good.patterns.food2door;

public final class OrderItem {
    private final Product product;
    private final double quantity;

    public OrderItem(final Product product, final double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
