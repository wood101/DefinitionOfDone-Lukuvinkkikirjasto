/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.ui;

import ReadMe.io.IO;
import ReadMe.dao.DaoManager;
import ReadMe.domain.Article;
import ReadMe.domain.Blog;
import ReadMe.domain.Book;
import ReadMe.domain.News;
import ReadMe.domain.Video;

/**
 * UI object. Used to run console app.
 *
 * @author bisi, peje
 */
public class UI {

    private IO io;
    private DaoManager manager;

    public UI(IO io, DaoManager manager) {
        this.io = io;
        this.manager = manager;
    }

    /**
     * Displays fields to input for video entry, takes input, and creates video
     * entry
     */
    public void addVideo() {
        try {
            io.print("VIDEO ENTRY - enter information: \n\n");
            String title = io.readLine("Title: ");
            String author = io.readLine("Author: ");
            String link = io.readLine("Link: ");
            String description = io.readLine("Description: ");
            int year = Integer.parseInt(io.readLine("Year published: "));
            manager.addVideo(new Video(author, title, description, link, year));
        } catch (Exception e) {
            io.print("Please type year as a number!");
        }
    }

    /**
     * Displays fields to input for book entry, takes input, and creates book
     * entry
     */
    public void addBook() {
        try {
            io.print("BOOK ENTRY - enter information: \n\n");
            String title = io.readLine("Title: ");
            String author = io.readLine("Author: ");
            String ISBN = io.readLine("ISBN: ");
            String description = io.readLine("Description: ");
            int year = Integer.parseInt(io.readLine("Year published: "));
            manager.addBook(new Book(author, title, ISBN, description, year));
        } catch (Exception e) {
            io.print("Please type ISBN and year as numbers!");
        }

    }

    /**
     * Displays fields to input for news entry, takes input, and creates news
     * entry
     */
    public void addNews() {
        try {
            io.print("NEWS ENTRY - enter information: \n\n");
            String title = io.readLine("Title: ");
            String author = io.readLine("Author: ");
            String link = io.readLine("Link: ");
            String description = io.readLine("Description: ");
            String publisher = io.readLine("Publisher: ");
            int year = Integer.parseInt(io.readLine("Year published: "));
            manager.addNews(new News(author, title, link, description, publisher, year));
        } catch (Exception e) {
            io.print("Please type year as a number!");
        }
    }

    /**
     * Displays fields to input for article entry, takes input, and creates
     * article entry
     */
    public void addArticle() {
        try {
            io.print("ARTICLE ENTRY - enter information: \n\n");
            String title = io.readLine("Title: ");
            String author = io.readLine("Author: ");
            String link = io.readLine("Link: ");
            String description = io.readLine("Description: ");
            String publisher = io.readLine("Publisher: ");
            int year = Integer.parseInt(io.readLine("Year published: "));
            manager.addArticle(new Article(author, title, link, description, publisher, year));
        } catch (Exception e) {
            io.print("Please type year as a number!");
        }
    }

    /**
     * Displays fields to input for blog entry, takes input, and creates blog
     * entry
     */
    public void addBlog() {
        try {
            io.print("BLOG ENTRY - enter information: \n\n");
            String title = io.readLine("Title: ");
            String author = io.readLine("Author: ");
            String link = io.readLine("Link: ");
            String description = io.readLine("Description: ");
            int year = Integer.parseInt(io.readLine("Year published: "));
            manager.addBlog(new Blog(author, title, link, description, year));
        } catch (Exception e) {
            io.print("Please type year as a number!");
        }
    }

    /**
     * Gets and prints string representation of all tips from manager
     *
     */
    public void listAll() {
        io.print(manager.listAll());
    }

    /**
     * Gets and prints string representation of all video tips from manager
     *
     */
    public void listVideos() {
        io.print(manager.listByType("video"));
    }

    /**
     * Gets and prints string representation of all book tips from manager
     *
     */
    public void listBooks() {
        io.print(manager.listByType("book"));
    }

    /**
     * Gets and prints string representation of all news tips from manager
     *
     */
    public void listNews() {
        io.print(manager.listByType("news"));
    }

    /**
     * Gets and prints string representation of all article tips from manager
     *
     */
    public void listArticles() {
        io.print(manager.listByType("article"));
    }

