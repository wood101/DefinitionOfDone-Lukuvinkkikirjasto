package ReadMe;

import ReadMe.classes.Bookmark;
import ReadMe.classes.UI;
import ReadMe.data_access.InMemoryBookmarkDao;
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
    InMemoryBookmarkDao dao = mock(InMemoryBookmarkDao.class);
    String[] inputLinesAdd = new String[5];
    String[] inputLinesList = new String[6];
    
    
    @Given("^database contains atleast one bookmark$")
    public void database_contains_atleast_one_bookmark() throws Throwable {
        inputLinesList[0] = "a";
        inputLinesList[1] = "title";
        inputLinesList[2] = "desc"; 
        inputLinesList[3] = "www";
        
    }
    
    
    @Given("^command new tip is selected$")
    public void command_new_tip_is_selected() throws Throwable {
        inputLinesAdd[0]= "a";

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
        inputLinesList[4] = "l";
        inputLinesList[4] = "q";
    }

    
    @Then("^a new tip is added$")
    public void a_new_tip_is_added() throws Throwable {
        
        io = new IOStub(inputLinesAdd);
        UI ui = new UI(io, dao);
        ui.run();
        assertTrue(io.getOutputs().contains("Tip added!\n\n"));
    }
    
    @Then("^all bookmarks are printed$")
    public void all_bookmarks_are_printed() throws Throwable {
        IOStub ios = new IOStub(inputLinesList);
        UI uis = new UI(ios, dao);
        ui.run();
        assertTrue(dao.listAll().contains(new Bookmark("title", "desc", "www")));
        
    }

   
     
}
