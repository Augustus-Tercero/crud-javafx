package edu.upvictoria.poo.lib;

import java.io.*;
import java.util.ArrayList;

public class FileWriterWrapper {
    private String path;
    private File file;

    public static void main(String[] args) {
        var test = new FileWriterWrapper("src/main/resources/Test.txt");
        test.modifyLine(0,"world, hello");
    }

    public FileWriterWrapper(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public void modifyLine(int index, String line) {
        var content = new FileContentWrapper(path).getFileContent();
        content.set(index,line);
        this.overWrite(content);
    }

    public void overWrite(ArrayList<String> content) {
        try {
            var bw = new BufferedWriter(new FileWriter(path));
            for (var line : content) {
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String str) {
        try {
            var fileEmpty = new FileContentWrapper(path).isEmpty();
            var bw = new BufferedWriter(new FileWriter(file, true));
            if (!fileEmpty)
                bw.newLine();
            bw.write(str.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
