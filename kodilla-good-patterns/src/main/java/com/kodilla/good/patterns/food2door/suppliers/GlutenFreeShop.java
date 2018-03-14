package com.kodilla.good.patterns.food2door.suppliers;

import com.kodilla.good.patterns.food2door.AbstractOrderDto;
import com.kodilla.good.patterns.food2door.Supplier;

public class GlutenFreeShop implements Supplier {
    private String name;

    public GlutenFreeShop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean process(AbstractOrderDto orderData) {
        System.out.println("Checking availability... (" + name + ")");
        System.out.println("Availability: not in stock, sending acknowledgement(" + name + ")");
        return false;
    }
}
