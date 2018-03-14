package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.bigmac.definitions.INGREDIENTS;
import com.kodilla.patterns.builder.bigmac.definitions.SAUCE;
import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testPizzaNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .burgers(2)
                .ingredient(INGREDIENTS.CHEESE)
                .roll(true)
                .ingredient(INGREDIENTS.BACON)
                .sauce(SAUCE.BARBECUE)
                .ingredient(INGREDIENTS.CHILIPEPPER)
                .ingredient(INGREDIENTS.PICKLE)
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(4, howManyIngredients);
    }
}
