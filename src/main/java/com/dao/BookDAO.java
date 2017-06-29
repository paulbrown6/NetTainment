package com.dao;

import com.entity.Book;

import java.util.List;

/**
 * Created by Paul Brown on 07.02.2017.
 */
public interface BookDAO {

    Book createBook(Book book);

    void updateBook(Book book);

    void deleteBook(Book book);

    Book getBookById(Long id);

    List<Book> getAllBook();
}
