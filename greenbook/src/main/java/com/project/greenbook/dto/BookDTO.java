package com.project.greenbook.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class BookDTO {
    int book_id;
    String large_category;
    String small_category;
    String book_title;
    String book_author;
    int book_price;
    String book_publisher;
    Date publication_date;
    String book_description;
    int book_stock;
    int new_book;
    int count;

    public BookDTO() {}

    public BookDTO(int book_id, String book_title, String book_author, Date publication_date, String book_description) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.publication_date = publication_date;
        this.book_description = book_description;
    }

    public BookDTO(int book_id, String large_category, String small_category, String book_title, String book_author, int book_price, String book_publisher, Date publication_date, String book_description, int book_stock, int new_book) {
        this.book_id = book_id;
        this.large_category = large_category;
        this.small_category = small_category;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_price = book_price;
        this.book_publisher = book_publisher;
        this.publication_date = publication_date;
        this.book_description = book_description;
        this.book_stock = book_stock;
        this.new_book = new_book;
    }
}

