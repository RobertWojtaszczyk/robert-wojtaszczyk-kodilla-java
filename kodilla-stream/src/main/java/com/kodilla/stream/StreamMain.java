package com.kodilla.stream;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.reference.FunctionalCalculator;
//import com.kodilla.stream.lambda.ExecuteSaySomething;
//import com.kodilla.stream.lambda.ExpressionExecutor;
//import com.kodilla.stream.lambda.Processor;
//import com.kodilla.stream.lambda.SaySomething;
//import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        System.out.println(poemBeautifier.beautify("Tekst upiększony gwiazdkami",(poem)->"***" + poem + "***"));
        System.out.println(poemBeautifier.beautify("Tekst tylko z dużych liter",(poem)->poem.toUpperCase()));
        PoemDecorator lambdaExpression = (poem) -> {
            String result = ".";
            for (int i = 0; i < poem.length(); i++) {
                result = result + poem.charAt(i) + ".";
            }
            return result;
        };
        System.out.println(poemBeautifier.beautify("Tekst rozdzielony kropkami", lambdaExpression));
        //nie wiem jak przerobić rekurencyjną metodę na wyrażenie lambda, skorzystałem z referencji do metody :)
        System.out.println(poemBeautifier.beautify(".kapsw ynasipan tskeT", FunctionalCalculator::reverseString));
        //materiał z modułu 7.1
        /*SaySomething saySomething = new SaySomething();
        saySomething.say();

        Processor processor = new Processor();
        processor.execute(new ExecuteSaySomething());

        processor.execute(()-> System.out.println("This is an example test of lambda expression"));
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        System.out.println(expressionExecutor.executeExpression(4,4, (a, b)-> a + b));
        System.out.println(expressionExecutor.executeExpression(5,5, (a, b)-> a * b));
        System.out.println(expressionExecutor.executeExpression(25,5.1, (a, b)-> a / b));

        System.out.println("Calculating expressions with method references");
        System.out.println(expressionExecutor.executeExpression(25,5.1, FunctionalCalculator::divideAByB));

        FunctionalCalculator functionalCalculator = new FunctionalCalculator();
        System.out.println(functionalCalculator.addAToB(3,3));*/
    }
}