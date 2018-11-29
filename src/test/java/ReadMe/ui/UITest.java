/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.ui;

import ReadMe.io.IOStub;
import ReadMe.ui.UI;
import ReadMe.dao.InMemoryDao;
import ReadMe.domain.Article;
import ReadMe.domain.Blog;
import ReadMe.domain.Book;
import ReadMe.domain.News;
import ReadMe.domain.Video;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
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

//    @Test
//    public void addBookmarkSuccessfulWhenTitleGiven() {
//        io = new IOStub("a", "title", "desc", "www.test.org", "q");
//        ui = new UI(io, db);
//        Bookmark bookmark = new Bookmark("title", "desc", "www.test.org");
//        
//        ui.run();
//
//        assertTrue(io.getOutputs().contains("Tip added!\n\n"));
//    }
    
    @Test
    public void addVideoSuccessfulWhenCorrectInputIsGiven() {
        io = new IOStub("a", "1", "title", "author", "www.test.org", "desc", "2000", "q");
        ui = new UI(io, db);
        Video video = new Video("author", "title", "desc", "www.test.org", 2000);
        
        ui.run();

        assertTrue(io.getOutputs().contains("Tip added!\n\n"));
        verify(db).addVideo(eq(video));
    }
    
    @Test
    public void addBookSuccessfulWhenCorrectInputIsGiven() {
        io = new IOStub("a", "2", "title", "author", "1234", "desc", "2000", "q");
        ui = new UI(io, db);
        Book book = new Book("author", "title", "1234", "desc", 2000);
        
        ui.run();

        assertTrue(io.getOutputs().contains("Tip added!\n\n"));
        verify(db).addBook(eq(book));
    }
    
    @Test
    public void addNewsSuccessfulWhenCorrectInputIsGiven() {
        io = new IOStub("a", "3", "title", "author", "www.test.org", "desc", "publisher", "2000", "q");
        ui = new UI(io, db);
        News news = new News("author", "title", "www.test.org", "desc", "publisher", 2000);
        
        ui.run();

        assertTrue(io.getOutputs().contains("Tip added!\n\n"));
        verify(db).addNews(eq(news));
    }
    
    @Test
    public void addArticleSuccessfulWhenCorrectInputIsGiven() {
        io = new IOStub("a", "4", "title", "author", "www.test.org", "desc", "publisher", "2000", "q");
        ui = new UI(io, db);
        Article article = new Article("author", "title", "www.test.org", "desc", "publisher", 2000);
        
        ui.run();

        assertTrue(io.getOutputs().contains("Tip added!\n\n"));
        verify(db).addArticle(eq(article));
    }
    
    @Test
    public void addBlogSuccessfulWhenCorrectInputIsGiven() {
        io = new IOStub("a", "5", "title", "author", "www.test.org", "desc", "2000", "q");
        ui = new UI(io, db);
        Blog blog = new Blog("author", "title", "www.test.org", "desc", 2000);
        
        ui.run();

        assertTrue(io.getOutputs().contains("Tip added!\n\n"));
        verify(db).addBlog(eq(blog));
    }
    
//    @Test
//    public void listBookmarksPrintsBookmarksCorrectly() {
//        io = new IOStub("l", "q");
//        ui = new UI(io, db);
//        Bookmark b1 = new Bookmark("title", "desc", "www.test.org");
//        Bookmark b2 = new Bookmark("title2", "desc2", "www.test2.org");
//        ArrayList<Bookmark> tips = new ArrayList<>();
//        tips.add(b1);
//        tips.add(b2);
//        
//        when(db.listAll()).thenReturn(tips);
//        
//        ui.run();
//
//        assertTrue(io.getOutputs().contains(b1.toString()));
//        assertTrue(io.getOutputs().contains(b2.toString()));
//    }
}
