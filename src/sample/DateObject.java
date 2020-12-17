package sample;

import java.util.Date;

public class DateObject {

    private Date date;
    private String dateAsString;
    private AnyList<Entry> listOfEntriesAtDate;
    private int amountOfEntries;
    private int amountOfErrors;

    public DateObject (Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateAsString() {
        return dateAsString;
    }

    public void setDateAsString(String dateAsString) {
        this.dateAsString = dateAsString;
    }

    public AnyList<Entry> getListOfEntriesAtDate() {
        return listOfEntriesAtDate;
    }

    public void setListOfEntriesAtDate(AnyList<Entry> listOfEntriesAtDate) {
        this.listOfEntriesAtDate = listOfEntriesAtDate;
    }

    public int getAmountOfEntries() {
        return amountOfEntries;
    }

    public void setAmountOfEntries(int amountOfEntries) {
        this.amountOfEntries = amountOfEntries;
    }

    public int getAmountOfErrors() {
        return amountOfErrors;
    }

    public void setAmountOfErrors(int amountOfErrors) {
        this.amountOfErrors = amountOfErrors;
    }

    public void addAmountOfEntries(){
        this.amountOfEntries += 1;
    }
    public void addAmountOfErrors(){
        this.amountOfErrors += 1;
    }
}
