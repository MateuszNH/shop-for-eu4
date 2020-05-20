package com.listy.shopforeu4.model;

public class User {
    private String mail;
    private String passwd;

    public User(String mail, String passwd) {
        this.mail = mail;
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "mail='" + mail + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
