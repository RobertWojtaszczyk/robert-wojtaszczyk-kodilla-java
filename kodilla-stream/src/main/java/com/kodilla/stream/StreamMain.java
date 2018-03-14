package com.kodilla.stream;
//import com.kodilla.stream.beautifier.PoemBeautifier;
//import com.kodilla.stream.beautifier.PoemDecorator;
//import com.kodilla.stream.iterate.NumbersGenerator;
//import com.kodilla.stream.person.People;
//import com.kodilla.stream.reference.FunctionalCalculator;
//import com.kodilla.stream.lambda.ExecuteSaySomething;
//import com.kodilla.stream.lambda.ExpressionExecutor;
//import com.kodilla.stream.lambda.Processor;
//import com.kodilla.stream.lambda.SaySomething;
//import com.kodilla.stream.reference.FunctionalCalculator;
//import com.kodilla.stream.book.Book;
//import com.kodilla.stream.book.BookDirectory;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");
        //zadanie 7.3
        Forum forum = new Forum();
        Map<Integer, ForumUser> theResultOfForumUsersList = forum.getTheForumUsersList().stream()
                .filter(user -> user.getPostsCount() > 0 && user.getGender() == 'M' && user.getBirthDate().until(LocalDate.now(), ChronoUnit.YEARS) > 20)
                .collect(Collectors.toMap(userid -> userid.getUniqueID(),forumuser -> forumuser));
        theResultOfForumUsersList.entrySet().stream()
                .map(entry -> entry.getKey() + "\t - " + entry.getValue())
                .forEach(user -> System.out.println(user));

        //moduł 7.3
        /*BookDirectory thebookDirectory = new BookDirectory();
        String theResultStringOfBooks = thebookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(book -> book.toString())
                .collect(Collectors.joining(",\n","<<",">>"));
        System.out.println(theResultStringOfBooks);*/
       /* Map<String, Book> theResultMapOfBooks = thebookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(book -> book.getSignature(),book -> book));
        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> "Sign: " + entry.getKey() + ": " + entry.getValue())
                .forEach(bookEntry -> System.out.println(bookEntry));*/

        /*People.getList().stream()
                .map(s -> s.toUpperCase())
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0,1).equals("M"))
                .forEach(s -> System.out.println(s));
        People.getList().stream().forEach(System.out::println);*/
        //zadanie 7.1
        /*PoemBeautifier poemBeautifier = new PoemBeautifier();
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
        System.out.println(poemBeautifier.beautify(".kapsw ynasipan tskeT", FunctionalCalculator::reverseString));*/
        /*System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);*/
        //moduł 7.1
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