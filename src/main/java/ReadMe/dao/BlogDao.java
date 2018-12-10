/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;

import ReadMe.database.Database;
import ReadMe.domain.Blog;
import ReadMe.domain.ReadingTip;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Interface for Blog database access object. 
 * @author madjanne
 */
public class BlogDao {
    private final Database db;

    /**
     * Creates new Blog DAO for database
     * @param db
     */
    public BlogDao(Database db) {
        this.db = db;
    }

    /**
     * Lists all Blog objects. Connects to database, retrieves all lines from the Blog table, and returns a list of Blog objects.
     * Returns null in case of SQL exception.
     * @return
     */
    
    public List<ReadingTip> listAll() {
        try (Connection c = db.getConnection()) {
            List<ReadingTip> blogs = new ArrayList<>();

            ResultSet rs = c.prepareStatement("SELECT * FROM Blog").executeQuery();
            while (rs.next()) {
                blogs.add(rowToBlog(rs));
            }

            return blogs;
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Adds a new Blog to database. Connects to database, adds a new Blog to the database. In case of database conflict does nothing.
     * In case of SQL exception returns null.
     * @param blog
     */
    public void add(Blog blog) {
        try (Connection c = db.getConnection()) {
            PreparedStatement add = c.prepareStatement("INSERT INTO Blog (blog_author, blog_title, blog_link, blog_description, blog_year, blog_checked, blog_date_checked) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            add.setString(1, blog.getAuthor());
            add.setString(2, blog.getTitle());
            add.setString(3, blog.getLink());
            add.setString(4, blog.getDescription());
            add.setInt(5, blog.getYear());
            add.setBoolean(6, false);
            add.setDate(7, null);
            add.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Marks the Blog as read and sets the date it was read on.
     * @param blog Object that is marked read
     */
    public boolean markAsRead(String title) {
        try (Connection c = db.getConnection()) {
            PreparedStatement stmt = c.prepareStatement(
                    "UPDATE Blog SET blog_checked = ?, blog_date_checked = ? WHERE blog_title = ? ");
            stmt.setBoolean(1, true);
            stmt.setDate(2, new java.sql.Date(System.currentTimeMillis()));
            stmt.setString(3, title);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 
    
    /**
     * Creates a new Blog object from database row
     * @param rs
     * @return
     * @throws SQLException
     */
    public static Blog rowToBlog(ResultSet rs) throws SQLException {
        return new Blog(rs.getInt("blog_id"), rs.getString("blog_author"), rs.getString("blog_title"), rs.getString("blog_link"), rs.getString("blog_description"), rs.getInt("blog_year"), rs.getBoolean("blog_checked"), rs.getDate("blog_date_checked"));
    }
}
