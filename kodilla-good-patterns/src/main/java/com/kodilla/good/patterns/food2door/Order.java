package com.kodilla.good.patterns.food2door;
import java.util.ArrayList;
import java.util.List;

public final class Order {
    private final List<OrderItem> order = new ArrayList<>();

    public List<OrderItem> getOrder() {
        return new ArrayList<>(order);
    }

    public void addOrderItem(OrderItem orderItem) {
        order.add(orderItem);
    }
}