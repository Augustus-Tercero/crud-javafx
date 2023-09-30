package edu.upvictoria.poo.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileContentWrapper {
    private final String path;
    private final File file;

    public FileContentWrapper(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public boolean isEmpty() {
        var c = new FileContentWrapper(path).getFileContent();
        return c.isEmpty();
    }

    public String getFileName() {
        if (file.isDirectory()) {
            return null;
        }
        var index = this.path.lastIndexOf("/");
        return path.substring(index + 1);
    }

    public ArrayList<String> searchString(String str) {
        var arr = new ArrayList<String>();
        var content = new FileContentWrapper(path).getFileContent();
        for (var line : content) {
            var split = line.split(",");
            if (split[0].equals(str)) {
                arr.addAll(Arrays.asList(split));
            }
        }
        return arr;
    }

    public ArrayList<String> getFileContent() {
        var arr = new ArrayList<String>();
        try {
            var br = new BufferedReader(new FileReader(this.file));
            var line = "";
            while ((line = br.readLine()) != null) {
                arr.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
