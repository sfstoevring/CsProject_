package sample;

public class Bubble {
    private String name;
    private String bubbleType;
    private int size;
    private int x;
    private int y;
    private String color;
    private int ID;
    private Method methodType;

    public Bubble(String name, int ID, String bubbleType) {
        this.name = name;
        this.ID = ID;
        this.bubbleType = bubbleType;
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
