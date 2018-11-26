/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.domain;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author madjanne
 */
public class VideoTest {
    private Video video;
    
    public VideoTest() {
    }
    
    @Before
    public void setUp() {
        this.video = new Video(1, "author", "title", "www", "desc", 2018, false, new Date(5));            
    }
    
    @Test
    public void toStringTest() {
        assertEquals("video_id: " + 1 + ", video_author: " + "author" + ", video_title: " + "title" + 
                ", video_link: " + "www" + ", video_description: " + "desc" + ", video_year: " + 2018 +
                ", video_checked: " + false + ", video_date_checked: " + new Date(5), video.toString());
    }
    
    @Test
    public void equalsTrueTest() {
        Video comp = new Video(1, "author", "title", "www", "desc", 2018, false, new Date(5));
        assertTrue(video.equals(comp));
    }
    @Test
    public void equalsFalseTest() {
        Video not = new Video(3, "author1", "title2", "www4", "descr", 2015, true, new Date());
        assertFalse(video.equals(not));
    }
}
