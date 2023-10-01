package edu.upvictoria.poo.lib;

import java.io.*;
import java.util.ArrayList;

public class FileWritterWrapper {
    private String path;
    private File file;

    public static void main(String[] args) {
        var test = new FileWritterWrapper("src/main/resources/Test.txt");
        test.modifyLine(0,"world, hello");
    }

    public FileWritterWrapper(String path) {
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

    public void write(String[] arr) {
        try {
            var fileEmpty = new FileContentWrapper(path).isEmpty();
            var bw = new BufferedWriter(new FileWriter(file, true));
            if (!fileEmpty)
                bw.newLine();
            for (var i = 0; i < arr.length; i++) {
                bw.write(arr[i]);
                if (i < arr.length - 1) {
                    bw.write(",");
                }
            }
            bw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
