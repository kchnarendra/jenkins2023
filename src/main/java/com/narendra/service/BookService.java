package com.narendra.service;

import java.util.List;

import com.narendra.dto.Book;

public interface BookService {

	public Book getBook(int id);

	public Book addBook(Book book);

	public void updateBookById(int id, Book book);

	public void deleteBook(int id);

	List<Book> getAllBooks();

}
