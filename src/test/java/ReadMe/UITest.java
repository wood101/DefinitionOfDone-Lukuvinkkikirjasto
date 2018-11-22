/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe;

import ReadMe.classes.Bookmark;
import ReadMe.classes.UI;
import ReadMe.data_access.BookmarkDao;
import ReadMe.data_access.InMemoryBookmarkDao;
import ReadMe.io.ConsoleIO;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author hameha
 */
public class UITest {
    UI ui;
    ConsoleIO io;
    InMemoryBookmarkDao db;

    @Before
    public void setUp() {
        
        io = mock(ConsoleIO.class);
        db = mock(InMemoryBookmarkDao.class);
        ui = new UI(io, db);
    }

    @Test
    public void addBookmarkSuccessfulWhenTitleGiven() {
        Bookmark bookmark = new Bookmark("title", "desc", "www.test.org");
        
        when(io.readLine(""))
                .thenReturn("a")
                .thenReturn("title")
                .thenReturn("desc")
                .thenReturn("www.test.org")
                .thenReturn("q");
        ui.run();
        assertTrue(db.listAll().contains(bookmark));
    }
}
