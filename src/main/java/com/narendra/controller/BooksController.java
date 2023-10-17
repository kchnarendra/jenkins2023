package com.narendra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narendra.dto.Book;
import com.narendra.service.BookService;

@RestController
@RequestMapping(value = "/book-api")
public class BooksController {

	@Autowired
	BookService bookService;

	//@GetMapping(value = "/books/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@GetMapping(value = "/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book bookRes = bookService.getBook(id);
		return new ResponseEntity<>(bookRes, HttpStatus.OK);
	}

	@PostMapping(value = "/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book bookRes = bookService.addBook(book);
		return new ResponseEntity<Book>(bookRes, HttpStatus.CREATED);
	}

	@PutMapping(value = "/books/{id}")
	public ResponseEntity<String> updateBookById(@PathVariable("id") int id, @RequestBody Book book) {
		bookService.updateBookById(id, book);
		return new ResponseEntity<String>("Book updated successfully !!!", HttpStatus.OK);

	}

	@DeleteMapping(value = "/books/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") int id) {
		bookService.deleteBook(id);
		return new ResponseEntity<>("Deleted Suceesfully", HttpStatus.OK);
	}

	@GetMapping(value = "/books")
	public ResponseEntity<List<Book>> getAllBook() {
		List<Book> bookResList = bookService.getAllBooks();
		return new ResponseEntity<>(bookResList, HttpStatus.OK);
	}
}
