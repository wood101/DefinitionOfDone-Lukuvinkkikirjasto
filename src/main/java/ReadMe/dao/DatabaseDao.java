package ReadMe.dao;

import ReadMe.dao.*;
import ReadMe.domain.*;
import java.util.ArrayList;
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
    int amountOfLists = 5;

    public DatabaseDao(VideoDao videoDao, BookDao bookDao,
            NewsDao newsDao, ArticleDao articleDao, BlogDao blogDao) {
        this.videoDao = videoDao;
        this.bookDao = bookDao;
        this.newsDao = newsDao;
        this.articleDao = articleDao;
        this.blogDao = blogDao;
    }

    /**
     * Returns all wanted bookmarks as a printable String. Returns the given
     * object list as a String based on input.
     *
     * Inputs = "all", "video", "book", "news", "article", "blog".
     *
     * Method uses private toString methods.
     *
     * @return Bookmarks
     */
    @Override
    public List<ReadingTip> listByType(String type) {
        ArrayList<ReadingTip> list = new ArrayList<>();
        switch (type) {
            case "all":  
                videoDao.listAll().forEach(a -> list.add(a));
                bookDao.listAll().forEach(a -> list.add(a));
                newsDao.listAll().forEach(a -> list.add(a));
                articleDao.listAll().forEach(a -> list.add(a));
                blogDao.listAll().forEach(a -> list.add(a));
                return list;
            case "video":
                return videoDao.listAll();
            case "book":
                return bookDao.listAll();
            case "news":
               return newsDao.listAll();
            case "article":
                return articleDao.listAll();
            case "blog":
               return blogDao.listAll();
            default:
                return null;
        }
    }

    private String videosToString() {
        String s = "";
        s += "Videos:\n";
        for (ReadingTip video : videoDao.listAll()) {
            s += (video.toString());
        }
        s += ("\n\n");
        return s;
    }

    private String booksToString() {
        String s = "";
        s += "Books:\n";
        for (ReadingTip book : bookDao.listAll()) {
            s += (book.toString());
        }
        s += ("\n\n");
        return s;
    }

    private String newsToString() {
        String s = "";
        s += "News:\n";
        for (ReadingTip n : newsDao.listAll()) {
            s += (n.toString());
        }
        s += ("\n\n");
        return s;
    }

    private String articlesToString() {
        String s = "";
        s += "Articles:\n";
        for (ReadingTip article : articleDao.listAll()) {
            s += (article.toString());
        }
        s += ("\n\n");
        return s;
    }

    private String blogsToString() {
        String s = "";
        s += "Blogs:\n";
        for (ReadingTip blog : blogDao.listAll()) {
            s += (blog.toString());
        }
        s += ("\n\n");
        return s;
    }

    @Override
    public void addVideo(Video video) {
        videoDao.add(video);
    }

    @Override
    public void addBook(Book book) {
        bookDao.add(book);
    }

    @Override
    public void addNews(News news) {
        newsDao.add(news);
    }

    @Override
    public void addArticle(Article article) {
        articleDao.add(article);
    }

    @Override
    public void addBlog(Blog blog) {
        blogDao.add(blog);
    }

    /**
     * Marks selected title as read.
     * 
     * @param type
     * @param title
     * @return true is marking is successful
     */
    public boolean markAsRead(String type, String title) {
        switch (type) {
            case "video":
                return false;
            case "book":
                return false;
            case "news":
                return false;
            case "article":
                return articleDao.markAsRead(title);
            case "blog":
                return false;
            default:
                return false;
        }
    }
   

    
}
