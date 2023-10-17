package com.narendra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narendra.entity.BookEntity;

public interface BooksRepo extends JpaRepository<BookEntity, Integer>{

}
