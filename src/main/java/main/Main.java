package main;

import ReadMe.classes.UI;
import ReadMe.io.ConsoleIO;
import java.util.Scanner;

/**
 *
 * @author bisi
 */
public class Main {

    /**
     * Creates an I/O object, UI object and runs the UI.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Toimii");
        System.out.println("Niinpä!");
        
        ConsoleIO io = new ConsoleIO();
        UI ui = new UI(io);
        ui.run();


    }
}
