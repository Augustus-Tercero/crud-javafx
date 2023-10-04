package edu.upvictoria.poo.lib;

public class User {
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;

    public User(String username, String firstName, String lastName, String email, String phoneNumber) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        // final var emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        // final var phoneNumberRegex = "^\\+\\d{12}|\\+\\d{14}$";
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String[] toArray() {
        var arr = new String[5];
        var split = this.toString().split(",");
        var k = 0;
        for (var s : split) {
            arr[k] = s;
            k++;
        }
        return arr;
    }

    public boolean isEmpty() {
        return (this.getUsername().isEmpty() || this.getFirstName().isEmpty() || this.getLastName().isEmpty() ||
                        this.getEmail().isEmpty() || this.getPhoneNumber().isEmpty());
    }

    @Override
    public String toString() {
        return username + "," + firstName + "," + lastName + "," + email + "," + phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
