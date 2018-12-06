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
}
