package com.kodilla.good.patterns.food2door.suppliers;

import com.kodilla.good.patterns.food2door.Supplier;

public class HealthyShop implements Supplier {
    @Override
    public boolean process() {
        System.out.println("HealthyShop: Checking availability... ");
        System.out.println("HealthyShop: Availability ok, sending acknowledgement.");
        return true;
    }
}
