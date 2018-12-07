package ReadMe.domain;

import java.text.SimpleDateFormat;
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
        assertEquals("\nTitle: " + "title" + "\n Author: " + "author" + 
                "\n Link: " + "www" + "\n Description: " + "desc" + "\n Publisher: " + "penguin" + 
                "\n Year: " + 2018 + "\n Checked: " + false + "\n Date checked: " + new SimpleDateFormat("dd-MM-yyyy").format(new Date(5)) +"\n", news.toString());
    }
    
    @Test
    public void toStringTestWithNullDate() {
        News nullDate = new News(1, "author", "title", "www", "desc", "penguin", 2018, false, null);  
        assertEquals("\nTitle: " + "title" + "\n Author: " + "author" + 
                "\n Link: " + "www" + "\n Description: " + "desc" + "\n Publisher: " + "penguin" + 
                "\n Year: " + 2018 + "\n Checked: " + false + "\n", nullDate.toString());
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