    /**
     * Gets and prints string representation of all blog tips from manager
     *
     */
    public void listBlogs() {
        io.print(manager.listByType("blog"));
    }
    
//    /**
//     * Marks a video tip as read based on the title
//     */
//    public void markVideoAsRead() {
//        String title = io.readLine("Enter title: ");
//        boolean success = manager.markAsRead("video", title);
//        if (success) {
//            io.print("Video tip marked as read");
//        } else {
//            io.print("No such tip in database");
//        }
//    }
//    /**
//     * Marks a book tip as read based on the title
//     */
//    public void markBookAsRead() {
//        String title = io.readLine("Enter title: ");
//        boolean success = manager.markAsRead("book", title);
//        if (success) {
//            io.print("Book tip marked as read");
//        } else {
//            io.print("No such tip in database");
//        }
//    }
//    /**
//     * Marks a video tip as read based on the title
//     */
//    public void markNewsAsRead() {
//        String title = io.readLine("Enter title: ");
//        boolean success = manager.markAsRead("news", title);
//        if (success) {
//            io.print("News tip marked as read");
//        } else {
//            io.print("No such tip in database");
//        }
//    }
//    /**
//     * Marks a video tip as read based on the title
//     */
//    public void markArticleAsRead() {
//        String title = io.readLine("Enter title: ");
//        boolean success = manager.markAsRead("article", title);
//        if (success) {
//            io.print("News tip marked as read");
//        } else {
//            io.print("No such tip in database");
//        }
//    }
//    /**
//     * Marks a video tip as read based on the title
//     */
//    public void markBlogAsRead() {
//        String title = io.readLine("Enter title: ");
//        boolean success = manager.markAsRead("blog", title);
//        if (success) {
//            io.print("Blog tip marked as read");
//        } else {
//            io.print("No such tip in database");
//        }
//    }

    /**
     * Displays options of types of tips to add and takes user input for
     * selection of type
     */
    public void selectTypeToAdd() {
        io.print("Choose type:\n"
                + "  1 - video\n"
                + "  2 - book\n"
                + "  3 - news\n"
                + "  4 - article\n"
                + "  5 - blog\n");
        String choice = io.readLine("Enter choice: ");
        switch (choice) {
            case "1":
                addVideo();
                break;
            case "2":
                addBook();
                break;
            case "3":
                addNews();
                break;
            case "4":
                addArticle();
                break;
            case "5":
                addBlog();
                break;
            default:
                io.print("Choose a correct input!\n");
                return;
        }
        io.print("Tip added!\n\n");
    }

    /**
     * Displays options of types of tips to list and takes user input for
     * selection of type or to list all
     */
    public void selectTypeToList() {
        io.print("Choose type:\n"
                + "  1 - all\n"
                + "  2 - video\n"
                + "  3 - book\n"
                + "  4 - news\n"
                + "  5 - article\n"
                + "  6 - blog\n");
        String choice = io.readLine("Enter choice: ");
        switch (choice) {
            case "1":
                listAll();
                break;
            case "2":
                listVideos();
                break;
            case "3":
                listBooks();
                break;
            case "4":
                listNews();
                break;
            case "5":
                listArticles();
                break;
            case "6":
                listBlogs();
                break;
            default:
                io.print("Choose a correct input!\n");
                break;
        }
    }
    
//    private void selectTypeToMark() {
//        io.print("Choose type:\n"
//                + "  1 - video\n"
//                + "  2 - book\n"
//                + "  3 - news\n"
//                + "  4 - article\n"
//                + "  5 - blog\n");
//        String choice = io.readLine("Enter choice: ");
//        switch (choice) {
//            case "1":
//                markVideoAsRead();
//                break;
//            case "2":
//                listBooks();
//                break;
//            case "3":
//                listNews();
//                break;
//            case "4":
//                listArticles();
//                break;
//            case "5":
//                listBlogs();
//                break;
//            default:
//                io.print("Choose a correct input!\n");
//                break;
//        }
//    }

    /**
     * Runs console UI
     */
    public void run() {
        this.io = io;
        io.print("Welcome to ReadTipper!\n\n");
        String choice = "";
        while (!choice.equals("q")) {
            io.print("Choose an action:\n"
                    + "  a - add new readtip\n"
                    + "  l - list all tips\n"
//                    + "  m - mark a tip as read\n"
                    + "  q - quit app\n");
            choice = io.readLine("Enter choice: ");
            switch (choice) {
                case "a":
                    io.print("Adding a new ReadTip: \n\n");
                    selectTypeToAdd();
                    break;
                case "l":
                    io.print("Existing tips: \n");
                    selectTypeToList();
                    io.print("\n\n");
                    break;
//                case "m":
//                    io.print("Mark tip as read: \n");
//                    selectTypeToMark();
                case "q":
                    break;
                default:
                    io.print("Choose a correct input!");
            }
        }
        io.print("Thank you!");
    }

}
