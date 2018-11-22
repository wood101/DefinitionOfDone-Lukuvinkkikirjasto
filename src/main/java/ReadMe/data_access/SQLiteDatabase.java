/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author bisi
 */
public class SQLiteDatabase implements Database {
    
    
    private String databaseAddress;
    

    public SQLiteDatabase(String databaseAddress) throws ClassNotFoundException {
        this.databaseAddress = databaseAddress;
        init();
    }

    /**
     * Opens a connection to the database
     *
     * @throws SQLException if this database query does not succeed, this
     * exception is thrown
     * @return Connection returns a Connection
     */
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }

    /**
     * Initialising procedures for the database. Creates the database and tables
     * for it if they do not exist in the root folder of the program
     *
     */
    @Override
    public void init() {
        try {
            Class.forName("org.sqlite.JDBC");
            getConnection();
            System.out.println("Database open - success");
        } catch (Exception e) {
            System.out.println("DB open fail");
        }
        
        try {
            createDatabaseTables();
        } catch (Exception e) {
            System.out.println("Unable to create table. Maybe it already exists.");
            return;
        }
    }

   public void createDatabaseTables() throws SQLException {
        Statement stmt = getConnection().createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS Bookmark ("
            + "bookmark_id integer PRIMARY KEY,"
            + "bookmark_title varchar(50),"
            + "bookmark_description varchar(3000),"
            + "bookmark_link varchar(200)"
            + ")";
        stmt.executeUpdate(sql);
        stmt.close();
        System.out.println("Table created successfully");
    }
    
//    private static String[] createTables() {
//        return new String[]{
//            "CREATE TABLE IF NOT EXISTS Bookmark ("
//            + "	bookmark_id integer PRIMARY KEY,"
//            + "	bookmark_title varchar(50),"
//            + "	bookmark_description varchar(3000),"
//            + "	bookmark_link varchar(200),"
//            + ");"
//        };
//    }

}
