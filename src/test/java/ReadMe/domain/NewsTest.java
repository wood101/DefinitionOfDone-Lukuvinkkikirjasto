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
public class NewsTest {
    private News news;
    
    public NewsTest() {
    }
    
    @Before
    public void setUp() {
        this.news = new News(1, "author", "title", "www", "desc", "penguin", 2018, false, new Date(5));            
    }
    
    @Test
    public void toStringTest() {
        assertEquals("news_id: " + 1 + ", news_author: " + "author" + ", news_title: " + "title" + 
                ", news_link: " + "www" + ", news_description: " + "desc" + ", news_publisher: " + "penguin" + ", news_year: " + 2018 +
                ", news_checked: " + false + ", news_date_checked: " + new Date(5), news.toString());
    }
    
    @Test
    public void equalsTrueTest() {
        News comp = new News(1, "author", "title", "www", "desc", "penguin", 2018, false, new Date(5));
        assertTrue(news.equals(comp));
    }
    @Test
    public void equalsFalseTest() {
        News not = new News(3, "author1", "title2", "www4", "descr", "otava", 2015, true, new Date());
        assertFalse(news.equals(not));
    }
}
