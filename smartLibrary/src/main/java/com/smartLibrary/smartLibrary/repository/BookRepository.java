package com.smartLibrary.smartLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartLibrary.smartLibrary.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    
}
