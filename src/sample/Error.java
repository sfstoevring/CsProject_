package sample;

import javafx.beans.property.SimpleStringProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Error {

    private String errorMsg;
    private int ID;
    private String sDate;
    private Date dDate;

    public Error(){
    }

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

    public void setsDate(String date) throws ParseException {
        this.sDate = date;
        formatDate(date);
    }

    public String getsDate() {
        return sDate;
    }

    public Date getdDate() {
        return dDate;
    }

    public void setdDate(Date dDate) {
        this.dDate = dDate;
    }

    public void formatDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
        Date tempDate = formatter.parse(date);
        setdDate(tempDate);
    }
}
