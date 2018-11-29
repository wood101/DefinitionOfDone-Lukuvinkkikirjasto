/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;

import ReadMe.database.Database;
import ReadMe.domain.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Interface for Book database access object. 
 * @author madjanne
 */
public class BookDao {
    private final Database db;

    /**
     * Creates new Book DAO for database
     * @param db
     */
    public BookDao(Database db) {
        this.db = db;
    }

    /**
     * Lists all Book objects. Connects to database, retrieves all lines from the Book table, and returns a list of Book objects.
     * Returns null in case of SQL exception.
     * @return
     */
    
    public List<Book> listAll() {
        try (Connection c = db.getConnection()) {
            List<Book> books = new ArrayList<>();

            ResultSet rs = c.prepareStatement("SELECT * FROM Book").executeQuery();
            while (rs.next()) {
                books.add(rowToBook(rs));
            }

            return books;
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Adds a new Book to database. Connects to database, adds a new Book to the database. In case of database conflict does nothing.
     * In case of SQL exception returns null.
     * @param book
     */
    public void add(Book book) {
        try (Connection c = db.getConnection()) {
            PreparedStatement add = c.prepareStatement("INSERT INTO Book (book_author, book_title, ISBN, book_description, book_year, book_checked, book_date_checked) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            add.setString(1, book.getBook_author());
            add.setString(2, book.getBook_title());
            add.setString(3, book.getISBN());
            add.setString(4, book.getBook_description());
            add.setInt(5, book.getBook_year());
            add.setBoolean(6, false);
            add.setDate(7, null);
            add.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     /**
     * Creates a new Book object from database row
     * @param rs
     * @return
     * @throws SQLException
     */
    public static Book rowToBook(ResultSet rs) throws SQLException {
        return new Book(rs.getInt("book_id"), rs.getString("book_author"), rs.getString("book_title"), rs.getString("ISBN"), rs.getString("book_description"), rs.getInt("book_year"), rs.getBoolean("book_checked"), rs.getDate("book_date_checked"));
    }
}
