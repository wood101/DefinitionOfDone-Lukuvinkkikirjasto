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
import ReadMe.domain.Book;
import java.util.Date;

/**
 *
 * @author madjanne
 */
public class BookDaoTest {

    private File testFile;
    private Database testDatabase;
    ConsoleIO testIo;
    private BookDao testDao;
    
    public BookDaoTest() {
    }

    @Before
    public void setUp() throws ClassNotFoundException {
        
        testFile = new File("testReadMeBase.db");
        testDatabase = new SQLiteDatabase("jdbc:sqlite:" + testFile.getAbsolutePath());
        testDao = new BookDao(testDatabase);
        testIo = new ConsoleIO();
    }

    @After
    public void tearDown() {
        testFile.delete();
    }

    @Test
    public void isListingCorrect() {
        testDao.add(new Book(1, "author", "title", "5F3D3", "desc", 2018, false, new Date(5)));
        testDao.add(new Book(3, "author1", "title2", "ASD214214", "descr", 2015, true, new Date(7)));
        
        List<Book> books = testDao.listAll();
        
        assertEquals(2, books.size());
        assertEquals("title", books.get(0).getBook_title());  
        assertEquals("desc", books.get(0).getBook_description());  
    }
}
