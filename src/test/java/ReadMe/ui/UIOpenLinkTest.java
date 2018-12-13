package ReadMe.ui;

import ReadMe.dao.InMemoryDao;
import ReadMe.io.IOStub;
import java.awt.Desktop;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bisi
 */
public class UIOpenLinkTest {

    UI ui;
    IOStub io;
    InMemoryDao db;

    @Before
    public void setUp() {
        db = new InMemoryDao();
    }

    @Test
    public void OpenCorrectReadTipLinkSuccesfully() {
        if (Desktop.isDesktopSupported()) {
            io = new IOStub("l", "2", "1", "o", "q");
            db = new InMemoryDao();
            ui = new UI(io, db);
            ui.isTesting = true;
            ui.run();
            String output = io.getOutputString();
            assertTrue(output.contains("Link opened in your default browser"));
        }
    }

    @Test
    public void OpenIncorrectReadTipLinkinGoogleSuccesfully() {
        if (Desktop.isDesktopSupported()) {
            io = new IOStub("a", "1", "titl", "auth", "link", "desc", "2000", "l", "2", "2", "o", "q");
            db = new InMemoryDao();
            ui = new UI(io, db);
            ui.isTesting = true;
            ui.run();
            String output = io.getOutputString();
            assertTrue(output.contains("Link opened in your default browser"));
        }

    }

    @Test
    public void OpenLinkWithoutHttp() {
        if (Desktop.isDesktopSupported()) {
            io = new IOStub("a", "1", "titl", "auth", "google.fi", "desc", "2000", "l", "2", "2", "o", "q");
            db = new InMemoryDao();
            ui = new UI(io, db);
            ui.isTesting = true;
            ui.run();
            String output = io.getOutputString();
            assertTrue(output.contains("Link opened in your default browser"));
        }

    }

    @Test
    public void OpenBookTipLinkSuccesfully() {
        if (Desktop.isDesktopSupported()) {
            io = new IOStub("l", "3", "1", "o", "q");
            db = new InMemoryDao();
            ui = new UI(io, db);
            ui.isTesting = true;
            ui.run();
            String output = io.getOutputString();
            assertTrue(output.contains("Searching for the book's ISBN at isbnsearch.org in your default browser"));

        }

    }

}
