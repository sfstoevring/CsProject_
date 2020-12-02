package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AnyList<T> {
    private String name;
    private ObservableList<T> anyList = null;


    public AnyList(String name){
        this.name = name;
        this.anyList = FXCollections.observableArrayList();
    }

    public void addToList(T o){
        this.anyList.add(o);
    }

    public ObservableList<T> getFromList(){
        return anyList;
    }

}
