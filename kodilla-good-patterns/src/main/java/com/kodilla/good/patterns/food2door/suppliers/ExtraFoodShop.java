package com.kodilla.good.patterns.food2door.suppliers;

import com.kodilla.good.patterns.food2door.AbstractOrderDto;
import com.kodilla.good.patterns.food2door.Supplier;

public class ExtraFoodShop implements Supplier {
    private String name;

    public ExtraFoodShop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean process(AbstractOrderDto orderData) {
        System.out.println(name + " : Checking availability... ");
        System.out.println(name + " : Availability ok, sending acknowledgement.");
        return true;
    }
}
