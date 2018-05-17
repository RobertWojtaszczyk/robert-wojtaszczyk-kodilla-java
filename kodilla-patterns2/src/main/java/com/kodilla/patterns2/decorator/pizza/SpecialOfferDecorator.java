package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SpecialOfferDecorator extends AbstractPizzaOrderDecorator {
    public SpecialOfferDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return checkDiscount() ? super.getCost().multiply(new BigDecimal(0.9)) : super.getCost();
    }

    @Override
    public String getDescription() {
        return checkDiscount() ? super.getDescription() + " with Special Offer: 10% discount" : super.getDescription();
    }

    private boolean checkDiscount() {
        return super.getCost().compareTo(new BigDecimal(25)) > 0;
    }
}
