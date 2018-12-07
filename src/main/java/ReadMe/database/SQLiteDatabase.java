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
 * @author bisi & apndx
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
            //System.out.println("DB open fail");
        }

        try {
            createDatabaseTables();
        } catch (Exception e) {
            //System.out.println("Unable to create table. Maybe it already exists.");
            return;
        }
    }

     /**
     * Databasetables are created if they do not exist already
     *
     * @throws SQLException if this database query does not succeed, this
     * exception is thrown
     */
    public void createDatabaseTables() throws SQLException {
        List<String> createTablesSentences = sqliteTables();

        //  execute command, iterate through the list
        try (Statement stmt = getConnection().createStatement()) {
            //  execute command, iterate through the list
            for (String sentence : createTablesSentences) {
                stmt.executeUpdate(sentence);
            }
        }
        //System.out.println("Tables created successfully");
    }

     /**
     * Creates the SQL database creation sentences
     *
     * @return a list of Strings, each String is a creation sentence for one database table
     */
    private List<String> sqliteTables() {
        ArrayList<String> tablesList = new ArrayList<>();

        tablesList.add("CREATE TABLE IF NOT EXISTS Book ("
                + " book_id integer PRIMARY KEY,"
                + " book_author varchar(200),"
                + " book_title varchar(50),"
                + " book_ISBN integer(100),"
                + " book_description varchar(3000),"
                + " book_year integer(50),"
                + " book_checked boolean,"
                + " book_date_checked date"
                + ");");
        tablesList.add("CREATE TABLE IF NOT EXISTS Video ("
                + " video_id integer PRIMARY KEY,"
                + " video_author varchar(200),"
                + " video_title varchar(50),"
                + " video_link varchar(200),"
                + " video_description varchar(3000),"
                + " video_year integer(50),"
                + " video_checked boolean,"
                + " video_date_checked date"
                + ");");

        tablesList.add("CREATE TABLE IF NOT EXISTS News ("
                + " news_id integer PRIMARY KEY,"
                + " news_author varchar(200),"
                + " news_title varchar(50),"
                + " news_link varchar(200),"
                + " news_description varchar(3000),"
                + " news_publisher varchar(200),"
                + " news_year integer(50),"
                + " news_checked boolean,"
                + " news_date_checked date"
                + ");");

        tablesList.add("CREATE TABLE IF NOT EXISTS Article ("
                + " article_id integer PRIMARY KEY,"
                + " article_author varchar(200),"
                + " article_title varchar(50),"
                + " article_link varchar(200),"
                + " article_description varchar(3000),"
                + " article_publisher varchar(200),"
                + " article_year integer(50),"
                + " article_checked boolean,"
                + " article_date_checked date"
                + ");");

        tablesList.add("CREATE TABLE IF NOT EXISTS Blog ("
                + " blog_id integer PRIMARY KEY,"
                + " blog_author varchar(200),"
                + " blog_title varchar(50),"
                + " blog_link varchar(200),"
                + " blog_description varchar(3000),"
                + " blog_year integer(50),"
                + " blog_checked boolean,"
                + " blog_date_checked date"
                + ");");

        return tablesList;
    }

}
