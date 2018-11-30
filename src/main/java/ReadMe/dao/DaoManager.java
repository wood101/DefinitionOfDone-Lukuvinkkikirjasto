/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;
import ReadMe.domain.*;


/**
 * Interface for BookMark database access object. 
 * @author bisi
 */
public interface DaoManager {

    /**
     * Returns all saved Bookmarks
     * @return List<String> List of saved Bookmarks
     */
    String listAll();

    /**
     * Returns all data as a string based on input type.
     * @param type the desired object
     * @return  String of all data of the given type
     */
    String listByType(String type);
    
     /**
     * Adds a new Bookmark object to database
     * @param readTip Bookmark readTip
     */
    
    void addVideo(Video bookmark);
    
    void addBook(Book bookmark);
    
    void addNews(News bookmark);
    
    void addArticle(Article bookmark);
    
    void addBlog(Blog bookmark);
    
    boolean markAsRead(String type, String title);
}
