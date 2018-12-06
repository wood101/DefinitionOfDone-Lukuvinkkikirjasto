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
import static org.junit.Assert.assertFalse;
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
        Video video1 = new Video("author1", "title", "www.test.org", "desc", 2000);
        Video video2 = new Video("author2", "title", "www.testAlt.org", "desc", 2000);
        List<ReadingTip> list = new ArrayList<>();
        list.add(video1);
        list.add(video2);

        when(db.listByType("all")).thenReturn(list);

        ui.run();
        String output = io.getOutputString();
        assertTrue(output.contains(video1.getAuthor()) && output.contains(video2.getTitle()));
    }

    @Test
    public void listVideosPrintsCorrectly() {
        io = new IOStub("l", "2", "q");
        ui = new UI(io, db);
        String author = "author1";
        String title = "title2";
        Video video1 = new Video(author, "title", "www.test.org", "desc", 2000);
        Video video2 = new Video("author2", title, "www.testAlt.org", "desc", 2000);
        List<ReadingTip> list = new ArrayList<>();
        list.add(video1);
        list.add(video2);
        when(db.listByType("video")).thenReturn(list);

        ui.run();
        String output = io.getOutputString();
        assertTrue(output.contains(author) && output.contains(title));
    }

    @Test
    public void listBooksPrintsCorrectly() {
        io = new IOStub("l", "3", "q");
        ui = new UI(io, db);
        String author = "author1";
        String title = "title2";
        Book book1 = new Book(author, "title", "1234", "desc", 2000);
        Book book2 = new Book("author2", title, "4321", "desc", 2000);
        List<ReadingTip> list = new ArrayList<>();
        list.add(book1);
        list.add(book2);

        when(db.listByType("book")).thenReturn(list);

        ui.run();
        String output = io.getOutputString();
        assertTrue(output.contains(author) && output.contains(title));

    }

    @Test
    public void listNewsPrintsCorrectly() {
        io = new IOStub("l", "4", "q");
        ui = new UI(io, db);
        String author = "author1";
        String title = "title2";
        News news1 = new News(author, "title", "www.test.org", "desc", "publisher", 2000);
        News news2 = new News("author2", title, "www.testAlt.org", "desc", "publisher", 2000);
        List<ReadingTip> list = new ArrayList<>();
        list.add(news1);
        list.add(news2);

        when(db.listByType("news")).thenReturn(list);

        ui.run();
        String output = io.getOutputString();
        assertTrue(output.contains(author) && output.contains(title));
    }

    @Test
    public void listArticlesPrintsCorrectly() {
        io = new IOStub("l", "5", "q");
        ui = new UI(io, db);
        String author = "author1";
        String title = "title2";
        Article article1 = new Article(author, "title", "www.test.org", "desc", "publisher", 2000);
        Article article2 = new Article("author2", title, "www.testAlt.org", "desc", "publisher", 2000);
        List<ReadingTip> list = new ArrayList<>();
        list.add(article1);
        list.add(article2);

        when(db.listByType("article")).thenReturn(list);

        ui.run();
        String output = io.getOutputString();
        assertTrue(output.contains(author) && output.contains(title));
    }

    @Test
    public void listBlogsPrintsCorrectly() {
        io = new IOStub("l", "6", "q");
        ui = new UI(io, db);
        String author = "author1";
        String title = "title2";
        Blog blog1 = new Blog(author, "title", "www.test.org", "desc", 2000);
        Blog blog2 = new Blog("author2", title, "www.testAlt.org", "desc", 2000);
        List<ReadingTip> list = new ArrayList<>();
        list.add(blog1);
        list.add(blog2);

        when(db.listByType("blog")).thenReturn(list);

        ui.run();
        String output = io.getOutputString();
        assertTrue(output.contains(author) && output.contains(title));
    }

    @Test
    public void singleBlogPrintsCorrectly() {
        io = new IOStub("l", "6", "s", "1", "q");
        ui = new UI(io, db);
        String author = "author1";
        String title = "title2";
        Blog blog1 = new Blog(author, "title", "www.test.org", "desc", 2000);
        Blog blog2 = new Blog("author2", title, "www.testAlt.org", "desc", 2000);
        List<ReadingTip> list = new ArrayList<>();
        list.add(blog1);
        list.add(blog2);

        when(db.listByType("blog")).thenReturn(list);

        ui.run();
        String output = io.getOutputString();
        assertTrue(output.contains(blog1.toString()));
    }

    @Test
    public void singleNewsPrintsCorrectly() {
        io = new IOStub("l", "4", "s", "2", "q");
        ui = new UI(io, db);
        String author = "author1";
        String title = "title2";
        News news1 = new News(author, "title", "www.test.org", "desc", "publisher", 2000);
        News news2 = new News("author2", title, "www.testAlt.org", "desc", "publisher", 2000);
        List<ReadingTip> list = new ArrayList<>();
        list.add(news1);
        list.add(news2);

        when(db.listByType("news")).thenReturn(list);

        ui.run();
        String output = io.getOutputString();
        assertTrue(output.contains(news2.toString()));
    }

    @Test
    public void givingWrongIndexForTipDoesNotShowTip() {
        io = new IOStub("l", "4", "s", "1234", "q");
        ui = new UI(io, db);
        String author = "author1";
        String title = "title2";
        News news1 = new News(author, "title", "www.test.org", "desc", "publisher", 2000);
        News news2 = new News("author2", title, "www.testAlt.org", "desc", "publisher", 2000);
        List<ReadingTip> list = new ArrayList<>();
        list.add(news1);
        list.add(news2);

        when(db.listByType("news")).thenReturn(list);

        ui.run();
        String output = io.getOutputString();
        assertFalse(output.contains(news2.toString()));
    }

    @Test
    public void addVideoUnsuccessfulWhenNonnumericalYearIsGiven() {
        io = new IOStub("a", "2", "title", "author", "1234", "desc", "f", "2000", "q");
        ui = new UI(io, db);

        ui.run();

        assertTrue(io.getOutputs().contains("Please type year as a number!"));
    }

    @Test
    public void addVideoUnsuccessfulWhenFutureYearIsGiven() {
        io = new IOStub("a", "2", "title", "author", "1234", "desc", "20000", "2000", "q");
        ui = new UI(io, db);

        ui.run();

        assertTrue(io.getOutputs().contains("Year cannot be in the future!"));
    }
    
    @Test
    public void noReadingTipsPrintedWhenDatabaseIsEmpty() {
        io = new IOStub("l", "1", "q");
        ui = new UI(io, db);
        List<ReadingTip> list = new ArrayList<>();
        when(db.listByType("all")).thenReturn(list);
        
        ui.run();
        String output = io.getOutputString();
        assertTrue(output.contains("No reading tips found."));
    }

}
