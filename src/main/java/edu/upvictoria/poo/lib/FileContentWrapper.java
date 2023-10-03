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

    public static void main(String[] args) {
        var m = new FileContentWrapper("src/main/resources/db.csv");
        System.out.println(m.isEmpty());
    }

    public FileContentWrapper(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public boolean isEmpty() {
        return new FileContentWrapper(path).getFileContent().isEmpty();
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

    /*public boolean stringExists(String str) {
        var content = new FileContentWrapper(path).getFileContent();
        for (var line : content) {
            var strToken = new StringTokenizer(line,",");
            while (strToken.hasMoreTokens()) {
                if (strToken.nextToken().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }*/

    public boolean stringExists(String str) {
        var content = new FileContentWrapper(path).getFileContent();
        for (var line : content) {
            var split = line.split(",");
            for (var s : split) {
                if (s.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getStringIndex(String str) {
        var content = new FileContentWrapper(path).getFileContent();
        var k = 0;
        for (var line : content) {
            var split = line.split(",");
            if (split[0].equals(str)) {
                // primera instancia que encuentre será el índice retornado, pero si no hay valores repetidos no importa.
                break;
            }
            k++;
        }
        return k;
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

    public String[] getContentArray() {
        var content = new FileContentWrapper(path).getFileContent();
        var arr = new String[content.size()];
        for (var i = 0; i < content.size(); i++) {
            arr[i] = content.get(i);
        }
        return arr;
    }
}
