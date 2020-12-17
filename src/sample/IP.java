package sample;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IP {
    private String IpAsString;
    private final InetAddress IpAsInetAddress;
    private AnyList<Entry> listOfEntriesAsIp;
    private int hitsFromThisIp;

    public IP(String ipAsString) throws UnknownHostException {
        this.IpAsString = ipAsString;
        this.IpAsInetAddress = setIpAsInetAddress(this.IpAsString);
        this.listOfEntriesAsIp = new AnyList<>("listOfEntriesAsIp@_" + this.IpAsString);
    }

    public String getIpAsString() {
        return IpAsString;
    }

    public void setIpAsString(String ipAsString) {
        IpAsString = ipAsString;
    }

    public InetAddress getIpAsInetAddress() {
        return IpAsInetAddress;
    }

    public InetAddress setIpAsInetAddress(String ipAsString) throws UnknownHostException {
        InetAddress tempIP = InetAddress.getByName(ipAsString);
        return tempIP;
    }

    public AnyList<Entry> getListOfEntriesAsIp() {
        return listOfEntriesAsIp;
    }

    public void setListOfEntriesAsIp(AnyList<Entry> listOfEntriesAsIp) {
        this.listOfEntriesAsIp = listOfEntriesAsIp;
    }

    public int getHitsFromThisIp() {
        return hitsFromThisIp;
    }

    public void addHitToThisIp(int addHitToThisIp) {
        this.hitsFromThisIp += hitsFromThisIp;
    }
    public void overwriteHitsFromThisIp(int newValue){
        this.hitsFromThisIp = newValue;
    }
}
