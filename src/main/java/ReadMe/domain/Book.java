package ReadMe.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Class for books in the reading tip library.
 * @author madjanne
 */
public class Book {
    private int book_id;
    private String book_author;
    private String book_title;
    private String ISBN;
    private String book_description;
    private int book_year;
    private boolean book_checked;
    private Date book_date_checked;

    public Book(int book_id, String book_author, String book_title, String ISBN, String book_description, int book_year, boolean book_checked, Date book_date_checked) {
        this.book_id = book_id;
        this.book_author = book_author;
        this.book_title = book_title;
        this.ISBN = ISBN;
        this.book_description = book_description;
        this.book_year = book_year;
        this.book_checked = book_checked;
        this.book_date_checked = book_date_checked;
    }
    
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }

    public int getBook_year() {
        return book_year;
    }

    public void setBook_year(int book_year) {
        this.book_year = book_year;
    }

    public boolean isBook_checked() {
        return book_checked;
    }

    public void setBook_checked(boolean book_checked) {
        this.book_checked = book_checked;
    }

    public Date getBook_date_checked() {
        return book_date_checked;
    }

    public void setBook_date_checked(Date book_date_checked) {
        this.book_date_checked = book_date_checked;
    }
    
    @Override
    public String toString() {
        return "book_id: " + book_id + ", book_author: " + book_author + ", book_title: " + book_title + 
                ", ISBN: " + ISBN + ", book_description: " + book_description + 
                ", book_year: " + book_year + ", book_checked: " + book_checked + ", book_date_checked: " + book_date_checked;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.book_author);
        hash = 23 * hash + Objects.hashCode(this.book_title);
        hash = 23 * hash + Objects.hashCode(this.book_description);
        hash = 23 * hash + Objects.hashCode(this.ISBN);
        hash = 23 * hash + Objects.hashCode(this.book_checked);
        hash = 23 * hash + Objects.hashCode(this.book_date_checked);
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

        final Book other = (Book) obj;
        return Objects.equals(this.book_author, other.book_author)
                && Objects.equals(this.book_title, other.book_title)
                && Objects.equals(this.book_description, other.book_description)
                && Objects.equals(this.ISBN, other.ISBN)
                && Objects.equals(this.book_checked, other.book_checked)
                && Objects.equals(this.book_date_checked, other.book_date_checked);
    }    
}
