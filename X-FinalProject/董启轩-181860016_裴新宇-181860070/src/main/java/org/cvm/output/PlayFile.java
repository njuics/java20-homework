package org.cvm.output;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlayFile {
    List<String> list = new ArrayList<>();

    public void addStatement(String statement) {
        list.add(statement);
    }

    public void save_file(String filepath) {

        PrintStream stream = null;
        try {
            stream = new PrintStream(filepath);
            for (int i = 0; i < list.size(); i++) {
                stream.println(list.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
