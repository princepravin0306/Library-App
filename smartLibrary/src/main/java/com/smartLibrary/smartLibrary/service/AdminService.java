package com.smartLibrary.smartLibrary.service;

import org.springframework.stereotype.Service;

import com.smartLibrary.smartLibrary.model.Book;
import com.smartLibrary.smartLibrary.repository.BookRepository;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final BookRepository bookRepository;

    public Book postBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new IllegalStateException("Book with id " + id + " does not exist");
        }
        bookRepository.deleteById(id);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(null);
    }

    public Book updateBook(Book book, Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book existingBook = bookOptional.get();

            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setDescription(book.getDescription());
            existingBook.setCopies(book.getCopies());
            existingBook.setCopiesAvailable(book.getCopiesAvailable());
            existingBook.setCategory(book.getCategory());

            return bookRepository.save(existingBook);
        }
        return null;
    }

    

    

   
   
   
}
