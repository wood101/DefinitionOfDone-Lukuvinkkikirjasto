package ReadMe.dao;

import ReadMe.domain.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
     * Returns all wanted bookmarks as a List.
     *
     * Inputs = "all", "video", "book", "news", "article", "blog".
     *
     * @param type of the bookmark
     * @return List<ReadingTip>
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

    /**
     * Returns all wanted bookmarks as a List, searches them by a key work
     *
     * @param keyword
     * @return List<ReadingTip>
     */
    @Override
    public List<ReadingTip> listByKeyword(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        List<ReadingTip> all = listByType("all");
        return all.stream()
                .filter(t -> {
                    String tipAsString = t.toString().toLowerCase();
                    return tipAsString.contains(lowerKeyword);
                })
                .collect(Collectors.toList());
    }

    /**
     * Adds a Video
     *
     * @param video to be added
     */
    @Override
    public void addVideo(Video video) {
        videoDao.add(video);
    }

    /**
     * Adds a Book
     *
     * @param book to be added
     */
    @Override
    public void addBook(Book book) {
        bookDao.add(book);
    }

    /**
     * Adds a News
     *
     * @param news to be added
     */
    @Override
    public void addNews(News news) {
        newsDao.add(news);
    }

    /**
     * Adds an Article
     *
     * @param article to be added
     */
    @Override
    public void addArticle(Article article) {
        articleDao.add(article);
    }

    /**
     * Adds a Blog
     *
     * @param blog to be added
     */
    @Override
    public void addBlog(Blog blog) {
        blogDao.add(blog);
    }

    /**
     * Marks selected title as read.
     *
     * @param tip
     * @return true if marking is successful
     */
    public boolean markAsRead(ReadingTip tip) {
        if (tip == null) {
            return false;
        }
        switch (tip.getClass().getName().replace("ReadMe.domain.", "")) {
            case "Video":
                return videoDao.markAsRead(tip.getTitle());
            case "Book":
                return bookDao.markAsRead(tip.getTitle());
            case "News":
                return newsDao.markAsRead(tip.getTitle());
            case "Article":
                return articleDao.markAsRead(tip.getTitle());
            case "Blog":
                return blogDao.markAsRead(tip.getTitle());
            default:
                return false;
        }
    }

}
