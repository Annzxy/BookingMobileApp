package com.example.booking;

public class ListItem {

    private String title;
    private int imageResId;
    private String price;
    private String discount;

    // Constructors, getters, and setters

    public ListItem(String title, int imageResId, String price, String discount) {
        this.title = title;
        this.imageResId = imageResId;
        this.price = price;
        this.discount = discount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}


