package com.logistic.implement;

import com.dao.BookDAO;
import com.entity.Book;
import com.logistic.BookLogistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Paul Brown on 07.02.2017.
 */

@Service("bookService")
public class BookLogisticImplement implements BookLogistic {

    @Autowired
    BookDAO bookDAO;

    @Override
    @Transactional
    public void createBook(Book book) {
        bookDAO.createBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    @Transactional
    public void deleteBook(Book book) {
        bookDAO.deleteBook(book);
    }

    @Override
    @Transactional
    public Book getBookById(Long id) {
        return bookDAO.getBookById(id);
    }

    @Override
    @Transactional
    public List<Book> getAllBook() {
        return bookDAO.getAllBook();
    }
}
