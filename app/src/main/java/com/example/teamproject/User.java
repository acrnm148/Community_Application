package com.example.teamproject;

public class User {
    public String id;
    public String pw;
    public String name;
    public String jumin;
    public String callnum;
    public String pw_check;


    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String id, String pw, String jumin, String name, String callnum, String pw_check ) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.jumin = jumin;
        this.callnum = callnum;
        this.pw_check = pw_check;
    }

    public String getId() {
        return id;
    }

    public void setUserID(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName(){return name;}

    public void setName(String name) { this.name = name; }

    public String getJumin() {
        return jumin;
    }

    public void setJumin(String jumin) {
        this.jumin = jumin;
    }

    public String getCallnum() {
        return callnum;
    }

    public void setCallnum(String callnum) {
        this.callnum = callnum;
    }

    public String getPw_check() {
        return pw_check;
    }

    public void setPw_check(String pw_check) {
        this.pw_check = pw_check;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID ='" + id + '\'' +
                ", PW ='" + pw + '\'' +
                "userName ='" + name + '\'' +
                "userJumin ='" + jumin + '\'' +
                "usercallnum ='" + callnum + '\'' +
                "userPW_C ='" + pw_check + '\'' +
                '}';
    }
}