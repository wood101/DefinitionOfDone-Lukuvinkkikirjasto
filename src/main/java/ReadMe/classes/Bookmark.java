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

    private String headline;
    private String description;
    private String link;

    public Bookmark(String headline, String description, String link) {
        this.headline = headline;
        this.description = description;
        this.link = link;
    }

    public String getHeadline() {
        return headline;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public static Bookmark rowToResepti(ResultSet rs) throws SQLException {
        return new Bookmark(rs.getString("headline"), rs.getString("description"), rs.getString("link"));
    }

}
