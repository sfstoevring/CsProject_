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


}
