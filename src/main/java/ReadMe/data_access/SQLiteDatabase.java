/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.data_access;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author bisi
 */
public class SQLiteDatabase implements Database {
    
    
    private final String databaseAddress;

    public SQLiteDatabase(String databaseAddress) throws ClassNotFoundException {
        this.databaseAddress = databaseAddress;
    }

    /**
     * Opens a connection to the database
     *
     * @throws SQLException if this database query does not succeed, this
     * exception is thrown
     * @return Connection returns a Connection
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }

    /**
     * Initialising procedures for the database. Creates the database and tables
     * for it if they do not exist in the root folder of the program
     *
     */
    public void init() {
        String[] createTablesSencences = createTables();

        // "try with resources" closes the connection in the end
        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();

            //  execute command
            for (String sentence : createTablesSencences) {
                st.executeUpdate(sentence);
            }

        } catch (Throwable t) {
            // if table exists, command not executed
            System.out.println("Error >> " + t.getMessage());
        }
    }
    

//    private String path;
//
//    public SQLiteDatabase(File file) {
//        this.path = file.getAbsolutePath();
//    }
//
//    public SQLiteDatabase() {
//        this.path = "sqlite:memory:";
//    }
//
//    @Override
//    public void init() throws SQLException {
//        //TODO: SQL käskyt taulujen luomiseen
//        try (Connection c = getConnection()) {
//            for (String kasky : createTables()) {
//                c.prepareStatement(kasky).execute();
//            }
//        }
//    }

//    @Override
//    public Connection getConnection() throws SQLException {
//        return DriverManager.getConnection("jdbc:sqlite:" + path);
//    }

    private static String[] createTables() {
        return new String[]{
            "CREATE TABLE IF NOT EXISTS Bookmark ("
            + "	bookmark_id integer PRIMARY KEY,"
            + "	bookmark_title varchar(50),"
            + "	bookmark_description varchar(3000),"
            + "	bookmark_link varchar(200),"
            + ");"
        };
    }

}
