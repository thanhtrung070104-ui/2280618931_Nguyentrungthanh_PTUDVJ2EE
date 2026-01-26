package com.example.bai2_2280618931_nguyentrungthanh.model; // Lưu ý: giữ đúng tên package của bạn

// Theo tài liệu trang 6 - tạo Class Book [cite: 830, 841]
public class Book {
    private int id;
    private String title;
    private String author;

    // Constructor mặc định
    public Book() {
    }

    // Constructor đầy đủ tham số [cite: 847]
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getter và Setter [cite: 852-858]
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}