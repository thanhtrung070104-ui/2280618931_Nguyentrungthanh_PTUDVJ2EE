package com.example.bai2_2280618931_nguyentrungthanh.service;

import com.example.bai2_2280618931_nguyentrungthanh.model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // Đánh dấu đây là lớp xử lý logic [cite: 882, 909]
public class BookService {
    
    // Tạo một danh sách sách giả lập trong bộ nhớ [cite: 892]
    private List<Book> books = new ArrayList<>();

    // Constructor: Thêm sẵn vài cuốn sách để test
    public BookService() {
        books.add(new Book(1, "Lap trinh Java", "Nguyen Van A"));
        books.add(new Book(2, "Spring Boot Co Ban", "Tran Van B"));
    }

    // Lấy tất cả sách [cite: 893]
    public List<Book> getAllBooks() {
        return books;
    }

    // Lấy sách theo ID [cite: 896]
    public Book getBookById(int id) {
        return books.stream()
                    .filter(book -> book.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    // Thêm sách mới [cite: 900]
    public void addBook(Book book) {
        books.add(book);
    }

    // Cập nhật sách [cite: 911]
    public void updateBook(int id, Book updatedBook) {
        Book book = getBookById(id);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
        }
    }

    // Xóa sách [cite: 922]
    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}