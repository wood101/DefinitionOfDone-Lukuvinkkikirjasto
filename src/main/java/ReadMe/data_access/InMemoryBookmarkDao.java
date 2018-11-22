/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.data_access;



import java.util.ArrayList;
import java.util.List;
import ReadMe.classes.Bookmark;


public class InMemoryBookmarkDao implements BookmarkDao {
    
    private List<Bookmark> tips;

    public InMemoryBookmarkDao() {
        this.tips = new ArrayList<Bookmark>();
        tips.add(new Bookmark("Kakkakuutiot", "Tämä on tärkeää tietoa", "https://www.iltalehti.fi/terveysuutiset/a/71cb5062-ed6e-45a6-a22c-d0949daeaa6a"));
        tips.add(new Bookmark("Täydelliset joulutortut", "Näin teet täydellisen tortun", "https://www.iltalehti.fi/ruoka-artikkelit/a/556f9c4c-638b-4091-ab35-cb6e52e02555"));
        
    }

    @Override
    public List<Bookmark> listAll() {
        return tips;
    }

    @Override
    public void add(Bookmark readTip) {
        tips.add(readTip);
    }

    @Override
    public String toString() {
        String s = "";
        for(Bookmark rt : tips){
            s += rt + "\n";
        }
        return s;
    }
    
}
