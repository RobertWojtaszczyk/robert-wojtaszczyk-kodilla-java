package com.kodilla.good.patterns.food2door;
import com.kodilla.good.patterns.food2door.definitions.Definitions;

public class OrderProcessorRunner {
    public static void main(String[] args) {
        Order order = new Order();
        order.addOrderItem(Definitions.getOrderItems().get(0));
        order.addOrderItem(Definitions.getOrderItems().get(1));
        order.addOrderItem(Definitions.getOrderItems().get(2));

        OrderProcessor orderProcessor = new OrderProcessor(order);
        orderProcessor.processOrder();
    }
}