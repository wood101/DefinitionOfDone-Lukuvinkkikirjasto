/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.domain;

/**
 *
 * @author bisi
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author bisi
 */
public class Bookmark {

    private String bookmark_title;
    private String bookmark_description;
    private String bookmark_link;

    /**
     * Create a new Bookmark object. Bookmark has a title, description and a link to the source
     * @param String title
     * @param String description
     * @param String link
     */
    public Bookmark(String title, String description, String link) {
        this.bookmark_title = title;
        this.bookmark_description = description;
        this.bookmark_link = link;
    }

    /**
     * Returns the headline of the Bookmark
     * @return String headline
     */
    public String getTitle() {
        return bookmark_title;
    }

    /**
     * Returns the description of the Bookmark
     * @return String description
     */
    public String getDescription() {
        return bookmark_description;
    }

    /**
     * Returns the link to the source of the Bookmark
     * @return
     */
    public String getLink() {
        return bookmark_link;
    }

    /**
     * Sets the title for the Bookmark
     * @param title
     */
    public void setTitle(String title) {
        this.bookmark_title = title;
    }

    /**
     * Sets the description of the Bookmark
     * @param description
     */
    public void setDescription(String description) {
        this.bookmark_description = description;
    }

    /**
     * Sets the link of the Bookmark
     * @param link
     */
    public void setLink(String link) {
        this.bookmark_link = link;
    }

    @Override
    public String toString() {
        return "headline: " + bookmark_title + ", description: " + bookmark_description + ", link: " + bookmark_link;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.bookmark_title);
        hash = 23 * hash + Objects.hashCode(this.bookmark_description);
        hash = 23 * hash + Objects.hashCode(this.bookmark_link);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Bookmark other = (Bookmark) obj;
        return Objects.equals(this.bookmark_title, other.bookmark_title)
                && Objects.equals(this.bookmark_description, other.bookmark_description)
                && Objects.equals(this.bookmark_link, other.bookmark_link);
    }

    /**
     * Creates a new Bookmark object from database row
     * @param rs
     * @return
     * @throws SQLException
     */
    public static Bookmark rowToBookmark(ResultSet rs) throws SQLException {
        return new Bookmark(rs.getString("bookmark_title"), rs.getString("bookmark_description"), rs.getString("bookmark_link"));
    }

}
