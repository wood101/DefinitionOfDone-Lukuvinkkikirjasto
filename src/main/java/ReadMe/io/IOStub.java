/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.io;

import ReadMe.domain.ReadingTip;
import ReadMe.io.IO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peje
 */
public class IOStub implements IO {

    String[] inputs;
    int index;
    public ArrayList<String> outputs;

    public IOStub(String... inputs) {
        this.inputs = inputs;
        this.outputs = new ArrayList<>();
    }

    @Override
    public void print(String toPrint) {
        outputs.add(toPrint);
    }

    @Override
    public String readLine(String prompt) {
        return inputs[index++];
    }

    public ArrayList<String> getOutputs() {
        return outputs;
    }
    
    public String getOutputString() {
        return outputs.toString();
    }
    
    @Override
    public void summaryTableView(List<ReadingTip> tips) {
        String output = "";
        String leftAlignFormat = "| %-4d| %-15s | %-20s | %-7s |%n";
        output += String.format("+-----+-----------------+----------------------+---------+%n");
        output += String.format("| ID  |     Author      |        Title         |  Type   |%n");
        output += String.format("+-----+-----------------+----------------------+---------+%n");
        for (int i = 0; i < tips.size(); i++) {
        output += String.format(leftAlignFormat, tips.get(i).getId(), tips.get(i).getAuthor(), tips.get(i).getTitle(), tips.get(i).getClass().getName().replace("ReadMe.domain.", ""));
        }
        output += String.format("+-----+-----------------+----------------------+---------+%n");
        outputs.add(output);
    }
}
