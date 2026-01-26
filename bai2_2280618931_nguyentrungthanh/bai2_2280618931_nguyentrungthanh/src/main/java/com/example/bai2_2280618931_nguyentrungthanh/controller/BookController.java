package com.example.bai2_2280618931_nguyentrungthanh.controller;

import com.example.bai2_2280618931_nguyentrungthanh.model.Book;
import com.example.bai2_2280618931_nguyentrungthanh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Đánh dấu đây là API Controller [cite: 927]
@RequestMapping("/api/books") // Đường dẫn gốc cho tất cả chức năng bên dưới [cite: 929]
public class BookController {

    @Autowired // Tự động nạp BookService vào [cite: 940, 947]
    private BookService bookService;

    // 1. Lấy danh sách tất cả sách (GET /api/books) [cite: 949]
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // 2. Lấy sách theo ID (GET /api/books/{id}) [cite: 954]
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // 3. Thêm sách mới (POST /api/books) [cite: 958]
    @PostMapping
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "Book added successfully!";
    }

    // 4. Cập nhật sách (PUT /api/books/{id}) [cite: 966]
    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        bookService.updateBook(id, updatedBook);
        return "Book updated successfully!";
    }

    // 5. Xóa sách (DELETE /api/books/{id}) [cite: 971]
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "Book deleted successfully!";
    }
}