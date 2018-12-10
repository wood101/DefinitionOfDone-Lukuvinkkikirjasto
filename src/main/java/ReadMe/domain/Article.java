package ReadMe.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Class for articles in the reading tip library.
 * @author madjanne
 */
public class Article extends ReadingTip {
    private String link;
    private String publisher;

    public Article(int id, String author, String title, String link, String description, String publisher, int year, boolean checked, Date date_checked) {
        super(id, author, title, description, year, checked, date_checked);
        this.publisher = publisher;
        this.link = link;
    }
    
    public Article(String author, String title, String link, String description, String publisher, int year) {
        super(author, title, description, year);
        this.link = link;
        this.publisher = publisher;
    }    

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    @Override
    public String toString() {
        String dateText;
        if(this.getDate_checked() == null) dateText = "";
        else dateText = " Date checked: " + new SimpleDateFormat("dd-MM-yyyy").format(this.getDate_checked())+ "\n";
        
        return "\nTitle: " + this.getTitle() + "\n Author: " + this.getAuthor() +
                "\n Link: " + link + "\n Description: " + this.getDescription() +  "\n Publisher: " + publisher +
                "\n Year: " + this.getYear() + "\n Checked: " + this.isChecked() + "\n" + dateText;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.getAuthor());
        hash = 23 * hash + Objects.hashCode(this.getTitle());
        hash = 23 * hash + Objects.hashCode(this.getDescription());
        hash = 23 * hash + Objects.hashCode(this.publisher);
        hash = 23 * hash + Objects.hashCode(this.link);
        hash = 23 * hash + Objects.hashCode(this.isChecked());
        hash = 23 * hash + Objects.hashCode(this.getDate_checked());
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
        return Objects.equals(this.getAuthor(), other.getAuthor())
                && Objects.equals(this.getTitle(), other.getTitle())
                && Objects.equals(this.getDescription(), other.getDescription())
                && Objects.equals(this.publisher, other.publisher)
                && Objects.equals(this.link, other.link)
                && Objects.equals(this.isChecked(), other.isChecked())
                && Objects.equals(this.getDate_checked(), other.getDate_checked());
    }    
}