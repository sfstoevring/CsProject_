package sample;

public class Error {

    private String errorMsg;
    private int ID;
    public Error(String errorMsg, int ID) {
        this.errorMsg = errorMsg;
        this.ID = ID;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Error{" +
                "errorMsg='" + errorMsg + '\'' +
                ", ID=" + ID +
                '}';
    }
}
