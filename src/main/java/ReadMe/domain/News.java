package ReadMe.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Class for news from newspapers in the reading tip library.
 * @author madjanne
 */
public class News extends ReadingTip {
    private String link;
    private String publisher;

    public News(int id, String author, String title, String link, String description, String publisher, int year, boolean checked, Date date_checked) {
        super(id, author, title, description, year, checked, date_checked);
        this.publisher = publisher;
        this.link = link;
    }
    
    public News(String author, String title, String link, String description, String publisher, int year) {
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
        return "\nTitle: " + super.getTitle() + "\n Author: " + super.getAuthor() +
                "\n Link: " + link + "\n Description: " + super.getDescription() +  "\n Publisher: " + publisher +
                "\n Year: " + super.getYear() + "\n Checked: " + super.isChecked() + "\n Date checked: " + super.getDate_checked() + "\n";
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(super.getAuthor());
        hash = 23 * hash + Objects.hashCode(super.getTitle());
        hash = 23 * hash + Objects.hashCode(super.getDescription());
        hash = 23 * hash + Objects.hashCode(this.publisher);
        hash = 23 * hash + Objects.hashCode(this.link);
        hash = 23 * hash + Objects.hashCode(super.isChecked());
        hash = 23 * hash + Objects.hashCode(super.getDate_checked());
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
        return Objects.equals(super.getAuthor(), other.getAuthor())
                && Objects.equals(super.getTitle(), other.getTitle())
                && Objects.equals(super.getDescription(), other.getDescription())
                && Objects.equals(this.publisher, other.publisher)
                && Objects.equals(this.link, other.link)
                && Objects.equals(super.isChecked(), other.isChecked())
                && Objects.equals(super.getDate_checked(), other.getDate_checked());
    }    
}
