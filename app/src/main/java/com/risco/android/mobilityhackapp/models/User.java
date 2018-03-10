package com.risco.android.mobilityhackapp.models;

/**
 * Created by Albert Risco on 10/03/2018.
 */

public class User {
    private String id, email, password, username;
    private int numTravels;

    public User(String id, String email, String password, String username, int numTravels) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.numTravels=numTravels;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", numTravels=" + numTravels +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumTravels() {
        return numTravels;
    }

    public void setNumTravels(int numTravels) {
        this.numTravels = numTravels;
    }
}
