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
public class BookTest {
    private Book book;
    
    public BookTest() {
    }
    
    @Before
    public void setUp() {
        this.book = new Book(1, "author", "title", "a52d253", "desc", 2018, false, new Date(5));            
    }
    
    @Test
    public void toStringTest() {
        assertEquals("\nTitle: " + "title" + "\n Author: " + "author" +
                "\n ISBN: " + "a52d253" + "\n Description: " + "desc" + 
                "\n Year: " + 2018 + "\n Checked: " + false + "\n Date checked: " + new SimpleDateFormat("dd-MM-yyyy").format(new Date(5)) + "\n", book.toString());
    }
    
    @Test
    public void toStringTestWithNullDate() {
        Book nullDate = new Book(1, "author", "title", "a52d253", "desc", 2018, false, null);  
        assertEquals("\nTitle: " + "title" + "\n Author: " + "author" +
                "\n ISBN: " + "a52d253" + "\n Description: " + "desc" + 
                "\n Year: " + 2018 + "\n Checked: " + false + "\n", nullDate.toString());
    }     
    
    @Test
    public void equalsTrueTest() {
        Book comp = new Book(1, "author", "title", "a52d253", "desc", 2018, false, new Date(5));
        assertTrue(book.equals(comp));
    }
    @Test
    public void equalsFalseTest() {
        Book not = new Book(3, "author1", "title2", "www4", "descr", 2015, true, new Date());
        assertFalse(book.equals(not));
    }
}
