/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.ui;

import ReadMe.domain.Bookmark;
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
 * @author bisi
 */
public class UI {

    private IO io;
    private DaoManager manager;

    public UI(IO io, DaoManager manager) {
        this.io = io;
        this.manager = manager;
    }

//    public void addBookmark() {
//        String headline = io.readLine("Enter title: ");
//        String description = io.readLine("Enter description: ");
//        String link = io.readLine("Enter link: ");
//        manager.add(new Bookmark(headline, description, link));
//    }

    public void addVideo() {
        io.print("VIDEO ENTRY - enter information: \n\n");
        String title = io.readLine("Title: ");
        String author = io.readLine("Author: ");
        String link = io.readLine("Link: ");
        String description = io.readLine("Description: ");
        int year = Integer.parseInt(io.readLine("Year published: "));
        manager.addVideo(new Video(author, title, description, link, year));
    }

    public void addBook() {
        io.print("BOOK ENTRY - enter information: \n\n");
        String title = io.readLine("Title: ");
        String author = io.readLine("Author: ");
        String ISBN = io.readLine("ISBN: ");
        String description = io.readLine("Description: ");
        int year = Integer.parseInt(io.readLine("Year published: "));
        manager.addBook(new Book(author, title, ISBN, description, year));
    }

    public void addNews() {
        io.print("NEWS ENTRY - enter information: \n\n");
        String title = io.readLine("Title: ");
        String author = io.readLine("Author: ");
        String link = io.readLine("Link: ");
        String description = io.readLine("Description: ");
        String publisher = io.readLine("Publisher: ");
        int year = Integer.parseInt(io.readLine("Year published: "));
        manager.addNews(new News(author, title, link, description, publisher, year));
    }

    public void addArticle() {
        io.print("ARTICLE ENTRY - enter information: \n\n");
        String title = io.readLine("Title: ");
        String author = io.readLine("Author: ");
        String link = io.readLine("Link: ");
        String description = io.readLine("Description: ");
        String publisher = io.readLine("Publisher: ");
        int year = Integer.parseInt(io.readLine("Year published: "));
        manager.addArticle(new Article(author, title, link, description, publisher, year));
    }

    public void addBlog() {
        io.print("ARTICLE ENTRY - enter information: \n\n");
        String title = io.readLine("Title: ");
        String author = io.readLine("Author: ");
        String link = io.readLine("Link: ");
        String description = io.readLine("Description: ");
        int year = Integer.parseInt(io.readLine("Year published: "));
        manager.addBlog(new Blog(author, title, link, description, year));
    }

    /**
     * Prints all Bookmarks from database
     */
    public String listAll() {
        return manager.listAll("all");
    }

    public void selectTypeOfTip() {
        io.print("Choose type of readtip:\n"
                    + "  1 - video\n"
                    + "  2 - book\n"
                    + "  3 - news\n"
                    + "  4 - article\n"
                    + "  5 - blog\n");
        String choice = io.readLine("Enter choice: ");
        switch (choice) {
            case "1":
                addVideo();
            case "2":
                addBook();
            case "3":
                addNews();
            case "4":
                addArticle();
            case "5":
                addBlog();
            default:
                io.print("Choose a correct input!\n");
                break;
        }
        io.print("Tip added!\n\n");
    }

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
                    + "  q - quit app\n");
            choice = io.readLine("Enter choice: ");
            switch (choice) {
                case "a":
                    io.print("Adding a new ReadTip!:\n\n");
                    selectTypeOfTip();
                    break;
                case "l":
                    io.print("All added tips: \n");
                    listAll();
                    io.print("\n\n");
                    break;
                case "q":
                    break;
                default:
                    io.print("Choose a correct input!");
            }
        }
        io.print("Thank you!");
    }

}
