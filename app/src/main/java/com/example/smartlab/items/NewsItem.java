package com.example.smartlab.items;

public class NewsItem {
    private int id;
    private String title;
    private String description;
    private String price;
    private int image;

    public NewsItem(int id, String title, String description, String price, int image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getPrice() {
        return price;
    }
    public int getId() {
        return id;
    }
    public int getImage() {
        return image;
    }
}
