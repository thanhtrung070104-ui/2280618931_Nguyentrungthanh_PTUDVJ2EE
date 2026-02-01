package com.example.bai2_2280618931_nguyentrungthanh.controller;

import com.example.bai2_2280618931_nguyentrungthanh.model.Book;
import com.example.bai2_2280618931_nguyentrungthanh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // Dùng @Controller (không dùng @RestController nữa)
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 1. Hiển thị danh sách (GET /books)
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("title", "Danh sách quản lý sách");
        return "books/list"; // Trả về file list.html trong thư mục books
    }

    // 2. Hiển thị Form thêm mới (GET /books/add)
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book()); // Gửi một quyển sách rỗng sang form để điền
        model.addAttribute("title", "Thêm sách mới");
        return "books/add";
    }

    // 3. Xử lý lưu sách mới (POST /books/add)
    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/books"; // Quay về trang danh sách
    }

    // 4. Hiển thị Form sửa (GET /books/edit/{id})
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            model.addAttribute("book", book);
            model.addAttribute("title", "Sửa thông tin sách");
            return "books/edit";
        }
        return "redirect:/books";
    }

    // 5. Xử lý lưu sách đã sửa (POST /books/edit)
    @PostMapping("/edit")
    public String updateBook(@ModelAttribute("book") Book book) {
        bookService.updateBook(book);
        return "redirect:/books";
    }

    // 6. Xóa sách (GET /books/delete/{id})
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}