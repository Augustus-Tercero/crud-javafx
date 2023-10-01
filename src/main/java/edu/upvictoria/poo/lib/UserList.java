package edu.upvictoria.poo.lib;

import edu.upvictoria.poo.crud_files.Exceptions.EmptyFieldException;
import edu.upvictoria.poo.crud_files.Exceptions.InvalidEmailException;
import edu.upvictoria.poo.crud_files.Exceptions.InvalidPhoneNumberException;

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

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
