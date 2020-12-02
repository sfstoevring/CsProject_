package sample;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Entries {

    private InetAddress iIp;
    private String sIp;
    private String sDate;
    private Date dDate;
    private String method;
    private int response;
    private int responseLength;
    private String fromPage;
    private String client;
    private int port;

    public Entries(String ip, String date, String method, int response, int responseLength, String fromPage, String client, int port) throws ParseException, UnknownHostException {
        this.iIp = formatIp(ip);
        this.sDate = date;
        this.dDate = formatDate(date);
        this.method = method;
        this.response = response;
        this.responseLength = responseLength;
        this.fromPage = fromPage;
        this.client = client;
        this.port = port;
    }

    public InetAddress getiIp() {
        return iIp;
    }

    public void setiIp(InetAddress iIp) {
        this.iIp = iIp;
    }

    public InetAddress formatIp(String ip) throws UnknownHostException {
        InetAddress tempIp = InetAddress.getByName(ip);
        return tempIp;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public Date getdDate() {
        return dDate;
    }

    public void setdDate(Date dDate) {
        this.dDate = dDate;
    }

    public Date formatDate(String sDate) throws ParseException {
       SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss");
        Date test = formatter.parse(sDate);

        return test;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public int getResponseLength() {
        return responseLength;
    }

    public void setResponseLength(int responseLength) {
        this.responseLength = responseLength;
    }

    public String getFromPage() {
        return fromPage;
    }

    public void setFromPage(String fromPage) {
        this.fromPage = fromPage;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Entries{" +
                "ip=" + iIp +
                ", date='" + sDate + '\'' +
                ", method='" + method + '\'' +
                ", response=" + response +
                ", responseLength=" + responseLength +
                ", fromPage='" + fromPage + '\'' +
                ", client='" + client + '\'' +
                ", port=" + port +
                '}';
    }
}
