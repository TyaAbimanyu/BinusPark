package com.example.binuspark;

public class UserModel {
    private  String fullname;
    private String email;
    private String password;
    private int phonenum;

    public UserModel(String fullname, String email, String password, int phonenum) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.phonenum = phonenum;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public int getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(int phonenum) {
        this.phonenum = phonenum;
    }
}
