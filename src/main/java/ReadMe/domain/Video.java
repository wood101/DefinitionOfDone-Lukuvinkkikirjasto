package ReadMe.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Class for videos in the reading tip library.
 * @author madjanne
 */
public class Video {
    private int video_id;
    private String video_author;
    private String video_title;
    private String video_link;
    private String video_description;
    private int video_year;
    private boolean video_checked;
    private Date video_date_checked;

    public Video(int video_id, String video_author, String video_title, String video_link, String video_description, int video_year, boolean video_checked, Date video_date_checked) {
        this.video_id = video_id;
        this.video_author = video_author;
        this.video_title = video_title;
        this.video_link = video_link;
        this.video_description = video_description;
        this.video_year = video_year;
        this.video_checked = video_checked;
        this.video_date_checked = video_date_checked;
    }
    
    public Video(String video_author, String video_title, String video_link, String video_description, int video_year) {
        this.video_author = video_author;
        this.video_title = video_title;
        this.video_link = video_link;
        this.video_description = video_description;
        this.video_year = video_year;
    }
    
    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public String getVideo_author() {
        return video_author;
    }

    public void setVideo_author(String video_author) {
        this.video_author = video_author;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getVideo_link() {
        return video_link;
    }

    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }

    public String getVideo_description() {
        return video_description;
    }

    public void setVideo_description(String video_description) {
        this.video_description = video_description;
    }

    public int getVideo_year() {
        return video_year;
    }

    public void setVideo_year(int video_year) {
        this.video_year = video_year;
    }

    public boolean isVideo_checked() {
        return video_checked;
    }

    public void setVideo_checked(boolean video_checked) {
        this.video_checked = video_checked;
    }

    public Date getVideo_date_checked() {
        return video_date_checked;
    }

    public void setVideo_date_checked(Date video_date_checked) {
        this.video_date_checked = video_date_checked;
    }
    
    @Override
    public String toString() {
        return "\nTitle: " + video_title + "\n Author: " + video_author + 
                "\n Link: " + video_link + "\n Description: " + video_description + 
                "\n Year: " + video_year + "\n Checked: " + video_checked + "\n Date checked: " + video_date_checked + "\n";
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.video_author);
        hash = 23 * hash + Objects.hashCode(this.video_title);
        hash = 23 * hash + Objects.hashCode(this.video_description);
        hash = 23 * hash + Objects.hashCode(this.video_link);
        hash = 23 * hash + Objects.hashCode(this.video_checked);
        hash = 23 * hash + Objects.hashCode(this.video_date_checked);
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

        final Video other = (Video) obj;
        return Objects.equals(this.video_author, other.video_author)
                && Objects.equals(this.video_title, other.video_title)
                && Objects.equals(this.video_description, other.video_description)
                && Objects.equals(this.video_link, other.video_link)
                && Objects.equals(this.video_checked, other.video_checked)
                && Objects.equals(this.video_date_checked, other.video_date_checked);
    }    
}
