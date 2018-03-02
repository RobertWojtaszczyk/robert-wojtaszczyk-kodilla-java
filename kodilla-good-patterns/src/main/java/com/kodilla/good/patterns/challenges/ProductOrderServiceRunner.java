package com.kodilla.good.patterns.challenges;

public class ProductOrderServiceRunner {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve(3,3,2);

        ProductOrderService productOrderService = new ProductOrderService(new MailService(), new OrdersProcessing(), new OrdersRepository());
        productOrderService.process(orderRequest);
    }
}
