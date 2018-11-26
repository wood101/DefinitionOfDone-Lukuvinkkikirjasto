/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;

import ReadMe.domain.Article;
import ReadMe.domain.Blog;
import ReadMe.domain.Book;
import java.util.List;
import ReadMe.domain.Bookmark;
import ReadMe.domain.News;
import ReadMe.domain.Video;


/**
 * Interface for BookMark database access object. 
 * @author bisi
 */
public interface DaoManager {

    /**
     * Returns all saved Bookmarks
     * @return List<Bookmark> List of saved Bookmarks
     */
    String listAll(String type);

    /**
     * Adds a new Bookmark object to database
     * @param readTip Bookmark readTip
     */
    
    void addVideo(Video bookmark);
    
    void addBook(Book bookmark);
    
    void addNews(News bookmark);
    
    void addArticle(Article bookmark);
    
    void addBlog(Blog bookmark);
}
