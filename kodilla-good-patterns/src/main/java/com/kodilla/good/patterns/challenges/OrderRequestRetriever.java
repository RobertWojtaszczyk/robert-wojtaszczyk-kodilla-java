package com.kodilla.good.patterns.challenges;
import com.kodilla.good.patterns.challenges.definitions.Definitions;

public class OrderRequestRetriever {
    public OrderRequest retrieve(final int userIndex, final int itemIndex, final int quantity) {
        User user = Definitions.getUsers().get(userIndex);
        Item item = Definitions.getItems().get(itemIndex);
        return new OrderRequest(user, item, quantity);
    }
}
