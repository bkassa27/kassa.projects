//package com.CSCI1933;
//kasssa065 carl6090
// written by kassa065 carl6090

// FractalDrawer class draws a fractal of a shape indicated by user input

import java.awt.Color;
import java.util.Scanner;

public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total area

    public FractalDrawer() {}  // contructor


    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
        Canvas myCanvas = new Canvas();
        if(type.equals("Circle")){
            drawCircleFractal(300,400,400,Color.BLUE,myCanvas,7);
            return totalArea;
        }
        if(type.equals("Triangle")){
            System.out.println("Making a triangle");
            drawTriangleFractal(400,400,200,600, Color.BLUE, myCanvas,7);
            return totalArea;
        }
        if(type.equals("Rectangle")){
            drawRectangleFractal(200,300,200,200,Color.BLUE,myCanvas,7);
            return totalArea;
        }
        System.out.println("Invalid option. Exiting program...");
        return 0;

    }


    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        Color[] colors = {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW, Color.ORANGE};
            if(level > 0) {
            Triangle triObj = new Triangle(x, y, width, height);
            totalArea += triObj.calculateArea();
            triObj.setColor(colors[level - 1]);
            can.drawShape(triObj);
            drawTriangleFractal(width/2,height/2,(x+(width/2)),y,colors[level-1],can,level-1);
            drawTriangleFractal(width/2,height/2,(x+(width/4)),(y-(height/2)),colors[level-1],can,level-1);
            drawTriangleFractal(width/2, height/2, x, y, colors[level - 1], can, level - 1);

            }
    }


    // TODO:
    //  drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        Color[] colors = {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW, Color.ORANGE};
        if(level > 0) {
            Circle circObj = new Circle(x, y, radius);
            totalArea += circObj.calculateArea();
            circObj.setColor(colors[level - 1]);
            can.drawShape(circObj);
            drawCircleFractal(radius / 2, x + (radius / 2), y, colors[level - 1], can, level - 1);
            drawCircleFractal(radius / 2, x - (radius / 2), y, colors[level - 1], can, level - 1);
            //drawCircleFractal(radius / 3, x, y+(radius/(3.14/2)), colors[level - 1], can, level - 1);
            //drawCircleFractal(radius / 3, x, y-(radius/(3.14/2)), colors[level - 1], can, level - 1);

        }

    }


    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        Color[] colors = {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW, Color.ORANGE};
        if(level > 0) {
            Rectangle rectObj = new Rectangle(x, y, height, width);
            totalArea += rectObj.calculateArea();
            rectObj.setColor(colors[level - 1]);
            can.drawShape(rectObj);
            drawRectangleFractal(width / 2, height / 2, x, y, colors[level - 1], can, level - 1);
            drawRectangleFractal(width / 2, height / 2, x+(width/2), y+(height/2), colors[level - 1], can, level - 1);

        }
    }

    //TODO:
    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args){
        FractalDrawer newObj = new FractalDrawer();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter one of 3 options: Circle, Rectangle, or Triangle: ");
        String choice = myScanner.nextLine();
        System.out.println(newObj.drawFractal(choice));

    }
}
