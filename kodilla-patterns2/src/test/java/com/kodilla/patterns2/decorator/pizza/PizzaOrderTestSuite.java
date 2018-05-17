package com.kodilla.patterns2.decorator.pizza;

import org.junit.After;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;


import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PizzaOrderTestSuite {
    private static int testCounter = 0;
    private BigDecimal cost;
    private String desc;

    @After
    public void afterEveryTestPrintResults() {
        testCounter++;
        System.out.println("\nPrinting results of test number: " + testCounter);
        System.out.println("Cost: " + cost);
        System.out.println("Description: " + desc);
    }

    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15), calculatedCost);
        cost = theOrder.getCost();
        desc = theOrder.getDescription();
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese", description);
        cost = theOrder.getCost();
        desc = theOrder.getDescription();
    }

    @Test
    public void testBasicPizzaOrderWithExtraCheeseGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(20), calculatedCost);
        cost = theOrder.getCost();
        desc = theOrder.getDescription();
    }

    @Test
    public void testBasicPizzaOrderWithExtraCheeseGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese + extra cheese", description);
        cost = theOrder.getCost();
        desc = theOrder.getDescription();
    }

    @Test
    public void testBasicPizzaOrderWithExtraCheeseAndOlivesGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new OlivesDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(23), calculatedCost);
        cost = theOrder.getCost();
        desc = theOrder.getDescription();
    }

    @Test
    public void testBasicPizzaOrderWithExtraCheeseAndOlivesGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new OlivesDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese + extra cheese + olives", description);
        cost = theOrder.getCost();
        desc = theOrder.getDescription();
    }

    @Test
    public void testBasicPizzaOrderWithExtraCheeseAndOlivesAndTomatoGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new OlivesDecorator(theOrder);
        theOrder = new TomatoDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
//        System.out.println("Total cost: " + calculatedCost);
        //Then
        assertEquals(new BigDecimal(26), calculatedCost);
        cost = theOrder.getCost();
        desc = theOrder.getDescription();
    }

    @Test
    public void testBasicPizzaOrderWithExtraCheeseAndOlivesAndTomatoGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new OlivesDecorator(theOrder);
        theOrder = new TomatoDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
//        System.out.println(description);
        //Then
        assertEquals("Pizza with tomato sauce and cheese + extra cheese + olives + tomato", description);
        cost = theOrder.getCost();
        desc = theOrder.getDescription();
    }

    @Test
    public void testBasicPizzaOrderWithExtraCheeseAndOlivesAndTomatoCheckOffersGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new OlivesDecorator(theOrder);
        theOrder = new TomatoDecorator(theOrder);
        theOrder = new SpecialOfferDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
//        System.out.println("Total cost: " + calculatedCost.setScale(1, RoundingMode.HALF_UP));
        //Then
        assertThat(new BigDecimal(23.4), is(closeTo(calculatedCost, new BigDecimal("0.1"))));
        cost = theOrder.getCost().setScale(1, RoundingMode.HALF_UP);
        desc = theOrder.getDescription();
    }

    @Test
    public void testBasicPizzaOrderWithExtraCheeseAndOlivesAndTomatoCheckOffersGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new OlivesDecorator(theOrder);
        theOrder = new TomatoDecorator(theOrder);
        theOrder = new SpecialOfferDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
//        System.out.println(description);
        //Then
        assertEquals("Pizza with tomato sauce and cheese + extra cheese + olives + tomato with Special Offer: 10% discount", description);
        cost = theOrder.getCost().setScale(1, RoundingMode.HALF_UP);
        desc = theOrder.getDescription();
    }

    @Test
    public void testBasicPizzaOrderCheckOffersShouldNotApplyGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new SpecialOfferDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15), calculatedCost);
        cost = theOrder.getCost();
        desc = theOrder.getDescription();
    }

    @Test
    public void testBasicPizzaOrderCheckOffersShouldNotApplyGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new SpecialOfferDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese", description);
        cost = theOrder.getCost();
        desc = theOrder.getDescription();
    }
}
