package sample;

import javafx.beans.property.ObjectProperty;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

public class Bubble {
    private String name;
    private String bubbleType;
    private int size;
    private int x;
    private int y;
    private String color;
    private int ID;
    private Method methodType;
    private boolean overlapping;

    public Bubble(String name, int size, int ID, Method methodType) {
        this.name = name;
        this.size = size;
        this.ID = ID;
        this.methodType = methodType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBubbleType() {
        return bubbleType;
    }

    public void setBubbleType(String bubbleType) {
        this.bubbleType = bubbleType;
    }

    public Method getMethodType() {
        return methodType;
    }

    public void setMethodType(Method methodType){
        this.methodType = methodType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isOverlapping() {
        return overlapping;
    }

    public void setOverlapping(boolean overlapping) {
        this.overlapping = overlapping;
    }

    public void drawBubble(Canvas canvas){
        GraphicsContext bubbleOnCanvas = canvas.getGraphicsContext2D();
        bubbleOnCanvas.setFill(Color.rgb(250,0,0,0.8));
        bubbleOnCanvas.fillOval(this.x, this.y, this.size, this.size);
        bubbleOnCanvas.setStroke(Color.BLACK);
        bubbleOnCanvas.strokeOval(this.x, this.y, this.size, this.size);
    }

    public void drawBubble(Canvas canvas, int x, int y){
        this.setX(x);
        this.setY(y);
        GraphicsContext bubbleOnCanvas = canvas.getGraphicsContext2D();
        bubbleOnCanvas.setFill(Color.rgb(250,0,0,0.8));
        bubbleOnCanvas.fillOval(this.x, this.y, this.size, this.size);
        bubbleOnCanvas.setStroke(Color.BLACK);
        bubbleOnCanvas.strokeOval(this.x, this.y, this.size, this.size);

//        if (10<=size && size<=150) {
//            bubbleOnCanvas.fillOval(x, y, size, size);
//        } else if (size>500) {
//            size = 200;
//            bubbleOnCanvas.fillOval(x, y, size, size);
//        }
    }

    public boolean pointInsideShape(Point2D point) {
        double distance = Math.sqrt( Math.pow((this.getX() - point.getX()), 2) + Math.pow((this.getY() - point.getY()), 2));
        if(distance <= this.size){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Bubble{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", x=" + x +
                ", y=" + y +
                ", color='" + color + '\'' +
                '}';
    }
}
