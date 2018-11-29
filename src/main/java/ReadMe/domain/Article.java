package ReadMe.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Class for articles in the reading tip library.
 * @author madjanne
 */
public class Article {
    private int article_id;
    private String article_author;
    private String article_title;
    private String article_link;
    private String article_description;
    private String article_publisher;
    private int article_year;
    private boolean article_checked;
    private Date article_date_checked;

    public Article(int article_id, String article_author, String article_title, String article_link, String article_description, String article_publisher, int article_year, boolean article_checked, Date article_date_checked) {
        this.article_id = article_id;
        this.article_author = article_author;
        this.article_title = article_title;
        this.article_link = article_link;
        this.article_description = article_description;
        this.article_publisher = article_publisher;
        this.article_year = article_year;
        this.article_checked = article_checked;
        this.article_date_checked = article_date_checked;
    }
    
    public Article(String article_author, String article_title, String article_link, String article_description, String article_publisher, int article_year) {
        this.article_author = article_author;
        this.article_title = article_title;
        this.article_link = article_link;
        this.article_description = article_description;
        this.article_publisher = article_publisher;
        this.article_year = article_year;
    }    

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getArticle_author() {
        return article_author;
    }

    public void setArticle_author(String article_author) {
        this.article_author = article_author;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_link() {
        return article_link;
    }

    public void setArticle_link(String article_link) {
        this.article_link = article_link;
    }

    public String getArticle_description() {
        return article_description;
    }

    public void setArticle_description(String article_description) {
        this.article_description = article_description;
    }

    public String getArticle_publisher() {
        return article_publisher;
    }

    public void setArticle_publisher(String article_publisher) {
        this.article_publisher = article_publisher;
    }

    public int getArticle_year() {
        return article_year;
    }

    public void setArticle_year(int article_year) {
        this.article_year = article_year;
    }

    public boolean isArticle_checked() {
        return article_checked;
    }

    public void setArticle_checked(boolean article_checked) {
        this.article_checked = article_checked;
    }

    public Date getArticle_date_checked() {
        return article_date_checked;
    }

    public void setArticle_date_checked(Date article_date_checked) {
        this.article_date_checked = article_date_checked;
    }
    
    @Override
    public String toString() {
        return "\nTitle: " + article_title + "\n Author: " + article_author + 
                "\n Link: " + article_link + "\n Description: " + article_description + "\n Publisher: " + article_publisher + 
                "\n Year: " + article_year + "\n Checked: " + article_checked + "\n Date checked: " + article_date_checked +"\n";
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.article_author);
        hash = 23 * hash + Objects.hashCode(this.article_title);
        hash = 23 * hash + Objects.hashCode(this.article_description);
        hash = 23 * hash + Objects.hashCode(this.article_publisher);
        hash = 23 * hash + Objects.hashCode(this.article_link);
        hash = 23 * hash + Objects.hashCode(this.article_checked);
        hash = 23 * hash + Objects.hashCode(this.article_date_checked);
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

        final Article other = (Article) obj;
        return Objects.equals(this.article_author, other.article_author)
                && Objects.equals(this.article_title, other.article_title)
                && Objects.equals(this.article_description, other.article_description)
                && Objects.equals(this.article_publisher, other.article_publisher)
                && Objects.equals(this.article_link, other.article_link)
                && Objects.equals(this.article_checked, other.article_checked)
                && Objects.equals(this.article_date_checked, other.article_date_checked);
    }    
}
