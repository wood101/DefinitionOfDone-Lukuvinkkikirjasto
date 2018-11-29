/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;

import ReadMe.domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bisi
 */
public class InMemoryDao implements DaoManager {

    private List<Video> videos;
    private List<Book> books;
    private List<News> news;
    private List<Article> articles;
    private List<Blog> blogs;

    /**
     * In memory 'database' that can be used for testing. Creates new lists of
     * boomark objects, and adds new objects in them.
     *
     */
    public InMemoryDao() {
        this.videos = new ArrayList<>();
        this.books = new ArrayList<>();
        this.news = new ArrayList<>();
        this.articles = new ArrayList<>();
        this.blogs = new ArrayList<>();
        setInMemoryObjects();
    }

    private void setInMemoryObjects() {
        
        Date date = new Date(2018, 9, 13);

        // Create entries 
        videos.add(new Video("hackerdashery", "P vs. NP and the Computational Complexity Zoo", 
                "https://www.youtube.com/watch?v=YX40hbAHx3s&frags=pl%2Cwn", "P js NP erot", 2014));
        
        /**news.add(new News("", "Kakkakuutiot",
                "https://www.iltalehti.fi/terveysuutiset/a/71cb5062-ed6e-45a6-a22c-d0949daeaa6a"));
        news.add(new News("Täydelliset joulutortut",
                "Näin teet täydellisen tortun", "https://www.iltalehti.fi/ruoka-artikkelit/a/556f9c4c-638b-4091-ab35-cb6e52e02555"));
*       */
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
    
    // Methods to keep ListAll cleaner. Methods turn list into a string.
    private String videosToString() {
        String s = "";
        s += "Videos:\n";

        for (Video video : videos) {
            s += (video.toString());
        }
        s += ("\n\n");

        return s;

    }

    private String booksToString() {
        String s = "";
        s += "Books:\n";

        for (Book book : books) {
            s += (book.toString());
        }
        s += ("\n\n");

        return s;
    }

    private String newsToString() {
        String s = "";
        s += "News:\n";

        for (News n : news) {
            s += (n.toString());
        }
        s += ("\n\n");

        return s;
    }

    private String articlesToString() {
        String s = "";
        s += "Articles:\n";

        for (Article article : articles) {
            s += (article.toString());
        }
        s += ("\n\n");

        return s;
    }

    private String blogsToString() {
        String s = "";
        s += "Blogs:\n";

        for (Blog blog : blogs) {
            s += (blog.toString());
        }
        s += ("\n\n");

        return s;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<News> getNews() {
        return news;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    @Override
    public void addVideo(Video video) {
        this.videos.add(video);
    }

    @Override
    public void addBook(Book book) {
        this.books.add(book);
    }

    @Override
    public void addNews(News news) {
        this.news.add(news);
    }

    @Override
    public void addArticle(Article article) {
        this.articles.add(article);
    }

    @Override
    public void addBlog(Blog blog) {
        this.blogs.add(blog);
    }

}
