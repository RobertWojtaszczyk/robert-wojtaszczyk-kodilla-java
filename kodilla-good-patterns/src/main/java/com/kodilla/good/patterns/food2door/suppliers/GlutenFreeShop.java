package com.kodilla.good.patterns.food2door.suppliers;

import com.kodilla.good.patterns.food2door.Supplier;

public class GlutenFreeShop implements Supplier {
    @Override
    public boolean process() {
        System.out.println("GlutenFreeShop: Checking availability... ");
        System.out.println("GlutenFreeShop: Availability: not in stock, sending acknowledgement.");
        return false;
    }
}
