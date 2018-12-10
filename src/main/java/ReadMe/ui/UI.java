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
import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
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
    private boolean run;

    public UI(IO io, DaoManager manager) {
        this.io = io;
        this.manager = manager;
    }

    // accepts only valid years. Years BCE are marked as negative values.
    public int safeYearInput() {
        Date today = new Date();
        int thisYear = today.getYear() + 1900; // getYear returns this year - 1900 for reasons unknown
        int year = 0;
        boolean flag = false;

        do {
            try {
                String option = io.readLine("Year published: ");
                year = Integer.parseInt(option);
                if (year > thisYear) {
                    io.print("Year cannot be in the future!");
                } else {
                    flag = true;
                }
            } catch (Exception e) {
                io.print("Please type year as a number!");
            }
        } while (!flag);
        return year;
    }

    /**
     * Prints reading tips as a table
     *
     * @param tips that should be printed
     * @return true if there were reading tips to print, otherwise false
     */
    private boolean summaryTableView(List<ReadingTip> tips) {
        if (tips.isEmpty()) {
            io.print("\nNo reading tips found.\n");
            return false;
        } else {
            String table = "";
            String leftAlignFormat = "| %-6d| %-50s | %-70s | %-4d | %-7s | %-7s |%n";
            table += String.format("+-------+----------------------------------------------------+------------------------------------------------------------------------+------+---------+---------+%n");
            table += String.format("| Index |                      Author                        |                                     Title                              | Year |  Type   | Checked |%n");
            table += String.format("+-------+----------------------------------------------------+------------------------------------------------------------------------+------+---------+---------+%n");
            for (int i = 0; i < tips.size(); i++) {
                String author = tips.get(i).getAuthor();
                String title = tips.get(i).getTitle();
                if(tips.get(i).getAuthor().length() > 50) author = tips.get(i).getAuthor().substring(0, 46) + "...";
                if(tips.get(i).getTitle().length() > 50) title = tips.get(i).getTitle().substring(0, 66) + "...";
                table += String.format(leftAlignFormat, incrementedIndex(i), author, title, tips.get(i).getYear(), tips.get(i).getClass().getName().replace("ReadMe.domain.", ""), tips.get(i).isChecked());
            }
            table += String.format("+-------+----------------------------------------------------+------------------------------------------------------------------------+------+---------+---------+%n");
            io.print(table);

            return true;
        }
    }

    /**
     * Method prints a the string representation of the tip
     *
     * @param tip
     */
    private void singleTipView(ReadingTip tip) {
        io.print(tip.toString());

    }

    /**
     * Method to increment index shown to user for a more familiar experience
     * when indexes start from 1
     *
     * @param index
     * @return incremented integer
     */
    private int incrementedIndex(int index) {
        return index + 1;
    }

    /**
     * Displays fields to input for video entry, takes input, and creates video
     * entry
     */
    public boolean addVideo() {
        io.print("VIDEO ENTRY - enter information: \n\n");
        String title = io.readLine("Title: ");
        String author = io.readLine("Author: ");
        String link = io.readLine("Link: ");
        String description = io.readLine("Description: ");
        int year = safeYearInput();
        manager.addVideo(new Video(author, title, description, link, year));
        return true;

    }

    /**
     * Displays fields to input for book entry, takes input, and creates book
     * entry
     */
    public boolean addBook() {
        io.print("BOOK ENTRY - enter information: \n\n");
        String title = io.readLine("Title: ");
        String author = io.readLine("Author: ");
        String ISBN = io.readLine("ISBN: ");
        String description = io.readLine("Description: ");
        int year = safeYearInput();
        manager.addBook(new Book(author, title, ISBN, description, year));
        return true;
    }

    /**
     * Displays fields to input for news entry, takes input, and creates news
     * entry
     */
    public boolean addNews() {
        io.print("NEWS ENTRY - enter information: \n\n");
        String title = io.readLine("Title: ");
        String author = io.readLine("Author: ");
        String link = io.readLine("Link: ");
        String description = io.readLine("Description: ");
        String publisher = io.readLine("Publisher: ");
        int year = safeYearInput();
        manager.addNews(new News(author, title, link, description, publisher, year));
        return true;
    }

    /**
     * Displays fields to input for article entry, takes input, and creates
     * article entry
     */
    public boolean addArticle() {
        io.print("ARTICLE ENTRY - enter information: \n\n");
        String title = io.readLine("Title: ");
        String author = io.readLine("Author: ");
        String link = io.readLine("Link: ");
        String description = io.readLine("Description: ");
        String publisher = io.readLine("Publisher: ");
        int year = safeYearInput();
        manager.addArticle(new Article(author, title, link, description, publisher, year));
        return true;
    }

    /**
     * Displays fields to input for blog entry, takes input, and creates blog
     * entry
     */
    public boolean addBlog() {
        io.print("BLOG ENTRY - enter information: \n\n");
        String title = io.readLine("Title: ");
        String author = io.readLine("Author: ");
        String link = io.readLine("Link: ");
        String description = io.readLine("Description: ");
        int year = safeYearInput();
        manager.addBlog(new Blog(author, title, link, description, year));
        return true;
    }

    /**
     * Displays options of types of tips to add and takes user input for
     * selection of type
     */
    private void selectTypeToAdd() {
        String prompt = "Choose type:\n"
                + "  1 - video\n"
                + "  2 - book\n"
                + "  3 - news\n"
                + "  4 - article\n"
                + "  5 - blog\n"
                + "  b - back to main commands\n";

        Set<String> acceptedInput = new TreeSet<>();
        acceptedInput.add("1");
        acceptedInput.add("2");
        acceptedInput.add("3");
        acceptedInput.add("4");
        acceptedInput.add("5");
        acceptedInput.add("b");

        String choice = userCommand(prompt, acceptedInput);
        boolean addedSuccessfully = false;
        switch (choice) {
            case "1":
                addedSuccessfully = addVideo();
                break;
            case "2":
                addedSuccessfully = addBook();
                break;
            case "3":
                addedSuccessfully = addNews();
                break;
            case "4":
                addedSuccessfully = addArticle();
                break;
            case "5":
                addedSuccessfully = addBlog();
                break;
            case "b":
                return;
        }
        if (addedSuccessfully) {
            io.print("Tip added!\n\n");
        }
    }

    /**
     * Displays options of types of tips to list and takes user input for
     * selection of type or to list all
     */
    private void selectTypeToList() {
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
        boolean hasTips = true;
        List<ReadingTip> tips = new ArrayList<>();
        switch (choice) {
            case "1":
                tips = manager.listByType("all");
                hasTips = summaryTableView(tips);
                break;
            case "2":
                tips = manager.listByType("video");
                hasTips = summaryTableView(tips);
                break;
            case "3":
                tips = manager.listByType("book");
                hasTips = summaryTableView(tips);
                break;
            case "4":
                tips = manager.listByType("news");
                hasTips = summaryTableView(tips);
                break;
            case "5":
                tips = manager.listByType("article");
                hasTips = summaryTableView(tips);
                break;
            case "6":
                tips = manager.listByType("blog");
                hasTips = summaryTableView(tips);
                break;
            case "b":
                return;
        }
        if (hasTips) {
            selectSingleTip(tips);
        }
    }

    /**
     * Displays options for actions to be made on a single tip and directs user
     * input
     */
    private void selectSingleTip(List<ReadingTip> tips) {
        boolean viewing = true;
        while (viewing) {
            String prompt = "Choose an action:\n"
                    + "  s - show more info about single tip\n"
                    + "  r - mark reading tip as read\n"
                    + "  b - back to main commands\n"
                    + "  q - quit app\n";

            Set<String> acceptedInput = new TreeSet<>();
            acceptedInput.add("s");
            acceptedInput.add("b");
            acceptedInput.add("r");
            acceptedInput.add("q");

            String choice = userCommand(prompt, acceptedInput);
            ReadingTip selected = null;
            switch (choice) {
                case "s":
                    selected = selectTipFromList(tips);
                    if (selected != null) {
                        singleTipView(selected);
                    }
                    break;
                case "b":
                    viewing = false;
                    break;
                case "r":
                    selected = selectTipFromList(tips);
                    if (selected != null) {
                        ReadingTip edited = MarkTipAsRead(selected);
                        updateCachedTipWhenMarked(tips, selected, edited);
                    }
                    break;
                case "q":
                    exitApplication();
                    viewing = false;
                    break;
            }
        }

    }

    private void updateCachedTipWhenMarked(List<ReadingTip> tips, ReadingTip selected, ReadingTip edited) {
        for (int i = 0; i < tips.size(); i++) {
            if (tips.get(i).equals(selected)) {
                tips.set(i, edited);
            }
        }
    }

    private ReadingTip MarkTipAsRead(ReadingTip tip) {
        manager.markAsRead(tip);
        io.print("Marked " + tip.getTitle() + " as read");
        tip.setChecked(true);
        tip.setDate_checked(new Date());
        return tip;
    }

    /**
     * Expects an index from a given list of reading tips to be input by the
     * user and rejects the input if it not an index, then returns tip or null
     * if none was found
     *
     * @param tips list to be checked for indexes
     * @return reading tip that was desired by index
     */
    private ReadingTip selectTipFromList(List<ReadingTip> tips) {
        io.print("Choose tip by index:\n");
        try {
            int index = Integer.parseInt(io.readLine("Enter index: "));
            int indexDecrement = index - 1;
            ReadingTip tip = tips.get(indexDecrement);
            return tip;
        } catch (Exception e) {
            io.print("Bad index\n");
        }
        return null;
    }

    /**
     * Displays options of types of tips to list and takes user input for
     * selection of type or to list all
     */
    private void selectBaseCommand() {
        while (run) {
            String prompt = "Choose an action:\n"
                    + "  a - add new readtip\n"
                    + "  l - list tips\n"
                    + "  q - quit app\n";

            Set<String> acceptedInput = new TreeSet<>();
            acceptedInput.add("a");
            acceptedInput.add("l");
            acceptedInput.add("q");
            acceptedInput.add("link");

            String choice = userCommand(prompt, acceptedInput);
            switch (choice) {
                case "a":
                    io.print("Adding a new ReadTip: \n");
                    selectTypeToAdd();
                    break;
                case "l":
                    io.print("Existing tips: \n");
                    selectTypeToList();
                    break;
                case "link":
                    openLinkInBrowser("http://www.google.com");
                    break;
                case "q":
                    exitApplication();
            }
        }
    }

    /**
     * Provides list of commands and prompts user for input. Accepts only input
     * from set of commands given as a parameter. Everything else is rejected.
     *
     * @param prompt message for telling user what to do
     * @param acceptedInput set of accepted input(s)
     * @return which input the user has typed
     */
    private String userCommand(String prompt, Set<String> acceptedInput) {
        io.print(prompt);
        String choice = "";
        while (true) {
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
        io.print("Welcome to ReadTipper!\n\n");
        run = true;
        selectBaseCommand();
    }

    private void exitApplication() {
        run = false;
        io.print("Thank you!");
    }

    public boolean openLinkInBrowser(String url) {
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI(url);
            desktop.browse(oURL);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // given isbn is edited into an isbnsearch.org link
    private String isbnSearchLink(String ISBN) {
        return "https://isbnsearch.org/search?s=" + ISBN;
    }
    
    private String getLinkFromReadingTip(ReadingTip tip){
        String url = "";
        if(tip instanceof Video){
            url = ((Video) tip).getLink();
        } else if (tip instanceof Article){
            url = ((Article) tip).getLink();  
        } else if (tip instanceof Blog){
            url = ((Blog) tip).getLink();
        } else if (tip instanceof News){
            url = ((News) tip).getLink();
        }
        return url;
    }

    private void singleTipCommands(List<ReadingTip> tips, int index) {
        boolean viewing = true;
        while (viewing) {
            String prompt = "Choose an action:\n"
                    + "  r - mark reading tip as read\n"
                    + "  b - back to list commands\n"
                    + "  q - quit app\n";

            Set<String> acceptedInput = new TreeSet<>();
            acceptedInput.add("b");
            acceptedInput.add("r");
            acceptedInput.add("o");
            acceptedInput.add("q");

            String choice = userCommand(prompt, acceptedInput);
            ReadingTip selected = tips.get(index);
            String successPrint = "";
            boolean LinkOpenedSuccesfully;
            switch (choice) {
                case "o":
                    if (selected instanceof Book) {
                        LinkOpenedSuccesfully = openLinkInBrowser(((Book) selected).getISBN());
                        successPrint = "Searching for the book's ISBN at isbnsearch.org in your default browser";
                    } else {
                        LinkOpenedSuccesfully = openLinkInBrowser(getLinkFromReadingTip(selected));
                        successPrint = "Link opened in your default browser";
                    }
                    if(LinkOpenedSuccesfully){
                        io.print(successPrint);
                    } else {
                        io.print("Failed to open link");
                    }
                case "b":
                    viewing = false;
                    break;
                case "r":
                    ReadingTip edited = MarkTipAsRead(selected);
                    updateCachedTipWhenMarked(tips, selected, edited);
                    break;
                case "q":
                    exitApplication();
                    viewing = false;
                    break;
            }
        }

    }

}
