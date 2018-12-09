/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;

import ReadMe.domain.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author obisi, hajame
 */
public class InMemoryDaoTest {

    private InMemoryDao dao;

    public InMemoryDaoTest() {
        this.dao = new InMemoryDao();
    }

    @Test
    public void videoIsAdded() {
        Video v = new Video("auth", "title", "link", "desc", 2010);
        dao.addVideo(v);
        assertEquals(v, dao.getVideos().get(1));
    }

    @Test
    public void bookIsAdded() {
        Book b = new Book("auth", "title", "ISBN", "desc", 2010);
        dao.addBook(b);
        assertEquals(b, dao.getBooks().get(1));
    }

    @Test
    public void articleIsAdded() {
        Article a = new Article("auth", "title", "link",
                "desc", "publisher", 2000);
        dao.addArticle(a);
        assertEquals(a, dao.getArticles().get(1));
    }

    @Test
    public void newsIsAdded() {
        News n = new News("auth", "title", "link",
                "desc", "publisher", 2000);
        dao.addNews(n);
        assertEquals(n, dao.getNews().get(1));
    }

    @Test
    public void blogIsAdded() {
        Blog b = new Blog("auth", "title", "link", "desc", 2010);
        dao.addBlog(b);
        assertEquals(b, dao.getBlogs().get(1));
    }

    @Test
    public void isListAllCorrect() {
        assertTrue(dao.getVideos().get(0).getAuthor().equals("hackerdashery"));
        assertTrue(dao.getBlogs().get(0).getAuthor().equals("hackerdashery4"));

    }

    @Test
    public void isListVideosCorrect() {
        assertTrue(dao.getVideos().get(0).getAuthor().equals("hackerdashery"));
    }

    @Test
    public void markAsReadWorks() {
        Blog b = new Blog("auth", "title", "link", "desc", 2010);
        dao.addBlog(b);
        News n = new News("auth", "title", "link", "desc", "publisher", 2000);
        dao.addNews(n);
        assertTrue(dao.markAsRead(b));
        assertTrue(dao.markAsRead(n));
    }

    @Test
    public void markAsReadReturnsFalseIfNotFound() {
        Blog b = new Blog("auth", "title", "link", "desc", 2010);
        assertFalse(dao.markAsRead(b));
        assertFalse(dao.markAsRead(null));
    }
}
