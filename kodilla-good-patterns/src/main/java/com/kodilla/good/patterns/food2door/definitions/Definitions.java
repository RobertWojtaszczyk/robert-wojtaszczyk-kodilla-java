package com.kodilla.good.patterns.food2door.definitions;

import com.kodilla.good.patterns.food2door.OrderItem;
import com.kodilla.good.patterns.food2door.Product;
import com.kodilla.good.patterns.food2door.suppliers.ExtraFoodShop;
import com.kodilla.good.patterns.food2door.suppliers.GlutenFreeShop;
import com.kodilla.good.patterns.food2door.suppliers.HealthyShop;

import java.util.ArrayList;
import java.util.List;

public final class Definitions {
    public static List<Product> getProducts() {
        final List<Product> products = new ArrayList<>();
        products.add(new Product("Apple","Fresh Apples", 1, new HealthyShop("!HealthyShop")));
        products.add(new Product("Oat Flakes","Gluten free Oat flakes", 1, new GlutenFreeShop("!GlutenFreeShop")));
        products.add(new Product("Cereal bar","Extra energetic", 1, new ExtraFoodShop("!ExtraFoodShop")));
        return new ArrayList<>(products);
    }

    public static List<OrderItem> getOrderItems() {
        final List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem(getProducts().get(0),10));
        orderItems.add(new OrderItem(getProducts().get(1),20));
        orderItems.add(new OrderItem(getProducts().get(2),30));
        return new ArrayList<>(orderItems);
    }
}
