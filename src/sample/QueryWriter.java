package sample;

import java.sql.*;


public class QueryWriter {
    Connection conn = null;
    Statement stmt;

    public void Connect(String url) throws SQLException {
        conn = DriverManager.getConnection(url);
    }

    public void createStatement() throws SQLException {
        stmt = conn.createStatement();
    }

    public ResultSet initResultSetToObjects(String url, String sql) throws SQLException {
    Connect(url);
    ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM '"+sql+"'");
    return rs;
    }

    public ResultSet listOfMethods(String url) throws SQLException {
        Connect(url);
        ResultSet rsMethods = conn.createStatement().executeQuery("SELECT METHOD FROM DATA GROUP BY METHOD");
        return rsMethods;
    }

    public ResultSet resultSetForHomeTabTableView(String url) throws SQLException{
        Connect(url);
        ResultSet rsHomeTabTableView = conn.createStatement().executeQuery("SELECT DATA.TIME, DATA.IP, DATA.PORT, DATA.METHOD, DATA.REQUEST, RESPONSE.RESPONSE_NAME AS RESPONSE FROM DATA LEFT JOIN RESPONSE ON RESPONSE.ID = DATA.RESPONSE");
        return rsHomeTabTableView;
    }

    public ResultSet resultSetForMethodTabTableView(String url) throws SQLException{
        Connect(url);
        ResultSet rsMethodTabTableView = conn.createStatement().executeQuery("SELECT DATA.TIME, DATA.IP, DATA.PORT, DATA.METHOD, DATA.REQUEST, RESPONSE.RESPONSE_NAME AS RESPONSE, DATA.FROM_CLIENT AS CLIENT FROM DATA LEFT JOIN RESPONSE ON RESPONSE.ID = DATA.RESPONSE");
        return rsMethodTabTableView;
    }
    public ResultSet resultSetForGlobalTabTableView(String url) throws SQLException{
        Connect(url);
        ResultSet rsGlobalTabTableView = conn.createStatement().executeQuery("SELECT * FROM DATA");
        return rsGlobalTabTableView;
    }
}
