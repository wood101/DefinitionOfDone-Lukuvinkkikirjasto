/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;

import ReadMe.domain.Bookmark;
import ReadMe.ui.UI;
import ReadMe.database.BookmarkDatabaseDao;
import ReadMe.database.Database;
import ReadMe.database.SQLiteDatabase;
import ReadMe.io.ConsoleIO;
import java.io.File;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ReadMe.dao.DaoManager;

/**
 *
 * @author apndx
 */
public class BookMarkDaoTest {

    private File testFile;
    private Database testDatabase;
    private UI testUi;
    ConsoleIO testIo;
    private DaoManager testDao;
    
    public BookMarkDaoTest() {
    }

    @Before
    public void setUp() throws ClassNotFoundException {
        
        testFile = new File("testReadMeBase.db");
        testDatabase = new SQLiteDatabase("jdbc:sqlite:" + testFile.getAbsolutePath());
        testDao = new BookmarkDatabaseDao(testDatabase);
        testIo = new ConsoleIO();
        testUi = new UI(testIo, testDao);

    }

    @After
    public void tearDown() {
        testFile.delete();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void isListingCorrect() {
        testDao.add(new Bookmark("Vinkki", "Mitä vinkki on", "https://en.wiktionary.org/wiki/vinkki"));
        testDao.add(new Bookmark("Tip", "What is a tip", "https://dictionary.cambridge.org/dictionary/english/tip"));
        
        List<Bookmark> bookmarks = testDao.listAll();
        
        assertEquals(2, bookmarks.size());
        assertEquals("Vinkki", bookmarks.get(0).getTitle());  
        assertEquals("What is a tip", bookmarks.get(1).getDescription());  
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
