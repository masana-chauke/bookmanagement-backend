package com.books.bookmanagement;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
    private BookService bookService;

    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    public Book addBook(String title, String author, String description) {
        return bookService.addBook(title, author, description);
    }

    public Book editBook(String id, String title, String author, String description) {
        Optional<Book> editedBook = bookService.editBook(id, title, author, description);
        return editedBook.orElse(null);
    }

    public Book deleteBook(String id) {
        Optional<Book> deletedBook = bookService.deleteBook(id);
        return deletedBook.orElse(null);
    }
}
