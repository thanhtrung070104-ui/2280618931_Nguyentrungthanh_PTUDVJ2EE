package com.example.bai2_2280618931_nguyentrungthanh.controller;

import com.example.bai2_2280618931_nguyentrungthanh.model.Book;
import com.example.bai2_2280618931_nguyentrungthanh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

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

   
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        // Kiểm tra lỗi validation
        if (result.hasErrors()) {
            model.addAttribute("title", "Thêm sách mới");
            return "books/add"; // Trả về lại form thêm mới nếu có lỗi
        }
        
        bookService.addBook(book);
        return "redirect:/books";
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
    public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Sửa thông tin sách");
            return "books/edit"; // Trả về lại form sửa nếu có lỗi
        }
        
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