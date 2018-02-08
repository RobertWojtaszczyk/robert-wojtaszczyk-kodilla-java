package com.kodilla.testing.collection;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("Test Suite: end");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        List<Integer> integerNumbersList = new ArrayList<>();
        List<Integer> evenNumbersList;
        OddNumbersExterminator testEmptyList = new OddNumbersExterminator();
        evenNumbersList = testEmptyList.exterminate(integerNumbersList);
        System.out.println("Testing empty list");
        Assert.assertTrue(evenNumbersList.isEmpty());
    }
    @Test
    public void testOddNumbersExterminatorNormalList() {
        List<Integer> integerNumbersList = new ArrayList<>();
        List<Integer> evenNumbersList;
        for (int i = 0; i < 11; i++){
            integerNumbersList.add(i);
        }
        OddNumbersExterminator testFilledList = new OddNumbersExterminator();
        evenNumbersList = testFilledList.exterminate(integerNumbersList);
        System.out.println("Testing filled list");
        Assert.assertEquals(6,evenNumbersList.size());
        for (Integer number : evenNumbersList){
            Assert.assertEquals(0, number % 2);
        }
    }
}