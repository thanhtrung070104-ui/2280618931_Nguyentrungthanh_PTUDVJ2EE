package com.example.bai2_2280618931_nguyentrungthanh.service;

import com.example.bai2_2280618931_nguyentrungthanh.model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

  public BookService() {
        // Dữ liệu mẫu phong phú hơn
        books.add(new Book(1, "Clean Code", "Robert C. Martin"));
        books.add(new Book(2, "Hoang tu be", "Antoine de Saint-Exupéry"));
        books.add(new Book(3, "Tu duy nguoc", "Nguyen Anh Dung"));
        books.add(new Book(4, "Nha gia kim", "Paulo Coelho"));
        books.add(new Book(5, "Spring Boot in Action", "Craig Walls"));
    }

    // Lấy hết sách
    public List<Book> getAllBooks() {
        return books;
    }

    // Lấy sách theo ID (dùng để hiển thị form sửa)
    public Book getBookById(int id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Thêm sách
    public void addBook(Book book) {
        books.add(book);
    }

    // Cập nhật sách (Sửa logic một chút so với bài 2 để nhận thẳng Object Book)
    public void updateBook(Book updatedBook) {
        Book book = getBookById(updatedBook.getId());
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
        }
    }

    // Xóa sách
    public void deleteBook(int id) {
        books.removeIf(b -> b.getId() == id);
    }
}