package ReadMe;

import ReadMe.domain.Bookmark;
import ReadMe.ui.UI;
import ReadMe.dao.InMemoryBookmarkDao;
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
    InMemoryBookmarkDao dao = new InMemoryBookmarkDao();
    String[] inputLinesAdd = new String[5];
    String[] inputLinesList = new String[2];

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

    @Then("^a new tip is added$")
    public void a_new_tip_is_added() throws Throwable {

        io = new IOStub(inputLinesAdd);
        UI ui = new UI(io, dao);
        ui.run();
        assertTrue(dao.listAll().contains(new Bookmark("title", "desc", "www")));
    }

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

}
