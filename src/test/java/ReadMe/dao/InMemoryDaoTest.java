/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;

import ReadMe.dao.InMemoryDao;
import ReadMe.domain.Article;
import ReadMe.domain.Blog;
import ReadMe.domain.Book;
import ReadMe.domain.News;
import ReadMe.domain.Video;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bisi
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
       assertEquals(b, dao.getBooks().get(0));
    }
    
    @Test
    public void articleIsAdded() {
       Article a = new Article("auth", "title", "link", 
               "desc", "publisher", 2000);
       dao.addArticle(a);
       assertEquals(a, dao.getArticles().get(0));
    }
    
    @Test
    public void newsIsAdded() {
        News n = new News("auth", "title", "link", 
                "desc", "publisher", 2000);
        dao.addNews(n);
        assertEquals(n, dao.getNews().get(0));
    }
    
    @Test
    public void blogIsAdded() {
       Blog b = new Blog("auth", "title", "link", "desc", 2010);
       dao.addBlog(b);
       assertEquals(b, dao.getBlogs().get(0));
    }
    
    
    @Test
    public void isListAllCorrect() {
       String s = "All: \n\n" + "Videos:\n" + dao.getVideos().toString() 
               + "\n\n" + "Books:\n" + "\n\n" + "News:\n" + "\n\n" + "Articles:\n" + "\n\n" + "Blogs:\n" + "\n\n";
       assertEquals(dao.listAll("all"), s);
    }
    
    @Test
    public void isListVideosCorrect() {
        String s = "Videos:\n" + dao.getVideos().toString() + "\n\n";
        assertEquals(dao.listAll("video"), s);
       
    }
    
    
}
