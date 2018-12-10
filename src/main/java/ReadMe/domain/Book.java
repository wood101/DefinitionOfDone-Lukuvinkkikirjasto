package ReadMe.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Class for books in the reading tip library.
 * @author madjanne
 */
public class Book extends ReadingTip {
    private String ISBN;

    public Book(int id, String author, String title, String ISBN, String description, int year, boolean checked, Date date_checked) {
        super(id, author, title, description, year, checked, date_checked);
        this.ISBN = ISBN;
    }
    
    public Book(String author, String title, String ISBN, String description, int year) {
        super(author, title, description, year);
        this.ISBN = ISBN;
    }    

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    @Override
    public String toString() {
        String dateText;
        if(this.getDate_checked() == null) dateText = "";
        else dateText = " Date checked: " + new SimpleDateFormat("dd-MM-yyyy").format(this.getDate_checked())+ "\n";
        return "\nTitle: " + this.getTitle() + "\n Author: " + this.getAuthor() +
                "\n ISBN: " + ISBN + "\n Description: " + this.getDescription() +
                "\n Year: " + this.getYear() + "\n Checked: " + this.isChecked() + "\n" + dateText;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.getAuthor());
        hash = 23 * hash + Objects.hashCode(this.getTitle());
        hash = 23 * hash + Objects.hashCode(this.getDescription());
        hash = 23 * hash + Objects.hashCode(this.ISBN);
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

        final Book other = (Book) obj;
        return Objects.equals(this.getAuthor(), other.getAuthor())
                && Objects.equals(this.getTitle(), other.getTitle())
                && Objects.equals(this.getDescription(), other.getDescription())
                && Objects.equals(this.ISBN, other.ISBN)
                && Objects.equals(this.isChecked(), other.isChecked())
                && Objects.equals(this.getDate_checked(), other.getDate_checked());
    }    
}
