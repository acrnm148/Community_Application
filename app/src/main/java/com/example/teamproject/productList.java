package com.example.teamproject;

public class productList {
    String title;
    String detail;
    String price;
    String locate;

//    public productList()
//    {
//
//    }
//
//    public productList(String _a, String _b, String _c, String _d)
//    {
//        title = _a;
//        detail = _b;
//        price = _c;
//        locate = _d;
//    }

    public String getTitle(){return title;}
    public String getDetail(){return detail;}
    public String getPrice(){return price;}
    public String getLocate(){return locate;}
    public void setTitle(String title){this.title=title;}
    public void setDetail(String detail){this.detail=detail;}
    public void setPrice(String price){this.price=price;}
    public void setLocate(String locate){this.locate=locate;}

}
