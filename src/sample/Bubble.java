package sample;

public class Bubble {
    private String name;
    private int size;
    private int x;
    private int y;
    private String color;
    private int ID;


    public Bubble(String name, String color, int ID) {
        this.name = name;
        this.color = color;
        this.ID = ID;
    }

    public void populateBubble(Method methodChild, String databaseColumn, AnyList<Entry> anyList){
        for (int i=0 ; i< anyList.getSize(); i++){
            if (anyList.getFromList().get(i).getMethod().equalsIgnoreCase(methodChild.getName())){
                methodChild.addToList(anyList.getFromList().get(i));
                System.out.println("Added "+methodChild.getName()+" object to bubbleList: "+methodChild.getListName()+"");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
