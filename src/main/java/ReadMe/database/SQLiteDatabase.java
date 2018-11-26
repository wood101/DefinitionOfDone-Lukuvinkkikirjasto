/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
        List<String> createTablesSentences = sqliteTables();

        //  execute command, iterate through the list
        try (Statement stmt = getConnection().createStatement()) {
            //  execute command, iterate through the list
            for (String sentence : createTablesSentences) {
                stmt.executeUpdate(sentence);
            }
        }
        System.out.println("Tables created successfully");
    }

    private List<String> sqliteTables() {
        ArrayList<String> tablesList = new ArrayList<>();

        tablesList.add("CREATE TABLE IF NOT EXISTS Book (\n"
                + " book_id integer PRIMARY KEY,\"\n"
                + " book_author varchar(200),\"\n"
                + " book_title varchar(50),\"\n"
                + " book_ISBN integer(100),\"\n"
                + " book_description varchar(3000),\"\n"
                + " book_year integer(50),\"\n"
                + " book_checked boolean\"\n"
                + " book_date_checked date\"\n"
                + ");");
        tablesList.add("CREATE TABLE IF NOT EXISTS Video (\n"
                + "video_id integer PRIMARY KEY,\"\n"
                + "video_author varchar(200),\"\n"
                + "video_title varchar(50),\"\n"
                + "video_link varchar(200),\"\n"
                + "video_description varchar(3000),\"\n"
                + "video_year integer(50),\"\n"
                + "video_checked boolean,\"\n"
                + "video_date_checked date\"\n"
                + ");");
        tablesList.add("CREATE TABLE IF NOT EXISTS News (\n"
                + "news_id integer PRIMARY KEY,\"\n"
                + "news_author varchar(200),\"\n"
                + "news_title varchar(50),\"\n"
                + "news_link varchar(200),\"\n"
                + "video_description varchar(3000),\"\n"
                + "news_bublisher varchar(200),\"\n"
                + "news_year integer(50),\"\n"
                + "video_checked boolean,\"\n"
                + "video_date_checked date\"\n"
                + ");");

        return tablesList;
    }

}
