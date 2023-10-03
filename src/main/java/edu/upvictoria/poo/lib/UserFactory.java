package edu.upvictoria.poo.lib;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class UserList {
    private ArrayList<User> users;
    private String path;

    public UserList(String path) {
        this.users = new ArrayList<>();
        this.path = path;
        var content = new FileContentWrapper(this.path).getFileContent();
        for (var line : content) {
            var strToken = new StringTokenizer(line,",");
            var username = strToken.nextToken();
            var firstName = strToken.nextToken();
            var lastName = strToken.nextToken();
            var email = strToken.nextToken();
            var phoneNumber = strToken.nextToken();
            this.users.add(new User(username,firstName,lastName,email,phoneNumber));
        }
    }

    public ArrayList<String> toArray() {
        var arr = new ArrayList<String>();
        for (var user : this.users) {
            arr.add(user.toString());
        }
        return arr;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
