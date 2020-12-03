package sample;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Entry {

    private InetAddress inetIP;
    private Date dDate;
    private String method;
    private int response;
    private int responseLength;
    private String fromPage;
    private String client;
    private int port;

    public Entry(String IP, String date, String method, int response, int responseLength, String fromPage, String client, int port) throws ParseException, UnknownHostException {
        this.inetIP = formatIP(IP);
        this.dDate = formatDate(date);
        this.method = method;
        this.response = response;
        this.responseLength = responseLength;
        this.fromPage = fromPage;
        this.client = client;
        this.port = port;
    }

    public InetAddress getInetIP() {
        return inetIP;
    }

    public void setInetIP(InetAddress inetIP) {
        this.inetIP = inetIP;
    }

    public InetAddress formatIP(String ip) throws UnknownHostException {
        InetAddress tempIP = InetAddress.getByName(ip);
        return tempIP;
    }

    public Date getdDate() {
        return dDate;
    }

    public void setdDate(Date dDate) {
        this.dDate = dDate;
    }

    public Date formatDate(String date) throws ParseException {
       SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss");
       Date tempDate = formatter.parse(date);
       return tempDate;
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
                "ip=" + inetIP +
                ", method='" + method + '\'' +
                ", response=" + response +
                ", responseLength=" + responseLength +
                ", fromPage='" + fromPage + '\'' +
                ", client='" + client + '\'' +
                ", port=" + port +
                '}';
    }
}