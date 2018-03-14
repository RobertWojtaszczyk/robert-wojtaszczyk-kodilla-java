package com.kodilla.good.patterns.food2door.suppliers;

import com.kodilla.good.patterns.food2door.AbstractOrderDto;
import com.kodilla.good.patterns.food2door.Supplier;

public class HealthyShop implements Supplier {
    private String name;

    public HealthyShop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean process(AbstractOrderDto orderData) {
        System.out.println(name + " processing order:");
        System.out.println("- Checking availability... ");
        System.out.println("- Availability ok, sending acknowledgement.");
        return true;
    }
}
