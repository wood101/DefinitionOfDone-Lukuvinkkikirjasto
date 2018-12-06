/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;

import ReadMe.database.Database;
import ReadMe.domain.ReadingTip;
import ReadMe.domain.Video;
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
 * Interface for Video database access object. 
 * @author madjanne
 */
public class VideoDao {
    private final Database db;

    /**
     * Creates new Video DAO for database
     * @param db
     */
    public VideoDao(Database db) {
        this.db = db;
    }

    /**
     * Lists all Video objects. Connects to database, retrieves all lines from the Video table, and returns a list of Video objects.
     * Returns null in case of SQL exception.
     * @return
     */
    
    public List<ReadingTip> listAll() {
        try (Connection c = db.getConnection()) {
            List<ReadingTip> videos = new ArrayList<>();

            ResultSet rs = c.prepareStatement("SELECT * FROM Video").executeQuery();
            while (rs.next()) {
                videos.add(rowToVideo(rs));
            }

            return videos;
        } catch (SQLException ex) {
            Logger.getLogger(VideoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Adds a new Video to database. Connects to database, adds a new Video to the database. In case of database conflict does nothing.
     * In case of SQL exception returns null.
     * @param vid
     */
    public void add(Video vid) {
        try (Connection c = db.getConnection()) {
            PreparedStatement add = c.prepareStatement("INSERT INTO Video (video_author, video_title, video_link, video_description, video_year, video_checked, video_date_checked) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            add.setString(1, vid.getAuthor());
            add.setString(2, vid.getTitle());
            add.setString(3, vid.getLink());
            add.setString(4, vid.getDescription());
            add.setInt(5, vid.getYear());
            add.setBoolean(6, false);
            add.setDate(7, null);
            add.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VideoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Marks the Video as read and sets the date it was read on.
     * @param video Object that is marked read
     */
    public boolean markAsRead(String title) {
        try (Connection c = db.getConnection()) {
            PreparedStatement stmt = c.prepareStatement(
                    "UPDATE Video SET video_checked = ?, video_date_checked = ? WHERE video_title = ? ");
            stmt.setBoolean(1, true);
            stmt.setDate(2, new java.sql.Date(System.currentTimeMillis()));
            stmt.setString(3, title);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VideoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 
    
     /**
     * Creates a new Video object from database row
     * @param rs
     * @return
     * @throws SQLException
     */
    public static Video rowToVideo(ResultSet rs) throws SQLException {
        return new Video(rs.getInt("video_id"), rs.getString("video_author"), rs.getString("video_title"), rs.getString("video_link"), rs.getString("video_description"), rs.getInt("video_year"), rs.getBoolean("video_checked"), rs.getDate("video_date_checked"));
    }
}
