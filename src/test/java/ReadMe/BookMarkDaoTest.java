/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe;

import ReadMe.classes.UI;
import ReadMe.data_access.BookmarkDao;
import ReadMe.data_access.BookmarkDatabaseDao;
import ReadMe.data_access.Database;
import ReadMe.data_access.SQLiteDatabase;
import ReadMe.io.ConsoleIO;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apndx
 */
public class BookMarkDaoTest {

    private File testFile;
    private Database testDatabase;
    private UI testUi;
    
    public BookMarkDaoTest() {
    }

    @Before
    public void setUp() throws ClassNotFoundException {
        
        testFile = new File("testReadMeBase.db");

        testDatabase = new SQLiteDatabase("jdbc:sqlite:" + testFile.getAbsolutePath());
        BookmarkDao dao = new BookmarkDatabaseDao(testDatabase);
        ConsoleIO io = new ConsoleIO();
        testUi = new UI(io, dao);

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

 

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
