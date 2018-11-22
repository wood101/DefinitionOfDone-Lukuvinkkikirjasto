/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.data_access;

import ReadMe.classes.Bookmark;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bisi
 */
public class BookmarkDatabaseDao implements BookmarkDao {

    private Database db;

    public BookmarkDatabaseDao(Database db) {
        this.db = db;
    }

    @Override
    public List<Bookmark> listAll() {
        try (Connection c = db.getConnection()) {
            List<Bookmark> bookmarks = new ArrayList<>();

            ResultSet rs = c.prepareStatement("SELECT * FROM Bookmark").executeQuery();
            while (rs.next()) {
                bookmarks.add(Bookmark.rowToResepti(rs));
            }

            return bookmarks;
        } catch (SQLException ex) {
            Logger.getLogger(BookmarkDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(Bookmark bm) {
        try (Connection c = db.getConnection()) {
            PreparedStatement add = c.prepareStatement("INSERT INTO Bookmark (bookmark_headline, bookmark_description, bookmark_link) "
                    + "VALUES (?, ?, ?) ON CONFLICT DO NOTHING RETURNING bookmark_id");
            add.setString(1, bm.getHeadline().toLowerCase());
            add.setString(2, bm.getDescription().toLowerCase());
            add.setString(3, bm.getLink().toLowerCase());
            ResultSet rs = add.executeQuery();

            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(BookmarkDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
