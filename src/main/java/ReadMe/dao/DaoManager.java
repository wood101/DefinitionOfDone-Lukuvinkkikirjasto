/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;

import java.util.List;
import ReadMe.domain.Bookmark;


/**
 * Interface for BookMark database access object. 
 * @author bisi
 */
public interface DaoManager {

    /**
     * Returns all saved Bookmarks
     * @return List<Bookmark> List of saved Bookmarks
     */
    List<String> listAll(String type);

    /**
     * Adds a new Bookmark object to database
     * @param readTip Bookmark readTip
     */
    
    void addVideo(Video bookmark);
    
    void addBook(Book bookmark);
    
    void addNews(News bookmark);
    
    void addArticle(Article bookmark);
    
    void add(Blog bookmark);
}
