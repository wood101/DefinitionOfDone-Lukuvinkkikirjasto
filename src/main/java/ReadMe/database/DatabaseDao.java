/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.database;

import ReadMe.dao.*;
import java.util.List;

/**
 * Class that manages DAO Objects.
 * 
 * @author hameha
 */
public class DatabaseDao implements DaoManager {
    private VideoDao videoDao;
    private BookDao bookDao;
    private NewsDao newsDao;
    private ArticleDao articleDao;
    private BlogDao blogDao;

    @Override
    public String listAll(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addVideo(Video bookmark) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addBook(Book bookmark) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNews(News bookmark) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addArticle(Article bookmark) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addBlog(Blog bookmark) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
