package ReadMe;

import ReadMe.domain.Bookmark;
import ReadMe.ui.UI;
import ReadMe.io.IOStub;
import ReadMe.dao.InMemoryDao;
import ReadMe.domain.Book;
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
    String[] inputLinesAdd = new String[5];
    String[] inputLinesList = new String[2];
    
    String[] inputLinesVideo = new String[7];
    String[] inputLinesBook = new String[7];
    String[] inputLinesNews = new String[7];
    String[] inputLinesArticle = new String[7];
    String[] inputLinesBlog = new String[7];

    @Given("^command new tip is selected$")
    public void command_new_tip_is_selected() throws Throwable {
        inputLinesAdd[0] = "a";

    }

    @When("^title \"([^\"]*)\" and description \"([^\"]*)\" and link \"([^\"]*)\" are given$")
    public void title_and_description_and_link_are_given(String title, String description, String link) throws Throwable {
        inputLinesAdd[1] = "title";
        inputLinesAdd[2] = "desc";
        inputLinesAdd[3] = "www";
        inputLinesAdd[4] = "q";

    }

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
    @Then("^all bookmarks are printed$")
    public void all_bookmarks_are_printed() throws Throwable {
        IOStub ios = new IOStub(inputLinesList);
        UI ui = new UI(ios, dao);
        ui.run();
        assertTrue(ios.getOutputs().contains(new Bookmark("Kakkakuutiot", "Tämä on tärkeää tietoa",
                "https://www.iltalehti.fi/terveysuutiset/a/71cb5062-ed6e-45a6-a22c-d0949daeaa6a").toString())
                && ios.getOutputs().contains(new Bookmark("Täydelliset joulutortut", "Näin teet täydellisen tortun",
                        "https://www.iltalehti.fi/ruoka-artikkelit/a/556f9c4c-638b-4091-ab35-cb6e52e02555").toString()));
    }

    @Given("^command \"([^\"]*)\" add new readtip is selected and command \"([^\"]*)\" book is selected$")
    public void command_add_new_readtip_is_selected_and_command_book_is_selected() throws Throwable {
        inputLinesAdd[0] = "a";
        inputLinesAdd[1] = "2";
    }

    @When("^Title \"([^\"]*)\" and Author \"([^\"]*)\" and ISBN \"([^\"]*)\" and Description \"([^\"]*)\" and Year \"([^\"]*)\" are input$")
    public void title_and_Author_and_ISBN_and_Description_and_Year_are_input() throws Throwable {
        inputLinesAdd[2] = "title";
        inputLinesAdd[3] = "author";
        inputLinesAdd[4] = "12345";
        inputLinesAdd[5] = "desc";
        inputLinesAdd[6] = "2000";
    }

    @Then("^a new booktip is added$")
    public void a_new_booktip_is_added() throws Throwable {
        io = new IOStub(inputLinesAdd);
        UI ui = new UI(io, dao);
        ui.run();
        assertTrue(dao.listByType("video").contains(new Book("author", "title", "www", "desc", 2000).toString()));

    }

    @Given("^command \"([^\"]*)\" add new readtip is selected and command \"([^\"]*)\" video is selected$")
    public void command_add_new_readtip_is_selected_and_command_video_is_selected(String arg1, String arg2) throws Throwable {
        inputLinesAdd[0] = "a";
        inputLinesAdd[1] = "1";

    }

    @When("^Title \"([^\"]*)\" and Author\"([^\"]*)\" and Link \"([^\"]*)\" and Description \"([^\"]*)\" and Year published \"([^\"]*)\" are input$")
    public void title_and_Author_and_Link_and_Description_and_Year_published_are_input(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        inputLinesAdd[2] = "title";
        inputLinesAdd[3] = "author";
        inputLinesAdd[4] = "www";
        inputLinesAdd[5] = "desc";
        inputLinesAdd[6] = "2000";
    }

    @Then("^a new videotip is added$")
    public void a_new_videotip_is_added() throws Throwable {

        io = new IOStub(inputLinesAdd);
        UI ui = new UI(io, dao);
        ui.run();
        assertTrue(dao.listByType("video").contains(new Video("author", "title", "www", "desc", 2000).toString()));
    }

}
