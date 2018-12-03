/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;

import ReadMe.database.Database;
import ReadMe.domain.News;
import ReadMe.domain.ReadingTip;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Interface for News database access object. 
 * @author madjanne
 */
public class NewsDao {
    private final Database db;

    /**
     * Creates new News DAO for database
     * @param db
     */
    public NewsDao(Database db) {
        this.db = db;
    }

    /**
     * Lists all News objects. Connects to database, retrieves all lines from the News table, and returns a list of News objects.
     * Returns null in case of SQL exception.
     * @return
     */
    
    public List<ReadingTip> listAll() {
        try (Connection c = db.getConnection()) {
            List<ReadingTip> newss = new ArrayList<>();

            ResultSet rs = c.prepareStatement("SELECT * FROM News").executeQuery();
            while (rs.next()) {
                newss.add(rowToNews(rs));
            }

            return newss;
        } catch (SQLException ex) {
            Logger.getLogger(NewsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Adds a new News to database. Connects to database, adds a new News to the database. In case of database conflict does nothing.
     * In case of SQL exception returns null.
     * @param news
     */
    public void add(News news) {
        try (Connection c = db.getConnection()) {
            PreparedStatement add = c.prepareStatement("INSERT INTO News (news_author, news_title, news_link, news_description, news_publisher, news_year, news_checked, news_date_checked) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            add.setString(1, news.getAuthor());
            add.setString(2, news.getTitle());
            add.setString(3, news.getLink());
            add.setString(4, news.getDescription());
            add.setString(5, news.getPublisher());
            add.setInt(6, news.getYear());
            add.setBoolean(7, false);
            add.setDate(8, null);
            add.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NewsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Marks the news as read and sets the date it was read on.
     * @param news Object that is marked read
     */
    public void markNewsAsRead(News news) {
        news.setChecked(true);
        news.setDate_checked(new Date());
    }    
    
     /**
     * Creates a new News object from database row
     * @param rs
     * @return
     * @throws SQLException
     */
    public static News rowToNews(ResultSet rs) throws SQLException {
        return new News(rs.getInt("news_id"), rs.getString("news_author"), rs.getString("news_title"), rs.getString("news_link"), rs.getString("news_description"), rs.getString("news_publisher"), rs.getInt("news_year"), rs.getBoolean("news_checked"), rs.getDate("news_date_checked"));
    }
}
