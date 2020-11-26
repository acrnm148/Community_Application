package com.example.teamproject;

public class ItemExample {
    String title;
    String detail;
    String price;
    String locate;

    ItemExample(){}

    ItemExample(String title, String detail, String price, String locate){
        this.title=title;
        this.detail=detail;
        this.price=price;
        this.locate=locate;
    }
    public String getTitle(){return title;}
    public String getDetail(){return detail;}
    public String getPrice(){return price;}
    public String getLocate(){return locate;}
}
