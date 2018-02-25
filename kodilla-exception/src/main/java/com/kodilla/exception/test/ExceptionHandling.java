package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            System.out.println(secondChallenge.probablyIWillThrowException(1,1.5));
        } catch (Exception e) {
            System.out.println("Illegal parameter! Error: " + e);
        } finally {
            System.out.println("End of probablyIWillThrowException method");
        }
    }
}