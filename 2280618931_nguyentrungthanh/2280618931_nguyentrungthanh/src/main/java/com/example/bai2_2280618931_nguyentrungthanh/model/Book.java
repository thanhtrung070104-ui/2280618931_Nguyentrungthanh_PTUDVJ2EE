package com.example.bai2_2280618931_nguyentrungthanh.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class Book {
    private int id;

    @NotBlank(message = "Tên sách không được để trống")
    @Size(min = 1, max = 100, message = "Tên sách phải từ 1 đến 100 ký tự")
    private String title;

    @NotBlank(message = "Tác giả không được để trống")
    private String author;

    // Constructor, Getter, Setter giữ nguyên
    public Book() {}
    
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    
    // ... (Các getter/setter của bạn) ...
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}