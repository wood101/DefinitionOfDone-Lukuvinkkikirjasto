package ReadMe.main;

import ReadMe.ui.UI;
import ReadMe.database.BookmarkDatabaseDao;
import ReadMe.database.Database;
import ReadMe.database.SQLiteDatabase;
import ReadMe.io.ConsoleIO;
import ReadMe.dao.DaoManager;

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
        
        String databaseName = "readMeBase.db";
        Database db = new SQLiteDatabase("jdbc:sqlite:" + databaseName);
        DaoManager dao = new BookmarkDatabaseDao(db);
        ConsoleIO io = new ConsoleIO();
        UI ui = new UI(io, dao);
        ui.run();
    }
}
