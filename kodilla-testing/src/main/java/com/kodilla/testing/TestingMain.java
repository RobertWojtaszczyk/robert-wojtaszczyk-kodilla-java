package com.kodilla.testing;
import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();
        System.out.print("Testing class SimpleUser: ");
        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();
        // testing methods separately
        System.out.print("Testing class Calculator, add() method: ");
        System.out.println((calculator.add(49, 51) == 100) ? "test OK" : "Error!");
        System.out.print("Testing class Calculator, subtract() method: ");
        System.out.println((calculator.subtract(51, 49) == 2) ? "test OK" : "Error!");
        // or both methods simultaneously
        System.out.print("Testing class Calculator: ");
        System.out.println(calculator.add(49, 51) == 100 && calculator.subtract(51, 49) == 2 ? "test OK" : "Error!");
    }
}
