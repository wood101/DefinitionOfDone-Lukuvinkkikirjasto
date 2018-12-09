package ReadMe.main;

import ReadMe.dao.*;
import ReadMe.database.Database;
import ReadMe.database.SQLiteDatabase;
import ReadMe.io.ConsoleIO;
import ReadMe.ui.UI;

/**
 * @author bisi
 */
public class Main {

    /**
     * Creates an I/O object, UI object and runs the UI.
     *
     * @param args
     */
    public static void main(String[] args) {

        String databaseName = "readMeBase.db";
        Database db = new SQLiteDatabase("jdbc:sqlite:" + databaseName);
        VideoDao video = new VideoDao(db);
        BookDao book = new BookDao(db);
        NewsDao news = new NewsDao(db);
        ArticleDao article = new ArticleDao(db);
        BlogDao blog = new BlogDao(db);
        DaoManager dao = new DatabaseDao(video, book, news, article, blog);
        ConsoleIO io = new ConsoleIO();
        UI ui = new UI(io, dao);
        ui.run();
    }
}
