/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;

import ReadMe.ui.UI;
import ReadMe.database.Database;
import ReadMe.database.SQLiteDatabase;
import ReadMe.io.ConsoleIO;
import java.io.File;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ReadMe.domain.Blog;
import java.util.Date;

/**
 *
 * @author madjanne
 */
public class BlogDaoTest {

    private File testFile;
    private Database testDatabase;
    ConsoleIO testIo;
    private BlogDao testDao;
    
    public BlogDaoTest() {
    }

    @Before
    public void setUp() throws ClassNotFoundException {
        
        testFile = new File("testReadMeBase.db");
        testDatabase = new SQLiteDatabase("jdbc:sqlite:" + testFile.getAbsolutePath());
        testDao = new BlogDao(testDatabase);
        testIo = new ConsoleIO();
    }

    @After
    public void tearDown() {
        testFile.delete();
    }

    @Test
    public void isListingCorrect() {
        testDao.add(new Blog(1, "author", "title", "www", "desc", 2018, false, new Date(5)));
        testDao.add(new Blog(3, "author1", "title2", "www4", "descr", 2015, true, new Date(7)));
        
        List<Blog> blogs = testDao.listAll();
        
        assertEquals(2, blogs.size());
        assertEquals("title", blogs.get(0).getBlog_title());  
        assertEquals("descr", blogs.get(0).getBlog_description());  
    }
}
