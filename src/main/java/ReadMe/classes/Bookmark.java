/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.classes;

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

    private String headline;
    private String description;
    private String link;

    /**
     * Create a new Bookmark object. Bookmark has a title, description and a link to the source
     * @param String headline
     * @param String description
     * @param String link
     */
    public Bookmark(String headline, String description, String link) {
        this.headline = headline;
        this.description = description;
        this.link = link;
    }

    /**
     * Returns the headline of the Bookmark
     * @return String headline
     */
    public String getHeadline() {
        return headline;
    }

    /**
     * Returns the description of the Bookmark
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the link to the source of the Bookmark
     * @return
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the title for the Bookmark
     * @param headline
     */
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    /**
     * Sets the descriotion of the Bookmark
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the link of the Bookmark
     * @param link
     */
    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "headline: " + headline + ", description: " + description + ", link: " + link;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.headline);
        hash = 23 * hash + Objects.hashCode(this.description);
        hash = 23 * hash + Objects.hashCode(this.link);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        
        final Bookmark other = (Bookmark) obj;
        return Objects.equals(this.headline, other.headline) 
            && Objects.equals(this.description, other.description) 
            && Objects.equals(this.link, other.link);
    }

    /**
     * Creates a new Bookmark object from database row
     * @param rs
     * @return
     * @throws SQLException
     */
    public static Bookmark rowToBookmark(ResultSet rs) throws SQLException {
        return new Bookmark(rs.getString("headline"), rs.getString("description"), rs.getString("link"));
    }

}
