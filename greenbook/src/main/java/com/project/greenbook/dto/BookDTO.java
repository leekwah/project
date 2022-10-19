package com.project.greenbook.dto;

import java.sql.Timestamp;

public class BookDTO {
    String category;
    String title;
    String author;
    int price;

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public BookDTO() {}

    public BookDTO(String category, String title, String author, int price) {
        this.category = category;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
