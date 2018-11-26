/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.ui;

import ReadMe.IOStub;
import ReadMe.domain.Bookmark;
import ReadMe.ui.UI;
import ReadMe.dao.InMemoryDao;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author peje
 */
public class UITest {

    UI ui;
    IOStub io;
    InMemoryDao db;

    @Before
    public void setUp() {
        db = mock(InMemoryDao.class);
    }

    @Test
    public void addBookmarkSuccessfulWhenTitleGiven() {
        io = new IOStub("a", "title", "desc", "www.test.org", "q");
        ui = new UI(io, db);
        Bookmark bookmark = new Bookmark("title", "desc", "www.test.org");
        
        ui.run();

        assertTrue(io.getOutputs().contains("Tip added!\n\n"));
    }
    
    @Test
    public void listBookmarksPrintsBookmarksCorrectly() {
        io = new IOStub("l", "q");
        ui = new UI(io, db);
        Bookmark b1 = new Bookmark("title", "desc", "www.test.org");
        Bookmark b2 = new Bookmark("title2", "desc2", "www.test2.org");
        ArrayList<Bookmark> tips = new ArrayList<>();
        tips.add(b1);
        tips.add(b2);
        
        when(db.listAll()).thenReturn(tips);
        
        ui.run();

        assertTrue(io.getOutputs().contains(b1.toString()));
        assertTrue(io.getOutputs().contains(b2.toString()));
    }
}
