/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;

import ReadMe.database.Database;
import ReadMe.database.SQLiteDatabase;
import ReadMe.io.ConsoleIO;
import java.io.File;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ReadMe.domain.Article;
import ReadMe.domain.ReadingTip;
import java.util.Date;

/**
 *
 * @author madjanne, hajame, obisi
 */
public class ArticleDaoTest {

    private File testFile;
    private Database testDatabase;
    ConsoleIO testIo;
    private ArticleDao testDao;

    public ArticleDaoTest() {
    }

    /**
     * Creates new testFile, testDatabase, Article DAO and ConsoleIO for testing
     */
    @Before
    public void setUp() throws ClassNotFoundException {
        
        testFile = new File("testReadMeBase.db");
        testDatabase = new SQLiteDatabase("jdbc:sqlite:" + testFile.getAbsolutePath());
        testDao = new ArticleDao(testDatabase);
        testIo = new ConsoleIO();
    }
     /**
     * Deletes testFile
     */
    @After
    public void tearDown() {
        testFile.delete();
    }
  
    /**
     * Tests if listing All gives correct output 
     */
    @Test
    public void isListingCorrect() {
        testDao.add(new Article(1, "author", "title", "www", "desc", "otava", 2018, false, new Date(5)));
        testDao.add(new Article(3, "author1", "title2", "www4", "descr", "penguin", 2015, true, new Date(7)));
        
        List<ReadingTip> articles = testDao.listAll();       
        assertEquals(2, articles.size());
        assertEquals("title", articles.get(0).getTitle());  
        assertEquals("desc", articles.get(0).getDescription());  
    }
    
     /**
     * Tests if marking as read works
     */
    @Test
    public void markAsReadWorks() {
        testDao.add(new Article(1, "author", "title", "www", "desc", "otava", 2018, false, null));
        testDao.markAsRead("title");
        
        assertTrue(testDao.listAll().get(0).isChecked());
        assertNotNull(testDao.listAll().get(0).getDate_checked());
    }
}
