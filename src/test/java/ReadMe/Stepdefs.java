package ReadMe;

import ReadMe.domain.Bookmark;
import ReadMe.ui.UI;
import ReadMe.io.IOStub;
import ReadMe.dao.InMemoryDao;
import ReadMe.domain.Blog;
import ReadMe.domain.Book;
import ReadMe.domain.News;
import ReadMe.domain.Video;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.mock;

public class Stepdefs {

    UI ui;
    IOStub io;
    InMemoryDao dao = new InMemoryDao();
    String[] inputLinesAdd = new String[2];
    String[] inputLinesList = new String[5];

    String[] inputLinesVideo = new String[7];
    String[] inputLinesBook = new String[7];
    String[] inputLinesNews = new String[8];
    String[] inputLinesArticle = new String[8];
    String[] inputLinesBlog = new String[7];

//    @Given("^command new tip is selected$")
//    public void command_new_tip_is_selected() throws Throwable {
//        inputLinesAdd[0] = "a";
//
//    }
//    @When("^title \"([^\"]*)\" and description \"([^\"]*)\" and link \"([^\"]*)\" are given$")
//    public void title_and_description_and_link_are_given(String title, String description, String link) throws Throwable {
//        inputLinesAdd[1] = "title";
//        inputLinesAdd[2] = "desc";
//        inputLinesAdd[3] = "www";
//        inputLinesAdd[4] = "q";
//
//    }
    @When("^command list all is given$")
    public void command_list_all_is_given() throws Throwable {
        inputLinesList[0] = "l";
        inputLinesList[1] = "q";
    }

//    @Then("^a new tip is added$")
//    public void a_new_tip_is_added() throws Throwable {
//
//        io = new IOStub(inputLinesAdd);
//        UI ui = new UI(io, dao);
//        ui.run();
//        assertTrue(dao.listAll().contains(new Bookmark("title", "desc", "www")));
//    }
//    @Then("^all bookmarks are printed$")
//    public void all_bookmarks_are_printed() throws Throwable {
//        IOStub ios = new IOStub(inputLinesList);
//        UI ui = new UI(ios, dao);
//        ui.run();
//        assertTrue(ios.getOutputs().contains(new Bookmark("Kakkakuutiot", "Tämä on tärkeää tietoa",
//                "https://www.iltalehti.fi/terveysuutiset/a/71cb5062-ed6e-45a6-a22c-d0949daeaa6a").toString())
//                && ios.getOutputs().contains(new Bookmark("Täydelliset joulutortut", "Näin teet täydellisen tortun",
//                        "https://www.iltalehti.fi/ruoka-artikkelit/a/556f9c4c-638b-4091-ab35-cb6e52e02555").toString()));
//    }
    //for video
    @Given("^command \"([^\"]*)\" add new readtip is selected and command \"([^\"]*)\" video is selected$")
    public void command_add_new_readtip_is_selected_and_command_video_is_selected(String arg1, String arg2) throws Throwable {
        inputLinesVideo[0] = "a";
        inputLinesVideo[1] = "1";

    }

    //for video
    @When("^Title \"([^\"]*)\" and Author \"([^\"]*)\" and Link \"([^\"]*)\" and Description \"([^\"]*)\" and Year published \"([^\"]*)\" are input$")
    public void title_and_Author_and_Link_and_Description_and_Year_published_are_input(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        inputLinesVideo[2] = "title";
        inputLinesVideo[3] = "author";
        inputLinesVideo[4] = "www";
        inputLinesVideo[5] = "desc";
        inputLinesVideo[6] = "2000";
    }

    //for video
    @Then("^a new videotip is added$")
    public void a_new_videotip_is_added() throws Throwable {
//        io = new IOStub(inputLinesVideo);
//        ui = new UI(io, dao);
//        ui.run();
//        assertTrue(dao.listByType("video").contains(new Video("author", "title", "www", "desc", 2000).toString()));
    }

    //for book
    @Given("^command \"([^\"]*)\" add new readtip is selected and command \"([^\"]*)\" book is selected$")
    public void command_add_new_readtip_is_selected_and_command_book_is_selected(String arg1, String arg2) throws Throwable {
        inputLinesBook[0] = "a";
        inputLinesBook[1] = "2";
    }

    //for book
    @When("^Title \"([^\"]*)\" and Author \"([^\"]*)\" and ISBN \"([^\"]*)\" and Description \"([^\"]*)\" and Year \"([^\"]*)\" are input$")
    public void title_and_Author_and_ISBN_and_Description_and_Year_are_input(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        inputLinesBook[2] = "title";
        inputLinesBook[3] = "author";
        inputLinesBook[4] = "12345";
        inputLinesBook[5] = "desc";
        inputLinesBook[6] = "2000";
    }

