/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.io;

/**
 *
 * @author bisi
 */

import java.util.Scanner;

/**
 *
 * @author bisi
 */
public class ConsoleIO implements IO {
    private Scanner scanner = new Scanner(System.in);
    
    /**
     * Prints given input string
     * @param String toPrint
     */
    public void print(String toPrint) {
        System.out.println(toPrint);
    }

    /**
     * Reads a line from user and returns the read string.
     * @param prompt
     * @return
     */
    public String readLine(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
