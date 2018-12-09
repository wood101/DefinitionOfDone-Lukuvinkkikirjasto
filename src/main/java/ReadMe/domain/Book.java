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

    public Book(String author, String title, String link, String description, int year) {
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
        else dateText = " Date checked: " + new SimpleDateFormat("dd-MM-yyyy").format(super.getDate_checked())+ "\n";
        return "\nTitle: " + super.getTitle() + "\n Author: " + super.getAuthor() +
                "\n ISBN: " + ISBN + "\n Description: " + super.getDescription() +
                "\n Year: " + super.getYear() + "\n Checked: " + super.isChecked() + "\n" + dateText;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 23 * hash + Objects.hashCode(this.ISBN);
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
        return Objects.equals(super.getAuthor(), other.getAuthor())
                && Objects.equals(super.getTitle(), other.getTitle())
                && Objects.equals(super.getDescription(), other.getDescription())
                && Objects.equals(this.ISBN, other.ISBN)
                && Objects.equals(super.isChecked(), other.isChecked())
                && Objects.equals(super.getDate_checked(), other.getDate_checked());
    }
}
