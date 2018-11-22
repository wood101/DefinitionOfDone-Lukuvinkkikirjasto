/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.data_access;

import java.util.List;
import ReadMe.classes.Bookmark;


/**
 * Interface for BookMark database access object
 * @author bisi
 */
public interface BookmarkDao {

    /**
     * Returns all saved Bookmarks
     * @return List<Bookmark> List of saved Bookmarks
     */
    List<Bookmark> listAll();

    /**
     * Adds a new Bookmark object to database
     * @param readTip Bookmark readTip
     */
    void add(Bookmark readTip);
}
