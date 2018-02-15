package com.kodilla.stream.lambda;

public class ExpressionExecutor {
    public String executeExpression(double a, double b, MathExpression mathExpression){
        return "Result equals: " + mathExpression.calculateExpression(a, b);
    }
}
