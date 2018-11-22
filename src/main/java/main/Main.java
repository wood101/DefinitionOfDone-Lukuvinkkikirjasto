package main;

import ReadMe.classes.UI;
import ReadMe.data_access.BookmarkDao;
import ReadMe.data_access.BookmarkDatabaseDao;
import ReadMe.data_access.Database;
import ReadMe.data_access.SQLiteDatabase;
import ReadMe.io.ConsoleIO;

/**
 *
 * @author bisi
 */
public class Main {

    /**
     * Creates an I/O object, UI object and runs the UI.
     * @param args
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Toimii");
        System.out.println("Niinpä!");
        System.out.println("branch test!");
        
        String databaseName = "readMeBase.db";
        Database db = new SQLiteDatabase("jdbc:sqlite:" + databaseName);
        BookmarkDao dao = new BookmarkDatabaseDao(db);
        ConsoleIO io = new ConsoleIO();
        UI ui = new UI(io, dao);
        ui.run();
    }
}
