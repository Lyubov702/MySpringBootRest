package com.mycode.controller;

import com.mycode.model.Book;
import com.mycode.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveBook(@RequestBody Book book) {
        bookService.save(book);
    }

    @GetMapping("/find")
    public ResponseEntity<Book> findById(@RequestParam int id) {
        Book book = bookService.findById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Book>> findAllBooks() {
        List<Book> allBooks = bookService.findAllBooks();
        if (allBooks != null) {
            return ResponseEntity.ok(allBooks);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        bookService.deleteById(id);

    }

    @PutMapping("/replace/{id}")
    public ResponseEntity<Book> replaceBook(@RequestBody Book book, @PathVariable Integer id) {
        Book replacedBook = bookService.replaceBook(book, id);
        if (replacedBook != null)
            return ResponseEntity.ok(replacedBook);
        else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/findDistinctByName")
    public ResponseEntity<List<String>> findDistinctByName(){
        List<String> books =  bookService.findDistinctByName();
        if (books != null) {
            return ResponseEntity.ok(books);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByNameContainsAndPrice")
    public ResponseEntity<List<String>> findByNameContainsAndPrice(){
        List<String> books = bookService.findByNameContainsAndPrice();
        if (books != null) {
            return ResponseEntity.ok(books);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
