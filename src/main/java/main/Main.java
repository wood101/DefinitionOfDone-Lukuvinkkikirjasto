package main;

import ReadMe.classes.UI;
import ReadMe.data_access.BookmarkDao;
import ReadMe.data_access.InMemoryBookmarkDao;
import ReadMe.io.ConsoleIO;
import ReadMe.io.IO;

public class Main {
    public static void main(String[] args) {
        System.out.println("Toimii");
        System.out.println("Niinpä!");
        
        IO io = new ConsoleIO();
        BookmarkDao db = new InMemoryBookmarkDao();
        UI ui = new UI(io, db);
        ui.run();

    }
}
