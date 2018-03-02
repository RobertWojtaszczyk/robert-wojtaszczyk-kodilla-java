package com.kodilla.good.patterns.challenges;

public class OrdersProcessing implements OrderService {
    @Override
    public boolean createOrder(final User user, final Item item, final int quantity) {
        System.out.println("Creating new order for user: " + user.getName() + "\nItem: " + item.getName() + "; quantity: " + quantity);
        return true;
    }
}
