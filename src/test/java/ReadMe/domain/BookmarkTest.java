/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.domain;

import ReadMe.domain.Bookmark;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author peje
 */
public class BookmarkTest {
    private Bookmark bookmark;

    public BookmarkTest() {
    }
    
    @Before
    public void setUp() {
        this.bookmark = new Bookmark("title", "desc", "www");            
    }
    
    @Test
    public void toStringTest() {
        assertEquals("headline: " + "title" + ", description: " + "desc" + ", link: " + "www", bookmark.toString());
    }
    
    @Test
    public void equalsTrueTest() {
        Bookmark comp = new Bookmark("title", "desc", "www");
        assertTrue(bookmark.equals(comp));
    }
    @Test
    public void equalsFalseTest() {
        Bookmark not = new Bookmark("title1", "desc1", "aaa");
        assertFalse(bookmark.equals(not));
    }
}
