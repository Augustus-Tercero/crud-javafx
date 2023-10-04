package edu.upvictoria.poo.lib;

import java.io.*;
import java.util.ArrayList;

public class FileWriterWrapper {
    private String path;
    private File file;

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

    public void overWrite(String str) {
        try {
            var bw = new BufferedWriter(new FileWriter(path));
            bw.write(str);
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write(String str) {
        try {
            var fileEmpty = new FileContentWrapper(path).isEmpty();
            var bw = new BufferedWriter(new FileWriter(file, true));
            if (!fileEmpty)
                bw.newLine();
            bw.write(str);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
