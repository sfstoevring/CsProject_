package sample;
// All files in sample folder are written by Anders Heide, Jesper Petersen, Magnus Stilling and Simon Støvring

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableViewObjects {

    private IntegerProperty ID;
    private StringProperty TIME;
    private StringProperty IP;
    private IntegerProperty PORT;
    private StringProperty METHOD;
    private StringProperty REQUEST;
    private IntegerProperty RESPONSE;
    private StringProperty sRESPONSE;
    private IntegerProperty RESPONSE_LEN;
    private StringProperty FROM_SYS;
    private StringProperty FROM_CLIENT;
    private StringProperty CLIENT;

    public TableViewObjects() {
        this.ID = new SimpleIntegerProperty();
        this.TIME = new SimpleStringProperty();
        this.IP = new SimpleStringProperty();
        this.PORT = new SimpleIntegerProperty();
        this.METHOD = new SimpleStringProperty();
        this.REQUEST = new SimpleStringProperty();
        this.RESPONSE = new SimpleIntegerProperty();
        this.sRESPONSE = new SimpleStringProperty();
        this.RESPONSE_LEN = new SimpleIntegerProperty();
        this.FROM_CLIENT = new SimpleStringProperty();
        this.FROM_SYS = new SimpleStringProperty();
        this.CLIENT = new SimpleStringProperty();
    }

    public int getID() {
        return ID.get();
    }

    public IntegerProperty IDProperty() {
        return ID;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public String getTIME() {
        return TIME.get();
    }

    public StringProperty TIMEProperty() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME.set(TIME);
    }

    public String getIP() {
        return IP.get();
    }

    public StringProperty IPProperty() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP.set(IP);
    }

    public int getPORT() {
        return PORT.get();
    }

    public IntegerProperty PORTProperty() {
        return PORT;
    }

    public void setPORT(int PORT) {
        this.PORT.set(PORT);
    }

    public String getMETHOD() {
        return METHOD.get();
    }

    public StringProperty METHODProperty() {
        return METHOD;
    }

    public void setMETHOD(String METHOD) {
        this.METHOD.set(METHOD);
    }

    public String getREQUEST() {
        return REQUEST.get();
    }

    public StringProperty REQUESTProperty() {
        return REQUEST;
    }

    public void setREQUEST(String REQUEST) {
        this.REQUEST.set(REQUEST);
    }

    public int getRESPONSE() {
        return RESPONSE.get();
    }

    public IntegerProperty RESPONSEProperty() {
        return RESPONSE;
    }

    public void setRESPONSE(int RESPONSE) {
        this.RESPONSE.set(RESPONSE);
    }

    public int getRESPONSE_LEN() {
        return RESPONSE_LEN.get();
    }

    public IntegerProperty RESPONSE_LENProperty() {
        return RESPONSE_LEN;
    }

    public void setRESPONSE_LEN(int RESPONSE_LEN) {
        this.RESPONSE_LEN.set(RESPONSE_LEN);
    }

    public String getsRESPONSE() {
        return sRESPONSE.get();
    }

    public StringProperty sRESPONSEProperty() {
        return sRESPONSE;
    }

    public void setsRESPONSE(String sRESPONSE) {
        this.sRESPONSE.set(sRESPONSE);
    }

    public String getCLIENT() {
        return CLIENT.get();
    }

    public StringProperty CLIENTProperty() {
        return CLIENT;
    }

    public void setCLIENT(String CLIENT) {
        this.CLIENT.set(CLIENT);
    }

    public String getFROM_SYS() {
        return FROM_SYS.get();
    }

    public StringProperty FROM_SYSProperty() {
        return FROM_SYS;
    }

    public void setFROM_SYS(String FROM_SYS) {
        this.FROM_SYS.set(FROM_SYS);
    }

    public String getFROM_CLIENT() {
        return FROM_CLIENT.get();
    }

    public StringProperty FROM_CLIENTProperty() {
        return FROM_CLIENT;
    }

    public void setFROM_CLIENT(String FROM_CLIENT) {
        this.FROM_CLIENT.set(FROM_CLIENT);
    }
}

