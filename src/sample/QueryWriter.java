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


}
