package com.books.bookmanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(String title, String author, String description) {
        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setDescription(description);
        return bookRepository.save(newBook);
    }

    public Optional<Book> editBook(String id, String title, String author, String description) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        optionalBook.ifPresent(book -> {
            book.setTitle(title);
            book.setAuthor(author);
            book.setDescription(description);
            bookRepository.save(book);
        });
        return optionalBook;
    }

    public Optional<Book> deleteBook(String id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        optionalBook.ifPresent(book -> bookRepository.deleteById(id));
        return optionalBook;
    }
}
