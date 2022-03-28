package com.example.spring_demo;

public class Friend {
    private int id;
    private String name;
    private String adress;
    private String phonenumber;

    public Friend(int id, String name, String adress, String phonenumber) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.phonenumber = phonenumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
