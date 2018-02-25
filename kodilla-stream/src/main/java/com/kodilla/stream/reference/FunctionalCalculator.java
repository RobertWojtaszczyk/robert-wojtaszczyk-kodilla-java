package com.kodilla.stream.reference;

public class FunctionalCalculator {
    public static double multiplyAByB(double a, double b) {
        return a * b;
    }
    public static double addAToB(double a, double b) {
        return a + b;
    }
    public static double subBFromA(double a, double b) {
        return a - b;
    }
    public static double divideAByB(double a, double b) {
        return a / b;
    }

    public static String reverseString(String str)
    {
        if (str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}