package com.smartLibrary.smartLibrary.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartLibrary.smartLibrary.model.Book;
import com.smartLibrary.smartLibrary.service.AdminService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    
    private final AdminService adminService;

    @PostMapping("/book")
    public Book postBook(@RequestBody Book book) {
        return adminService.postBook(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return adminService.getAllBooks();
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBooks(@PathVariable Long id) {
        try {
            adminService.deleteBook(id);
            return new ResponseEntity<>("Book with ID " + id + " deleted Successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        Book book = adminService.getBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping("/book/{id}")
    public ResponseEntity<?> updateBook(@RequestBody Book book, 
            @PathVariable Long id) {
                Book updatedBook = adminService.updateBook(book, id);
        if (updatedBook == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(updatedBook); // Return the updated book object in the response body.
    }

}
