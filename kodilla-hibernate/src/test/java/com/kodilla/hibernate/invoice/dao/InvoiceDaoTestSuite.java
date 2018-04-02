package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
//    @Autowired
//    ItemDao itemDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product = new Product("Mobile phone");

        Item item1 = new Item(product ,new BigDecimal(999.99), 2); //czy 'product' może być bezpośrednio w konstruktorze?
        //product.getItems().add(item1);
        Item item2 = new Item(product, new BigDecimal(888.99), 3);
        //product.getItems().add(item2);

        Invoice invoice = new Invoice("1/2018");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        //When
        productDao.save(product);
        //itemDao.save(item2);
        invoiceDao.save(invoice);

        int idItem1 = item1.getId();
        int idItem2 = item2.getId();
        int idProduct = product.getId();
        int idInvoice = invoice.getId();

        //Then
        Assert.assertNotEquals(0, idItem1);
        Assert.assertNotEquals(0, idItem2);
        Assert.assertNotEquals(0, idProduct);
        Assert.assertNotEquals(0, idInvoice);

        //CleanUp
        invoiceDao.delete(idInvoice);
        productDao.delete(idProduct);
    }
}