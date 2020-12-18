package sample;
import java.util.ArrayList;

public class Request {
    private Method methodType;
    private String firstPartOfRequest;
    private ArrayList<Entry> listBasedOnFirstPartOfReqForAnObject = new ArrayList<>();

    public Request(Method type, String firstPartOfRequest) {
        this.methodType = type;
        this.firstPartOfRequest = firstPartOfRequest;
    }

    public Method getMethodType() {
        return methodType;
    }

    public void setMethodType(Method methodType) {
        this.methodType = this.methodType;
    }

    public String getFirstPartOfRequest() {
        return firstPartOfRequest;
    }

    public void setFirstPartOfRequest(String firstPartOfRequest) {
        this.firstPartOfRequest = firstPartOfRequest;
    }

    public ArrayList<Entry> getListBasedOnFirstPartOfReqForAnObject() {
        return this.listBasedOnFirstPartOfReqForAnObject;
    }

    public Entry getFromListBasedOnFirstPartOfReqForAnObject(int index) {
        return this.listBasedOnFirstPartOfReqForAnObject.get(index);
    }

    public void addToListBasedOnFirstPartOfReqForAnObject(Entry e) {
        this.listBasedOnFirstPartOfReqForAnObject.add(e);
    }
}
