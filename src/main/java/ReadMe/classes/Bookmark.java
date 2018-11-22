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

public class Bookmark {

    private String bookmark_headline;
    private String bookmark_description;
    private String bookmark_link;

    public Bookmark(String headline, String description, String link) {
        this.bookmark_headline = headline;
        this.bookmark_description = description;
        this.bookmark_link = link;
    }

    public String getHeadline() {
        return bookmark_headline;
    }

    public String getDescription() {
        return bookmark_description;
    }

    public String getLink() {
        return bookmark_link;
    }

    public void setHeadline(String headline) {
        this.bookmark_headline = headline;
    }

    public void setDescription(String description) {
        this.bookmark_description = description;
    }

    public void setLink(String link) {
        this.bookmark_link = link;
    }

    @Override
    public String toString() {
        return "headline: " + bookmark_headline + ", description: " + bookmark_description + ", link: " + bookmark_link;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.bookmark_headline);
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
        return Objects.equals(this.bookmark_headline, other.bookmark_headline)
                && Objects.equals(this.bookmark_description, other.bookmark_description)
                && Objects.equals(this.bookmark_link, other.bookmark_link);
    }

    public static Bookmark rowToResepti(ResultSet rs) throws SQLException {
        return new Bookmark(rs.getString("bookmark_headline"), rs.getString("bookmark_description"), rs.getString("bookmark_link"));
    }

}
