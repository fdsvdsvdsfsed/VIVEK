package com.example.hehehe;

public class user {

    private int id;
    private String naam; // Changed 'name' to 'naam'
    private String email;
    private String password;

    public user(int id, String naam, String email, String password) {
        this.id = id;
        this.naam = naam;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
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
}
