package com.example.teamproject;

public class UserModel {
    // 사용자 기본정보

    private String userName; // 사용자 이름(닉네임)
    private String uid; // 현재 사용자(로그인한)
    private String address; //사용자 주소(주소인증)
//    public String pushToken;
    public UserModel() {}
    public UserModel(String userName, String uid, String address) {
        this.userName = userName;
        this.uid = uid;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getUid() {
        return uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
