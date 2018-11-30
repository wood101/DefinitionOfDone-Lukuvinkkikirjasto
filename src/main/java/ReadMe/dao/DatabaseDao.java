
package ReadMe.dao;

import ReadMe.dao.*;
import ReadMe.domain.*;

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

    public DatabaseDao(VideoDao videoDao, BookDao bookDao,
            NewsDao newsDao, ArticleDao articleDao, BlogDao blogDao) {
        this.videoDao = videoDao;
        this.bookDao = bookDao;
        this.newsDao = newsDao;
        this.articleDao = articleDao;
        this.blogDao = blogDao;
    }

    /**
     * Returns all wanted bookmarks as a printable String. Returns
     * the given object list as a String based on input.
     *
     * Inputs = "all", "video", "book", "news", "article", "blog".
     *
     * Method uses private toString methods.
     *
     * @return Bookmarks
     */
    @Override
    public String listByType(String type) {
        String s = "\n\n"; // returned string
        switch (type) {
            case "video":
                s += videosToString();
                break;
            case "book":
                s += booksToString();
                break;
            case "news":
                s += newsToString();
                break;

            case "article":
                s += articlesToString();
                break;

            case "blog":
                s += blogsToString();
                break;

            default:
                s += ("\n\n");
        }

        return s;
    }

    /**
     * Returns all bookmarks as a printable String.
     * only the given object list as a String.
     * Method uses private toString methods.
     *
     * @return Bookmarks
     */
    @Override
    public String listAll() {
        String s = "\n\n"; // returned string
        s += "All: \n\n";
        s += videosToString();
        s += booksToString();
        s += newsToString();
        s += articlesToString();
        s += blogsToString();
        return s;
    }

    private String videosToString() {
        String s = "";
        s += "Videos:\n";
        for (Video video : videoDao.listAll()) {
            s += (video.toString());
        }
        s += ("\n\n");
        return s;
    }

    private String booksToString() {
        String s = "";
        s += "Books:\n";
        for (Book book : bookDao.listAll()) {
            s += (book.toString());
        }
        s += ("\n\n");
        return s;
    }

    private String newsToString() {
        String s = "";
        s += "News:\n";
        for (News n : newsDao.listAll()) {
            s += (n.toString());
        }
        s += ("\n\n");
        return s;
    }

    private String articlesToString() {
        String s = "";
        s += "Articles:\n";
        for (Article article : articleDao.listAll()) {
            s += (article.toString());
        }
        s += ("\n\n");
        return s;
    }

    private String blogsToString() {
        String s = "";
        s += "Blogs:\n";
        for (Blog blog : blogDao.listAll()) {
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
}
