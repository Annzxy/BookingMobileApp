package com.example.booking;

public class Category {

    private String title;

    private int categoryImage;  // this is a drawable id for an icon or image

    public Category(String title, int categoryImage) {
        this.title = title;
        this.categoryImage = categoryImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(int categoryImage) {
        this.categoryImage = categoryImage;
    }
}
