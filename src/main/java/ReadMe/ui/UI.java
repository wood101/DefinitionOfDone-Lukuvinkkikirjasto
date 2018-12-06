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
import ReadMe.domain.ReadingTip;
import ReadMe.domain.Video;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

    public void summaryTableView(List<ReadingTip> tips) {

        if (tips.isEmpty()) {
            io.print("\nNo reading tips found.\n");
        } else {
            String table = "";
            String leftAlignFormat = "| %-4d| %-15s | %-20s | %-7s |%n";
            table += String.format("+-----+-----------------+----------------------+---------+%n");
            table += String.format("| ID  |     Author      |        Title         |  Type   |%n");
            table += String.format("+-----+-----------------+----------------------+---------+%n");
            for (int i = 0; i < tips.size(); i++) {
                table += String.format(leftAlignFormat, i, tips.get(i).getAuthor(), tips.get(i).getTitle().substring(0, Math.min(19, tips.get(i).getTitle().length())), tips.get(i).getClass().getName().replace("ReadMe.domain.", ""));
            }
            table += String.format("+-----+-----------------+----------------------+---------+%n");
            io.print(table);
        }

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
            io.print("Please type  year as numbers!");
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
     * Displays options of types of tips to add and takes user input for
     * selection of type
     */
    public void selectTypeToAdd() {
        String prompt = "Choose type:\n"
                + "  1 - video\n"
                + "  2 - book\n"
                + "  3 - news\n"
                + "  4 - article\n"
                + "  5 - blog\n"
                + "  b - back to previous view\n";

        Set<String> acceptedInput = new TreeSet<>();
        acceptedInput.add("1");
        acceptedInput.add("2");
        acceptedInput.add("3");
        acceptedInput.add("4");
        acceptedInput.add("5");
        acceptedInput.add("b");

        String choice = userCommand(prompt, acceptedInput);
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
            case "b":
                break;
        }
        selectBaseCommand();
        io.print("Tip added!\n\n");
    }

    /**
     * Displays options of types of tips to list and takes user input for
     * selection of type or to list all
     */
    public void selectTypeToList() {
        String prompt = "Choose type:\n"
                + "  1 - all\n"
                + "  2 - video\n"
                + "  3 - book\n"
                + "  4 - news\n"
                + "  5 - article\n"
                + "  6 - blog\n"
                + "  b - back to main commands\n";

        Set<String> acceptedInput = new TreeSet<>();
        acceptedInput.add("1");
        acceptedInput.add("2");
        acceptedInput.add("3");
        acceptedInput.add("4");
        acceptedInput.add("5");
        acceptedInput.add("6");
        acceptedInput.add("b");

        String choice = userCommand(prompt, acceptedInput);
        switch (choice) {
            case "1":
                summaryTableView(manager.listByType("all"));
                break;
            case "2":
                summaryTableView(manager.listByType("video"));
                break;
            case "3":
                summaryTableView(manager.listByType("book"));
                break;
            case "4":
                summaryTableView(manager.listByType("news"));
                break;
            case "5":
                summaryTableView(manager.listByType("article"));
                break;
            case "6":
                summaryTableView(manager.listByType("blog"));
                break;
            case "b":
                break;
        }
        selectBaseCommand();
    }

    /**
     * Displays options of types of tips to list and takes user input for
     * selection of type or to list all
     */
    public void selectSingleTip() {
        String prompt = "Choose type:\n"
                + "  s - show more info about single tip\n"
                + "  b - back to main commands\n";

        Set<String> acceptedInput = new TreeSet<>();
        acceptedInput.add("s");
        acceptedInput.add("b");

        String choice = userCommand(prompt, acceptedInput);
        switch (choice) {
            case "s":
                break;
            case "b":
                break;
        }
        selectBaseCommand();
    }

    /**
     * Displays options of types of tips to list and takes user input for
     * selection of type or to list all
     */
    public void selectBaseCommand() {
        String prompt = "Choose an action:\n"
                + "  a - add new readtip\n"
                + "  l - list tips\n"
                + "  q - quit app\n";

        Set<String> acceptedInput = new TreeSet<>();
        acceptedInput.add("a");
        acceptedInput.add("l");
        acceptedInput.add("q");

        String choice = userCommand(prompt, acceptedInput);
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
            case "q":
                exitApplication();
        }
    }

    private String userCommand(String prompt, Set<String> acceptedInput) {
        io.print(prompt);
        String choice = "";
        while (!choice.equals("q")) {
            choice = io.readLine("Enter choice: ");
            if (acceptedInput.contains(choice)) {
                break;
            } else {
                io.print("Choose a correct input!");
            }
        }
        return choice;
    }

    /**
     * Runs console UI
     */
    public void run() {
        this.io = io;
        io.print("Welcome to ReadTipper!\n\n");
        selectBaseCommand();
//        String choice = "";
//        while (!choice.equals("q")) {
//            String prompt = "Choose an action:\n"
//                    + "  a - add new readtip\n"
//                    + "  l - list tips\n"
//                    + "  q - quit app\n";
//            choice = io.readLine("Enter choice: ");
//            switch (choice) {
//                case "a":
//                    io.print("Adding a new ReadTip: \n\n");
//                    selectTypeToAdd();
//                    break;
//                case "l":
//                    io.print("Existing tips: \n");
//                    selectTypeToList();
//                    io.print("\n\n");
//                    break;
//                case "q":
//                    break;
//                default:
//                    io.print("Choose a correct input!");
//            }
//        }

    }

    private void exitApplication() {
        io.print("Thank you!");
    }

}

///**
// * Gets and prints string representation of all tips from manager
// *
// */
//public void listAll() {
//        io.print(manager.listAll());
//    }
//
//    /**
//     * Gets and prints string representation of all video tips from manager
//     *
//     */
//    public void listVideos() {
//        io.print(manager.listByType("video"));
//    }
//
//    /**
//     * Gets and prints string representation of all book tips from manager
//     *
//     */
//    public void listBooks() {
//        io.print(manager.listByType("book"));
//    }
//
//    /**
//     * Gets and prints string representation of all news tips from manager
//     *
//     */
//    public void listNews() {
//        io.print(manager.listByType("news"));
//    }
//
//    /**
//     * Gets and prints string representation of all article tips from manager
//     *
//     */
//    public void listArticles() {
//        io.print(manager.listByType("article"));
//    }
//
//    /**
//     * Gets and prints string representation of all blog tips from manager
//     *
//     */
//    public void listBlogs() {
//        io.print(manager.listByType("blog"));
//    }
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

