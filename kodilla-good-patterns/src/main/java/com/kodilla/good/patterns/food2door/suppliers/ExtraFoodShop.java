package com.kodilla.good.patterns.food2door.suppliers;
import com.kodilla.good.patterns.food2door.Supplier;

public class ExtraFoodShop implements Supplier {
    @Override
    public boolean process() {
        System.out.println("ExtraFoodShop: Checking availability... ");
        System.out.println("ExtraFoodShop: Availability ok, sending acknowledgement.");
        return true;
    }
}
