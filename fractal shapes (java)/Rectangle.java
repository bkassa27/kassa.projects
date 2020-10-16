//package com.CSCI1933;
// kassa065 carl6090
// written by kassa065 carl6090


import java.awt.*;

public class Rectangle {
    double xPos;
    double yPos;
    double width;
    double height;
    Color color;
    public Rectangle(double xPos, double yPos, double height, double width){
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }
    public double calculatePerimeter(){
        double perimeter = (this.width * 2) + (this.height);
        return perimeter;
    }
    public double calculateArea(){
        double area = this.width * this.height;
        return area;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return this.color;
    }
    public void setPos(double newXPos, double newYPos){
        this.xPos = newXPos;
        this.yPos = newYPos;
    }
    public double getXPos(){
        return this.xPos;
    }
    public double getYPos(){
        return this.yPos;
    }
    public void setHeight(double newHeight) {
        this.height = newHeight;
    }
    public double getHeight(){
        return this.height;
    }
    public void setWidth(double newWidth){
        this.width = newWidth;
    }
    public double getWidth(){
        return this.width;
    }

}
