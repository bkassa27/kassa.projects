//kassa065 carl6090
// written by kassa065 carl6090


import java.awt.*;

public class Triangle {
    double xPos;
    double yPos;
    double width;
    double height;
    Color color;

    public Triangle(double initXPos, double initYPos, double initWidth, double initHeight){
        this.xPos = initXPos;
        this.yPos = initYPos;
        this.width = initWidth;
        this.height = initHeight;
    }

    public double calculatePerimeter(){
        double perimeter = this.width + (this.height * 2);
        return perimeter;
    }


    public double calculateArea(){
        double area = (this.width * this.height) / 2;
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
        return xPos;
    }
    public double getYPos(){
        return yPos;
    }
    public void setHeight(double newHeight){
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
