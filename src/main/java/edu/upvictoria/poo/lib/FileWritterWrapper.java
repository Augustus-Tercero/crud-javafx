package edu.upvictoria.poo.lib;

import java.io.*;

public class FileWritterWrapper {
    private String path;
    private File file;

    public FileWritterWrapper(String path) {
        this.path = path;
        this.file = new File(path);
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
