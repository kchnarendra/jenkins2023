package com.narendra.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narendra.dto.Book;
import com.narendra.entity.BookEntity;
import com.narendra.exception.BookIdNotAvailableException;
import com.narendra.repo.BooksRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	BooksRepo booksRepo;

	@Override
	public Book getBook(int id) {
		Optional<BookEntity> bookEntity = booksRepo.findById(id);
		if(bookEntity.isPresent()) {
			Book book = modelMapper.map(bookEntity.get(), Book.class);
			return book;
		}
		throw new BookIdNotAvailableException("Book not Avalabe!!!!");
	}

	@Override
	public Book addBook(Book book) {
		BookEntity bookEntity = modelMapper.map(book, BookEntity.class);
		BookEntity bookEntitySaved = booksRepo.save(bookEntity);
		return modelMapper.map(bookEntitySaved, Book.class);
	}

	@Override
	public void updateBookById(int id, Book book) {
		BookEntity bookEntity = modelMapper.map(book, BookEntity.class);
		bookEntity.setId(id);
		booksRepo.save(bookEntity);
	}

	@Override
	public void deleteBook(int id) {
		booksRepo.deleteById(id);
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<>();
		List<BookEntity> bookEntityList = booksRepo.findAll();
		for (BookEntity bookEntity : bookEntityList) {
			bookList.add(modelMapper.map(bookEntity, Book.class));
		}
		return bookList;
	}

	

}
