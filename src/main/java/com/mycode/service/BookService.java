package com.mycode.service;

import com.mycode.model.Book;
import com.mycode.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }


    public Book findById(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }


    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    public Book replaceBook(Book newBook, Integer id) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setName(newBook.getName());
                    book.setNumber(newBook.getNumber());
                    book.setPrice(newBook.getPrice());
                    book.setStorage(newBook.getStorage());
                    return bookRepository.save(book);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return bookRepository.save(newBook);
                });
    }


    public List<String> findDistinctByName () {
        return bookRepository.findDistinctByName();
    }

    public List<String> findByNameContainsAndPrice () {
        return bookRepository.findByNameContainsAndPrice();
    }

}