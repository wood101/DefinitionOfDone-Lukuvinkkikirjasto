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

import ReadMe.domain.ReadingTip;
import java.util.List;
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
    
    @Override
    public void summaryTableView(List<ReadingTip> tips) {
        String leftAlignFormat = "| %-4d| %-15s | %-20s | %-7s |%n";
        System.out.format("+-----+-----------------+----------------------+---------+%n");
        System.out.format("| ID  |     Author      |        Title         |  Type   |%n");
        System.out.format("+-----+-----------------+----------------------+---------+%n");
        for (int i = 0; i < tips.size(); i++) {
            System.out.format(leftAlignFormat, tips.get(i).getId(), tips.get(i).getAuthor(), tips.get(i).getTitle(), tips.get(i).getClass().getName().replace("ReadMe.domain.", ""));
        }
        System.out.format("+-----+-----------------+----------------------+---------+%n");
    }

    
}
