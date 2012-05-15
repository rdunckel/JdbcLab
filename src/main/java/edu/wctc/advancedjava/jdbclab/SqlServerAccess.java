package edu.wctc.advancedjava.jdbclab;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ryan Dunckel <rdunckel@my.wctc.edu>
 */
public class SqlServerAccess {

    private String url;
    private String user;
    private String password;
    private Connection conn;

    public SqlServerAccess(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.password = pass;
    }

    private void testSql(String sql) {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SqlServerAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(SqlServerAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println(rs);

    }

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://bitsql.wctc.edu:1433;databaseName=JGL-EMPLOYEE";
        String user = "advjava";
        String password = "advjava";

        SqlServerAccess db = new SqlServerAccess(url, user, password);

        String sql = "SELECT * FROM EMPLOYEE";

        db.testSql(sql);

        //databaseName=JGL-EMPLOYEE


    }
}
