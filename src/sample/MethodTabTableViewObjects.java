//package sample;
//
//import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//
//public class MethodTabTableViewObjects {
//    private StringProperty TIME;
//    private StringProperty IP;
//    private IntegerProperty PORT;
//    private StringProperty METHOD;
//    private StringProperty REQUEST;
//    private StringProperty RESPONSE;
//    private StringProperty CLIENT;
//
//    public MethodTabTableViewObjects() {
//        this.TIME = new SimpleStringProperty();
//        this.IP = new SimpleStringProperty();
//        this.PORT = new SimpleIntegerProperty();
//        this.METHOD = new SimpleStringProperty();
//        this.REQUEST = new SimpleStringProperty();
//        this.RESPONSE = new SimpleStringProperty();
//        this.CLIENT = new SimpleStringProperty();
//    }
//
//    public String getTIME() {
//        return TIME.get();
//    }
//
//    public StringProperty TIMEProperty() {
//        return TIME;
//    }
//
//    public void setTIME(String TIME) {
//        this.TIME.set(TIME);
//    }
//
//    public String getIP() {
//        return IP.get();
//    }
//
//    public StringProperty IPProperty() {
//        return IP;
//    }
//
//    public void setIP(String IP) {
//        this.IP.set(IP);
//    }
//
//    public int getPORT() {
//        return PORT.get();
//    }
//
//    public IntegerProperty PORTProperty() {
//        return PORT;
//    }
//
//    public void setPORT(int PORT) {
//        this.PORT.set(PORT);
//    }
//
//    public String getMETHOD() {
//        return METHOD.get();
//    }
//
//    public StringProperty METHODProperty() {
//        return METHOD;
//    }
//
//    public void setMETHOD(String METHOD) {
//        this.METHOD.set(METHOD);
//    }
//
//    public String getREQUEST() {
//        return REQUEST.get();
//    }
//
//    public StringProperty REQUESTProperty() {
//        return REQUEST;
//    }
//
//    public void setREQUEST(String REQUEST) {
//        this.REQUEST.set(REQUEST);
//    }
//
//    public String getRESPONSE() {
//        return RESPONSE.get();
//    }
//
//    public StringProperty RESPONSEProperty() {
//        return RESPONSE;
//    }
//
//    public void setRESPONSE(String RESPONSE) {
//        this.RESPONSE.set(RESPONSE);
//    }
//
//    public String getCLIENT() {
//        return CLIENT.get();
//    }
//
//    public StringProperty CLIENTProperty() {
//        return CLIENT;
//    }
//
//    public void setCLIENT(String CLIENT) {
//        this.CLIENT.set(CLIENT);
//    }
//}
