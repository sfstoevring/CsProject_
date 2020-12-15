package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bubble {
    private String name;
    private String bubbleType;
    private int size;
    private double x;
    private double y;
    private String color;
    private int ID;
    private Method methodType;


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

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void drawBubble(Canvas canvas, double x, double y){
        this.setX(x);
        this.setY(y);
        GraphicsContext bubble = canvas.getGraphicsContext2D();
        bubble.setFill(Color.RED);
        if (10<=size && size<=150) {
            bubble.fillOval(x, y, size, size);
        } else if (size>500) {
            size = 200;
            bubble.fillOval(x, y, size, size);
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
