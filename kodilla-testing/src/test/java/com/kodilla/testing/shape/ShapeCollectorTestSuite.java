package com.kodilla.testing.shape;
import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;
    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests");
    }
    @AfterClass
    public static void afterAllTests(){
        System.out.println("All tests are finished");
    }
    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Test
    public void testAddFigure(){
        //Given
        ShapeCollector shapeCollection = new ShapeCollector();
        //When
        shapeCollection.addFigure(new Circle(2));
        shapeCollection.addFigure(new Triangle(3,3));
        shapeCollection.addFigure(new Square(5));
        //Then
        shapeCollection.showFigures();
        Assert.assertEquals(3, shapeCollection.getFiguresCollectionSize());
    }
    @Test
    public void testRemoveNotExistingFigure(){
        //Given
        ShapeCollector shapeCollection = new ShapeCollector();
        Shape shape = new Circle(2);
        //When
        boolean result = shapeCollection.removeFigure(shape);
        //Then
        Assert.assertFalse(result);
    }
    @Test
    public void testRemoveExistingFigure(){
        //Given
        ShapeCollector shapeCollection = new ShapeCollector();
        Shape shape = new Circle(2);
        shapeCollection.addFigure(shape);
        //When
        boolean result = shapeCollection.removeFigure(shape);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0,shapeCollection.getFiguresCollectionSize());
    }
    @Test
    public void testGetFigure(){
        //Given
        ShapeCollector shapeCollection = new ShapeCollector();
        Shape shape = new Circle(2);
        shapeCollection.addFigure(shape);
        //When
        Shape retrievedFigure = shapeCollection.getFigure(0);
        //Then
        System.out.println(retrievedFigure.getShapeName() + " : " + retrievedFigure.getField());
        Assert.assertEquals(shape,retrievedFigure);
    }
}
