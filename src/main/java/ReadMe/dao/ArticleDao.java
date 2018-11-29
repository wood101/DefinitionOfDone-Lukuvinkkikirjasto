/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;

import ReadMe.database.Database;
import ReadMe.domain.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Interface for Article database access object. 
 * @author madjanne
 */
public class ArticleDao {
    private final Database db;

    /**
     * Creates new Article DAO for database
     * @param db
     */
    public ArticleDao(Database db) {
        this.db = db;
    }

    /**
     * Lists all Article objects. Connects to database, retrieves all lines from the Article table, and returns a list of Article objects.
     * Returns null in case of SQL exception.
     * @return
     */
    
    public List<Article> listAll() {
        try (Connection c = db.getConnection()) {
            List<Article> articles = new ArrayList<>();

            ResultSet rs = c.prepareStatement("SELECT * FROM Article").executeQuery();
            while (rs.next()) {
                articles.add(rowToArticle(rs));
            }

            return articles;
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Marks the article as read and sets the date it was read on.
     * @param article Object that is marked read
     */
    public boolean markAsRead(String title) {
        try (Connection c = db.getConnection()) {
            PreparedStatement stmt = c.prepareStatement(
                    "UPDATE Article SET article_checked = ?, article_date_checked = ? WHERE article_title = ?) ");
            stmt.setBoolean(1, true);
            stmt.setDate(2, new Date(System.currentTimeMillis()));
            stmt.setString(3, title);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }    
    
    /**
     * Adds a new Article to database. Connects to database, adds a new Article to the database. In case of database conflict does nothing.
     * In case of SQL exception returns null.
     * @param article
     */
    public void add(Article article) {
        try (Connection c = db.getConnection()) {
            PreparedStatement add = c.prepareStatement("INSERT INTO Article (article_author, article_title, article_link, article_description, article_publisher, article_year, article_checked, article_date_checked) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            add.setString(1, article.getArticle_author());
            add.setString(2, article.getArticle_title());
            add.setString(3, article.getArticle_link());
            add.setString(4, article.getArticle_description());
            add.setString(5, article.getArticle_publisher());
            add.setInt(6, article.getArticle_year());
            add.setBoolean(7, false);
            add.setDate(8, null);
            add.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     /**
     * Creates a new Article object from database row
     * @param rs
     * @return
     * @throws SQLException
     */
    public static Article rowToArticle(ResultSet rs) throws SQLException {
        return new Article(rs.getInt("article_id"), rs.getString("article_author"), rs.getString("article_title"), rs.getString("article_link"), rs.getString("article_description"), rs.getString("article_publisher"), rs.getInt("article_year"), rs.getBoolean("article_checked"), rs.getDate("article_date_checked"));
    }
}
