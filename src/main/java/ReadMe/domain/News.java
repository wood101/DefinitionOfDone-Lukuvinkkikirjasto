package ReadMe.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Class for news from newspapers in the reading tip library.
 * @author madjanne
 */
public class News {
    private int news_id;
    private String news_author;
    private String news_title;
    private String news_link;
    private String news_description;
    private String news_publisher;
    private int news_year;
    private boolean news_checked;
    private Date news_date_checked;

    public News(int news_id, String news_author, String news_title, String news_link, String news_description, String news_publisher, int news_year, boolean news_checked, Date news_date_checked) {
        this.news_id = news_id;
        this.news_author = news_author;
        this.news_title = news_title;
        this.news_link = news_link;
        this.news_description = news_description;
        this.news_publisher = news_publisher;
        this.news_year = news_year;
        this.news_checked = news_checked;
        this.news_date_checked = news_date_checked;
    }
    
    public News(String news_author, String news_title, String news_link, String news_description, String news_publisher, int news_year) {
        this.news_author = news_author;
        this.news_title = news_title;
        this.news_link = news_link;
        this.news_description = news_description;
        this.news_publisher = news_publisher;
        this.news_year = news_year;
    }    

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getNews_author() {
        return news_author;
    }

    public void setNews_author(String news_author) {
        this.news_author = news_author;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_link() {
        return news_link;
    }

    public void setNews_link(String news_link) {
        this.news_link = news_link;
    }

    public String getNews_description() {
        return news_description;
    }

    public void setNews_description(String news_description) {
        this.news_description = news_description;
    }

    public String getNews_publisher() {
        return news_publisher;
    }

    public void setNews_publisher(String news_publisher) {
        this.news_publisher = news_publisher;
    }

    public int getNews_year() {
        return news_year;
    }

    public void setNews_year(int news_year) {
        this.news_year = news_year;
    }

    public boolean isNews_checked() {
        return news_checked;
    }

    public void setNews_checked(boolean news_checked) {
        this.news_checked = news_checked;
    }

    public Date getNews_date_checked() {
        return news_date_checked;
    }

    public void setNews_date_checked(Date news_date_checked) {
        this.news_date_checked = news_date_checked;
    }
    
    @Override
    public String toString() {
        return "\nTitle: " + news_title + "\n Author: " + news_author + 
                "\n Link: " + news_link + "\n Description: " + news_description + "\n Publisher: " + news_publisher + 
                "\n Year: " + news_year + "\n Checked: " + news_checked + "\n Date checked: " + news_date_checked +"\n";
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.news_author);
        hash = 23 * hash + Objects.hashCode(this.news_title);
        hash = 23 * hash + Objects.hashCode(this.news_description);
        hash = 23 * hash + Objects.hashCode(this.news_publisher);
        hash = 23 * hash + Objects.hashCode(this.news_link);
        hash = 23 * hash + Objects.hashCode(this.news_checked);
        hash = 23 * hash + Objects.hashCode(this.news_date_checked);
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

        final News other = (News) obj;
        return Objects.equals(this.news_author, other.news_author)
                && Objects.equals(this.news_title, other.news_title)
                && Objects.equals(this.news_description, other.news_description)
                && Objects.equals(this.news_publisher, other.news_publisher)
                && Objects.equals(this.news_link, other.news_link)
                && Objects.equals(this.news_checked, other.news_checked)
                && Objects.equals(this.news_date_checked, other.news_date_checked);
    }    
}
