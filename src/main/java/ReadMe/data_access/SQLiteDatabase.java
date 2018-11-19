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

/**
 *
 * @author bisi
 */
public class SQLiteDatabase implements Database {

    private String path;

    public SQLiteDatabase(File file) {
        this.path = file.getAbsolutePath();
    }

    public SQLiteDatabase() {
        this.path = "sqlite:memory:";
    }

    @Override
    public void init() throws SQLException {
        //TODO: SQL käskyt taulujen luomiseen
        try (Connection c = getConnection()) {
            for (String kasky : createTables()) {
                c.prepareStatement(kasky).execute();
            }
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + path);
    }

    private static String[] createTables() {
        return new String[]{
            "CREATE TABLE IF NOT EXISTS Bookmark ("
            + "	resepti_id integer PRIMARY KEY,"
            + "	title varchar(50),"
            + "	description varchar(3000),"
            + "	link varchar(200),"
            + ");"
        };
    }

}
