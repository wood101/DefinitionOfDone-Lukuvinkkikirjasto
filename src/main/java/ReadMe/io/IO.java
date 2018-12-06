package ReadMe.io;

import ReadMe.domain.ReadingTip;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bisi
 */
public interface IO {

    /**
     * I/O interface for printing
     * @param toPrint
     */
    void print(String toPrint);

    /**
     * I/O interface for reading input
     * @param prompt
     * @return
     */
    String readLine(String prompt);
}

