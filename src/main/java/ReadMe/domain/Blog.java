package ReadMe.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Class for blogs in the reading tip library.
 * @author madjanne
 */
public class Blog {
    private int blog_id;
    private String blog_author;
    private String blog_title;
    private String blog_link;
    private String blog_description;
    private int blog_year;
    private boolean blog_checked;
    private Date blog_date_checked;

    public Blog(int blog_id, String blog_author, String blog_title, String blog_link, String blog_description, int blog_year, boolean blog_checked, Date blog_date_checked) {
        this.blog_id = blog_id;
        this.blog_author = blog_author;
        this.blog_title = blog_title;
        this.blog_link = blog_link;
        this.blog_description = blog_description;
        this.blog_year = blog_year;
        this.blog_checked = blog_checked;
        this.blog_date_checked = blog_date_checked;
    }
    
    public Blog(String blog_author, String blog_title, String blog_link, String blog_description, int blog_year) {
        this.blog_author = blog_author;
        this.blog_title = blog_title;
        this.blog_link = blog_link;
        this.blog_description = blog_description;
        this.blog_year = blog_year;
    }
    
    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public String getBlog_author() {
        return blog_author;
    }

    public void setBlog_author(String blog_author) {
        this.blog_author = blog_author;
    }

    public String getBlog_title() {
        return blog_title;
    }

    public void setBlog_title(String blog_title) {
        this.blog_title = blog_title;
    }

    public String getBlog_link() {
        return blog_link;
    }

    public void setBlog_link(String blog_link) {
        this.blog_link = blog_link;
    }

    public String getBlog_description() {
        return blog_description;
    }

    public void setBlog_description(String blog_description) {
        this.blog_description = blog_description;
    }

    public int getBlog_year() {
        return blog_year;
    }

    public void setBlog_year(int blog_year) {
        this.blog_year = blog_year;
    }

    public boolean isBlog_checked() {
        return blog_checked;
    }

    public void setBlog_checked(boolean blog_checked) {
        this.blog_checked = blog_checked;
    }

    public Date getBlog_date_checked() {
        return blog_date_checked;
    }

    public void setBlog_date_checked(Date blog_date_checked) {
        this.blog_date_checked = blog_date_checked;
    }
    
    @Override
    public String toString() {
        return "blog_id: " + blog_id + ", blog_author: " + blog_author + ", blog_title: " + blog_title + 
                ", blog_link: " + blog_link + ", blog_description: " + blog_description + 
                ", blog_year: " + blog_year + ", blog_checked: " + blog_checked + ", blog_date_checked: " + blog_date_checked;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.blog_author);
        hash = 23 * hash + Objects.hashCode(this.blog_title);
        hash = 23 * hash + Objects.hashCode(this.blog_description);
        hash = 23 * hash + Objects.hashCode(this.blog_link);
        hash = 23 * hash + Objects.hashCode(this.blog_checked);
        hash = 23 * hash + Objects.hashCode(this.blog_date_checked);
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

        final Blog other = (Blog) obj;
        return Objects.equals(this.blog_author, other.blog_author)
                && Objects.equals(this.blog_title, other.blog_title)
                && Objects.equals(this.blog_description, other.blog_description)
                && Objects.equals(this.blog_link, other.blog_link)
                && Objects.equals(this.blog_checked, other.blog_checked)
                && Objects.equals(this.blog_date_checked, other.blog_date_checked);
    }    
}
