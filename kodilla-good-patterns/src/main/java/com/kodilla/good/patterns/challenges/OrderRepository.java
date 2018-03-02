package com.kodilla.good.patterns.challenges;

public interface OrderRepository {
    void saveOrder(final User user, final Item item, final int quantity);
}
