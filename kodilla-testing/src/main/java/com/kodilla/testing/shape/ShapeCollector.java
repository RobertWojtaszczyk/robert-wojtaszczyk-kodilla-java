package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<Shape> figuresCollection = new ArrayList<>();
    public int getFiguresCollectionSize(){
        //return figuresCollection.size();
        return 100;
    }
    public void addFigure(Shape shape){
        //figuresCollection.add(shape);
    }
    public boolean removeFigure(Shape shape){
        return true;
    }
    public Shape getFigure(int n){
        return null;
    }
    public void showFigures(){
        //
    }
}
