package com.kodilla.testing.shape;
import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<Shape> figuresCollection = new ArrayList<>();
    public int getFiguresCollectionSize(){
        return figuresCollection.size();
    }
    public void addFigure(Shape shape){
        figuresCollection.add(shape);
    }
    public boolean removeFigure(Shape shape){
        boolean result = false;
        if (figuresCollection.contains(shape)){
            figuresCollection.remove(shape);
            result = true;
        }
        return result;
    }
    public Shape getFigure(int n){
        return figuresCollection.get(n);
    }
    public void showFigures(){
        for (Shape shape : figuresCollection) {
            System.out.println(shape.getShapeName() + " with surface area equals: " + shape.getField());
        }
    }
}
