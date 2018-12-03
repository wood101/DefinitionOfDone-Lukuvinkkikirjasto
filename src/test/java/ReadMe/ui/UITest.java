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
import ReadMe.domain.ReadingTip;
import ReadMe.domain.Video;
import ReadMe.io.ConsoleIO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
    
    @Test
    public void addVideoSuccessfulWhenCorrectInputIsGiven() {
        io = new IOStub("a", "1", "title", "author", "www.test.org", "desc", "2000", "q");
        ui = new UI(io, db);
        Video video = new Video("author", "title", "desc", "www.test.org", 2000);
        
        ui.run();
        
        assertTrue(io.getOutputs().contains("Tip added!\n\n"));
        verify(db).addVideo(any());
        verify(db, times(1)).addVideo(any());
    }
    
    @Test
    public void addBookSuccessfulWhenCorrectInputIsGiven() {
        io = new IOStub("a", "2", "title", "author", "1234", "desc", "2000", "q");
        ui = new UI(io, db);
        Book book = new Book("author", "title", "1234", "desc", 2000);
        
        ui.run();

        assertTrue(io.getOutputs().contains("Tip added!\n\n"));
        verify(db).addBook(any());
        verify(db, times(1)).addBook(any());
    }
    
    @Test
    public void addNewsSuccessfulWhenCorrectInputIsGiven() {
        io = new IOStub("a", "3", "title", "author", "www.test.org", "desc", "publisher", "2000", "q");
        ui = new UI(io, db);
        News news = new News("author", "title", "www.test.org", "desc", "publisher", 2000);
        
        ui.run();

        assertTrue(io.getOutputs().contains("Tip added!\n\n"));
        verify(db).addNews(any());
        verify(db, times(1)).addNews(any());
    }
    
    @Test
    public void addArticleSuccessfulWhenCorrectInputIsGiven() {
        io = new IOStub("a", "4", "title", "author", "www.test.org", "desc", "publisher", "2000", "q");
        ui = new UI(io, db);
        Article article = new Article("author", "title", "www.test.org", "desc", "publisher", 2000);
        
        ui.run();

        assertTrue(io.getOutputs().contains("Tip added!\n\n"));
        verify(db).addArticle(any());
        verify(db, times(1)).addArticle(any());
    }
    
    @Test
    public void addBlogSuccessfulWhenCorrectInputIsGiven() {
        io = new IOStub("a", "5", "title", "author", "www.test.org", "desc", "2000", "q");
        ui = new UI(io, db);
        Blog blog = new Blog("author", "title", "www.test.org", "desc", 2000);
        
        ui.run();

        assertTrue(io.getOutputs().contains("Tip added!\n\n"));
        verify(db).addBlog(any());
        verify(db, times(1)).addBlog(any());
    }

    @Test
    public void listAllPrintsCorrectly() {
        io = new IOStub("l", "1", "q");
        ui = new UI(io, db);
        Video video1 = new Video("author", "title", "www.test.org", "desc", 2000);
        Video video2 = new Video("author", "title", "www.testAlt.org", "desc", 2000);
        String tips = "";
        tips += "Videos:\n";
        tips += video1.toString();
        tips += "\n\n";
        tips += video2.toString();
        
        when(db.listAll()).thenReturn(tips);
        
        ui.run();

        assertTrue(io.getOutputs().contains(tips));
    }
    
    @Test
    public void listVideosPrintsCorrectly() {
        io = new IOStub("l", "2", "q");
        ui = new UI(io, db);
        Video video1 = new Video("author", "title", "www.test.org", "desc", 2000);
        Video video2 = new Video("author", "title", "www.testAlt.org", "desc", 2000);
        String tips = "";
        tips += "Videos:\n";
        tips += video1.toString();
        tips += "\n\n";
        tips += video2.toString();
        
        when(db.listByType("video")).thenReturn(tips);
        
        ui.run();

        assertTrue(io.getOutputs().contains(tips));
    }
    
    @Test
    public void listBooksPrintsCorrectly() {
        io = new IOStub("l", "3", "q");
        ui = new UI(io, db);
        Book book1 = new Book("author", "title", "1234", "desc", 2000);
        Book book2 = new Book("author", "title", "4321", "desc", 2000);
        String tips = "";
        tips += "Books:\n";
        tips += book1.toString();
        tips += "\n\n";
        tips += book2.toString();
        
        when(db.listByType("book")).thenReturn(tips);
        
        ui.run();

        assertTrue(io.getOutputs().contains(tips));
    }
    
    @Test
    public void listNewsPrintsCorrectly() {
        io = new IOStub("l", "4", "q");
        ui = new UI(io, db);
        News news1 = new News("author", "title", "www.test.org", "desc", "publisher", 2000);
        News news2 = new News("author", "title", "www.testAlt.org", "desc", "publisher", 2000);
        
        String tips = "";
        tips += "News:\n";
        tips += news1.toString();
        tips += "\n\n";
        tips += news2.toString();
        
        when(db.listByType("news")).thenReturn(tips);
        
        ui.run();

        assertTrue(io.getOutputs().contains(tips));
    }
    
    @Test
    public void listArticlesPrintsCorrectly() {
        io = new IOStub("l", "5", "q");
        ui = new UI(io, db);
        Article article1 = new Article("author", "title", "www.test.org", "desc", "publisher", 2000);
        Article article2 = new Article("author", "title", "www.testAlt.org", "desc", "publisher", 2000);
        
        String tips = "";
        tips += "Articles:\n";
        tips += article1.toString();
        tips += "\n\n";
        tips += article2.toString();
        
        when(db.listByType("article")).thenReturn(tips);
        
        ui.run();

        assertTrue(io.getOutputs().contains(tips));
    }
    
    @Test
    public void listBlogsPrintsCorrectly() {
        io = new IOStub("l", "6", "q");
        ui = new UI(io, db);
        Blog blog1 = new Blog("author", "title", "www.test.org", "desc", 2000);
        Blog blog2 = new Blog("author", "title", "www.testAlt.org", "desc", 2000);
        
        String tips = "";
        tips += "Blogs:\n";
        tips += blog1.toString();
        tips += "\n\n";
        tips += blog2.toString();
        
        when(db.listByType("blog")).thenReturn(tips);
        
        ui.run();

        assertTrue(io.getOutputs().contains(tips));
    }

    @Test
    public void summaryTableViewPrintsCorrectly() {
        io = new IOStub();
        List<ReadingTip> tips = new ArrayList<>();
        ReadingTip blog = new Blog(1, "author", "title", "www.test.org", "desc", 2000, false, new Date(5));
        ReadingTip article = new Article(2, "hack", "cook chicken", "www.test.org", "desc", "publisher", 2000, false, new Date(5));
        ReadingTip news = new News(3, "writer", "chicken is not good", "www.test.org", "desc", "publisher", 2000, false, new Date(5));
        tips.add(news);
        tips.add(blog);
        tips.add(article);
        
        String expectedOutput = "";
        expectedOutput += String.format("+-----+-----------------+----------------------+---------+%n");
        expectedOutput += String.format("| ID  |     Author      |        Title         |  Type   |%n");
        expectedOutput += String.format("+-----+-----------------+----------------------+---------+%n");
        expectedOutput += String.format("| 3   | writer          | chicken is not good  | News    |%n");
        expectedOutput += String.format("| 1   | author          | title                | Blog    |%n");
        expectedOutput += String.format("| 2   | hack            | cook chicken         | Article |%n");
        expectedOutput += String.format("+-----+-----------------+----------------------+---------+%n");
        
        assertEquals(io.summaryTableView(tips), expectedOutput);
    }
}
