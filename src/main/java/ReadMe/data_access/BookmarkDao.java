/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.data_access;

import java.util.List;
import ReadMe.classes.Bookmark;


/**
 *
 * @author bisi
 */
public interface BookmarkDao {
    List<Bookmark> listAll();
    void add(Bookmark readTip);
}
