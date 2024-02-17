package com.smartLibrary.smartLibrary.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartLibrary.smartLibrary.model.Book;
import com.smartLibrary.smartLibrary.service.UserService;

import lombok.RequiredArgsConstructor;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return userService.getAllBooks();
    }

    @PutMapping("/borrow/{id}")
    public Book borrowBook(@PathVariable Long id) throws Exception {
        return userService.borrowBook(id);
    }

    @PutMapping("/return/{id}")
    public Book returnBook(@PathVariable Long id) throws Exception {
        return userService.returnBook(id);
    }

}
