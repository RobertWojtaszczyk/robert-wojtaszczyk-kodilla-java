package com.kodilla.good.patterns.challenges;

public interface OrderService {
    boolean createOrder(final User user, final Item item, final int quantity);
}
