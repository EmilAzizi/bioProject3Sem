package com.example.bioproject.model;

public class Kiosk {
    private int ID;
    private String name;
    private double price;

    public Kiosk(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Kiosk(){

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
