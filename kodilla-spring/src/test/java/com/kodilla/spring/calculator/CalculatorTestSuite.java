package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CalculatorTestSuite {
    @Test
    public void testCalculations () {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = (Calculator) context.getBean("calculator");
        //When
        double addTest = calculator.add(3,3);
        double subTest = calculator.sub(3,3);
        double mulTest = calculator.mul(3,3);
        double divTest = calculator.div(3,3);
        //Then
        Assert.assertEquals(6,addTest,0.1);
        Assert.assertEquals(0,subTest,0.1);
        Assert.assertEquals(9,mulTest,0.1);
        Assert.assertEquals(1,divTest,0.1);
    }
}
