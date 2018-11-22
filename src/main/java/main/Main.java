package main;

import ReadMe.classes.UI;
import ReadMe.data_access.BookmarkDatabaseDao;
import ReadMe.data_access.SQLiteDatabase;
import ReadMe.io.ConsoleIO;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
     private SQLiteDatabase database;
//      private BookmarkDatabaseDao bookmarkDao;
      
    public static void main(String[] args) throws Exception {
        System.out.println("Toimii");
        System.out.println("Niinpä!");
        System.out.println("branch test!");
        
 //       init();
//        ConsoleIO io = new ConsoleIO();
//        UI ui = new UI(io);
//        ui.run();

  //alustusmetodi init hakee tietokantaosoitteen ja luo käytettävät DAO:t ja injektoi ne sovelluslogiikalle:
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        try {
            String usedDatabase = properties.getProperty("usedDatabase");
        database = new SQLiteDatabase(usedDatabase);
        } catch (Exception ex) {
        }
        
        //luo tietokantataulut if not exist
        database.init();

        BookmarkDatabaseDao bookmarkDao = new  BookmarkDatabaseDao(database);
            ConsoleIO io = new ConsoleIO();
        UI ui = new UI(io, bookmarkDao);
        ui.run();
    }
    
//    public static void init() throws IOException, Exception {
//
//        //alustusmetodi init hakee tietokantaosoitteen ja luo käytettävät DAO:t ja injektoi ne sovelluslogiikalle:
//        Properties properties = new Properties();
//        properties.load(new FileInputStream("config.properties"));
//        try {
//            String usedDatabase = properties.getProperty("usedDatabase");
//        database = new SQLiteDatabase(usedDatabase);
//        } catch (Exception ex) {
//        }
//        
//        //luo tietokantataulut if not exist
//        database.init();
//
//        BookmarkDatabaseDao bookmarkDao = new  BookmarkDatabaseDao(database);
//            ConsoleIO io = new ConsoleIO();
//        UI ui = new UI(io, bookmarkDao);
//        ui.run();
//
//    
//    }
}
