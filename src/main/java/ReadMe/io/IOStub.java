/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.io;

import java.util.ArrayList;

/**
 *
 * @author peje
 */
public class IOStub implements IO {

    String[] inputs;
    int index;
    public ArrayList<String> outputs;

    /**
     * IOStubfor testing, inputs are stored in an array
     *
     * @param inputs that are stored in an array
     */
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

    /**
     * Returns the outputs that UI provides after getting the inputs in the input array
     *
     * @return output string
     */
    public String getOutputString() {
        return outputs.toString();
    }
}
