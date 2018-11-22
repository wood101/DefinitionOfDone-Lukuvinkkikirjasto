/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.classes;




import ReadMe.data_access.BookmarkDao;
import ReadMe.data_access.BookmarkDatabaseDao;
import ReadMe.data_access.InMemoryBookmarkDao;
import ReadMe.data_access.SQLiteDatabase;
import ReadMe.io.IO;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


/**
 *
 * @author bisi
 */
public class UI {
    private IO io;  
    private   SQLiteDatabase database;
    private BookmarkDao bookmarkDao;

    public UI(IO io,BookmarkDao bookmarkDao) {
        this.io = io;
       this.bookmarkDao = bookmarkDao;
     ;
    }
    
    
    //lisätty by viku

    public void init() throws IOException, Exception {

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

    
    }
    
    
   
        
    public Bookmark addBookmark(){
        String headline = io.readLine("Enter headline: ");
        String description = io.readLine("Enter description: ");
        String link = io.readLine("Enter link: ");
        return new Bookmark(headline, description, link);
    }
    public void listBookmarks(){
        List<Bookmark> tips = bookmarkDao.listAll();
        for (Bookmark rt : tips) {
            io.print(rt.toString());
        }
    }
    
    
    
    public void run(){
        this.io = io;
        io.print("Welcome to ReadTipper!\n\n");
        String choice = "";
        while(!choice.equals("q")) {
            io.print("Choose a to add new readtip, l to list all tips, q to quit app:");
            choice = io.readLine("Enter choice: ");
            switch (choice) {
                case "a":
                    System.out.println("Adding a new ReadTip!:\n\n");
                    bookmarkDao.add(addBookmark());
                    System.out.println("Tip added!\n\n");
                    break;
                case "l":
                    System.out.println("All added tips: \n");
                    listBookmarks();
                    System.out.println("\n\n");
                    break;
                case "q":
                    break;
                default:
                    io.print("Choose a correct input!");
            }
            
        }
        System.out.println("Thank you!");
        
        
    }
    

    
}
