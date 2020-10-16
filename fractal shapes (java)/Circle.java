//kassa065 carl6090
// written by kassa065 carl6090

import java.awt.*;

public class Circle {
    double xPos;
    double yPos;
    double radius;
    Color color;

    public Circle(double initXPos, double initYPos,double initRadius){
        this.xPos = initXPos;
        this.yPos = initYPos;
        this.radius = initRadius;
    }

    public double calculatePerimeter() {
        double perimeter = this.radius * 2 * 3.14;
        return perimeter;

    }

    public double calculateArea(){
        double area = (this.radius * this.radius) * 3.14;
        return area;

    }

    public void setColor(Color newColor){
        this.color = newColor;

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

    public void setRadius(double newRadius){
        this.radius = newRadius;
    }

    public double getRadius(){
        return this.radius;
    }

}