/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.database;

import ReadMe.database.Database;
import ReadMe.domain.Bookmark;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ReadMe.dao.DaoManager;

/**
 * Data access object for Bookmark database
 * @author bisi
 */
public class BookmarkDatabaseDao implements DaoManager {

    private Database db;

    /**
     * Creates new BookMark DAO for database
     * @param database
     */
    public BookmarkDatabaseDao(Database db) {
        this.db = db;
    }

    /**
     * Lists all Bookmark objects. Connects to database, retrieves all lines from Bookmark table, and returns a list of Bookmark objects.
     * Returns null in case of SQL exception.
     * @return
     */
    @Override
    public List<Bookmark> listAll() {
        try (Connection c = db.getConnection()) {
            List<Bookmark> bookmarks = new ArrayList<>();

            ResultSet rs = c.prepareStatement("SELECT * FROM Bookmark").executeQuery();
            while (rs.next()) {
                bookmarks.add(Bookmark.rowToBookmark(rs));
            }

            return bookmarks;
        } catch (SQLException ex) {
            Logger.getLogger(BookmarkDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Adds a new Bookmark to database. Connects to database, adds a new Bookmark to the database. In case of database conflict does nothing.
     * In case of SQL exception returns null.
     * @param bm
     */
    @Override
    public void add(Bookmark bm) {
        try (Connection c = db.getConnection()) {
            PreparedStatement add = c.prepareStatement("INSERT INTO Bookmark (bookmark_title, bookmark_description, bookmark_link) "
                    + "VALUES (?, ?, ?)");
            add.setString(1, bm.getTitle());
            add.setString(2, bm.getDescription());
            add.setString(3, bm.getLink());
            add.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookmarkDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
