package com.dao.implement;

import com.dao.BookDAO;
import com.entity.Book;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Paul Brown on 07.02.2017.
 */

@Repository("bookDAOImplement")
@Transactional
public class BookDAOImplement implements BookDAO {

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Override
    public Book createBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
        return book;
    }

    @Override
    public void updateBook(Book book) {
        sessionFactory.getCurrentSession().update(book);
    }

    @Override
    public void deleteBook(Book book) {
        Book mergBook = (Book) sessionFactory.getCurrentSession().merge(book);
        sessionFactory.getCurrentSession().delete(mergBook);
    }

    @Override
    public Book getBookById(Long id) {
        Book book = sessionFactory.getCurrentSession().get(Book.class, id);
        return book;
    }

    @Override
    public List<Book> getAllBook() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class);
        criteria.addOrder(Order.desc("name"));
        List result = criteria.list();
        return result;
    }
}
