package com.kodilla.good.patterns.challenges;

public class OrdersRepository implements OrderRepository {
    @Override
    public void saveOrder(final User user, final Item item, final int quantity) {
        System.out.println("Saving new order data: \n" + user + "\n" + item + "\n" + "Quantity: " + quantity);
    }
}