    //for book
    @Then("^a new booktip is added$")
    public void a_new_booktip_is_added() throws Throwable {
//        io = new IOStub(inputLinesBook);
//        InMemoryDao daoBook= new InMemoryDao();
//        ui = new UI(io, daoBook);
//        ui.run();
//        assertTrue(daoBook.listByType("book").contains(new Book("author", "title", "12345", "desc", 2000).toString()));

    }

    //news
    @Given("^command \"([^\"]*)\" add new readtip is selected and command \"([^\"]*)\" newstip is selected$")
    public void command_add_new_readtip_is_selected_and_command_newstip_is_selected(String arg1, String arg2) throws Throwable {
        inputLinesNews[0] = "a";
        inputLinesNews[1] = "3";
    }

    //news
    @When("^Title \"([^\"]*)\" and Author \"([^\"]*)\" and link \"([^\"]*)\" and Description \"([^\"]*)\" and Publisher \"([^\"]*)\" and Year published \"([^\"]*)\" are input$")
    public void title_and_Author_and_link_and_Description_and_Publisher_and_Year_published_are_input(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
        inputLinesNews[2] = "title";
        inputLinesNews[3] = "author";
        inputLinesNews[4] = "www";
        inputLinesNews[5] = "desc";
        inputLinesNews[6] = "publisher";
        inputLinesNews[7] = "2000";
    }

    //news
    @Then("^a new newstip is added$")
    public void a_new_newstip_is_added() throws Throwable {
//        io = new IOStub(inputLinesNews);
//        ui = new UI(io, dao);
//        ui.run();
//        assertTrue(dao.listByType("news").contains(new News("author", "title", "www", "desc", "publisher", 2000).toString()));
    }

    //article
    @Given("^command \"([^\"]*)\" add new readtip is selected and command \"([^\"]*)\" article is selected$")
    public void command_add_new_readtip_is_selected_and_command_article_is_selected(String arg1, String arg2) throws Throwable {
        inputLinesArticle[0] = "a";
        inputLinesArticle[1] = "4";
    }

    //article
    @When("^Title \"([^\"]*)\" and Author \"([^\"]*)\" and Link \"([^\"]*)\" and Description \"([^\"]*)\" and Publisher \"([^\"]*)\" and Year \"([^\"]*)\" are input$")
    public void title_and_Author_and_Link_and_Description_and_Publisher_and_Year_are_input(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
        inputLinesArticle[2] = "title";
        inputLinesArticle[3] = "author";
        inputLinesArticle[4] = "www";
        inputLinesArticle[5] = "desc";
        inputLinesArticle[6] = "pub";
        inputLinesArticle[7] = "2000";
    }

    //article
    @Then("^a new articletip is added$")
    public void a_new_articletip_is_added() throws Throwable {
//        io = new IOStub(inputLinesArticle);
//        ui = new UI(io, dao);
//        ui.run();
//        assertTrue(dao.listByType("article").contains(new News("author", "title", "www", "desc", "publisher", 2000).toString()));

    }

    //blog
    @Given("^command \"([^\"]*)\" add new readtip is selected and command \"([^\"]*)\" blog is selected$")
    public void command_add_new_readtip_is_selected_and_command_blog_is_selected(String arg1, String arg2) throws Throwable {
        inputLinesBlog[0] = "a";
        inputLinesBlog[1] = "5";
    }

    //blog
    @When("^Title \"([^\"]*)\" and Author \"([^\"]*)\" and Link \"([^\"]*)\" and Description \"([^\"]*)\" and Year \"([^\"]*)\" are input$")
    public void title_and_Author_and_Link_and_Description_and_Year_are_input(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        inputLinesBlog[2] = "title";
        inputLinesBlog[3] = "author";
        inputLinesBlog[4] = "www";
        inputLinesBlog[5] = "desc";
        inputLinesBlog[6] = "2000";
    }

    //blog
    @Then("^a new blogtip is added$")
    public void a_new_blogtip_is_added() throws Throwable {
//        io = new IOStub(inputLinesBlog);
//        ui = new UI(io, dao);
//        ui.run();
//        assertTrue(dao.listByType("blog").contains(new Blog("author", "title", "www", "desc", 2000).toString()));
    }

    @Then("^all bookmarks are printed$")
    public void all_bookmarks_are_printed() throws Throwable {
//        IOStub ios = new IOStub(inputLinesVideo);     
//        InMemoryDao dao = new InMemoryDao();
//        ui = new UI(ios, dao);
//        ui.run();
//        assertTrue(ios.getOutputs().contains(new Video("hackerdashery", "P vs. NP and the Computational Complexity Zoo",
        //        "https://www.youtube.com/watch?v=YX40hbAHx3s&frags=pl%2Cwn", "P js NP erot", 2014)));
        //assertTrue(ios.getOutputs().contains(new Video("author", "title", "www", "desc", 2000).toString()));
    }

}
