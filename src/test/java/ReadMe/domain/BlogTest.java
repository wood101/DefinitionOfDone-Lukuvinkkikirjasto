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
public class BlogTest {
    private Blog blog;
    
    public BlogTest() {
    }
    
    @Before
    public void setUp() {
        this.blog = new Blog(1, "author", "title", "www", "desc", 2018, false, new Date(5));            
    }
    
    @Test
    public void toStringTest() {
        assertEquals("\nTitle: " + "title" + "\n Author: " + "author" + 
                "\n Link: " + "www" + "\n Description: " + "desc" + 
                "\n Year: " + 2018 + "\n Checked: " + false + "\n Date checked: " + new Date(5) + "\n", blog.toString());
    }
    
    @Test
    public void equalsTrueTest() {
        Blog comp = new Blog(1, "author", "title", "www", "desc", 2018, false, new Date(5));
        assertTrue(blog.equals(comp));
    }
    @Test
    public void equalsFalseTest() {
        Blog not = new Blog(3, "author1", "title2", "www4", "descr", 2015, true, new Date());
        assertFalse(blog.equals(not));
    }
}
