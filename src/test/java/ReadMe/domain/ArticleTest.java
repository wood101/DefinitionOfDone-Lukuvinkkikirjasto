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
public class ArticleTest {
    private Article article;
    
    public ArticleTest() {
    }
    
    @Before
    public void setUp() {
        this.article = new Article(1, "author", "title", "www", "desc", "penguin", 2018, false, new Date(5));            
    }
    
    @Test
    public void toStringTest() {
        assertEquals("article_id: " + 1 + ", article_author: " + "author" + ", article_title: " + "title" + 
                ", article_link: " + "www" + ", article_description: " + "desc" + ", article_publisher: " + "penguin" + ", article_year: " + 2018 +
                ", article_checked: " + false + ", article_date_checked: " + new Date(5), article.toString());
    }
    
    @Test
    public void equalsTrueTest() {
        Article comp = new Article(1, "author", "title", "www", "desc", "penguin", 2018, false, new Date(5));
        assertTrue(article.equals(comp));
    }
    @Test
    public void equalsFalseTest() {
        Article not = new Article(3, "author1", "title2", "www4", "descr", "otava", 2015, true, new Date());
        assertFalse(article.equals(not));
    }
}
