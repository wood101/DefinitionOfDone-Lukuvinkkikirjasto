/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;
import ReadMe.domain.*;
import java.util.List;


/**
 * Interface for BookMark database access object. 
 * @author bisi
 */
public interface DaoManager {

    /**
     * Returns all reading tips based on input type. If type is "all" 
     * then all ReadingTips in the database are listed.
     * @param type the desired object
     * @return  List of all ReadingTips of the given type
     */
    List<ReadingTip> listByType(String type);
    
    public List<ReadingTip> listByKeyword(String keyword);
    
     /**
     * Adds a new Bookmark object to database
     * @param readTip Bookmark readTip
     */
    
    void addVideo(Video bookmark);
    
    void addBook(Book bookmark);
    
    void addNews(News bookmark);
    
    void addArticle(Article bookmark);
    
    void addBlog(Blog bookmark);
    
    boolean markAsRead(ReadingTip tip);
}
