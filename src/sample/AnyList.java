package sample;
// All files in sample folder are written by Anders Heide, Jesper Petersen, Magnus Stilling and Simon Støvring

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AnyList<T> {
    private String name;
    private ObservableList<T> anyList = null;


    public AnyList(String name) {
        this.name = name;
        this.anyList = FXCollections.observableArrayList();
    }

    public void addToList(T o) {
        this.anyList.add(o);
    }

    public void removeFromList(T o) {
        this.anyList.remove(o);
    }

    public ObservableList<T> getList() {
        return anyList;
    }

    public void setList(ObservableList<T> anyList) {
        this.anyList = anyList;
    }

    public int getSize() {
        return this.anyList.size();
    }

    public String getName() {
        return this.name;
    }

    public void clearList() {
        this.anyList.clear();
    }
}
