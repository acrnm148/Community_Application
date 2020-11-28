package com.example.teamproject;

public class Address_ListViewItem {
    private String zipNo_;
    private String rnAdres_;
    private String lnAdres_;


    public void setzipNo(String zipNo) {
        zipNo_ = zipNo;
    }
    public void setrnAdres(String rnAdres) {
        rnAdres_ = rnAdres;
    }
    public void setlnAdres(String lnAdres) {
        lnAdres_ = lnAdres;
    }

    public String getzipNo() {
        return this.zipNo_;
    }
    public String getrnAdres() {
        return this.rnAdres_;
    }
    public String getlnAdres() {
        return this.lnAdres_;
    }

}
