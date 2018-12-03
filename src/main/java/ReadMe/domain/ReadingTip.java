/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Superclass for all the reading tips
 * @author madjanne
 */
public abstract class ReadingTip {
    private int id;
    private String author;
    private String title;
    private String description;
    private int year;
    private boolean checked;
    private Date date_checked;
    
    public ReadingTip(int id, String author, String title, String description, int year, boolean checked, Date date_checked) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.year = year;
        this.checked = checked;
        this.date_checked = date_checked;
    }
    
    public ReadingTip(String author, String title, String description, int year) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Date getDate_checked() {
        return date_checked;
    }

    public void setDate_checked(Date date_checked) {
        this.date_checked = date_checked;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.author);
        hash = 19 * hash + Objects.hashCode(this.title);
        hash = 19 * hash + Objects.hashCode(this.description);
        hash = 19 * hash + this.year;
        hash = 19 * hash + (this.checked ? 1 : 0);
        hash = 19 * hash + Objects.hashCode(this.date_checked);
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
        final ReadingTip other = (ReadingTip) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (this.checked != other.checked) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.date_checked, other.date_checked)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nTitle: " + title + "\n Author: " + author + 
                "\n Description: " + description + 
                "\n Year: " + year + "\n Checked: " + checked + "\n Date checked: " + date_checked + "\n";
    }
    
    
    
}
