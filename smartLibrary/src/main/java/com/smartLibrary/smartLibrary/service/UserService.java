package com.smartLibrary.smartLibrary.service;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.stereotype.Service;

import com.smartLibrary.smartLibrary.model.Book;
import com.smartLibrary.smartLibrary.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final BookRepository bookRepository;
    

    

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book borrowBook(Long id) throws Exception {
        Optional<Book> book = bookRepository.findById(id);
        if (!book.isPresent() || book.get().getCopiesAvailable() <= 0) {
            throw new Exception("Book not found");
        }
        book.get().setCopiesAvailable(book.get().getCopiesAvailable() - 1);
        bookRepository.save(book.get());
        return book.get();
    }

    public Book returnBook(Long id) throws Exception {
        Optional<Book> book = bookRepository.findById(id);
        if (!book.isPresent() ) {
            throw new Exception("Book not found");
        }
        book.get().setCopiesAvailable(book.get().getCopiesAvailable() + 1);
        bookRepository.save(book.get());
        return book.get();
    }

    
}
