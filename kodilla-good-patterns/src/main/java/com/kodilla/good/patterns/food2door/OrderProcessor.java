package com.kodilla.good.patterns.food2door;

public final class OrderProcessor {
    private final Order order;

    public OrderProcessor(final Order order) {
        this.order = order;
    }

    public void processOrder() {
        order.getOrder().stream()
                .forEach(orderItem -> {
                    System.out.println(orderItem.getProduct().toString() + " Quantity: " + orderItem.getQuantity());
                    if (orderItem.getProduct().getSupplier().process(new AbstractOrderDto(orderItem.getProduct().getSupplier().getName()))) {
                        System.out.println("Order accepted!\n");
                    } else {
                        System.out.println("Order rejected!\n");
                    }
                });
    }
}